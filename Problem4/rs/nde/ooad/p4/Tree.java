package rs.nde.ooad.p4;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

class Tree implements Terrain
{
	private int x;
	private int y;
	private Image image;
	public Tree(String type)
	{
		System.out.println("Creating a new instance of a tree of type " + type);
		String filename = "Problem4/tree" + type + ".png";
		try
		{
			image = ImageIO.read(new File(filename));
		} catch(Exception exc) { throw new RuntimeException(exc);}
	}
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public int getX() { return x; }
	public int getY() { return y; }
	@Override
	public void draw(Graphics graphics, int x, int y)
	{
		graphics.drawImage(image, x, y, null);
	}
}
