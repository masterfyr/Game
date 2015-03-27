package serg.game.objects;

import serg.game.geometry.Point;
import serg.game.geometry.Rotation;

//Special class of hunter in the game
public class Hunter extends LocalObject {
		
	private Point destination;
	
	public Hunter()
	{
		super();
		destination = new Point();
		setType(TYPE.HUNTER);
	}

	public Point getDestination() {
		return destination;
	}

	public void setDestination(Point destination) {
		this.destination = destination;
	}
	
	public void move(double time)
	{
		if (!isNearDestination(0.01))
		{
			setVposition(destination.minus(getPosition()).normalize().mult(3));
			setRotation(new Rotation(getPosition(),destination));
		}
		else setVposition(new Point());
		super.move(time);
	}
	
	public boolean isNearDestination(double thold)
	{
		if (getPosition().dist(destination) <= thold) return true;
		else return false;
	}
	
	public void print()
	{
		super.print();
		System.out.print("Destination: ");
		destination.print();
	}
	
}