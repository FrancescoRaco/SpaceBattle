package it.insidecode.racogame.framework.core;

import it.insidecode.racogame.framework.level.Level0;
import it.insidecode.spacetagger.framework.Level;

public class Core {
	
	public static Class<? extends Level> getLevel()
	{
		return (Level0.class);
	}

}
