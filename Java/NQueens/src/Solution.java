import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static int[] R = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] C = {1, 0, -1, -1, -1, 0, 1, 1};
    StringBuilder s;
    List<List<String>> answers;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        answers = new ArrayList<>();
        if(n == 1) {
            s = new StringBuilder();
            s.append('Q');
            List<String> one = new ArrayList<>();
            one.add(s.toString());
            answers.add(one);
            return answers;
        }
        if(n <= 3)
            return answers;
            board = new char[n][n];
            //Fill arrays with .
            for(int i = 0; i < board.length; i++) {
                Arrays.fill(board[i], '.');
            }
            rowChecker(n, 0, n);
        return answers;
    }
    public void addIt() {
        List<String> sol = new ArrayList<>();
        System.out.println("Hit");
        for(int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board.length; j++) 
                    sb.append(board[i][j]);
            sol.add(sb.toString());
        }   
        answers.add(sol);
    }
    public void rowChecker(int n, int i, int c) {
        for(int j = 0; j < n; j++) {
            if(check(i, j, n)) {
                board[i][j] = 'Q';
                System.out.print(c + " ");
                if(c == 1) {
                    addIt();
            }
                else 
                    rowChecker(n, i + 1, c - 1);
                board[i][j] = '.';
            }
        }
    }
    //Check if queen does not intersect
    //Parameters here are the queen's tentative position, n is board length
    public boolean check(int r, int c, int n) {
        for(int i = 0; i < R.length; i++) {
            if(r + R[i] < n && r + R[i] >= 0 &&
               c + C[i] < n && c + C[i] >= 0)
                if(!dirCheck(r, c, R[i], C[i], R[i], C[i], n))
                    return false;
        }
        return true;
    }
    //Check the diretion from check 
    //Parameters, r and c are tentative positions, r1 and c1 are direction it's checking, rinc and cinc increment r1 and c1 to         keep checking in the right direction
    public boolean dirCheck(int r, int c, int r1, int c1, int rinc, int cinc, int n) {
        if(r + r1 < n && r + r1 >= 0 &&
               c + c1 < n && c + c1 >= 0) {
            if(board[r + r1][c + c1] != 'Q')
                return dirCheck(r, c, r1 + rinc, c1 + cinc, rinc, cinc, n);
            else
                return false;
            }
        else 
            return true;
    }
}