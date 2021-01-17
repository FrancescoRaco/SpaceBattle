package it.insidecode.racogame.framework.level;

import com.badlogic.gdx.math.Vector2;

import it.insidecode.spacetagger.framework.Framework;
import it.insidecode.spacetagger.path.LineDirection;
import it.insidecode.spacetagger.path.LinePath;
import it.insidecode.spacetagger.path.Type;
import it.insidecode.spacetagger.shots.Shot;
import it.insidecode.spacetagger.shots.SimpleShot;
import it.insidecode.spacetagger.util.SimpleCallback;

/**
 * Scene 03
 * @author Francesco Raco
 */
public class Scene03 extends SceneModel
{
	public static final String SCENE_NAME = "Scene 03";
	public static final int DRAGON_MAX_SHOTS = 5;
		
	private float time = 15000;
	private float timer = 0;
		
	public Scene03(Framework framework)
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
		
		framework.getGameEngine().setBackground(new BlackBackground());
		
		addEntity(new RattleDragon(framework, new Vector2(0, 450), shot, new FireShotDecorator(framework.getGameEngine(), shot), DRAGON_MAX_SHOTS), new CuspPath(LineDirection.UPRIGHT, 130));
		addEntity(new RattleDragon(framework, new Vector2(400, 400), shot, new FireShotDecorator(framework.getGameEngine(), shot), DRAGON_MAX_SHOTS), new CuspPath(LineDirection.UPLEFT, 130));
		
		countDown(4000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new BlueDragon(framework, new Vector2(0, 450), shot, new FireShotDecorator(framework.getGameEngine(), shot), DRAGON_MAX_SHOTS), new CuspPath(LineDirection.DOWNRIGHT, 145));
				addEntity(new BlueDragon(framework, new Vector2(400, 450), shot, new FireShotDecorator(framework.getGameEngine(), shot), DRAGON_MAX_SHOTS), new CuspPath(LineDirection.DOWNLEFT, 145));
			}
		});
		
		countDown(7500, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new RattleDragon(framework, new Vector2(0, 350), shot, new FireShotDecorator(framework.getGameEngine(), shot), DRAGON_MAX_SHOTS), 4, new CuspPath(LineDirection.UPRIGHT, 145));
				addEntity(new BlueDragon(framework, new Vector2(400, 550), shot, new FireShotDecorator(framework.getGameEngine(), shot), DRAGON_MAX_SHOTS), new CuspPath(LineDirection.DOWNLEFT, 145));
			}
		});
		
		countDown(12000, new SimpleCallback()
		{
			@Override
			public void onComplete()
			{
				addEntity(new BlackHole(framework, new Vector2(40, 450)));
				addEntity(new AlienMonster(framework, new Vector2(30, 350), shot, new FireShotDecorator(framework.getGameEngine(), shot), true), new SentinelPath(MyDirection.RIGHT, 130, true));
				addEntity(new Star(framework, new Vector2(530, 550), new MonetinaBonus(framework, new Vector2(430, 550))), new CirclePath(Type.DOWNLEFT, 200, 200, true));
			}
		});
	}
	
	@Override
	public void update(float delta)
	{
		if ((timer += delta) > time && !isComplete())
		{
			addEntity(new RockBoss(framework, new Vector2(230, 550)), new LinePath(LineDirection.DOWN, 700));
			addEntity(new RockBoss(framework, new Vector2(430, 550)), new LinePath(LineDirection.DOWN, 700));
			timer = 0;
			time = 4000;
		}
		super.update(delta);
	}
		
	
	

}
