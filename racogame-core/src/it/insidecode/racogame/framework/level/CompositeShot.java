package it.insidecode.racogame.framework.level;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

import java.util.List;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.GameEngine;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.shots.Shot;

/**
 * Prototype of composite shot
 * @author Francesco Raco
 */
abstract public class CompositeShot extends Shot
{
	
	/**
	 * Shots list
	 */
	protected List<Shot> shotsList = new ArrayList<Shot>();
		
	/**
	 * Constructor with game engine, position, damage value and speed
	 * @param gameEngine The game engine
	 * @param position The Vector2 position of the shot
	 * @param damageValue The damage value of the shot
	 * @param speed The speed of the shot
	 */
	public CompositeShot(GameEngine gameEngine, Vector2 position, float damageValue, float speed)
	{
		super(gameEngine, position, damageValue, speed);
		
	}
	
	@Override
	public List<Shot> instance()
	{
		return shotsList;
	}
	
	
		
}
