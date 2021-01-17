package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Dark space background
 * @author Francesco Raco
 *
 */
public class DarkSpaceBackground extends ParallaxBackground
{
	public DarkSpaceBackground()
	{
		super(PropertiesManager.getParameter("darkSpaceBg"), true);
	}

}