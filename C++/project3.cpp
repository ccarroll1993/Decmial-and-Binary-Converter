// The program will show how much John Doe has in his savings account. 
#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main()
{
	// List of variables
	string name;
	double principal, interestRate, timesCompounded, interest, amount, rate;

	// Output for values that has to be entered.
	cout << "Enter full name: ";
	getline(cin, name);
	cout << "Interest Rate: ";
	cin >> interestRate;
	cout << "Times Compounded: ";
	cin >> timesCompounded;
	cout << "Principal: $";
	cin >> principal;

	// Equations
	rate = interestRate / 100;
	amount = principal * pow(1 + (rate / timesCompounded), timesCompounded);
	interest = principal * rate;

	// Output for the values through calculation.
	cout << "Interest: $" << interest << endl;
	cout << "Amount in Savings: $" << amount << endl;
	cout << name << " has a total amount of $" << amount << " in the savings account." << endl;
	return 0;
}