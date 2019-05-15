package rs.oisumida.mac0321.ex06.events;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Trainer;

public class EndBattleEvent implements Event {
	private Trainer p1, p2;
	
	public EndBattleEvent(Trainer p1, Trainer p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public int getPriority() {
		return 900;
	}

	@Override
	public void run(EventController controller) {
		Communicator.passError("TODO: decidir vencedor!");
		controller.stop();
	}

}
