package serg.game.geometry;


//This class represents the orientation of the object in space;
public class Rotation {
	
	//default constructor
	public Rotation()
	{
	}
	
	//constructor from the vector of values in radiands
	public Rotation(double ... vec) {
		if (vec.length == 3)
		{
			aZ=vec[0]%(2*Math.PI);
			aY=vec[1]%(2*Math.PI);
			aX=vec[2]%(2*Math.PI);
		}
		else throw new IllegalArgumentException();
	}
	
	public Rotation(Point position, Point destination) {
		// TODO Auto-generated constructor stub
		Point p=destination.minus(position);
		double dxy=Math.sqrt(p.x*p.x + p.y*p.y);
		if (dxy == 0) {aZ=0;aX=Math.PI/2;aY=0;}
		else
		{
			aZ = Math.acos(p.x/dxy);
			if (p.y<0) aZ= 2*Math.PI - aZ;
			aY=0;
			aX = Math.asin(p.z / p.dist());
		}
	}

	//rotate the current position
	public void rotate(Rotation r)
	{
		aZ=(aZ + r.aZ)%(2*Math.PI);
		aY=(aY + r.aY)%(2*Math.PI);
		aX=(aX + r.aX)%(2*Math.PI);
	}
	
	public Rotation mult(double factor)
	{
		return new Rotation(aZ*factor, aY*factor, aX*factor);
	}
	
	public double aZ = 0; //left right AROUND Z
	public double aY = 0; //up down AROUND Y
	public double aX = 0; //Counterclockwise clockwise AROUND X
	
	public Rotation minus(Rotation r) {
		return new Rotation(aZ - r.aZ, aY - r.aY, aX - r.aX);
	}
	
}
