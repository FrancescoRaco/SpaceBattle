package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxShip;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;

/**
 * Dream ship
 * @author Francesco Raco
 */
public class DreamShip extends GfxShip
{
	/**
	 * Shot sound
	 */
	private static Sound shotSound = Gdx.audio.newSound(Gdx.files
			.internal((PropertiesManager.getParameter("laserSound"))));
	
	/**
	 * Constructor with framework and Vector2 position
	 * @param framework The current framework
	 * @param position The initial position
	 */
	public DreamShip(Framework framework, Vector2 position)
	{
		super(framework, position, Animation.createAnimation(PropertiesManager.getParameter("newShip"),AnimationType.LOOP, 1),
				Animation.createAnimation(PropertiesManager.getParameter("newShip"), AnimationType.LOOP, 1),
				Animation.createAnimation(PropertiesManager.getParameter("newShip"), AnimationType.LOOP, 1),
				Animation.createAnimation(PropertiesManager.getParameter("newShip"), AnimationType.LOOP, 1),
				Animation.createAnimation(PropertiesManager.getParameter("newShip"), AnimationType.LOOP, 1),
				Animation.createAnimation(PropertiesManager.getParameter("newShip"),AnimationType.LOOP, 1));
		Shot shot = new SimpleShot(framework.getGameEngine(), new Vector2(10,10));
		setShot(shot);
		ShotDecorator shotDec = new LaserShotDecorator(framework.getGameEngine(), shot);
		setShotDecorator(shotDec.getClass());
		
	}
	
	@Override
	public void playShotSound()
	{
		shotSound.play();
		super.shoot();
	}
	
	/**
	 * Override in order to enable shot points also on lateral sides
	 */
	@Override
    public Vector2[] getShotPoint()
    {
  	  return new Vector2[]
  			  {
  			     new Vector2(0, getBody().getHeight()).add(getPosition()),
  			     new Vector2(getCenter().x, getBody().getHeight()).add(getPosition()),
  			     new Vector2(getBody().getWidth(),
                  getBody().getHeight()).add(getPosition())
              };
    }
	
	/**
	 * Override in order to enable multiple shots 
	 */
	@Override
    public Shot shoot(Class<? extends Shot> shotType, int shotPoint)
    {
  	 Shot shot = super.shoot(shotType, shotPoint);
  	 if (shot != null && shotPoint == 1) shot.setDirection(Direction.RIGHT);
  	 else if (shot != null && shotPoint == 2) shot.setDirection(Direction.LEFT);
  	 return shot;
    }


}
