package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Bright background
 * @author Francesco Raco
 *
 */
public class BrightBackground extends ParallaxBackground
{
	public BrightBackground()
	{
		super(PropertiesManager.getParameter("brightBg"), true);
	}

}

