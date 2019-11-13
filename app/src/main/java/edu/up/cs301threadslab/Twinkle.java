package edu.up.cs301threadslab;

public class Twinkle extends Thread
{
	private AnimationView myAV;
	
	public Twinkle(AnimationView myAV)
	{
		this.myAV = myAV;
	}
	
	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				sleep(50);
			}
			catch (InterruptedException e) {}
		
			this.myAV.postInvalidate();
		}
	}
}
