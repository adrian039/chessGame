package Game;

import ChessLogic.ChessGame;
import ChessLogic.Piece;

public class Game {
	
	private ChessGame chessGame;
	
	public Game() {

		// create a new chess game
		//
		this.chessGame = new ChessGame();
	}
	
	
	public void handleMove(String input) {
		String strSourceColumn = input.substring(0, 1);
		String strSourceRow = input.substring(1, 2);
		String strTargetColumn = input.substring(3, 4);
		String strTargetRow = input.substring(4, 5);

		int sourceColumn = 0;
		int sourceRow = 0;
		int targetColumn = 0;
		int targetRow = 0;

		sourceColumn = convertColumnStrToColumnInt(strSourceColumn);
		sourceRow = convertRowStrToRowInt(strSourceRow);
		targetColumn = convertColumnStrToColumnInt(strTargetColumn);
		targetRow = convertRowStrToRowInt(strTargetRow);

		chessGame.movePiece(sourceRow, sourceColumn, targetRow, targetColumn);
	}

	/**
	 * Converts a column string (e.g. 'a') into its internal representation.
	 * 
	 * @param strColumn a valid column string (e.g. 'a')
	 * @return internal integer representation of the column
	 */
	private int convertColumnStrToColumnInt(String strColumn) {
		if (strColumn.equalsIgnoreCase("a")) {
			return Piece.COLUMN_A;
		} else if (strColumn.equalsIgnoreCase("b")) {
			return Piece.COLUMN_B;
		} else if (strColumn.equalsIgnoreCase("c")) {
			return Piece.COLUMN_C;
		} else if (strColumn.equalsIgnoreCase("d")) {
			return Piece.COLUMN_D;
		} else if (strColumn.equalsIgnoreCase("e")) {
			return Piece.COLUMN_E;
		} else if (strColumn.equalsIgnoreCase("f")) {
			return Piece.COLUMN_F;
		} else if (strColumn.equalsIgnoreCase("g")) {
			return Piece.COLUMN_G;
		} else if (strColumn.equalsIgnoreCase("h")) {
			return Piece.COLUMN_H;
		} else
			throw new IllegalArgumentException("invalid column: " + strColumn);
	}

	/**
	 * Converts a row string (e.g. '1') into its internal representation.
	 * 
	 * @param strRow a valid row string (e.g. '1')
	 * @return internal integer representation of the row
	 */
	private int convertRowStrToRowInt(String strRow) {
		if (strRow.equalsIgnoreCase("1")) {
			return Piece.ROW_1;
		} else if (strRow.equalsIgnoreCase("2")) {
			return Piece.ROW_2;
		} else if (strRow.equalsIgnoreCase("3")) {
			return Piece.ROW_3;
		} else if (strRow.equalsIgnoreCase("4")) {
			return Piece.ROW_4;
		} else if (strRow.equalsIgnoreCase("5")) {
			return Piece.ROW_5;
		} else if (strRow.equalsIgnoreCase("6")) {
			return Piece.ROW_6;
		} else if (strRow.equalsIgnoreCase("7")) {
			return Piece.ROW_7;
		} else if (strRow.equalsIgnoreCase("8")) {
			return Piece.ROW_8;
		} else
			throw new IllegalArgumentException("invalid column: " + strRow);
	}

}
