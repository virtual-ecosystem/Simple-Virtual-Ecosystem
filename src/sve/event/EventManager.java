package sve.event;

import java.util.Map;
import java.util.HashMap;

public class EventManager {

	//TODO Change this to NavigableMap
	private Map<EventKey, Speaker> events;

	public EventManager() {
		this.events = new HashMap<>();
	}

	/**
	 * Registers the listener to the given key
	 * @param key an event key with event type and priority
	 * @param listener that will be registered to given key
	 * @return false if listener already registered to the given key,
	 * true otherwise
	 */
	public boolean register(EventKey key, Listener listener) {

		Speaker speaker = events.get(key);
		if(speaker == null) {
			speaker = events.put(key, new Speaker());
		}

		return speaker.add(listener);
	}

	/**
	 * Unregisters the listener from the given key
	 * @param key an event key with event type and priority
	 * @param listener that will be unregistered to given key
	 * @return true if removed which happens if already registered,
	 * false otherwise
	 */
	public boolean unregister(EventKey key, Listener listener) {

		Speaker speaker = events.get(key);
		if(speaker == null) {
			return false;
		}

		return speaker.remove(listener);
	}

	/**
	 * Calls the event for registered listeners foreach priority
	 * @param type called event type
	 */
	public void callEvent(EventType type) {
		for(EventPriority priority : EventPriority.values()) {
			callEvent(EventKey.valueOf(type, priority));
		}
	}


	/**
	 * Calls the event for registered listeners for given priority
	 * @param type event type
	 * @param priority event priority
	 */
	public void callEvent(EventType type, EventPriority priority) {
		callEvent(EventKey.valueOf(type, priority));
	}

	/**
	 * Calls the event for registered listeners for given key
	 * @param key event key with event type and priority
	 */
	public void callEvent(EventKey key) {

		Speaker speaker = events.get(key);
		if(speaker == null)
			return;

		speaker.speak(key.type);
	}
}
