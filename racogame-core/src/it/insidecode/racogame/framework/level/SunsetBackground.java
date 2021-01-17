package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Sunset background
 * @author Francesco Raco
 */
public class SunsetBackground extends ParallaxBackground
{
	public SunsetBackground()
	{
		super(PropertiesManager.getParameter("sunsetBg"), true);
	}

}
