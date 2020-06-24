package sve.event;

import java.util.Map;
import java.util.HashMap;

public class EventManager {

	//TODO Change this to NavigableMap
	private Map<EventType, Speaker> events;

	public EventManager() {
		this.events = new HashMap<>();
	}

	/**
	 * Registers the listener to the given event type
	 * @param etype an event type
	 * @param listener that will be registered to given event type
	 * @return false if listener already registered to the given event type,
	 * true otherwise
	 */
	public boolean register(EventType etype, Listener listener) {

		if(!events.containsKey(etype)) {
			events.put(etype, new Speaker());
		}

		Speaker speaker = events.get(etype);

		return speaker.add(listener);
	}

	/**
	 * Unregisters the listener from the given event type
	 * @param etype an event type
	 * @param listener that will be unregistered to given event type
	 * @return true if removed which happens if already registered,
	 * false otherwise
	 */
	public boolean unregister(EventType etype, Listener listener) {

		Speaker speaker = events.get(etype);
		if(speaker == null) {
			return false;
		}

		return speaker.remove(listener);
	}

	/**
	 * Calls the event for registered listeners for given event type
	 * @param etype an event type
	 */
	public void callEvent(EventType etype) {

		Speaker speaker = events.get(etype);
		if(speaker == null)
			return;

		speaker.speak(etype);
	}
}
