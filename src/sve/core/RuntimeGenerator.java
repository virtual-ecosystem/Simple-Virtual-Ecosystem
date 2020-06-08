package sve.core;

import java.io.File;

public interface RuntimeGenerator<E> extends Generator<E> {
	void read(File file);
}
