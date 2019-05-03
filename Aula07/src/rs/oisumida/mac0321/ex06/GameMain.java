package rs.oisumida.mac0321.ex06;

import rs.oisumida.mac0321.ex06.factories.PokemonFactory;

public class GameMain {	
	Trainer P1, P2;
	private Map map;
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.run();
	}
	
	private void run() {
		Communicator.start();
		
		System.out.println("Usar treinadores padrão? [S] Sim [N] Não");
		if (Communicator.getBool()) {
			P1 = new Trainer("Alice", Gender.FEMALE);
			P2 = new Trainer("Bob", Gender.MALE);
		} else {
			P1 = getPlayerInfo(1);
			Communicator.passMessage("Olá, "+P1.toString());
			P2 = getPlayerInfo(2);
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
	
	private void Versus() {
		P1.givePokemon(PokemonFactory.aleatorio());
		P2.givePokemon(PokemonFactory.aleatorio());
		
		while (true) {
			this.playerRun(P1, P2);
			this.playerRun(P2, P1);
		}
	}

	private void Solo() {
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
				Communicator.passMessage("Um(a) " + wild.getRoster().get(0).getName() + " selvagem apareceu!");
				playerRun(this.P1, wild);
			}
		}
	}

	private void playerSwitch(Trainer player, Trainer adversary) throws Exception {
		int new_pokemon = Communicator.askWhichPos(
				player.toString()+", esolha um pokémon:", player.getRoster());
		player.switchPokemon(new_pokemon);
	}
	
	@SuppressWarnings("unused")
	private void playerItem(Trainer player, Trainer adversary) throws Exception {
		if (player.getBag().size() == 0) {
			throw new MessageException("Você não tem itens!");
		}
		ItemStack item_stack = Communicator.askWhich(
				player.toString()+", esolha um item:", player.getBag());
	}
	

	private void playerFight(Trainer player, Trainer adversary) throws Exception {
		Pokemon pokemon = player.getCurrentPokemon();
		Move move = Communicator.askWhich(
				player.toString()+", esolha um ataque:", pokemon.getMoves());
		pokemon.attack(adversary.getCurrentPokemon(), move);
	}
	
	private void playerRun(Trainer player, Trainer adversary) {
		Communicator.divider();
		while (true) {
			try {
				Action act = (Action) Communicator.askWhich(
						player.toString()+", esolha uma opção:", Action.List);
				Communicator.passMessage(player.toString()+ " escolheu: "+act.toString());
				if (act == Action.FLEE) {
					throw new MessageException("Você não pode fugir!");
					// break;
				}
				if (act == Action.SWITCH) {
					this.playerSwitch(player, adversary);
				}
				if (act == Action.ITEM) {
					this.playerItem(player, adversary);
					break;
				}
				if (act == Action.FIGHT) {
					this.playerFight(player, adversary);
					break;
				}
			} catch (MessageException m) {
				Communicator.passError(m.getMessage());
			} catch (Exception e) {
				System.out.println("Algo deu muito errado :(");
				e.printStackTrace();
			}
		}
	}

	Trainer getPlayerInfo(int num) {
		Communicator.divider();
		Gender gender = (Gender) Communicator.askWhich(
				"Jogador(a) "+Integer.toString(num)+", você é:", Gender.List);
		Communicator.passMessage("Seu nome? ");
		String name = Communicator.getString();
		return new Trainer(name, gender);
	}

}
