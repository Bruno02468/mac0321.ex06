package rs.oisumida.mac0321.ex06;

public enum Gender {
  MALE, FEMALE, NONBINARY;
	static Gender[] List = {MALE, FEMALE, NONBINARY};
	public String getColor() {
		switch (this) {
		case MALE:
			return Communicator.ANSI_BLUE;
		case FEMALE:
			return Communicator.ANSI_MAGENTA;
		default:
			return Communicator.ANSI_GREEN;
		}
	}
	public String toSymbol() {
		switch (this) {
		case MALE:
			return "♂";
		case FEMALE:
			return "♀";
		default:
			return "⚧";
		}
	}
	public String toString() {
		switch (this) {
		case MALE:
			return getColor()+"Menino ♂"+Communicator.ANSI_RESET;
		case FEMALE:
			return getColor()+"Menina ♀"+Communicator.ANSI_RESET;
		default:
			return getColor()+"Não-Binárix ⚧"+Communicator.ANSI_RESET;
		}
	}
}

