package sve.event;

public class EventKey implements Comparable<EventKey> {
	EventType type;
	EventPriority priority;

	public EventKey(EventType type, EventPriority priority) {
		this.type = type;
		this.priority = priority;
	}

	@Override
	public int compareTo(EventKey other) {
		int comparison = priority.compareTo(other.priority);
		if(comparison == 0)
			return type.compareTo(other.type);
		return comparison;
	}

	public static EventKey valueOf(EventType key, EventPriority priority) {
		return new EventKey(key, priority);
	}
}
