package rs.oisumida.mac0321.ex06.itens;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Item;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.Trainer;

public class Pokeboll extends Item {

	public Pokeboll(String name, int max_stack) {
		super("Pokebola", 8);
	}

	@Override
	public boolean apply(Trainer player, Pokemon target) {
		target.damage(999999);
		player.givePokemon(target);
		Communicator.passMessage(player.toString() + ", capturou " + target.getName());
		return true;
	}

}
