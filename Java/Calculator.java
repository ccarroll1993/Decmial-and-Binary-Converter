import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.applet.Applet;
import java.util.ArrayList;
	
public class Calculator extends JFrame implements ActionListener{
	private JTextArea solutionArea;
	private JButton equals;
	private JButton plus;
	private JButton minus;
	private JButton mult;
	private JButton divide;
	private JButton clear;
	private JButton zero;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private String num = "";
	private ArrayList<String> numbers = new ArrayList();
	private int total = 0;
	
	Calculator(){
		JLabel solution = new JLabel("");
		
		//Title
		setTitle("GUI Calculator");
		
		
		// Text Area
		solutionArea = new JTextArea(5,18);
		solutionArea.setEditable(false);
		solutionArea.setText("");
		solutionArea.setVisible(true);
		
		//Buttons
		equals = new JButton("=");
		plus = new JButton("+");
		minus = new JButton("-");
		mult = new JButton("x");
		divide = new JButton("/");
		clear = new JButton("CLR");
		zero = new JButton("0");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		
		// Setting up action listener
		equals.addActionListener(this);
		plus.addActionListener(this);
		minus.addActionListener(this);
		mult.addActionListener(this);
		divide.addActionListener(this);
		clear.addActionListener(this);
		zero.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		
		// Layout for the calculator
		setLayout(new GridBagLayout());
		
		GridBagConstraints layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 5, 1);
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		add(solution, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 10, 15, 10);
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 5;
		add(solutionArea, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 10);
		layoutConst.weightx = 0.0;
		layoutConst.gridx = 4;
		layoutConst.gridy = 4;
		add(clear, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 5, 1, 5);
		layoutConst.gridx = 1;
		layoutConst.gridy = 5;
		add(seven, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 5);
		layoutConst.gridx = 2;
		layoutConst.gridy = 5;
		add(eight, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 0);
		layoutConst.gridx = 3;
		layoutConst.gridy = 5;
		add(nine, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 5, 1, 5);
		layoutConst.gridx = 1;
		layoutConst.gridy = 6;
		add(four, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 5);
		layoutConst.gridx = 2;
		layoutConst.gridy = 6;
		add(five, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 0);
		layoutConst.gridx = 3;
		layoutConst.gridy = 6;
		add(six, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 5, 1, 5);
		layoutConst.gridx = 1;
		layoutConst.gridy = 7;
		add(one, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 5);
		layoutConst.gridx = 2;
		layoutConst.gridy = 7;
		add(two, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 0);
		layoutConst.gridx = 3;
		layoutConst.gridy = 7;
		add(three, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 5, 10, 5);
		layoutConst.fill = GridBagConstraints.BOTH;
		layoutConst.gridx = 1;
		layoutConst.gridy = 8;
		layoutConst.gridwidth = 2;
		add(zero, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 10, 0);
		layoutConst.gridx = 3;
		layoutConst.gridy = 8;
		add(equals, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 10, 10);
		layoutConst.ipadx = 16;
		layoutConst.gridx = 4;
		layoutConst.gridy = 8;
		add(plus, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 10);
		layoutConst.ipadx = 19;
		layoutConst.gridx = 4;
		layoutConst.gridy = 7;
		add(minus, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 10);
		layoutConst.ipadx = 16;
		layoutConst.gridx = 4;
		layoutConst.gridy = 6;
		add(mult, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 0, 1, 10);
		layoutConst.ipadx = 20;
		layoutConst.gridx = 4;
		layoutConst.gridy = 5;
		add(divide, layoutConst);
		
		numbers.add("initial");
		}
	
	
	public static void main(String[] args) {
	// Setting the frame/window for the calculator
	Calculator frame = new Calculator();
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		// adds to string 'num' to increase digits
		if (event.getSource() == zero) {
			num += '0';
			solutionArea.setText(num);
		}
		if(event.getSource() == one) {
			num += '1';
			solutionArea.setText(num);
		}
		if (event.getSource() == two) {
			num+='2';
			solutionArea.setText(num);
		}
		if (event.getSource() == three) {
			num += '3';
			solutionArea.setText(num);
		}
		if (event.getSource() == four) {
			num += '4';
			solutionArea.setText(num);
		}
		if (event.getSource() == five) {
			num += '5';
			solutionArea.setText(num);
		}
		if (event.getSource() == six) {
			num += '6';
			solutionArea.setText(num);
		}
		if (event.getSource() == seven) {
			num += '7';
			solutionArea.setText(num);
		}
		if (event.getSource() == eight) {
			num += '8';
			solutionArea.setText(num);
		}
		if (event.getSource() == nine) {
			num += '9';
			solutionArea.setText(num);
		}
		if(event.getSource() == clear) {
			solutionArea.setText(" ");	//emptying text
			num = "";	//reseting number
			total = 0;
			for(int j=numbers.size()-1; j<=0; j--) {
				numbers.remove(j);
			}
			
		}
		if(event.getSource() == plus) {
			String temp = num;	// holding number
			num +=  '+';
			solutionArea.setText("+");
			numbers.add(temp);	// adding the number to array
			numbers.add("+");	// adding + in the array
			num = "";		// resetting number
		}
		if(event.getSource() == minus) {
			String temp = num;
			num +=  '-';
			solutionArea.setText("-");
			numbers.add(temp);
			numbers.add("-");
			num = "";
		}
		if(event.getSource() == mult) {
			String temp = num;
			num +=  'x';
			solutionArea.setText("x");
			numbers.add(temp);
			numbers.add("x");
			num = "";
		}
		if(event.getSource() == divide) {
			String temp = num;
			num +=  '/';
			solutionArea.setText("/");
			numbers.add(temp);
			numbers.add("/");
			num = "";
		}
		if(event.getSource() == equals) {
			String temp = num;	
			numbers.add(temp);	// adding num to array to complete expression
			for(int i=1; i<numbers.size()-1; i++) {		// going through array
				int plus1 = i + 1;
				int minus1 = i - 1;
				if (i==2) {		// for the first number
					if(numbers.get(i) == "+") {
						total = Integer.valueOf(numbers.get(plus1)) + Integer.valueOf(numbers.get(minus1));
					}
					else if(numbers.get(i) == "-") {
						total = Integer.valueOf(numbers.get(minus1)) - Integer.valueOf(numbers.get(plus1));
					}
					else if(numbers.get(i) == "x") {
						total = Integer.valueOf(numbers.get(plus1)) * Integer.valueOf(numbers.get(minus1));
					}
					else if(numbers.get(i) == "/") {
						total = Integer.valueOf(numbers.get(minus1)) / Integer.valueOf(numbers.get(plus1));
					}
				}
				else {			//after adding the first two numbers
					if(numbers.get(i) ==  "+") {
						total = total + Integer.valueOf(numbers.get(plus1));
					}
					if(numbers.get(i) ==  "-") {
						total = total - Integer.valueOf(numbers.get(plus1));
					}
					if(numbers.get(i) ==  "x") {
						total = total * Integer.valueOf(numbers.get(plus1));
					}
					if(numbers.get(i) ==  "/") {
						total = total / Integer.valueOf(numbers.get(plus1));
					}
						
				}
				
			}
			solutionArea.setText(Integer.toString(total));
		}
	}
}
