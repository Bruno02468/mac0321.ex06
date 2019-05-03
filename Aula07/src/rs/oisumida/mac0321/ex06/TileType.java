package rs.oisumida.mac0321.ex06;

public enum TileType {
	Concrete, Grass;
	static TileType List[] = {TileType.Concrete, TileType.Grass};
	public String toString() {
		if (Communicator.isFancy()) {
			if (this == TileType.Grass) {
				return "🍀";
			}
			if (this == TileType.Concrete) {
				return "🧱";
			}
		} else {
			if (this == TileType.Grass) {
				return ".";
			}
			if (this == TileType.Concrete) {
				return "#";
			}
		}
		return "?";
	}
}
