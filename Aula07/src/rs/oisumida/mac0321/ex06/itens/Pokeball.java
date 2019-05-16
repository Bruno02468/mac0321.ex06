package rs.oisumida.mac0321.ex06.itens;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Item;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.Trainer;

public class Pokeball extends Item {
  
  private final double capture_chance;
  private final String name;

	public Pokeball(String name, double chance, int max_stack) {
	  super(name, max_stack, false);
	  this.name = name;
		this.capture_chance = chance;
	}
	
	public boolean captureAttempt() {
	  return true; //FIXME
	}
	
	public boolean applyAs(Trainer player, Pokemon target) {
		player.givePokemon(target);
		target.getTrainer().removePokemon(target);
		Communicator.passMessage(player + " capturou " + target);
		return true;
	}
}
