package rs.oisumida.mac0321.ex06.events;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.Trainer;

public class WildPokemonEvent implements Event {
	private Trainer player, wild;
	
	public WildPokemonEvent(Trainer player, Trainer wild) {
		this.wild = wild;
		this.player = player;
	}

	@Override
	public int getPriority() {
		return 40;
	}

	@Override
	public void run(EventController controller) throws Throwable {
		this.player.setCanFlee(true);
		Pokemon wild_pokemon = this.wild.getCurrentPokemon();
        Communicator.passMessage("Um(a) " + wild_pokemon.getName() + " selvagem apareceu!");
        controller.addEvent(new NextRoundEvent(this.player, this.wild));
	}
}
