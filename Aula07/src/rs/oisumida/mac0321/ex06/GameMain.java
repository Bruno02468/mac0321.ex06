package rs.oisumida.mac0321.ex06;

public class GameMain {	
	Trainer P1, P2;
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.run();
	}
	
	private void run() {
		Communicator.start();
		System.out.println("Ativar cores? [S] Sim [N] Não");
		if (Communicator.getBool()) {
			Communicator.enableColors();
		}
		
		P1 = getPlayerInfo(1);
		Communicator.passMessage("Olá, "+P1.toString());
		P2 = getPlayerInfo(2);
		Communicator.passMessage("Olá, "+P2.toString());
		
		while (true) {
			this.playerRun(P1);
			this.playerRun(P2);
		}
	}
	
	private void playerRun(Trainer player) {
		Communicator.divider();
		Action act = (Action) Communicator.askWhich(
				player.toString()+", esolha uma opção:", Action.List);
		Communicator.passMessage(player.toString()+ " escolheu: "+act.toString());
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
