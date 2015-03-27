package serg.game.objects;

import java.util.ArrayList;

//this class collect the scope of all local objects in the game
public class ObjectScope {

	ArrayList<LocalObject> scope;
	
	public ObjectScope()
	{
		scope = new ArrayList<LocalObject>();
		add(new Hunter());
	//	add(new Hunter());
	}
	
	public void add(LocalObject lObject)
	{
		scope.add(lObject);
	}
	
	public LocalObject get(LocalObject lObject)
	{
		//TODO
		return null;
	}
	
	public Hunter getHunter()
	{
		for (int i=0;i<scope.size();i++)
		{
			if (scope.get(i).getClass()==Hunter.class) return (Hunter) scope.get(i);
		}
		return null;
	}
	
	public ArrayList<LocalObject> getScope()
	{
		return scope;
	}

	public void move(double time) {
		// TODO Auto-generated method stub
		for (int i=0;i<scope.size();i++)
		{
			scope.get(i).move(time);
		}
	}
	
	public void print()
	{
		// TODO Auto-generated method stub
		for (int i=0;i<scope.size();i++)
		{
			scope.get(i).print();
		}
	}
}
