import java.util.Scanner;

public class Assignment4 {

	static Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("0. End Program");
		System.out.println("1. Print amount of occurrences in number");
		System.out.println("2. Print all odd numbers in array");
		System.out.println("3. Compute k mod m");
		System.out.println("4. Check if array can be divided");
		System.out.println("pleasr enter number:");
		int userInput = sc.nextInt();
		if (userInput < 0 || userInput > 4) { // check if user input is ok
			System.out.println("Wrong input");
			showMenu();
		}
		switch (userInput) {
		case 0:
			System.out.println("End program"); //finish program
			break;
		case 1:
			int dig = 4; // the num that we count
			int num = 367426432; //the number we search in
			int ammount = countTheAmountOfDigitInNumber(num, dig);
			System.out.println("The amount of occurrences in number:" + ammount);
			break;
		case 2:
			int[] arr = { 1, -8, 3, 0, -4, 5 };
			int numEzugy = countTheAmountOfOddElements(arr);
			System.out.println("The ammount of odd numbers in the arrey:" + numEzugy);
			break;
		case 3:
			int k = -22;
			int m = 100;
			int num1 = mod(k, m);
			System.out.println(num1);
			System.out.println(k + " mod " + m + " = " + num1);
			break;
		case 4:
			int[] array1 = {5,11,1,8,8,0};
			boolean checkArray = canBeDivided(array1);
			if (checkArray == true) {
				System.out.println("The array can be divided");
			}
			else {
				System.out.println("The array can not be divided");
			}
		break;
	}
	}

	public static int countTheAmountOfDigitInNumber(int num, int dig) { //count the numbers of dig in num
		// TODO Auto-generated method stub
		if (num < 10) { //always finish here.
			if (num == dig) { 
				return 1;
			} else {
				return 0;
			}
		}
		if (num % 10 == dig) { //check every last number
			return (countTheAmountOfDigitInNumber(num / 10, dig)) + 1; //rekursia plus 1 to the final run
		}
		return countTheAmountOfDigitInNumber(num / 10, dig); //rekursia to the new number
	}

	public static int countTheAmountOfOddElements(int[] arr) { //count how many odd diggits in arr
		return newFunction2(arr, arr.length - 1);
	}

	public static int newFunction2(int[] arr, int i) {
		if (i == 0) { //arr with 1 number
			if (arr[0] % 2 == 1) { // if it odd
				return 1;
			} else { //if not odd
				return 0;
			}
		}
		if (arr[i] % 2 == 1) { //checking the last number ,if it odd
			return newFunction2(arr, i - 1) + 1; // new reqursia plus 1
		} else { // if not odd
			return newFunction2(arr, i - 1); //new reqursia
		}
	}

	public static int mod(int k, int m) {
		if (k >= 0) { //if k positive
			if (k < m) { 
				return k; // k will be the modulu, 5 mod 8 = 5.
			} else if (k == m) {
				return 0; // not have modulu. 5 mod 5 = 0.
			} else { // if k > m
				return mod(k - m, m); //new reqursia with smaller number. 17 mod 6 => 11 mod 6 => 5 mod 6 = 5.  
			}
		} else { // if k is negative
			return mod(k + m, m); // plus m until it positive.
		}
	}

	public static boolean canBeDivided(int[] arr) { // check if the sum of array divide to 2 with sub arrays.
		int sum = sumArray(arr, arr.length - 1); // calc the sum of array
		if (sum % 2 == 1) { // if the sum is odd it cand divided exectly.
			return false;
		} else {
			boolean divide = calcSum(arr, 0, sum / 2);
			return divide;
		}
	}

	public static int sumArray(int[] arr, int i) { // culculate the sum of array
		if (i == 0) { //if the size of array is 1.
			return arr[0];

		} else {
			return sumArray(arr, i - 1) + arr[i]; //smaller the size of the araray plus the last number 
		}
	}
	

	public static boolean calcSum(int[] arr, int i, int sum) { // check if array have numbers that create "sum".
		boolean res = false;
		if (sum == 0) { // always can create 0.
			res = true;
		}
		else if (i >= arr.length) { // out of bounds
			res = false;
		}
		else {
			res = (calcSum(arr, i + 1, sum - arr[i]) || calcSum(arr, i + 1, sum)); // do the requria
		}
		return res;
	}


	public static void main(String[] args) {
		// Do not Change!!
		showMenu(); 
	}

}
