package rs.oisumida.mac0321.ex06.events;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Direction;
import rs.oisumida.mac0321.ex06.Map;
import rs.oisumida.mac0321.ex06.Trainer;

public class MapMove implements Event {
	Trainer player;
	Map map;
	
	public MapMove(Trainer player, Map map) {
		this.map = map;
		this.player = player;
	}
	
	@Override
	public int getPriority() {
		return 30;
	}

	@Override
	public void run(EventController controller) throws Throwable {
		Trainer wild = null;
		Communicator.passMessage(this.map.toString());
		while (true) {
			try {
				Direction dir = Communicator.getDirection();
				wild = this.map.movePlayer(dir);
				break;
			} catch (Exception e) {
				Communicator.passError(e.getMessage());
			}
		}
		if (wild != null) {
			controller.addEvent(new WildPokemonEvent(this.player, wild));
		}		
		controller.addEvent(new MapMove(this.player, this.map));
	}
}
