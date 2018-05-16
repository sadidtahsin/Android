package com.tamim.dxballgame;



import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.util.Log;

public class GameThread extends Thread {
	Boolean running;
	Game game;
	GameObject ball;
	public GameThread(Game game) {
		this.game=game;
	}
	
	public void setRunning(Boolean run) {
		
		running=run;
	}
	Canvas c= new  Canvas();
	@SuppressLint("WrongCall")
	
	@Override
	public void run() {
	
		
		while(running){

		    Log.d("ABC", "sa  "+running);
			
		    
		    
			try {
				
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				game.onDraw(c);
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				c=null;
			}
		    	
			
			
		}
	}
	
}
