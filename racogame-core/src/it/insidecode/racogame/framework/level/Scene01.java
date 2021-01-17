package it.insidecode.racogame.framework.level;

import java.util.ArrayList;
import java.util.Vector;

import it.insidecode.spacetagger.PropertiesManager;
import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.framework.Scene;
import it.insidecode.spacetagger.path.HalfCirclePath;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.SimpleCallback;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.logic.Ship;
import it.insidecode.spacetagger.path.Path;
import it.insidecode.spacetagger.framework.GfxShip;








import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.path.Type;

/**
 * Scene01
 * @author Francesco Raco
 */
public class Scene01 extends SceneModel
{
	public static final String SCENE_NAME = "Scene 01";
	public static final float TIME = 5000;
	public static final int EYE_MAX_SHOTS = 3;
	public static final int SENTINEL_MAX_SHOTS = 12;
	
	private float timer = 0;
		
	public Scene01(Framework framework)
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
		
		framework.setShip(new DefaultShip(framework, new Vector2(100, 200)));
		
		addEntity(new Eye(framework, new Vector2(100, 650), shot, new EyeShotDecorator(framework.getGameEngine(), shot), EYE_MAX_SHOTS), 8, new RisaliAiLati(MyDirection.LEFT, 600, 100, 700));
		addEntity(new Eye(framework, new Vector2(175, 650), shot, new EyeShotDecorator(framework.getGameEngine(), shot), EYE_MAX_SHOTS), new LPath(LineDirection.DOWN, MyDirection.LEFT, 450, 300));
		addEntity(new Eye(framework, new Vector2(225, 650), shot, new EyeShotDecorator(framework.getGameEngine(), shot), EYE_MAX_SHOTS), new LPath(LineDirection.DOWN, MyDirection.RIGHT, 450, 300));
		addEntity(new Eye(framework, new Vector2(320, 650), shot, new EyeShotDecorator(framework.getGameEngine(), shot), EYE_MAX_SHOTS), 8, new RisaliAiLati(MyDirection.RIGHT, 600, 100, 700));

		
		
		countDown(3000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new Eye(framework, new Vector2(50, 650), shot, new EyeShotDecorator(framework.getGameEngine(), shot), EYE_MAX_SHOTS), new LinePath(LineDirection.DOWN, 700));
				addEntity(new Eye(framework, new Vector2(150, 650), shot, new EyeShotDecorator(framework.getGameEngine(), shot),  EYE_MAX_SHOTS), new LinePath(LineDirection.DOWN, 700));
				addEntity(new Eye(framework, new Vector2(250, 650), shot, new EyeShotDecorator(framework.getGameEngine(), shot),  EYE_MAX_SHOTS), new LinePath(LineDirection.DOWN, 700));
				addEntity(new Eye(framework, new Vector2(350, 650), shot, new EyeShotDecorator(framework.getGameEngine(), shot),  EYE_MAX_SHOTS), new LinePath(LineDirection.DOWN, 700));
			}
		});
		
		countDown(5000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				
				addEntity(new BlackHole(framework, new Vector2(250, 400)));
				addEntity(new Guardian(framework, new Vector2(210, 525), shot, new IceShotDecorator(framework.getGameEngine(), shot), true), 12, new SquarePath(Corner.UPLEFT, PoligonalDirection.HORIZONTAL, 150, true));
				addEntity(new Star(framework, new Vector2(-50, 550), new MonetinaBonus(framework, new Vector2(50, 550))), new CirclePath(Type.DOWNRIGHT, 200, 200, true));
		    }
		});
	}
	
	@Override
	public void update(float delta)
	{
		if ((timer += delta) > TIME && !isComplete())
		{
			addEntity(new Sentinel(framework, new Vector2(175, 325), shot, new GunShotDecorator(framework.getGameEngine(), shot), SENTINEL_MAX_SHOTS), (float)0.3, new LinePath(LineDirection.DOWN, 400));
			addEntity(new Sentinel(framework, new Vector2(225, 325), shot, new GunShotDecorator(framework.getGameEngine(), shot), SENTINEL_MAX_SHOTS), (float)0.3, new LinePath(LineDirection.DOWN, 400));
			addEntity(new Sentinel(framework, new Vector2(275, 325), shot, new GunShotDecorator(framework.getGameEngine(), shot), SENTINEL_MAX_SHOTS), (float)0.3, new LinePath(LineDirection.DOWN, 400));
			addEntity(new Sentinel(framework, new Vector2(325, 325), shot, new GunShotDecorator(framework.getGameEngine(), shot), SENTINEL_MAX_SHOTS), (float)0.3, new LinePath(LineDirection.DOWN, 400));
			timer = -15000;
		}
		super.update(delta);
	}
}

