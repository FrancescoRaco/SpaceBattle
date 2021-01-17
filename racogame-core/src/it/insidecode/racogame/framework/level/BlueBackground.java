package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.graphics.ParallaxBackground;

/**
 * Blue background
 * @author Francesco Raco
 *
 */
public class BlueBackground extends ParallaxBackground
{
	public BlueBackground()
	{
		super(PropertiesManager.getParameter("blueBg"), true);
	}
}
