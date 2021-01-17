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
 * Shot from right
 * @author Francesco Raco
 */
public class RightShot extends CompositeShot
{
	/**
	 * Damage value of the shot
	 */
	public static float DAMAGE_VALUE = (float)0.3;
	
	/**
	 * Speed value of the shot
	 */
	public static float SPEED_VALUE = 2;
	
	/**
	 * constructor with the current instance of game engine and the position
	 * @param gameEngine The current instance of game engine
	 * @param position The position
	 */
	public RightShot(GameEngine gameEngine, Vector2 position)
	{
		super(gameEngine, position, DAMAGE_VALUE, SPEED_VALUE);
		
		shotsList.add(this);
		setDirection(Direction.RIGHT);
	}
}
