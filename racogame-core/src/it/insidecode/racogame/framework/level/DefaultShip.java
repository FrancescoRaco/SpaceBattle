package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxShip;

/**
 * Default ship
 * @author Francesco Raco
 */
public class DefaultShip extends GfxShip
{
	private Framework framework;
	
	public DefaultShip(Framework framework, Vector2 position)
	{
		super(framework, position);
		this.framework = framework;
	}
	
	/**
	 * Dispose the framework and restart (after ship destruction)
	 */
	@Override
	public void destroy()
	{
    	framework.dispose();
		framework.play(new Level0(framework));
		super.destroy();
	}

}
