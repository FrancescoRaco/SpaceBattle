package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Night sky background
 * @author Francesco Raco
 */
public class NightSkyBackground extends ParallaxBackground
{
	public NightSkyBackground()
	{
		super(PropertiesManager.getParameter("nightSkyBg"), true);
	}

}
