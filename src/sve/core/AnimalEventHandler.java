package sve.core;

import sve.event.Listener;
import sve.event.EventType;

public class AnimalEventHandler implements Listener {

	@Override
	public void onEvent(EventType etype) {

		switch(etype) {
			case TIME_MINUTE:
				SVEDatabase.getAnimals().forEach(animal -> animal.updateMinutely());
				break;
			case TIME_HOUR:
				SVEDatabase.getAnimals().forEach(animal -> animal.updateHourly());
				break;
			case TIME_DAY:
				SVEDatabase.getAnimals().forEach(animal -> animal.updateDayly());
				break;
			case TIME_MONTH:
				SVEDatabase.getAnimals().forEach(animal -> animal.updateMonthly());
				break;
			case TIME_YEAR:
				SVEDatabase.getAnimals().forEach(animal -> animal.updateYearly());
				break;
		}
	}
}
