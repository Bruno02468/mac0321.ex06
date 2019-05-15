package rs.oisumida.mac0321.ex06.events;

public interface Event {
	static EventController MainController=null;
	public abstract int getPriority();
	public abstract void run(EventController controller) throws Throwable;
}
