package rs.nde.ooad.p4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rs.nde.ooad.p4.Terrain;
import rs.nde.ooad.p4.Tree;

class TreeFactory
{
	private static final Map<String, Tree> myMap = new HashMap<String, Tree>();
	public static Terrain getTree(String type)
	{
		if (myMap.containsKey(type))
			return myMap.get(type);

		Tree tree = new Tree(type);
		myMap.put(type, tree);
		return tree;
   }
}