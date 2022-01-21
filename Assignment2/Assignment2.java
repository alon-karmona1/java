package assignment2;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;
import java.util.Random;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		boolean flag = true;
		int[][] board = null;
		int[][] boardNew = null;
		int a = 0;
		int b = 0;
		while (flag == true) {
			System.out.println("0. End Program");
			System.out.println("1. Initialize Game Size");
			System.out.println("2. Initialize Game");
			System.out.println("3. Print 1 stage ahead");
			System.out.println("4. Print k stage ahead");
			System.out.println("Enter a digit 0-4 >");
			Scanner sc = new Scanner(System.in);
			int userInput = sc.nextInt();
			switch (userInput) {
			case 0:
				flag = false;
				break;
			case 1:
				System.out.println("Enter number of rows >");
				a = sc.nextInt();
				System.out.println("Enter number of columns >");
				b = sc.nextInt();
				if (a < 1 || b < 1) {
					System.out.println("Wrong game size");
					break;
				} else {
					board = new int[a][b];
					System.out.println("Game size set");
				}
				break;
			case 2:
				if (board == null) {
					System.out.println("No game size stored");
				} else {
					for (int i = 0; i < a; i++) {
						for (int j = 0; j < b; j++) {
							if (rand.nextBoolean()) {
								board[i][j] = 1;
							} else {
								board[i][j] = 0;
							}
							System.out.print(board[i][j] + " ");
						}
						System.out.println();
					}
				}
				break;
			case 3:
				if (board == null) {
					System.out.println("No game size stored");
				}
				else {
				int count;
				boardNew = new int[a][b];
				for (int i = 0; i < a; i++) {
					for (int j = 0; j < b; j++) {
						count = 0;;
						// running through all the board
						if (board[i][j] == 1) { // needs one or two of "1" neghibors to keep being 1.
							if (i - 2 >= 0 && j - 1 >= 0) {
								if (board[i - 2][j - 1] == 1) {
									count++;
								}
							}
							if (i - 2 >= 0 && j + 1 <= b - 1) {
								if (board[i - 2][j + 1] == 1) {
									count++;
								}
							}
							if (i - 1 >= 0 && j - 2 >= 0) {
								if (board[i - 1][j - 2] == 1) {
									count++;
								}
							}
							if (i - 1 >= 0 && j + 2 <= b - 1) {
								if (board[i - 1][j + 2] == 1) {
									count++;
								}
							}
							if (i + 1 <= a - 1 && j - 2 >= 0) {
								if (board[i + 1][j - 2] == 1) {
									count++;
								}
							}
							if (i + 1 <= a - 1 && j + 2 <= b - 1) {
								if (board[i + 1][j + 2] == 1) {
									count++;
								}
							}
							if (i + 2 <= a - 1 && j - 1 >= 0) {
								if (board[i + 2][j - 1] == 1) {
									count++;
								}
							}
							if (i + 2 <= a - 1 && j + 1 <= b - 1) {
								if (board[i + 2][j + 1] == 1) {
									count++;
								}
							}
							if (count == 1 || count == 2) { // he doesn't have the exact neghibors.
								boardNew[i][j] = 1; // switching from 1 to 0.
							}
						} // if board i,j == 1
						else if (board[i][j] == 0) { // needs two of "1" neighbors to switch to 1.
							if (i - 2 >= 0 && j - 1 >= 0) {
								if (board[i - 2][j - 1] == 1) {
									count++;
								}
							}
							if (i - 2 >= 0 && j + 1 <= b - 1) {
								if (board[i - 2][j + 1] == 1) {
									count++;
								}
							}
							if (i - 1 >= 0 && j - 2 >= 0) {
								if (board[i - 1][j - 2] == 1) {
									count++;
								}
							}
							if (i - 1 >= 0 && j + 2 <= b - 1) {
								if (board[i - 1][j + 2] == 1) {
									count++;
								}
							}
							if (i + 1 <= a - 1 && j - 2 >= 0) {
								if (board[i + 1][j - 2] == 1) {
									count++;
								}
							}
							if (i + 1 <= a - 1 && j + 2 <= b - 1) {
								if (board[i + 1][j + 2] == 1) {
									count++;
								}
							}
							if (i + 2 <= a - 1 && j - 1 >= 0) {
								if (board[i + 2][j - 1] == 1) {
									count++;
								}
							}
							if (i + 2 <= a - 1 && j + 1 <= b - 1) {
								if (board[i + 2][j + 1] == 1) {
									count++;
								}
							}
							if (count == 2) { // he doesn't have the exact neghibors.
								boardNew[i][j] = 1; // switching from 1 to 0.
							}
						} // board i,j
						System.out.print(boardNew[i][j] + " ");
					} // for j
					System.out.println();
				} // for i
				board = boardNew;
				}
				break;
			case 4:
				int k;
				if (board == null) {
					System.out.println("No game size stored");
				}
				else {
					System.out.println("number of stages you want to produce >");
					k = sc.nextInt();
					if (k < 1) {
						System.out.println("Wrong number of stages");
					}
						else {
							for (int m =0; m < k; m ++) {
								System.out.println("stage number " + (m+1));
								int count;
								boardNew = new int[a][b];
								for (int i = 0; i < a; i++) {
									for (int j = 0; j < b; j++) {
										count = 0;;
										// running through all the board
										if (board[i][j] == 1) { // needs one or two of "1" neghibors to keep being 1.
											if (i - 2 >= 0 && j - 1 >= 0) {
												if (board[i - 2][j - 1] == 1) {
													count++;
												}
											}
											if (i - 2 >= 0 && j + 1 <= b - 1) {
												if (board[i - 2][j + 1] == 1) {
													count++;
												}
											}
											if (i - 1 >= 0 && j - 2 >= 0) {
												if (board[i - 1][j - 2] == 1) {
													count++;
												}
											}
											if (i - 1 >= 0 && j + 2 <= b - 1) {
												if (board[i - 1][j + 2] == 1) {
													count++;
												}
											}
											if (i + 1 <= a - 1 && j - 2 >= 0) {
												if (board[i + 1][j - 2] == 1) {
													count++;
												}
											}
											if (i + 1 <= a - 1 && j + 2 <= b - 1) {
												if (board[i + 1][j + 2] == 1) {
													count++;
												}
											}
											if (i + 2 <= a - 1 && j - 1 >= 0) {
												if (board[i + 2][j - 1] == 1) {
													count++;
												}
											}
											if (i + 2 <= a - 1 && j + 1 <= b - 1) {
												if (board[i + 2][j + 1] == 1) {
													count++;
												}
											}
											if (count == 1 || count == 2) { // he doesn't have the exact neghibors.
												boardNew[i][j] = 1; // switching from 1 to 0.
											}
										} // if board i,j == 1
										else if (board[i][j] == 0) { // needs two of "1" neighbors to switch to 1.
											if (i - 2 >= 0 && j - 1 >= 0) {
												if (board[i - 2][j - 1] == 1) {
													count++;
												}
											}
											if (i - 2 >= 0 && j + 1 <= b - 1) {
												if (board[i - 2][j + 1] == 1) {
													count++;
												}
											}
											if (i - 1 >= 0 && j - 2 >= 0) {
												if (board[i - 1][j - 2] == 1) {
													count++;
												}
											}
											if (i - 1 >= 0 && j + 2 <= b - 1) {
												if (board[i - 1][j + 2] == 1) {
													count++;
												}
											}
											if (i + 1 <= a - 1 && j - 2 >= 0) {
												if (board[i + 1][j - 2] == 1) {
													count++;
												}
											}
											if (i + 1 <= a - 1 && j + 2 <= b - 1) {
												if (board[i + 1][j + 2] == 1) {
													count++;
												}
											}
											if (i + 2 <= a - 1 && j - 1 >= 0) {
												if (board[i + 2][j - 1] == 1) {
													count++;
												}
											}
											if (i + 2 <= a - 1 && j + 1 <= b - 1) {
												if (board[i + 2][j + 1] == 1) {
													count++;
												}
											}
											if (count == 2) { // he doesn't have the exact neghibors.
												boardNew[i][j] = 1; // switching from 1 to 0.
											}
										} // board i,j
										System.out.print(boardNew[i][j] + " ");
									} // for j
									System.out.println();
								} // for i
								board = boardNew;
								System.out.println();
							}
						}
					}
				break;
			default:
				System.out.println("Wrong menu input");
				break;
			}
		}
		System.out.println("End Program");
	}
}
