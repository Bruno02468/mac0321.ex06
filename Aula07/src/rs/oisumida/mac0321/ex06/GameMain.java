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
		P2 = getPlayerInfo(2);
	}
	
	Trainer getPlayerInfo(int num) {
		Gender gender = (Gender) Communicator.askWhich(
				"Jogador(a) "+Integer.toString(num)+", você é:", Gender.List);
		Communicator.passMessage("Seu nome? ");
		String name = Communicator.getString();
		return new Trainer(name, gender);
	}

}
