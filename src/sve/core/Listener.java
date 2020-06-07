package sve.core;

/**
 * Any class that will have/need events
 * should implement this
 *
 * @author repelliuss
 */
public interface Listener {
	void onEvent(EventType etype);
}
