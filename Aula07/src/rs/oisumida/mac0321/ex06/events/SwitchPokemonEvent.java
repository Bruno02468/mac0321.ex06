package rs.oisumida.mac0321.ex06.events;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Trainer;

public class SwitchPokemonEvent implements Event {
	private Trainer player;
	
	public SwitchPokemonEvent(Trainer player) {
		this.player = player;
	}

	@Override
	public int getPriority() {
		return 200;
	}

	@Override
	public void run(EventController controller) throws Exception {
		int new_pokemon = Communicator.askWhichPos(
				player.toString()+", esolha um pokémon:", player.getRoster());
		player.switchPokemon(new_pokemon);

	}
}