package rs.oisumida.mac0321.ex06.events;

import rs.oisumida.mac0321.ex06.Trainer;

public class PlayerRoundEvent implements Event {
	private Trainer P1, P2;

	public PlayerRoundEvent(Trainer P1, Trainer P2) {
		this.P1 = P1;
		this.P2 = P2;
	}

	@Override
	public int getPriority() {
		return 50;
	}

	@Override
	public void run(EventController controller) {
		controller.addEvent(new PlayerTurnEvent(P1, P2));
		controller.addEvent(new PlayerTurnEvent(P2, P1));
		controller.addEvent(new PlayerRoundEvent(P1, P2));
	}

}
