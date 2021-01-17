package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.graphics.GameDecorator;
import it.insidecode.spacetagger.shots.Shot;

/**
 * Laser shot decorator
 * @author Francesco Raco
 */
public class LaserShotDecorator extends ShotDecorator
{
	public LaserShotDecorator(GameDecorator gameDec, Shot shot)
		{
			super(gameDec, shot, Animation.createAnimation(PropertiesManager.getParameter("laserShot"), AnimationType.LOOP, 1));
		}
}
