package rs.oisumida.mac0321.ex06.events;

public interface EventController {
	public void addEvent(Event evt);

	public void stop();

	public void removeEventByType(Class<?> class_to_remove);
}
