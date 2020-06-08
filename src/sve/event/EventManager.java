package sve.event;

import java.util.Map;
import java.util.HashMap;

public class EventManager {

	//Will be changed with NavigableMap
	private Map<EventKey, Speaker> events;

	public EventManager() {
		this.events = new HashMap<>();
	}

	public boolean register(EventKey key, Listener listener) {

		Speaker speaker = events.get(key);
		if(speaker == null) {
			speaker = events.put(key, new Speaker());
		}

		return speaker.add(listener);
	}

	public boolean unregister(EventKey key, Listener listener) {

		Speaker speaker = events.get(key);
		if(speaker == null) {
			return false;
		}

		return speaker.remove(listener);
	}

	public void onEvent(EventType type) {
		//TODO for each event priority
	}

	public void onEvent(EventType type, EventPriority priority) {
		onEvent(EventKey.valueOf(type, priority));
	}

	public void onEvent(EventKey key) {

		Speaker speaker = events.get(key);
		if(speaker == null)
			return;

		speaker.speak(key.type);
	}
}
