package it.insidecode.racogame.framework.level;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.util.SimpleCallback;

import com.badlogic.gdx.math.Vector2;

/**
 * Scene 04
 * @author Francesco Raco
 */
public class Scene04 extends SceneModel
{
	public static final String SCENE_NAME = "Scene 04";
	public static final int EYE_MAX_SHOTS = 3;
	public static final int SENTINEL_MAX_SHOTS = 5;
	public static final int GREEN_MAX_SHOTS = 10;
	
	private float time = 16000;
	private float timer = 0;
	
	public Scene04(Framework framework)
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
		
		framework.getGameEngine().setBackground(new ColoredBackground());
		
		addEntity(new Eye(framework, new Vector2(400, 400), shot, new EyeShotDecorator(framework.getGameEngine(), shot), EYE_MAX_SHOTS), new LinePath(LineDirection.LEFT, 700));
		addEntity(new Eye(framework, new Vector2(0, 450), shot, new EyeShotDecorator(framework.getGameEngine(), shot), EYE_MAX_SHOTS), new LinePath(LineDirection.RIGHT, 700));
		
		countDown(3500, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new Sentinel(framework, new Vector2(430, 450), shot, new GunShotDecorator(framework.getGameEngine(), shot), SENTINEL_MAX_SHOTS), new SnakePath(LineDirection.LEFT, LineDirection.DOWN, 200, 150, 500));
				addEntity(new Sentinel(framework, new Vector2(0, 500), shot, new GunShotDecorator(framework.getGameEngine(), shot), SENTINEL_MAX_SHOTS), new SnakePath(LineDirection.RIGHT, LineDirection.DOWN, 200, 150, 500));
			}
		});
		
		countDown(12000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new LittleFireMonster(framework, new Vector2(30, 0)), new LinePath(LineDirection.UP, 700));
				addEntity(new LittleFireMonster(framework, new Vector2(180, 0)), new LinePath(LineDirection.UP, 700));
				addEntity(new LittleFireMonster(framework, new Vector2(330, 0)), new LinePath(LineDirection.UP, 700));
				addEntity(new LittleFireMonster(framework, new Vector2(440, 0)), new LinePath(LineDirection.UP, 700));
			}
		});
		
		countDown(13000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new BlackHole(framework, new Vector2(300, 400)));
				addEntity(new Lavagon(framework, new Vector2(290, 350), shot, new FireShotDecorator(framework.getGameEngine(), shot), true), new SquarePath(Corner.DOWNLEFT, PoligonalDirection.HORIZONTAL, 150, true));
				addEntity(new Star(framework, new Vector2(-50, 550), new MonetinaBonus(framework, new Vector2(50, 550))), new CirclePath(Type.DOWNRIGHT, 200, 200, true));
			}
		});
		
	}
	
	@Override
	public void update(float delta)
	{
		if ((timer += delta) > time && !isComplete())
		{
			addEntity(new GreenMonster(framework, new Vector2(30, 450), shot, new GreenShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), new ZigZagPath(LineDirection.DOWNRIGHT, 50, true));
			addEntity(new GreenMonster(framework, new Vector2(130, 450), shot, new GreenShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), new ZigZagPath(LineDirection.DOWNRIGHT, 50, true));
			timer = 0;
			time = 4000;
		}
		super.update(delta);
	}

}
