package rs.oisumida.mac0321.ex06;

import java.util.ArrayList;
import java.util.Iterator;

import rs.oisumida.mac0321.ex06.events.Event;
import rs.oisumida.mac0321.ex06.events.EventController;

public class GameController implements EventController {
	private ArrayList<Event> eventList;
	private boolean stopped=false;
	
	GameController() {
		this.eventList = new ArrayList<Event>();
	}
	
	@Override
	public void addEvent(Event evt) {
		this.eventList.add(evt);
	}

	public void run() throws Throwable  {
		while (!this.eventList.isEmpty() && !this.stopped) {
			this.runStep();
		}
	}

	private void runStep() throws Throwable {
		int priority = this.getMaxPriority();
		Iterator<Event> it = this.eventList.iterator();
		while (it.hasNext()) {
			Event evt = it.next();
			if (evt.getPriority() == priority) {
				evt.run(this);
				this.eventList.remove(evt);
				return;
			}
		}
	}

	private int getMaxPriority() {
		int max = 0;
		Iterator<Event> it = this.eventList.iterator();
		while (it.hasNext()) {
			int priority = it.next().getPriority();
			if (priority > max) {
				max = priority;
			}
		}
		return max;
	}

	public void stop() {
		this.stopped = true;
	}
}
