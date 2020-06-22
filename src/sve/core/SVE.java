package sve.core;

import sve.event.EventManager;

/**
 *Main class for SVE system
 *
 *@author repelliuss
 */
public class SVE {

	private static EventManager eventManager;

	public SVE() {
		this.eventManager = new EventManager();
	}

	public void start() {

		init();
		update();
		finish();
	}

	private void init() {
		//TODO
	}

	private void update() {
		//TODO
	}

	private void finish() {
		//TODO
	}

	public static EventManager getEventManager() {
		return eventManager;
	}
}
