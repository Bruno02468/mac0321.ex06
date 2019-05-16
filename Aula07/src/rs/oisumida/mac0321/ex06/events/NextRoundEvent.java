package rs.oisumida.mac0321.ex06.events;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Trainer;

public class NextRoundEvent implements Event {
	private Trainer P1, P2;

	public NextRoundEvent(Trainer P1, Trainer P2) {
		this.P1 = P1;
		this.P2 = P2;
	}

	@Override
	public int getPriority() {
		return 50;
	}

	@Override
	public void run(EventController controller) {
		Communicator.divider();
		String str = this.P1.getCurrentPokemon().toString();
		str += "\n ";
		for (int l = str.length()/2; l  >= 2; l--) {
			str += " ";
		}		
		str += "VS. \n";
		str += this.P2.getCurrentPokemon().toString();
		Communicator.passMessage(str);
		
		controller.addEvent(new PlayerTurnEvent(P1, P2));
		controller.addEvent(new PlayerTurnEvent(P2, P1));
		if (!P1.areAllFainted() && !P2.areAllFainted()) {
			controller.addEvent(new NextRoundEvent(P1, P2));
		}
	}

}
