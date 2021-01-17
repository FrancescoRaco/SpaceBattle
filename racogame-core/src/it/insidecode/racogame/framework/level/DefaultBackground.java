package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Default background
 * @author Francesco Raco
 */
public class DefaultBackground extends ParallaxBackground
{
	public DefaultBackground()
	{
		super(PropertiesManager.getParameter("parallaxBackground"), true);
	}
}
