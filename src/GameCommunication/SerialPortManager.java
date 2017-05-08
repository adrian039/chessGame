package GameCommunication;


import java.io.IOException;
import java.io.OutputStream;


public class SerialPortManager {
	private static SerialPortManager _instance;
	private OutputStream output;
	private SerialPortManager(){
	}
	
	public static SerialPortManager getInstance(){
		if(_instance ==null){
			_instance= new SerialPortManager();
		}
		return _instance;
	}
	public void setOutput(OutputStream out){
		this.output=out;
	}
	
	public void writeUsb(int pInfo) throws IOException{
		
		output.write(pInfo);
		output.flush();
		System.out.println("Escribiendo en el serial: "+pInfo);
	}
}