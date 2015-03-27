package serg.game.objects;

import serg.game.geometry.Rotation;
import serg.game.geometry.Point;

//This class contain all main features of the moving object
public abstract class LocalObject {

	public LocalObject()
	{
		position = new Point();
		rotation = new Rotation();
		vposition = new Point();
		vrotation = new Rotation();
		type = TYPE.EMPTY;
	}
	
	/**
	 * 
	 * @param time in seconds
	 */
	public void move(double time)
	{
		position.move(vposition.mult(time));
		rotation.rotate(vrotation.mult(time));
	}

	private Point position;
	
	private Rotation rotation;
	
	private Point vposition; // difference per second
	
	private Rotation vrotation; //difference per second
	
	private float relativeSize = 1f;
	
	public enum TYPE{
		EMPTY, HUNTER, TARGET
	};
	
	private TYPE type = TYPE.EMPTY;

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Rotation getRotation() {
		return rotation;
	}

	public void setRotation(Rotation rotation) {
		this.rotation = rotation;
	}

	public Point getVposition() {
		return vposition;
	}

	public void setVposition(Point vposition) {
		this.vposition = vposition;
	}

	public Rotation getVrotation() {
		return vrotation;
	}

	public void setVrotation(Rotation vrotation) {
		this.vrotation = vrotation;
	}

	public float getRelativeSize() {
		return relativeSize;
	}

	public void setRelativeSize(float relativeSize) {
		this.relativeSize = relativeSize;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}
	
	public void print()
	{
		System.out.print("Position: ");
		position.print();
		System.out.print("Velocity: ");
		vposition.print();
	}
	
}
