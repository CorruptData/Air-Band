import java.util.ArrayList;
import java.util.Arrays;

public class ChordMap
{
	private static ArrayList<ArrayList<ArrayList<Integer>>> map;
	private static ArrayList<ArrayList<Integer>> domResPat;
	public ChordMap()
	{
		domResPat = new ArrayList<ArrayList<Integer>>();
		domResPat.add(new ArrayList<Integer>(Arrays.asList(0,4,7,12)));
		domResPat.add(new ArrayList<Integer>(Arrays.asList(0,4,7,10)));
		domResPat.add(new ArrayList<Integer>(Arrays.asList(0,3,7,12)));
		domResPat.add(new ArrayList<Integer>(Arrays.asList(0,3,7,10)));
		map = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		for(int i = 0; i < 24; i++)
		{
			map.add(new ArrayList<ArrayList<Integer>>());
		}
		map.get(0).add(new ArrayList<Integer>(Arrays.asList(4,0,3,7,12)));
		map.get(4).add(new ArrayList<Integer>(Arrays.asList(5,0,4,7,12)));
		map.get(4).add(new ArrayList<Integer>(Arrays.asList(5,0,4,7,10)));
		map.get(5).add(new ArrayList<Integer>(Arrays.asList(0,0,3,7,10)));
	}
	
	private static boolean isDominant(ArrayList<Integer> c)
	{
		return (c.equals(new ArrayList(Arrays.asList(0,4,7,10))) || c.equals(new ArrayList(Arrays.asList(0,3,7,10))));
	}
	
	private static Chord resolveDominant(int root)
	{
		return (root>11) ? new Chord((root-7)%12,domResPat.get((int)Math.random()*4)):
		new Chord((root+5)%12,domResPat.get((int)Math.random()*4));
	}
	
	public static Chord getChord(int key, int root, ArrayList<Integer> pattern)
	{
		System.out.println(key + " " + root + " ");
		ArrayList<Integer> candidate = map.get(root).get((int)(Math.random()*map.get(root).size()));
		int newroot = candidate.remove(0);
		return isDominant(pattern)? resolveDominant(root): new Chord((key+newroot)%12,candidate);		
	}
}