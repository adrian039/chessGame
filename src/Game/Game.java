package Game;

import java.io.IOException;
import java.util.ArrayList;

import ChessLogic.ChessGame;
import ChessLogic.Piece;
import GameCommunication.TxtReader;
import GameCommunication.TxtWriter;

public class Game {
	
	private ChessGame chessGame;
	private ArrayList<String> _move;
	private TxtWriter _writer;
	private TxtReader _reader;
	public Game() {
		_writer = new TxtWriter();
		_reader = new TxtReader();
		_move = new ArrayList<String>();
		// create a new chess game
		//
		this.chessGame = new ChessGame();
	}
	
	public void saveMoves(String input){
		_move.add(input);
		 System.out.println(_move.toString());
	}
	public void saveGame(String file){
		int cont = 0;
		while(cont<_move.size()){
		String move = _move.get(cont);
		_writer.writeInFile(move, file);
		cont++;
		}
	}
	public void loadGame(String pFile){
		_reader.openFile(pFile);
		int total = _reader.lineCounter(pFile);
		int cont =0 ;
		while(total>cont){
		  try {
			String inst = _reader.readLine(cont);
			handleMove(inst);
			wait(10000);
			cont++;
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	public void handleMove(String input) throws IOException {
		 SerialTest.strSourceColumn = input.substring(0, 1);
		 SerialTest.strSourceRow = input.substring(1, 2);
		 SerialTest.strTargetColumn = input.substring(3, 4);
		 SerialTest.strTargetRow = input.substring(4, 5);
		int sourceColumn = 0;
		int sourceRow = 0;
		int targetColumn = 0;
		int targetRow = 0;

		sourceColumn = convertColumnStrToColumnInt(SerialTest.strSourceColumn);
		sourceRow = convertRowStrToRowInt(SerialTest.strSourceRow);
		targetColumn = convertColumnStrToColumnInt(SerialTest.strTargetColumn);
		targetRow = convertRowStrToRowInt(SerialTest.strTargetRow);

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
