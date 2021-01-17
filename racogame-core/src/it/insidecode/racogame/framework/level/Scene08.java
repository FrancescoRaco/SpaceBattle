package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.framework.GfxEnemy;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.logic.DynamicPhysicsEntity;
import it.insidecode.spacetagger.path.HalfCirclePath;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Scene 08
 * @author Francesco Raco
 */
public class Scene08 extends SceneModel
{
	public static final String SCENE_NAME = "Scene 08";
	public static final int EYE_MAX_SHOTS = 5;
	public static final int GREEN_MAX_SHOTS = 3;
	public static final float TIME = 8000;
		
	private float timer = 0;
		
	public Scene08(Framework framework)
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
		
		framework.getGameEngine().setBackground(new SunsetBackground());
		
		addEntity(new RattleDragon(framework, new Vector2(100, 550), shot, new FireShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 5, new SnakePath(LineDirection.DOWN, LineDirection.LEFT, 350, 100, 300));
		addEntity(new RattleDragon(framework, new Vector2(300, 550), shot, new FireShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 5, new SnakePath(LineDirection.DOWN, LineDirection.RIGHT, 350, 100, 300));
		
		countDown(3000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new GreenMonster(framework, new Vector2(0, 300), shot, new GreenShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 3, new CuspPath(LineDirection.DOWNRIGHT, 175, true));
				addEntity(new Star(framework, new Vector2(200, 550), new MonetinaBonus(framework, new Vector2(200, 550))), 3, new LinePath(LineDirection.DOWN, 650));
				addEntity(new GreenMonster(framework, new Vector2(480, 300), shot, new GreenShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 3, new CuspPath(LineDirection.UPLEFT, 175, true));
			}
		});
		
		countDown(8000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new BlackHole(framework, new Vector2(180, 500)));
				addEntity(new Lavagon(framework, new Vector2(160, 420), shot, new FireShotDecorator(framework.getGameEngine(), shot), true), new SentinelPath(MyDirection.RIGHT, 100, true));
			}
		});
	}
	
	@Override
	public void update(float delta)
	{
		if ((timer += delta) > TIME && !isComplete())
		{
			addEntity(new Eye(framework, new Vector2(0, 550), shot, new EyeShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 3, new ZigZagPath(LineDirection.DOWNRIGHT, 25, true));
			addEntity(new Eye(framework, new Vector2(380, 550), shot, new EyeShotDecorator(framework.getGameEngine(), shot), GREEN_MAX_SHOTS), 3, new ZigZagPath(LineDirection.DOWNRIGHT, 25, true));
			timer = 0;
		}
		super.update(delta);
	}
	
	
}	
