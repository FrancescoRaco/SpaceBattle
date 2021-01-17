package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.logic.Enemy;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.path.VerticalCosPath;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Scene 02
 * @author Francesco Raco
 */
public class Scene02 extends SceneModel
{
	public static final String SCENE_NAME = "Scene 02";
	public static final int GREEN_MAX_SHOTS = 4;
	public static final int LAVAGON_MAX_SHOTS = 5;
	public static final float TIME = 10000;
	
	private float timer = 0;
		
	public Scene02(Framework framework)
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
		
		framework.getGameEngine().setBackground(new DarkBackground());
		
		addEntity(new Lavagon(framework, new Vector2(0, 600), shot, new FireShotDecorator(framework.getGameEngine(), shot), LAVAGON_MAX_SHOTS), new ZigZagPath(LineDirection.DOWNRIGHT, 50, true));
		addEntity(new Lavagon(framework, new Vector2(400, 600), shot, new FireShotDecorator(framework.getGameEngine(), shot), LAVAGON_MAX_SHOTS), new ZigZagPath(LineDirection.DOWNLEFT, 50, true));
		
		
		countDown(6000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new LittleFireMonster(framework, new Vector2(190, 600)), 6, new LinePath(LineDirection.DOWN, 700));
				addEntity(new LittleFireMonster(framework, new Vector2(270, 600)), 4, new LinePath(LineDirection.DOWN, 700));
				addEntity(new LittleFireMonster(framework, new Vector2(350, 600)), 2, new LinePath(LineDirection.DOWN, 700));
			}
		});
		
		countDown(12000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new GreenMonster(framework, new Vector2(0, 500), shot, new GreenShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 3, new SnakePath(LineDirection.RIGHT, LineDirection.DOWN, 200, 150, 500));
				addEntity(new GreenMonster(framework, new Vector2(430, 450), shot, new GreenShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 3, new SnakePath(LineDirection.LEFT, LineDirection.DOWN, 200, 150, 550));
			}
			
		});
		
		countDown(16000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new BlackHole(framework, new Vector2(300, 500)));
				addEntity(new Gargoyle(framework, new Vector2(200, 550), shot, new FireShotDecorator(framework.getGameEngine(), shot), true), new SentinelPath(MyDirection.DOWN, 130, true));
				addEntity(new Gargoyle(framework, new Vector2(250, 400), shot, new FireShotDecorator(framework.getGameEngine(), shot), true), new SentinelPath(MyDirection.RIGHT, 130, true));
				addEntity(new Star(framework, new Vector2(-50, 550), new MonetinaBonus(framework, new Vector2(50, 550))), new CirclePath(Type.DOWNRIGHT, 200, 200, true));
			}
		});
	}
	
	@Override
	public void update(float delta)
	{
		if ((timer += delta) > TIME && !isComplete())
		{
			addEntity(new GreenMonster(framework, new Vector2(20, 450), shot, new GreenShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 1, new LinePath(LineDirection.DOWN, 600));
			addEntity(new GreenMonster(framework, new Vector2(120, 450), shot, new GreenShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 1, new LinePath(LineDirection.DOWN, 600));
			timer = 1750;
		}
		super.update(delta);
	}
	
}
