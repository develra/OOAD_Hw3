package rs.nde.ooad.p4;
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;


/**
 * Don’t change anything in TreeDemo
 */
class TreeDemo extends JPanel
{
	private static final int width = 800;
	private static final int height = 700;
	private static final int numTrees = 50;
	private static final String type[] = { "Apple", "Lemon", "Blob", "Elm", "Maple" };

	public void paint(Graphics graphics)
	{
		for(int i=0; i < numTrees; i++) 
		{
			Tree tree = (Tree)TreeFactory.getTree(getRandomType());
			tree.draw(graphics, getRandomX(width), getRandomY(height));
		}
	}
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		frame.add(new TreeDemo());
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	private static String getRandomType() 
	{
		return type[(int)(Math.random()*type.length)];
	}
	private static int getRandomX(int max) 
	{
		return (int)(Math.random()*max );
	}
	private static int getRandomY(int max) 
	{
		return (int)(Math.random()*max);
	}
}

