package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.logic.Direction;
import it.insidecode.spacetagger.path.HalfCirclePath;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Scene 06
 * @author Francesco Raco
 */
public class Scene06 extends SceneModel
{
	public static final String SCENE_NAME = "Scene 06";
	public static final float TIME = 8000;
		
	private float timer = 0;
		
	public Scene06(Framework framework)
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
		
		framework.getGameEngine().setBackground(new NightSkyBackground());
		
		addEntity(new LittleFireMonster(framework, new Vector2(50, 550)), new ZigZagPath(LineDirection.DOWNRIGHT, 150, true));
		addEntity(new LittleFireMonster(framework, new Vector2(150, 550)), new ZigZagPath(LineDirection.DOWNRIGHT, 150, true));
		addEntity(new LittleFireMonster(framework, new Vector2(250, 550)), new ZigZagPath(LineDirection.DOWNRIGHT, 150, true));
		
		countDown(3000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new Lavagon(framework, new Vector2(50, 450), shot, new FireShotDecorator(framework.getGameEngine(), shot), true), 1, new SnakePath(LineDirection.RIGHT, LineDirection.DOWNRIGHT, 150, 350, 200, true));
				addEntity(new Lavagon(framework, new Vector2(430, 450), shot, new FireShotDecorator(framework.getGameEngine(), shot), true), 1, new SnakePath(LineDirection.LEFT, LineDirection.DOWNLEFT, 150, 350, 200, true));
				
			}
		});
		
		countDown(16000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new BlackHole(framework, new Vector2(180, 500)));
				addEntity(new BlueDragon(framework, new Vector2(150, 450), shot, new FireShotDecorator(framework.getGameEngine(), shot), true), 12, new SentinelPath(MyDirection.RIGHT, 100, true));
				addEntity(new Star(framework, new Vector2(50, 550), new MonetinaBonus(framework, new Vector2(50, 550))), new CirclePath(Type.DOWNLEFT, 200, 200, true));
			}
		});
		
	}
	
	@Override
	public void update(float delta)
	{
		if ((timer += delta) > TIME && !isComplete())
		{
			addEntity(new Eye(framework, new Vector2(0, 50), shot, new EyeShotDecorator(framework.getGameEngine(), shot), true), 1, new LinePath(LineDirection.RIGHT, 600));
			addEntity(new Eye(framework, new Vector2(0, 250), shot, new EyeShotDecorator(framework.getGameEngine(), shot), true), 1, new LinePath(LineDirection.RIGHT, 600));
			timer = 0;
		}
		super.update(delta);
	}
	
	
}		