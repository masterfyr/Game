package serg.game.main.gl;

import java.util.Random;

import serg.game.geometry.Point;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public class MyGLGameView extends GLSurfaceView {

	public MyGLGameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setRenderer(new MyGLGameRenderer());
	}
	
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
    	DisplayMetrics metrics = this.getResources().getDisplayMetrics();
    	int width = metrics.widthPixels;
    	int height = metrics.heightPixels;
    	
    	//converting to GL coordinates
    	float x=2*e.getX()/width-1;
    	float y=-(2*e.getY()/height -1);
    	Point p=new Point(3*x,3*y,0);
    	MyGLGameRenderer.scope.getHunter().setDestination(p);
 
		return false;
    }

}
