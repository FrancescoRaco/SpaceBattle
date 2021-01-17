package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Colored background
 * @author Francesco
 */
public class ColoredBackground extends ParallaxBackground
{
	public ColoredBackground()
	{
		super(PropertiesManager.getParameter("coloredBg"), true);
	}

}
