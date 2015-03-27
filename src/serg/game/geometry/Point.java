package serg.game.geometry;

//This class represents the point in the Euclidean space
public class Point{
	
	//constructor for array of float values
	public Point(float[] vec) {
		if (vec.length == 3)
			for (int i=0;i<3;i++) setCoord(vec[i],i);
		else throw new IllegalArgumentException();
	}
	
	public Point(double ... vec)
	{
		if (vec.length == 3)
			for (int i=0;i<3;i++) setCoord(vec[i],i);
		else throw new IllegalArgumentException();
	}
	
	//empty constructor
	public Point()
	{
		
	}
	
	//move vector to the coordinate system based in new point
	public void move(Point p1)
	{
		for (int i=0;i<3;i++)
			setCoord(getCoord(i)+p1.getCoord(i),i);
	}
	
	public Point add(Point p1)
	{
		Point p = new Point();
		for (int i=0;i<3;i++)
			p.setCoord(getCoord(i)+p1.getCoord(i),i);
		return p;
	}
	
	//change the size of the object by factor
	public void resize(double factor)
	{
		for (int i=0;i<3;i++) setCoord(getCoord(i)*factor,i);
	}
	
	public void rotateAroundAxis(double phi, int axIndex)
	{
		double cos=Math.cos(phi);
		double sin=Math.sin(phi);
		switch(axIndex)
		{
		case 0:
		{
			double y1;
			y1=cos*y - sin*z;
			z=sin*y +cos*z;
			y=y1;
			break;
		}
		case 1:
		{
			double x1;
			x1=cos*x + sin*z;
			z=-sin*x  + cos*z;
			x=x1;
			break;
		}
		case 2:
		{
			double x1;
			x1 = cos*x - sin*y;
			y  = sin*x + cos*y;
			x=x1;
			break;
		}
		default: throw new IllegalArgumentException();
		}
	}
	
	//rotation around zero
	public void rotate(Rotation dir)
	{
		rotateAroundAxis(dir.aZ, 2);
		rotateAroundAxis(dir.aY, 1);
		rotateAroundAxis(dir.aX, 0);
	}
	
	public void setCoord(double val, int index)
	{
		switch(index)
		{
		case 0: x=val;break;
		case 1: y=val;break;
		case 2: z=val;break;
			default: throw new IllegalArgumentException();
		}
	}
	
	public double getCoord(int index)
	{
		switch(index)
		{
		case 0: return x;
		case 1: return y;
		case 2: return z;
			default: throw new IllegalArgumentException();
		}
	}
	
	public void copy(Point p)
	{
		for (int i=0;i<3;i++)
			setCoord(p.getCoord(i), i);
	}
	
	public double x;
	public double y;
	public double z;
	
	public Point mult(double factor) {
		return new Point(x*factor, y*factor, z*factor);
	}
	
	public boolean equals(Point p)
	{
		if ((x==p.x) && (y == p.y) && (z == p.z)) return true;
		else return false;
	}

	public Point minus(Point p) {
		return new Point(x-p.x,y - p.y, z - p.z);
	}
	
	public void print()
	{
		System.out.println("x="+x+" y="+y+" z="+z);
	}

	public double dist(Point p) {
		return Math.sqrt((x- p.x)*(x- p.x) + (y- p.y)*(y- p.y) + (z- p.z)*(z- p.z));
	}
	
	public double dist() {
		return Math.sqrt(x*x + y*y+ z*z);
	}

	public Point normalize() {
		// TODO Auto-generated method stub
		Point p = new Point();
		double d = dist(p);
		if (d==0) return p;
		else
		{
			p=this;
			p.resize(1/d);
		}
		return p;
	}
}
