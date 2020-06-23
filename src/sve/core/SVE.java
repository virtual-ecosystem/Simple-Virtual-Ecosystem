package sve.core;

import sve.event.EventManager;
import sve.gui.GuiScene;

/**
 *Main class for SVE system
 *
 *@author repelliuss
 */
public class SVE implements SVEModule {

	private static EventManager eventManager = new EventManager();;

	public SVE() {
	}

	public void start() {

		init();
		update();
		finish();
	}

	@Override
	public void init() {
		GuiScene.start();
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
