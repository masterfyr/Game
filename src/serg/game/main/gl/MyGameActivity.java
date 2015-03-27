package serg.game.main.gl;

import android.app.Activity;
import android.os.Bundle;

public class MyGameActivity extends Activity {
	
	private MyGLGameView myView; 
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		myView = new MyGLGameView(this); 	//creates new view
		setContentView(myView); 			//setting this view
	}

	/*
	@Override
	public void onDestroy()
	{
		finish();
	}
	*/
}
