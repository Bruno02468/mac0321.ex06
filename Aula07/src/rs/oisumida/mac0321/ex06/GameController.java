package rs.oisumida.mac0321.ex06;

import java.util.ArrayList;

import rs.oisumida.mac0321.ex06.events.Event;
import rs.oisumida.mac0321.ex06.events.EventController;

public class GameController implements EventController {
	private ArrayList<Event> eventList;
	
	@Override
	public void addEvent(Event evt) {
		this.eventList.add(evt);
	}

	public void run() {
	}
}
