package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Black background
 * @author Francesco Raco
 */
public class BlackBackground extends ParallaxBackground
{
	public BlackBackground()
	{
		super(PropertiesManager.getParameter("blackBg"), true);
	}

}