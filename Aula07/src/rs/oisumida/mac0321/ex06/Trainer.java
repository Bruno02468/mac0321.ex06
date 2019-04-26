package rs.oisumida.mac0321.ex06;

public class Trainer {
	private String name;
	private Gender gender;
	
	Trainer(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}
	public String toString() {
		return this.gender.getColor() + this.name + Communicator.ANSI_RESET;
	}
}
