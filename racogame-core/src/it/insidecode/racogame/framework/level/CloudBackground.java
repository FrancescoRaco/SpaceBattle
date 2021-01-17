package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Cloud background
 * @author Francesco Raco
 */
public class CloudBackground extends ParallaxBackground
{
	public CloudBackground()
	{
		super(PropertiesManager.getParameter("cloud"), true);
	}

}
