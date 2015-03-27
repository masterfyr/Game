package serg.game.glimpl.objects;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import serg.game.objects.Hunter;
import serg.game.objects.LocalObject;
import serg.game.objects.ObjectScope;

public class DrawManager {

	public static void draw(ObjectScope scope, GL10 gl)
	{
		ArrayList<LocalObject> list = scope.getScope();
		for (int i=0;i<list.size();i++)
		{
			if (list.get(i).getClass()==Hunter.class) drawHunter(list.get(i),gl);
		}
	}

	private static void drawHunter(LocalObject localObject, GL10 gl) {
		// TODO Auto-generated method stub
		GLHunter.draw((Hunter)localObject,gl);
	}
	
}
