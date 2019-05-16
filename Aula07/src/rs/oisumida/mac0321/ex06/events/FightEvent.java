package rs.oisumida.mac0321.ex06.events;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Move;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.Trainer;

public class FightEvent implements Event {
	private Trainer player, adversary;
	
	FightEvent(Trainer player, Trainer adversary) {
		this.player = player;
		this.adversary = adversary;
	}

	@Override
	public int getPriority() {
		return 200;
	}

	@Override
	public void run(EventController controller) {
		Pokemon pokemon = player.getCurrentPokemon();
		Move move = Communicator.askWhich(
				player.toString()+", esolha um ataque:", pokemon.getMoves());
		pokemon.attack(adversary.getCurrentPokemon(), move);
	}
}