package rs.oisumida.mac0321.ex06;

public enum Action {
	FIGHT, ITEM, SWITCH, FLEE;
	static Action[] List = {FIGHT, ITEM, SWITCH, FLEE};
	public String toString() {
		switch (this) {
		case FIGHT:
			return "Lutar";
		case ITEM:
			return "Usar item";
		case SWITCH:
			return "Trocar pokemon";
		case FLEE:
			return "Fugir";
		default:
			return "???";
		}
	}
}
