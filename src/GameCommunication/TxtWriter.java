package GameCommunication;

import java.io.*;

public class TxtWriter {
	private String _file;
	private FileWriter _writer;
	private BufferedWriter _buffer;
	public TxtWriter(){
		
		
}
	
	private void openFile(){
		try {
			_writer = new FileWriter(_file);
			_buffer = new BufferedWriter(_writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void closeFile(){
		try {
			_buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public void writeInFile(String pData, String pFile){
		_file = pFile;
		openFile();
		try {
			_buffer.write(pData);
			_buffer.newLine();
			closeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}