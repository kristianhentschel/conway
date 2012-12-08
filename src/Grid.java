import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;


public class Grid {
	
	private Map<Dimension, Boolean> map;
	
	public Grid(){
		
		map = new HashMap<Dimension,Boolean>();
		
		
	}

	public void setCellState(int i, int j, boolean b) {
		
		if(b)
			map.put(new Dimension(i,j),new Boolean(true));
		else
			map.remove(new Dimension(i,j));
		// TODO Auto-generated method stub
		
	}

	public boolean isAlive(int i, int j) {
		return map.containsKey(new Dimension(i,j));		
	}
}
