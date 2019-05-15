package rs.oisumida.mac0321.ex06;

import rs.oisumida.mac0321.ex06.events.NextRoundEvent;
import rs.oisumida.mac0321.ex06.events.WildPokemonEvent;
import rs.oisumida.mac0321.ex06.factories.PokemonFactory;

public class GameMain {	
	Trainer P1, P2;
	private Map map;
	private GameController controller;
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.controller = new GameController();
		try {
			game.run();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	private void run() throws Throwable {
		Communicator.start();
		
		System.out.println("Usar treinadores padrão? [S] Sim [N] Não");
		P1 = new Trainer("Alice", Gender.FEMALE);
		P2 = new Trainer("Bob", Gender.MALE);
		//P1 = TrainerFactory.aleatorio();
		//P2 = TrainerFactory.aleatorio();
		if (!Communicator.getBool()) {
			P1 = getPlayerInfo(1, P1);
			Communicator.passMessage("Olá, "+P1.toString());
			P2 = getPlayerInfo(2, P2);
			Communicator.passMessage("Olá, "+P2.toString());
		}
		int ans = Communicator.askWhichPos("Qual modo de jogo?", new String[]{"Solo", "Versus"});
		if (ans == 0) {
			this.Solo();
		}
		if (ans == 1) {
			this.Versus();
		}
	}
	
	private void Versus() throws Throwable {
		if (P1.getRoster().isEmpty()) {
			P1.givePokemon(PokemonFactory.aleatorio());
		}
		if (P2.getRoster().isEmpty()) {
			P2.givePokemon(PokemonFactory.aleatorio());
		}
		P1.setCanFlee(false);
		P2.setCanFlee(false);
		
		controller.addEvent(new NextRoundEvent(P1, P2));
		controller.run();
	}

	private void Solo() throws Throwable {
		P1.givePokemon(PokemonFactory.aleatorio());
		this.map = new Map(this.P1);
		
		while (true) {
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
				controller.addEvent(new WildPokemonEvent(this.P1, wild));
				controller.run();
			}
		}
	}

	Trainer getPlayerInfo(int num, Trainer player) {
		Communicator.divider();
		Gender gender = (Gender) Communicator.askWhich(
				"Jogador(a) "+Integer.toString(num)+", você é:", Gender.List);
		Communicator.passMessage("Seu nome? ");
		String name = Communicator.getString();
		player.setName(name);
		player.setGender(gender);
		return player;
	}

}
