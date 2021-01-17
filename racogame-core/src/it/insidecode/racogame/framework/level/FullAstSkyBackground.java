package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Full asteroid sky background
 * @author Francesco Raco
 */
public class FullAstSkyBackground extends ParallaxBackground
{
	public FullAstSkyBackground()
	{
		super(PropertiesManager.getParameter("fullAstSkyBg"), true);
	}

}