package rs.oisumida.mac0321.ex06.events;

public interface Event {
	public abstract int getPriority();
	public abstract void run();
}
