package rs.oisumida.mac0321.ex06.events;

import rs.oisumida.mac0321.ex06.Action;
import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.Trainer;

public class PlayerTurnEvent implements Event {
	private Trainer player, adversary;
	private int priority=100;
	
	public PlayerTurnEvent(Trainer player, Trainer adversary) {
		this.player = player;
		this.adversary = adversary;
	}
	
	public PlayerTurnEvent(Trainer player, Trainer adversary, int extra_priority) {
		this(player, adversary);
		this.priority += extra_priority;
	}
	
	@Override
	public int getPriority() {
		return this.priority;
	}
	@Override
	public void run(EventController controller) {
		if (this.player.getAutoPlay()) {
			this.auto_run(controller);
		} else {
			this.user_run(controller);
		}
	}
		
	private void auto_run(EventController controller) {
       Pokemon wild_pokemon = this.player.getCurrentPokemon();       
       wild_pokemon.attack(this.player.getCurrentPokemon(), wild_pokemon.getRandomMove());
       if (this.player.areAllFainted()) {
           Communicator.passMessage(this.player.getRoster().get(0).getName()+ " selvagem desmaiou!");
           return;
       }
   }

	private void user_run(EventController controller) {
		Communicator.divider();
		this.player.printStats();
		if (player.areAllFainted()) {
			Communicator.passMessage(player.toString()+ ", todos os seus pokemons desmaiaram!");
			controller.addEvent(new EndFightEvent());
			return;
		}
		if (adversary.areAllFainted()) {
			Communicator.passMessage(adversary.toString()+ ", todos os seus pokemons desmaiaram!");
			controller.addEvent(new EndFightEvent());
			return;
		}
		Action act = (Action) Communicator.askWhich(
				player.toString()+", esolha uma opção:", Action.List);
		Communicator.passMessage(player.toString()+ " escolheu: "+act.toString());
		if (act == Action.FLEE) {
			if (this.player.canFlee()) {
				controller.addEvent(new EndFightEvent());
				return;
			} else {
				Communicator.passMessage("Você não pode fugir!");
			}
		}
		if (act == Action.SWITCH) {
			controller.addEvent(new SwitchPokemonEvent(this.player));
			controller.addEvent(new PlayerTurnEvent(this.player, this.adversary, 1));
		}
		if (act == Action.ITEM) {
			controller.addEvent(new ItemEvent(this.player, this.adversary));
			controller.addEvent(new PlayerTurnEvent(this.player, this.adversary, 1));
		}
		if (act == Action.FIGHT) {
			controller.addEvent(new FightEvent(this.player, this.adversary));
		}
	}

}
