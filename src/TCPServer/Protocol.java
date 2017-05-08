package TCPServer;

import java.io.IOException;

import org.json.simple.JSONObject;

import GameCommunication.IConstants;
import GameCommunication.JsonCreator;



public class Protocol {
	private static Protocol _instance;
	private Protocol(){

	}
	
	public static Protocol getInstance(){
		if(_instance==null){
			_instance = new Protocol();
		}
		return _instance;
	}
	


}
