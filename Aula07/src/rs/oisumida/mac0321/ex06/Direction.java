package rs.oisumida.mac0321.ex06;

public enum Direction {
	North, East, West, South;

	public static Direction fromString(String val) throws Exception {
		val = val.toUpperCase();
		char c = val.charAt(0);
		if (c == 'W') {
			return Direction.North;
		}
		if (c == 'A') {
			return Direction.West;
		}
		if (c == 'S') {
			return Direction.South;
		}
		if (c == 'D') {
			return Direction.East;
		}
		throw new Exception("direção inválida: ");
	}

	public int getDeltaX() {
		if (this == Direction.East) {
			return 1;
		}
		if (this == Direction.West) {
			return -1;
		}
		return 0;
	}
	
	public int getDeltaY() {
		if (this == Direction.North) {
			return -1;
		}
		if (this == Direction.South) {
			return 1;
		}
		return 0;
	}
}
