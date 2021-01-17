package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Dark background
 * @author Francesco Raco
 */
public class DarkBackground extends ParallaxBackground
{
	public DarkBackground()
	{
		super(PropertiesManager.getParameter("dark"), true);
	}

}
