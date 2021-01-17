package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.GameEngine;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;

/**
 * Double shot
 * @author Francesco Raco
 */
public class DoubleShot extends CompositeShot
{
	/**
	 * Damage value which inflicts to its enemies
	 */
	public static float DAMAGE_VALUE = (float)0.3;
	
	/**
	 * Speed value of the shot
	 */
	public static float SPEED_VALUE = 2;
	
	/**
	 * Allowed constructor for (not abstract) Shot subclass
	 * @param gameEngine The game engine
	 * @param position The Vector2 position of the shot
	 */
	public DoubleShot(GameEngine gameEngine, Vector2 position)
	{
		super(gameEngine, position, DAMAGE_VALUE, SPEED_VALUE);
		
		shotsList.add(new SimpleShot(gameEngine, new Vector2(getPosition().x, getPosition().y-10)));
		shotsList.add(new SimpleShot(gameEngine, new Vector2(getPosition().x, getPosition().y)));
	}
}
