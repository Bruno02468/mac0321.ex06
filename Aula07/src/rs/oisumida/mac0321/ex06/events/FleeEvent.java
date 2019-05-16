package rs.oisumida.mac0321.ex06.events;

public class FleeEvent implements Event {
	@Override
	public int getPriority() {
		return 250;
	}

	@Override
	public void run(EventController controller) {
		controller.removeEventByType(PlayerTurnEvent.class);
		controller.removeEventByType(NextRoundEvent.class);
	}

}
