package rs.oisumida.mac0321.ex06;

public class GameMain {

	private static java.util.Scanner scanner;
	
//	Trainer P1, P2;
	public static void main(String[] args) {
		Communicator.start();
		GameMain game = new GameMain();

		System.out.println("Ativar cores? [S] Sim [N] Não");
		if (Communicator.getBool()) {
			Communicator.enableColors();
		}
		
		System.out.println("Jogador 1, você é:");
		System.out.println("[1] "+Communicator.ANSI_BLUE+"Um menino ♂"+Communicator.ANSI_RESET);
		System.out.println("[2] "+Communicator.ANSI_MAGENTA+"Uma menina ♀"+Communicator.ANSI_RESET);
		System.out.println("[3] "+Communicator.ANSI_GREEN+"Não-Binárix ⚧"+Communicator.ANSI_RESET);
		System.out.println(Communicator.getInt(1, 3));

	}

}
