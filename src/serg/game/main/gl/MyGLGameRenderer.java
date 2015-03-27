package serg.game.main.gl;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import serg.game.drivers.ObjectDriver;
import serg.game.geometry.Rotation;
import serg.game.glimpl.objects.DrawManager;
import serg.game.glimpl.objects.GLHunter;
import serg.game.objects.ObjectScope;

import android.opengl.GLSurfaceView.Renderer;

public class MyGLGameRenderer implements Renderer{

	public static ObjectScope scope;
	public static double time;
	public static GLHunter h;
	public static boolean flag = true;
	
	public MyGLGameRenderer() {
		// TODO Auto-generated constructor stub
		scope = new ObjectScope();
		time = System.currentTimeMillis()/(double)1000;
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		 gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); 
	     gl.glMatrixMode(GL10.GL_MODELVIEW); 
	     gl.glLoadIdentity();
	     gl.glTranslatef(0, 0, -3.0f); 
	     
	     double t1 = System.currentTimeMillis()/(double)1000;
	     DrawManager.draw(scope,gl);
	     ObjectDriver.move(scope, t1- time);
	//     scope.getHunter().getRotation().rotate((new Rotation(0,0,0.1)).);
	     long tt=System.currentTimeMillis() % 1000 ;
	     
	     if ((tt< 100) && (flag==true))
	     {
//	    	 scope.print();
	    	 flag=false;
	     }
	     else if (tt>100) flag=true;
	     time = t1;
	}

	private Object getRotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		 gl.glViewport(0, 0, width, height);
	     float aspect = (float)width / height;
	     gl.glMatrixMode(GL10.GL_PROJECTION);
	     gl.glLoadIdentity();
	     gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 1f, 10.0f);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
	     gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 
	     gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST); 
	     gl.glEnable(GL10.GL_DEPTH_TEST); 
	     
	}
}
