package com;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Conway {
	private Map<Point, Boolean> initial;
	
	public Conway() {
		initial = new HashMap<Point, Boolean>();
	}

	public void addInitialLife(int x, int y) {
		// TODO Auto-generated method stub
		initial.put(new Point(x, y), true);
	}

	public boolean calculateState(int x, int y, int generation) {
		int prevGen = generation - 1;
		if (generation == 0)
			return initial.containsKey(new Point(x, y));
		
		int liveNeighbours = 0;
		for (int nx = x - 1; nx <= x + 1; nx++)
			for (int ny = y - 1; ny <= y + 1; ny++)
				if (!(nx == x && ny == y))
					if (calculateState(nx, ny, prevGen))
						liveNeighbours++;

		
		if (liveNeighbours == 3)
			return true;
		
		if (liveNeighbours == 2)
			return calculateState(x, y, prevGen);
		
		//less than two or more than 3 neighbours: die.
		return false;
	}
	
	public String stringWindow(int generation, int sx, int sy, int w, int h) {
		StringBuilder sb = new StringBuilder();
		
		for(int vx = sx; vx < sx + w; vx++){
			for(int vy = sy; vy < sy + h; vy++) {
				if(calculateState(vx, vy, generation))
					sb.append("x");
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
