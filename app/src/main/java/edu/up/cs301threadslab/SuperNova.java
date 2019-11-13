package edu.up.cs301threadslab;

import java.util.ConcurrentModificationException;
import java.util.Random;

public class SuperNova extends Thread
{
	private StarAnimation myStarAnimation;
	private Random rand;
	
	public SuperNova(StarAnimation myStarAnimation)
	{
		this.myStarAnimation = myStarAnimation;
		this.rand = new Random();
	}
	
	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				sleep(40);
				
				synchronized (this.myStarAnimation.field)
				{
					if (this.rand.nextInt(2) == 0)
						this.myStarAnimation.addStar();
					else
						this.myStarAnimation.removeStar();
				}
			}
			catch(InterruptedException e) {}
		}
	}
}
