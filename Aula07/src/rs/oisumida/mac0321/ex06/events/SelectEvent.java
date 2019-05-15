package rs.oisumida.mac0321.ex06.events;

import java.util.ArrayList;
import java.util.Iterator;

import rs.oisumida.mac0321.ex06.Communicator;

public class SelectEvent<T> implements Event {
	private ArrayList<T> opts;
	private int ans=-1;
	private String prompt;
	
	SelectEvent(String prompt, ArrayList<T> opts) throws Exception {
		this.prompt = prompt;
		this.opts = opts;
		if (opts.size() == 0) {
			throw new Exception("lista de opção não pode ser nula");
		}
	}
	
	public int getAnsPos() {
		return this.ans;
	}
	
	public T getAns() {
		return this.opts.get(this.ans);
	}
	
	public int getPriority() {
		return 999;
	}

	public void run(EventController controller) {
		System.out.println(prompt);
		Iterator<T> it = opts.iterator();
		for (int i = 1; it.hasNext(); i++) {
			System.out.print("[");
			System.out.print(i);
			System.out.println("] "+it.next().toString());
		}
		this.ans = Communicator.getInt(1, opts.size())-1;
	}
}
