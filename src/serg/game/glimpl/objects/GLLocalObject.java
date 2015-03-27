package serg.game.glimpl.objects;

import javax.microedition.khronos.opengles.GL;

import serg.game.objects.LocalObject;


//represents the common class for the visualization of a local object
public abstract class GLLocalObject {
	
	public abstract void draw(LocalObject obj, GL gl);
	
}
