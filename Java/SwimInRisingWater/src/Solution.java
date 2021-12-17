import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	boolean[][] marked;
    public int swimInWater(int[][] grid) {
        int t = 0, start = grid[0][0], end = grid[grid.length - 1][grid.length - 1];
        marked = new boolean[grid.length][grid.length];
        for(int i = 0; i < grid.length * grid[0].length; i++){
            if(bfs(grid, start, end, t))
                break;
            t++;
        }
        return t;
    }
    boolean bfs(int[][] g, int s, int e, int n) {
        Queue<String> q = new LinkedList<>();
        q.add(0 + "," + 0);
        while(!q.isEmpty()) {
            String x = q.remove();   
            int row = Integer.parseInt(x.split(",")[0]);
            int col = Integer.parseInt(x.split(",")[1]);
            if(g[row][col] == e) 
                return true;         
            if (marked[row][col]) 
               continue;          
            marked[row][col] = true;
            if(col - 1 >= 0 && n >= g[row][col - 1] && n >= g[row][col]) 
                q.add(row + "," + (col - 1)); 
            if(col + 1 < g.length && n >= g[row][col + 1] && n >= g[row][col]) 
                q.add(row + "," + (col + 1));    
            if(row - 1 >= 0 && n >= g[row - 1][col] && n >= g[row][col])  
                q.add((row - 1) + "," + col);
            if(row + 1 < g[0].length && n >= g[row + 1][col] && n >= g[row][col]) 
                q.add((row + 1) + "," + col);
        }
        for(int i = 0; i < marked.length; i++)
            Arrays.fill(marked[i], Boolean.FALSE);
        return false;
    }
}
