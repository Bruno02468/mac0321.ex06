package rs.oisumida.mac0321.ex06.itens;

import java.util.Random;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Item;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.Trainer;

public class Pokeball extends Item {
  
  private final double capture_chance;

	public Pokeball(String name, double chance) {
	  super(name, 10, false);
		this.capture_chance = chance;
	}
	
	public boolean captureAttempt(Pokemon target) {
	  double true_chance = capture_chance
	      * (1.0 - (double)target.getHP()/target.max_hp);
	  return new Random().nextDouble() < true_chance; //FIXME
	}
	
	public boolean applyAs(Trainer player, Pokemon target) {
	  if (captureAttempt(target)) {
		Trainer adversary = target.getTrainer();
	    boolean got = player.givePokemon(target);
	    if (got) {
	    	adversary.removePokemon(target);
		    Communicator.passMessage(
		    		player.getGender().getColor() + player.getName() + Communicator.ANSI_RESET +
		    		" capturou " + target + "!");
	    } else {
	    	Communicator.passMessage(
		    		player.getGender().getColor() + player.getName() + Communicator.ANSI_RESET +
		    		" já tem pokemons demais!");
	    }
	  } else {
		  Communicator.passMessage(target + " escapou da sua " + this);
	  }
	  return true;
	}
}
