import java.util.ArrayList;

class Solution {
    static int[] ROWS = {1, 0, -1, 0};
    static int[] COLS = {0, 1, 0, -1};
    ArrayList<Integer> row = new ArrayList<>();
    ArrayList<Integer> col = new ArrayList<>();
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] marked = new boolean[image.length][image[0].length];  
        row.add(sr);
        col.add(sc);
        marked[sr][sc] = true;
        adjacent(marked, image, sr, sc);
        for(int i = 0; i < row.size(); i++) {
            image[row.get(i)][col.get(i)] = newColor;
        }
        return image;
    }
    void adjacent(boolean[][] marked, int[][] image, int x, int y) {
        for(int i = 0; i < 4; i++) {
            if(validCoors(image, x + ROWS[i], y + COLS[i])
              && image[x + ROWS[i]][y + COLS[i]] == image[x][y]
              && !marked[x + ROWS[i]][y + COLS[i]]) {
                marked[x + ROWS[i]][y + COLS[i]] = true;
                row.add(x + ROWS[i]);
                col.add(y + COLS[i]);
                adjacent(marked, image, x + ROWS[i], y + COLS[i]);
            }
        }
    }
    boolean validCoors(int[][] image, int x, int y) {
        return (x >= 0 && x < image.length && y >= 0 && y < image[0].length) ? true : false;
    }
}