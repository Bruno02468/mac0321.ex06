package rs.oisumida.mac0321.ex06;

public enum Gender {
  MALE, FEMALE, NONBINARY;
	static Gender[] List = {MALE, FEMALE, NONBINARY};
	public String toSymbol() {
		switch (this) {
		case MALE:
			return Communicator.ANSI_BLUE+"♂"+Communicator.ANSI_RESET;
		case FEMALE:
			return Communicator.ANSI_MAGENTA+"♀"+Communicator.ANSI_RESET;
		default:
			return Communicator.ANSI_GREEN+"⚧"+Communicator.ANSI_RESET;
		}
	}
	public String toString() {
		switch (this) {
		case MALE:
			return Communicator.ANSI_BLUE+"Menino ♂"+Communicator.ANSI_RESET;
		case FEMALE:
			return Communicator.ANSI_MAGENTA+"Menina ♀"+Communicator.ANSI_RESET;
		default:
			return Communicator.ANSI_GREEN+"Não-Binárix ⚧"+Communicator.ANSI_RESET;
		}
	}
}

