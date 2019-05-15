package rs.oisumida.mac0321.ex06.events;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.ItemStack;
import rs.oisumida.mac0321.ex06.Trainer;

public class ItemEvent implements Event {
	private Trainer player, adversary;

	public ItemEvent(Trainer player, Trainer adversary) {
		this.player = player;
		this.adversary = adversary;
	}

	@Override
	public int getPriority() {
		return 200;
	}

	@Override
	public void run(EventController controller) {
		if (player.getBag().size() == 0) {
			Communicator.passError("Você não tem itens!");
			return;
		}
		ItemStack item_stack = Communicator.askWhich(
				player.toString()+", esolha um item:", player.getBag());
		if (item_stack.getAmount() <= 0) {
			Communicator.passError("itens insuficientes");
			return;
		}
		item_stack.applyAs(player, adversary.getCurrentPokemon());
	}
}