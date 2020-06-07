package sve.core;

import java.util.Set;
import java.util.HashSet;

public class Speaker {

	private Set<Listener> listeners;

	public Speaker() {
		this.listeners = new HashSet<>();
	}

	public boolean add(Listener listener) {
		if(listener == null)
			return false;

		return listeners.add(listener);
	}

	public boolean remove(Listener listener) {
		return listeners.remove(listener);
	}

	public void speak(EventType etype) {
		listeners.forEach(listener -> listener.onEvent(etype));
	}
}
