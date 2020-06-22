package sve.core;

import sve.event.EventManager;

/**
 *Main class for SVE system
 *
 *@author repelliuss
 */
public class SVE implements SVEModule {

	private static EventManager eventManager;

	public SVE() {
		this.eventManager = new EventManager();
	}

	public void start() {

		init();
		update();
		finish();
	}

	@Override
	public void init() {
		//TODO
	}

	@Override
	public void update() {
		//TODO
	}

	@Override
	public void finish() {
		//TODO
	}

	public static EventManager getEventManager() {
		return eventManager;
	}
}
