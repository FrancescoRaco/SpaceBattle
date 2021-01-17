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
 * Shot from left
 * @author Francesco Raco
 */
public class LeftShot extends CompositeShot
{
	public static float DAMAGE_VALUE = (float)0.3;
	public static float SPEED_VALUE = 2;
	
	/**
	 * Allowed constructor for (not abstract) Shot subclass 
	 * @param gameEngine The game engine
	 * @param position The Vector2 position of the shot
	 */
	public LeftShot(GameEngine gameEngine, Vector2 position)
	{
		super(gameEngine, position, DAMAGE_VALUE, SPEED_VALUE);
		
		shotsList.add(this);
		setDirection(Direction.LEFT);
	}
}
