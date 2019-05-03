package rs.oisumida.mac0321.ex06;

import java.util.ArrayList;

import rs.oisumida.mac0321.ex06.factories.PokemonFactory;
import rs.oisumida.mac0321.ex06.factories.TrainerFactory;

public class GameMain {	
	Trainer P1, P2;
	private Map map;
	private boolean canFlee = false;
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.run();
	}
	
	private void run() {
		Communicator.start();
		
		System.out.println("Usar treinadores padrão? [S] Sim [N] Não");
		P1 = TrainerFactory.aleatorio();
		P2 = TrainerFactory.aleatorio();
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
	
	private void Versus() {
		P1.givePokemon(PokemonFactory.aleatorio());
		P2.givePokemon(PokemonFactory.aleatorio());
		this.canFlee  = true;
		
		boolean keep_fighting;
		while (true) {
			P1.printStats();
			P2.printStats();
			keep_fighting = this.playerRun(P1, P2);
			if (!keep_fighting) {
				break;
			}
			keep_fighting = this.playerRun(P2, P1);
			if (!keep_fighting) {
				break;
			}
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
				Pokemon wild_pokemon = wild.getCurrentPokemon();
				Communicator.passMessage("Um(a) " + wild_pokemon.getName() + " selvagem apareceu!");
				boolean keep_fighting;
				while (true) {
					P1.printStats();
					Communicator.passMessage("Pokemon selvagem:");
					System.out.print("\t");
					wild_pokemon.printStats();
					keep_fighting = this.playerRun(P1, wild);
					if (!keep_fighting) {
						break;
					}
					
					wild_pokemon.attack(P1.getCurrentPokemon(), wild_pokemon.getRandomMove());
					if (wild.areAllFainted()) {
						Communicator.passMessage(wild.getRoster().get(0).getName()+ " selvagem desmaiou!");
						return;
					}
				}
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
		if (item_stack.getAmount() <= 0) {
			throw new Exception("itens insuficientes");
		}
		item_stack.applyAs(player, adversary.getCurrentPokemon());
	}
	

	private void playerFight(Trainer player, Trainer adversary) throws Exception {
		Pokemon pokemon = player.getCurrentPokemon();
		Move move = Communicator.askWhich(
				player.toString()+", esolha um ataque:", pokemon.getMoves());
		pokemon.attack(adversary.getCurrentPokemon(), move);
	}
	
	// has next round
	private boolean playerRun(Trainer player, Trainer adversary) {
		Communicator.divider();
		if (player.areAllFainted()) {
			Communicator.passMessage(player.toString()+ " todos os seus pokemons desmaiaram!");
			return false;
		}
		while (true) {
			try {
				Action act = (Action) Communicator.askWhich(
						player.toString()+", esolha uma opção:", Action.List);
				Communicator.passMessage(player.toString()+ " escolheu: "+act.toString());
				if (act == Action.FLEE) {
					if (this.canFlee) {
						return false;
					}
					throw new MessageException("Você não pode fugir!");
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
		return true;
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
