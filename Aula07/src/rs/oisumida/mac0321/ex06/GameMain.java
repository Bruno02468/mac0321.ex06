package rs.oisumida.mac0321.ex06;

import rs.oisumida.mac0321.ex06.events.MapMove;
import rs.oisumida.mac0321.ex06.events.NextRoundEvent;
import rs.oisumida.mac0321.ex06.factories.PokemonFactory;
import rs.oisumida.mac0321.ex06.factories.TrainerFactory;

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
		
		int ans = Communicator.askWhichPos("Qual modo de jogo?", new String[]{"Solo", "Versus"});
		if (ans == 0) {
			this.Solo();
		}
		if (ans == 1) {
			this.Versus();
		}
	}
	
	private void Versus() throws Throwable {
		System.out.println("Usar treinadores aleatórios? [S] Sim [N] Não");
		P1 = TrainerFactory.aleatorio();
		P2 = TrainerFactory.aleatorio();
		if (!Communicator.getBool()) {
			P1 = getPlayerInfo(1, P1);
			Communicator.passMessage("Olá, "+P1.toString());
			P2 = getPlayerInfo(2, P2);
			Communicator.passMessage("Olá, "+P2.toString());
		}
		
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
		System.out.println("Usar treinador aleatório? [S] Sim [N] Não");
		P1 = TrainerFactory.aleatorio();
		if (!Communicator.getBool()) {
			P1 = getPlayerInfo(1, P1);
			Communicator.passMessage("Olá, "+P1.toString());
		}
		
		if (P1.getRoster().isEmpty()) {
			P1.givePokemon(PokemonFactory.aleatorio());
		}
		
		this.map = new Map(this.P1);
		
		controller.addEvent(new MapMove(this.P1, this.map));
		controller.run();
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
