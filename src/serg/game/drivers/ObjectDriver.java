package serg.game.drivers;

import java.util.ArrayList;

import serg.game.objects.Hunter;
import serg.game.objects.LocalObject;
import serg.game.objects.ObjectScope;

//this class contains the object and moves it!
public class ObjectDriver {
	
	public static void move(Hunter hunter, double time)
	{
		hunter.move(time);
	}
	
	public static void move(ObjectScope scope, double time)
	{
		ArrayList<LocalObject> list = scope.getScope();
		for (int i=0;i<list.size();i++)
		{
			if (list.get(i).getClass()==Hunter.class) move((Hunter)list.get(i),time);
		}
	}
	
}
