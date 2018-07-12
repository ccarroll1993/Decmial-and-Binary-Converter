/**
 * Example code for using a microchip mrf24j40 module to send and receive
 * packets using plain 802.15.4
 * Requirements: 3 pins for spi, 3 pins for reset, chip select and interrupt
 * notifications
 * This example file is considered to be in the public domain
 * Originally written by Karl Palsson, karlp@tweak.net.au, March 2011
 */
 
#include <SPI.h>
#include <mrf24j.h>
#include <Time.h>
#include <TimeLib.h>
#include <LowPower.h>

const int pin_reset = 6;
const int pin_cs = 7; // default CS pin on ATmega8/168/328
const int pin_interrupt = 2; // default interrupt pin on ATmega8/168/328
const int pin_motor = 3;
const int patient_id = 0x6001; // comm address and patient id
int j=0;

Mrf24j mrf(pin_reset, pin_cs, pin_interrupt);

long last_time;
long last_time2;
long tx_interval = 1000;

void setup() {
  Serial.begin(9600);
  pinMode(pin_motor, 3);
  
  mrf.reset();
  mrf.init();
  
  mrf.set_pan(0xcafe);
  // This is _our_ address
  mrf.address16_write(patient_id); 

  // uncomment if you want to receive any packet on this channel
  //mrf.set_promiscuous(true);
  
  // uncomment if you want to enable PA/LNA external control
  //mrf.set_palna(true);l
  
  // uncomment if you want to buffer all PHY Payload
  //mrf.set_bufferPHY(true);

  attachInterrupt(0, interrupt_routine, CHANGE); // interrupt 0 equivalent to pin 2(INT0) on ATmega8/168/328
  last_time = millis();
  interrupts();
}

void interrupt_routine() {
    mrf.interrupt_handler(); // mrf24 object interrupt routine
}

void loop() {
    mrf.check_flags(&handle_rx, &handle_tx);
    unsigned long current_time = millis();
    if (current_time - last_time > tx_interval) {
        last_time = current_time;
        Serial.println("txxxing...");
        mrf.send16(0x6002, "abcd");
    }
      
      j = j + 1;
      
      if(j<=3600){                   // Slow motor for 15 seconds
      slow_clock();
      }
      else {                        // Fast motor after the slow motor is finished
      fast_clock();
      }   
    int rss = (mrf.get_rxinfo()->rssi, DEC);
      if (rss > 500){
         j = 0;
         attachInterrupt(0, wakeUp, LOW);
         LowPower.powerDown(SLEEP_FOREVER, ADC_OFF, BOD_OFF); 
    } 
}

void fast_clock(){
  if(second() % 2 == 0){          // Set the motor to run every second
    digitalWrite(pin_motor, HIGH);
  }
  else {                          // Every other second, the motor isn't running
    digitalWrite(pin_motor, LOW);
  }
}

void slow_clock(){
  if(second() % 5 == 0){           // Set the motor to run every 4 seconds
    digitalWrite(pin_motor, HIGH);
  }
  else {                          //  Every other second, the motor isn't running
    digitalWrite(pin_motor, LOW);
  }
}

void wakeUp(){
  // Just a handler for the pin interrupt.
}

/*
void fast_motor() {
    digitalWrite(pin_motor, HIGH);   // turns the motor on
    delay(500);                  // waits for half a second
    digitalWrite(pin_motor, LOW);    // turns the motor off
    delay(500);                  // waits for half a second     
}


void slow_motor() {
    digitalWrite(pin_motor, HIGH);   // turns the motor on
    delay(1000);                  // waits for a second
    digitalWrite(pin_motor, LOW);    // turns the motor off
    delay(3000);                  // waits for 3 seconds    
} 
*/

void handle_rx() {
    Serial.print("received a packet ");Serial.print(mrf.get_rxinfo()->frame_length, DEC);Serial.println(" bytes long");
    
    if(mrf.get_bufferPHY()){
      Serial.println("Packet data (PHY Payload):");
      for (int i = 0; i < mrf.get_rxinfo()->frame_length; i++) {
          Serial.print(mrf.get_rxbuf()[i]);
      }
    }
    
    Serial.println("\r\nASCII data (relevant data):");
    for (int i = 0; i < mrf.rx_datalength(); i++) {
        Serial.write(mrf.get_rxinfo()->rx_data[i]);
    }
    
    Serial.print("\r\nLQI/RSSI=");
    Serial.print(mrf.get_rxinfo()->lqi, DEC);
    Serial.print("/");
    Serial.println(mrf.get_rxinfo()->rssi, DEC);
}

void handle_tx() {
    if (mrf.get_txinfo()->tx_ok) {
        Serial.println("TX went ok, got ack");
    } else {
        Serial.print("TX failed after ");Serial.print(mrf.get_txinfo()->retries);Serial.println(" retries\n");
    }
}
