package serg.game.glimpl.objects;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import serg.game.geometry.Point;
import serg.game.geometry.Rotation;
import serg.game.objects.Hunter;

public class GLHunter{//extends GLLocalObject{

	static float pointsArray[]= {
				0.5f,		0f, 	0f,
				-0.5f, 	0.25f,	0f,
				-0.5f,	-0.25f,	0f,
			//extra 
				-0.5f, 	0f, 	0.25f
	};

	static float colorArray[] = {  	1.0f, 1.0f, 0.0f, 1.0f,
								1.0f, 1.0f, 1.0f, 0.0f,
									1.0f, 0.0f, 1.0f, 1.0f,
									1.0f, 1.0f, 1.0f, 1.0f};

	static short indexArray[] = { 0, 1 , 2, 0, 2, 3, 0, 3, 1, 2, 3, 1};
	
	static private FloatBuffer pointBuffer;
	static private FloatBuffer colorBuffer;
	static private ShortBuffer 	indexBuffer;
	
	//abstract positions
	private static void init(Hunter hunter)
	{
		//converting objects positions to display position
		Point[] points= new Point[pointsArray.length/3];
		for (int i=0;i<pointsArray.length/3;i++)
		{
			points[i]=new Point();
			for (int j=0;j<3;j++)
			{	
				points[i].setCoord(pointsArray[3*i + j],j);
			}
		}
		//making transformations over positions (moving and rotating)
		for (int i=0;i<points.length;i++)
		{
			points[i].rotate(new Rotation(0,0,2*Math.PI*(System.currentTimeMillis()%1000)/(double)1000));
			points[i].rotate(hunter.getRotation());
			
			points[i].resize(1);
			points[i].move(hunter.getPosition());
		}
		float[] tpointsArray = new float[pointsArray.length];
		for (int i=0;i<points.length;i++)
			for (int j=0;j<3;j++)
				tpointsArray[3*i +j] = (float) points[i].getCoord(j);
		
		pointBuffer=arrayToBuffer(tpointsArray);
		colorBuffer=arrayToBuffer(colorArray);
		indexBuffer=arrayToBuffer(indexArray);
	}
	
	public static FloatBuffer arrayToBuffer(float[] arr)
	{
		ByteBuffer bb = ByteBuffer.allocateDirect(arr.length * Float.SIZE/8);
		bb.order(ByteOrder.nativeOrder());
		FloatBuffer buf=bb.asFloatBuffer();
		buf.put(arr);
		buf.position(0);
		return buf;		
	}
	
	public static ShortBuffer arrayToBuffer(short[] arr)
	{
		ByteBuffer bb = ByteBuffer.allocateDirect(arr.length * Short.SIZE/8);
		bb.order(ByteOrder.nativeOrder());
		ShortBuffer buf = bb.asShortBuffer();
		buf.put(arr);
		buf.position(0);
		return buf;		
	}

	public static void draw(Hunter obj, GL10 gl)
	{
		 init(obj);
		// the vertex array is enabled for writing and used during rendering
	     gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	     // the color array is enabled for writing and used during rendering
	     gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

	     gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
	     /* specifies the location and data format of an array of 
	     vertex coordinates to use when rendering */
	     gl.glVertexPointer(3, GL10.GL_FLOAT, 0, pointBuffer); 

	     //DRAW THE TRIANGLE
	     gl.glDrawElements(GL10.GL_TRIANGLES, 12, 
	       GL10.GL_UNSIGNED_SHORT, indexBuffer);

	     gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	     gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
	
}
