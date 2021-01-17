package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.decorator.ShotDecorator;
import it.insidecode.spacetagger.graphics.Animation;
import it.insidecode.spacetagger.graphics.AnimationType;
import it.insidecode.spacetagger.graphics.GameDecorator;
import it.insidecode.spacetagger.shots.Shot;

/**
 * Ice shot decorator
 * @author Francesco Raco
 */
public class IceShotDecorator extends ShotDecorator
{
	public IceShotDecorator(GameDecorator gameDec, Shot shot)
	{
		super(gameDec, shot, Animation.createAnimation(PropertiesManager.getParameter("iceShot"),AnimationType.LOOP, 1));
	}
}