import java.util.Scanner;

public class Assignment3 {

	static Scanner sc = new Scanner(System.in);

	public static int readInt() { // taking int from user
		return Integer.parseInt(sc.nextLine());
	}

	public static String readLine() { // taking string from user
		return sc.nextLine();
	}

	public static int[] getBlackCell(int[][] blackCells, int i, int j) { 
		for (int k = 0; k < blackCells.length; k++) {
			if (blackCells[k][0] == i && blackCells[k][1] == j) {
				return blackCells[k];
			}
		}
		return null;
	}

	public static void printKakuro(int[][] board, int[][] blackCells) { //printing the board
		int[] bcell = null;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// if (i,j) is black cell
				if ((bcell = getBlackCell(blackCells, i, j)) != null) {
					System.out.print(
							String.format("[%2s/%-2s]", bcell[2] == 0 ? "" : bcell[2], bcell[3] == 0 ? "" : bcell[3]));
				}
				// if (i,j) is empty
				else if (board[i][j] == 0) {
					System.out.print(String.format("[%-5s]", ""));
				}
				// else (i,j) contains value from user
				else {
					System.out.print(String.format("[  %d  ]", board[i][j]));
				}
			}
			System.out.println();
		}
	}

	public static void printMenu() { //printing the main menu
		System.out.println("Kakuro:");
		System.out.println("1. Read instance");
		System.out.println("2. Play");
		System.out.println("3. Exit");
		System.out.println("Select an option:");
	}

	public static int[][] initBoard() { //returning board with rows and colums number.
		System.out.println("Enter number of rows in kakuro board:");
		int numRows = readInt();
		System.out.println("Enter number of columns in kakuro board:");
		int numColums = readInt();
		int[][] board1 = new int[numRows][numColums];
		return board1;
	}

	public static String[] splitString(String str, char seperator) { /* taking string with seperator and making array of
		substrings without the seperetor. "acb+efg+hij" --> [abc,efg,hij]  */
		int count = 0;
		int temp = 0;
		for (int i = 0; i < str.length(); i++) { //counting the numbers of the seperators. 
			if (str.charAt(i) == seperator) {
				count = count + 1;
			}
		}
		String[] newstring = new String[count + 1]; // if 3 seperators --> 4 substrings.
		int position = -1;
		for (int i = 0; i < newstring.length; i++) {
			position = str.indexOf(seperator, position + 1);
			if (position >= 0) {
				newstring[i] = str.substring(temp, position); // filling the array with the substring.
				temp = position + 1;
			} else {
				newstring[i] = str.substring(temp); // filling the array with substring.
			}
		}
		return newstring;

	}

	public static int[] extractIndicesOfPair(String pairStr) { /*taking string pair of numbers and making array with
		the 2 numbers. "123,456" --> [123,456]  */
		String[] strArray = splitString(pairStr, ','); // spliting with the function "splitstring"
		int[] arr = new int[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			arr[i] = Integer.parseInt(strArray[i]); // making  number from string for every index
		}
		return arr;
	}

	public static int[] parseHint(String hintStr) { //taking string of hint and making to array of numbers representing.
   // "16=1,1+2,1+3,1" --> [16,1,1,2,1,2,1]
		int count = 0;
		for (int i = 0; i < hintStr.length(); i++) { 
			if (hintStr.charAt(i) == '=') { //counting seperators.
				count++;
			}
			if (hintStr.charAt(i) == ',') {
				count++;
			}
			if (hintStr.charAt(i) == '+') {
				count++;
			}
		}
		int[] hints = new int[count + 1]; // if i'll have 4 seperators --> 5 numbers .

		String[] equal = splitString(hintStr, '='); // splitting the sum from the others
		hints[0] = Integer.parseInt(equal[0]); //putting the sum in the array
		String[] plus = splitString(equal[1], '+'); // splitting to the points ["1,1","2,1"]
		int located = 1;
		for (int i = 0; i < plus.length; i++) {
			int[] num = extractIndicesOfPair(plus[i]);
			hints[located] = num[0]; // filling the cells in the hints by the first number of the pair.
			hints[located + 1] = num[1]; // filling the cells in the hints by the second number of the pair.
			located += 2; // goo another time for the next pair (point).
		}
		return hints;
	}

	public static int[][] readAllHints() { // get num of hints and hints. give back int[][] of nums represent the hints
		System.out.println("Enter total number of hints:");
		int numHint = readInt(); // numbers of hints
		int[][] array = new int[numHint][]; // the final array.
		System.out.println("Enter hints:");
		for (int i = 0; i < numHint; i++) {
			String hintString = readLine();
			int[] hintArray = parseHint(hintString); // changing the string hint to array of ints.
			array[i] = hintArray; // each row get a hintArray.
		} // for i
		return array; // return int[][] of nums represent the hints
	}

	public static int[] parseBlackCell(String blackCellStr) { // change string (represent black cube) to array of ints
		int count = 0;
		for (int i = 0; i < blackCellStr.length(); i++) { // counting how many "=" "," "/" are.
			if (blackCellStr.charAt(i) == '=') {
				count++;
			}
			if (blackCellStr.charAt(i) == ',') {
				count++;
			}
			if (blackCellStr.charAt(i) == '/') {
				count++;
			}
		}
		String[] equal = splitString(blackCellStr, '='); // split the string to 2 array of strings
		int[] equal0 = extractIndicesOfPair(equal[0]); // change from pair in string to 2 intigers
		String[] slash = splitString(equal[1], '/'); // split the right side to 2 array of strings
		int[] slashArr = new int[2];
		slashArr[0] = Integer.parseInt(slash[0]); // change slash (2 strings) to slashArr( 2 intigers)
		slashArr[1] = Integer.parseInt(slash[1]); // also
		int[] blackArray = new int[count + 1]; // the final array.
		for (int i = 0; i < equal0.length; i++) { // the 2 first int from equal0 goes to 0,1 in blackarray
			blackArray[i] = equal0[i];
		}
		for (int i = 0; i < slashArr.length; i++) { // the 2 first int from equal0 goes to 2,3 in blackarray
			blackArray[i + 2] = slashArr[i];
		}
		return blackArray;
	}

	public static int[][] readBlackCells() { //
		System.out.println("Enter total number of black cells:");
		int numCells = readInt();
		System.out.println("Enter black cells:");
		int[][] blackArray = new int[numCells][];
		for (int i = 0; i < numCells; i++) {
			String cells = readLine();
			int[] cellsArray = parseBlackCell(cells);
			blackArray[i] = cellsArray;
		}
		return blackArray;
	}

	public static void printGameModeOptions() { // print the 2 case menu.
		System.out.println("Play:");
		System.out.println("1. Fill cell");
		System.out.println("2. Clear cell");
		System.out.println("3. Verify solution");
		System.out.println("4. End game");
		System.out.println("Select an option:");
	}

	public static boolean isBlackCell(int[][] blackCells, int i, int j) { //cheking if the cell is black cell.

		for (int k = 0; k < blackCells.length; k++) { //runing through the rows.
			if (blackCells[k][0] == i && blackCells[k][1] == j) {
				return true;
			}
		}
		return false;
	}

	public static boolean put(int[][] board, int[][] blackCells, int i, int j, int val) { //if possible put val in cell.
		if (i < board.length && j < board[0].length) { // if the cell is inside the matrix.
			if (val > 0 && val < 10) { // if the val is between 1-9.
				if (isBlackCell(blackCells, i, j) == false) { //if the cell is not black cell.
					board[i][j] = val;
					return true;
				}
			}
		}
		return false;
	}

	public static boolean clear(int[][] board, int[][] blackCells, int i, int j) { // if possible delete the val in cell.
		if (i < board.length && j < board[0].length) { // if the cell is inside the matrix.
			if (isBlackCell(blackCells, i, j) == false) { //if the cell is not black cell.
				board[i][j] = 0; // clear the cell.
				return true;
			}
		}
		return false;
	}

	public static int[] getHintCells(int[] hint, int[][] board) { /* taking the hint and giving array of the values in
		the points */
		int[] arrVal = new int[hint.length / 2];
		for (int i = 1; i < hint.length - 1; i += 2) { // dont touch the first num (sum), medaleg every two nums. 
			arrVal[i/2] = board[hint[i]][hint[i + 1]]; //put me the val in the board for the point in the hint. example:
			/*      6   8   9
			 *      v   v   v
			 * [16,1,1,2,1,3,1]
			  [6,8,9] */
		}
		return arrVal;
	}

	public static boolean allDiff(int[] arr) { //cheking if all the nums different from each other.
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean between(int[] arr, int min, int max) { // checking if all the nums between the min,max.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max || arr[i] < min) {
				return false;
			}
		}
		return true;
	}

	public static int arraySum(int[] arr) {  //giving the sum of the nums in the arr.
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static boolean verifyHint(int[] hint, int[][] board) { //verify if the hint with the values ok.
		int[] arrVal = getHintCells(hint, board); // making array of the values in the points.
		int sum = arraySum(arrVal); // sum of all the values.
		if (hint[0] == sum && allDiff(arrVal) == true && between(arrVal, 0, 10) == true) { 
			/* if the first num is sum , all the values different and between 1-9 so */
			return true;
		}
		return false;
	}

	public static boolean verifyKakuro(int[][] board, int[][] hints) { //verify if the board  is with all the corect hints.
		for (int i = 0; i < hints.length; i++) {
			boolean verify = verifyHint(hints[i], board); // checking every hint if he is ok.
			if (verify == false) {
				return false;
			}
		}
		return true;
	}

	public static void clean(int[][] board) { //puting 0 in all the cells in the board.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) {

		int[][] board = null;
		int[][] blackCells = null;
		int[][] hints = null;
		boolean keepGoing = true;
		while (keepGoing) { // if choosing "3" keepGoing will be false.
			printMenu();
			int userInput = readInt();
			switch (userInput) {
			case 1:
				board = initBoard();
				hints = readAllHints();
				blackCells = readBlackCells();
				printKakuro(board, blackCells); // making the size of the board, all hints and all blackcells
				break;
			case 2:
				printKakuro(board, blackCells);
				printGameModeOptions(); // the 2 case menu.
				boolean exit2 = true;
				while (exit2) { // if choosing "4" exit2 will be false.
					int userInput2 = readInt();
					switch (userInput2) {
					case 1:
						System.out.println("Enter row index:");
						int i1 = readInt();
						System.out.println("Enter column index:");
						int j1 = readInt();
						System.out.println("Enter value:");
						int val = readInt();
						boolean fillCell = put(board, blackCells, i1, j1, val);
						if (fillCell == false) { // if something is error with filling the board.
							System.out.println("Operation failed!");
						}
						printKakuro(board, blackCells); // if its ok, printing with the new cell that filled.
						printGameModeOptions();
						break;
					case 2:
						System.out.println("Enter row index:");
						int i2 = readInt();
						System.out.println("Enter column index:");
						int j2 = readInt();
						boolean clearCell = clear(board, blackCells, i2, j2);
						if (clearCell == false) { // iff the conditions not afford to clear the cell.
							System.out.println("Operation failed!");
						}
						printKakuro(board, blackCells); // if its ok, printing with the new cell that cleared.
						printGameModeOptions();
						break;
					case 3:
						boolean verify = verifyKakuro(board, hints); // verify if the board fullfill good.
						if (verify == true) {
							System.out.println("Well done!");
						} else {
							System.out.println("Not a solution!");
						}
						printKakuro(board, blackCells);
						printGameModeOptions();
						break;
					case 4:
						System.out.println("Game over!");
						clean(board);
						exit2 = false; // going back to the main menu.
						break;
					} // switch
				} // while
				break;
			case 3:
				System.out.println("Exiting!");
				keepGoing = false;
				break;
			}
		}
	}

}
