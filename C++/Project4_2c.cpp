#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	// Variables for the calories calculator
	double calories, fatGrams, caloriesPercent, fatCalories;

	cout << "Number of calories: ";
	cin >> calories;
	cout << "Fat Grams: ";
	cin >> fatGrams;

	// Equations for the (percentage of) calories coming from fat.
	fatCalories = fatGrams * 9;
	caloriesPercent = (fatCalories / calories) * 100;

	// If statement so to display the low fat comment and for abnormal calorie and fat gram numbers.
	if (fatCalories < 0.3 * calories)
	{
		cout << fixed << showpoint << setprecision(1);
		cout << "Your food has " << caloriesPercent << "%" << " from fat." << endl;
		cout << "The food is low in fat!" << endl;
	}
	else if (calories < 0 || fatGrams < 0 || fatCalories > calories)
	{
		cout << "Either the calories or fat grams were entered incorrectly." << endl;
		return 1;
	}
	else
		cout << "Your food has " << caloriesPercent << "%" << " from fat." << endl;

	cout << "" << endl;
	cout << "" << endl;

	// Variables for the menu 
	char food;
	double fatGrams2, calories2, caloriesPercent2, fatCalories2;

	// Display of what the menu is asking for
	cout << "What you have to eat: " << endl;
	cout << "B - breakfast" << endl;
	cout << "L - lunch" << endl;
	cout << "D - dinner" << endl;
	cout << "Meal Choice: ";
	cin >> food;

	// Scenarios for each case whether it is breakfast, lunch, or dinner
	switch (food)
	{
	case 'b':
	case 'B':
		cout << "How many calories: ";
		cin >> calories2;
		cout << "How many grams of fat: ";
		cin >> fatGrams2;

		fatCalories2 = fatGrams2 * 9;
		caloriesPercent2 = (fatCalories2 / calories2) * 100;

		if (fatCalories2 < 0.1 * calories2)
		{
			cout << fixed << showpoint << setprecision(1);
			cout << "Your food has " << caloriesPercent2 << "%" << " from fat." << endl;
			cout << "It is a low calories food!" << endl;
		}
		else if (calories2 < 0 || fatGrams2 < 0 || fatCalories2 > calories2)
			cout << "Either the calories or fat grams were entered incorrectly." << endl;
		else cout << "Your food has " << caloriesPercent2 << "%" << " from fat." << endl;

		break;

	case 'l':
	case 'L':
		cout << "How many calories: ";
		cin >> calories2;
		cout << "How many grams of fat: ";
		cin >> fatGrams2;

		fatCalories2 = fatGrams2 * 9;
		caloriesPercent2 = (fatCalories2 / calories2) * 100;

		if (fatCalories2 < 0.2 * calories2)
		{
			cout << fixed << showpoint << setprecision(1);
			cout << "Your food has " << caloriesPercent2 << "%" << " from fat." << endl;
			cout << "It is a low calories food!" << endl;
		}
		else if (calories2 < 0 || fatGrams2 < 0 || fatCalories2 > calories2)
			cout << "Either the calories or fat grams were entered incorrectly." << endl;
		else cout << "Your food has " << caloriesPercent2 << "%" << " from fat." << endl;

		break;

	case 'd':
	case 'D':
		cout << "How many calories: ";
		cin >> calories2;
		cout << "How many grams of fat: ";
		cin >> fatGrams2;

		fatCalories2 = fatGrams2 * 9;
		caloriesPercent2 = (fatCalories2 / calories2) * 100;

		if (fatCalories2 < 0.3 * calories2)
		{
			cout << fixed << showpoint << setprecision(1);
			cout << "Your food has " << caloriesPercent2 << "%" << " from fat." << endl;
			cout << "It is a low calories food!" << endl;
		}
		else if (calories2 < 0 || fatGrams2 < 0 || fatCalories2 > calories2)
			cout << "Either the calories or fat grams were entered incorrectly." << endl;
		else cout << "Your food has " << caloriesPercent2 << "%" << " from fat." << endl;

		break;

	default: cout << "Error: " << food << " is not a valid menu choice." << endl;
	}
	return 0;
}