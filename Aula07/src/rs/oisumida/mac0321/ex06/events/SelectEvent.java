package rs.oisumida.mac0321.ex06.events;

import java.util.ArrayList;

public class SelectEvent<T> implements Event {
	ArrayList<T> opts;
	
	public int getPriority() {
		return 999;
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

}
