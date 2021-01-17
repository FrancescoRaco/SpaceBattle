package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.PowerUp;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Scene 09
 * @author Francesco Raco
 */
public class Scene09 extends SceneModel
{
	public static final String SCENE_NAME = "Scene 09";
	
	private Shot rightShot = new RightShot(framework.getGameEngine(), new Vector2(100, 200));
	private Shot leftShot = new LeftShot(framework.getGameEngine(), new Vector2(100, 200));
	public Scene09(Framework framework)
	{
		super(framework);
	}
	
	@Override
	public String getName()
	{
		return SCENE_NAME;
	}
	
	@Override
	public void init()
	{
		super.init();
		
		framework.getGameEngine().setBackground(new FullAstSkyBackground());
				
		addEntity(new Star(framework, new Vector2(350, 250), new MonetinaBonus(framework, new Vector2(300, 250))), new CirclePath(Type.DOWNRIGHT, 200, 200, true));
		addEntity(new RockBarrier(framework, new Vector2(0, 150)));
		addEntity(new Sentinel(framework, new Vector2(10, 175), rightShot, new GunShotDecorator(framework.getGameEngine(), rightShot), true), 1, new SentinelPath(MyDirection.RIGHT, 150, true));
		addEntity(new RockBarrier(framework, new Vector2(312, 300)));
		addEntity(new Sentinel(framework, new Vector2(460, 325), leftShot, new GunShotDecorator(framework.getGameEngine(), leftShot), true), 1, new SentinelPath(MyDirection.LEFT, 150, true));
		addEntity(new RockBarrier(framework, new Vector2(0, 450)));
		addEntity(new PlanetBoss(framework, new Vector2(0, 485), new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new BlackHole(framework, new Vector2(0, 475)));
			}
		}));
	}
	
}
