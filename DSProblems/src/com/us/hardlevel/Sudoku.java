package com.us.hardlevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * ----------------------------------------------------------------------------------------
 * You're given a two-dimensional array that represents a 9X9 partially filled Sudoku board
 * Write a function that returns the solved Sudoku board.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *------------------------------------------------------------------------------------------
 */
public class Sudoku {
	public static void main(String[] args) {
		int[][] inputValues =
		        new int[][] {
		          {7, 8, 0, 4, 0, 0, 1, 2, 0},
		          {6, 0, 0, 0, 7, 5, 0, 0, 9},
		          {0, 0, 0, 6, 0, 1, 0, 7, 8},
		          {0, 0, 7, 0, 4, 0, 2, 6, 0},
		          {0, 0, 1, 0, 5, 0, 9, 3, 0},
		          {9, 0, 4, 0, 6, 0, 0, 0, 5},
		          {0, 7, 0, 3, 0, 0, 0, 1, 2},
		          {1, 2, 0, 0, 0, 7, 4, 0, 0},
		          {0, 4, 9, 2, 0, 6, 0, 0, 7}
		        };
		        
        var input = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < inputValues.length; i++) {
          ArrayList<Integer> row = new ArrayList<Integer>();
          for (int j = 0; j < inputValues[i].length; j++) {
            row.add(inputValues[i][j]);
          }
          input.add(row);
        }
        
		List<ArrayList<Integer>> actual = solveSudoku(input);
		System.out.println("Solved Sudoku Board : ");
		for (int i = 0; i < actual.size(); i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < actual.get(i).size(); j++) {
				System.out.print(actual.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
		solvePartialSudoku(0, 0, board);
		return board;
	}

	public static boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {
		int currentRow = row;
		int currentCol = col;

		if (currentCol == board.get(currentRow).size()) {
			currentRow += 1;
			currentCol = 0;
			if (currentRow == board.size()) {
				return true;
			}
		}
		if (board.get(currentRow).get(currentCol) == 0) {
			return tryDigitsAtPosition(currentRow, currentCol, board);
		}
		return solvePartialSudoku(currentRow, currentCol + 1, board);
	}

	public static boolean tryDigitsAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {
		for (int digit = 1; digit < 10; digit++) {
			if (isValidAtPosition(digit, row, col, board)) {
				board.get(row).set(col, digit);
				if (solvePartialSudoku(row, col + 1, board)) {
					return true;
				}
			}
		}
		board.get(row).set(col, 0);
		return false;
	}

	public static boolean isValidAtPosition(int value, int row, int col, ArrayList<ArrayList<Integer>> board) {
		boolean rowIsValid = !board.get(row).contains(value);
		boolean columnIsValid = true;

		for (int r = 0; r < board.size(); r++) {
			if (board.get(r).get(col) == value)
				columnIsValid = false;
		}
		if (!rowIsValid || !columnIsValid) {
			return false;
		}

		int subgridRowStart = (row / 3) * 3;
		int subgridColStart = (col / 3) * 3;

		for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
			for (int colIdx = 0; colIdx < 3; colIdx++) {
				int rowToCheck = subgridRowStart + rowIdx;
				int colToCheck = subgridColStart + colIdx;
				int existingValue = board.get(rowToCheck).get(colToCheck);

				if (existingValue == value) {
					return false;
				}
			}
		}
		return true;
	}
}
