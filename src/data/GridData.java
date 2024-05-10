package data;

import java.util.ArrayList;

public class GridData {
    private final int N = 9;
    private final int[][] grid;
    private final ArrayList<Cell> cells = new ArrayList<>();
    private final ArrayList<int[][]> solutionSte = new ArrayList<>();

    public GridData(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (this.grid[i][j] == 0) {
                    cells.add(new Cell(i, j));
                }
            }
        }
    }

    public void solve(int deep) {
        if (deep < cells.size() && solutionSte.size() <= 1000) {
            find(deep);
            for (int i = 0; i < cells.get(deep).getNum().size(); i++) {
                grid[cells.get(deep).getX()][cells.get(deep).getY()] = cells.get(deep).getNum().get(i);
                solve(deep + 1);
            }
            grid[cells.get(deep).getX()][cells.get(deep).getY()] = 0;
        } else if (solutionSte.size() <= 1000) {
            int[][] solution = new int[N][N];
            for (int i = 0; i < N; i++) {
                System.arraycopy(grid[i], 0, solution[i], 0, N);
            }
            solutionSte.add(solution);
        }
    }

    private void find(int deep) {
        boolean[] hasNum = new boolean[9];
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (grid[cells.get(deep).getX()][i] != 0)
                hasNum[grid[cells.get(deep).getX()][i] - 1] = true;
        }
        for (int i = 0; i < N; i++) {
            if (grid[i][cells.get(deep).getY()] != 0)
                hasNum[grid[i][cells.get(deep).getY()] - 1] = true;
        }
        for (int i = cells.get(deep).getX() / 3 * 3; i < (cells.get(deep).getX() / 3 + 1) * 3; i++) {
            for (int j = cells.get(deep).getY() / 3 * 3; j < (cells.get(deep).getY() / 3 + 1) * 3; j++) {
                if (grid[i][j] != 0)
                    hasNum[grid[i][j] - 1] = true;
            }
        }
        for (int i = 0; i < hasNum.length; i++) {
            if (!hasNum[i])
                num.add(i + 1);
        }
        cells.get(deep).setNum(num);
    }

    public ArrayList<int[][]> getSolutionSte() {
        return solutionSte;
    }
}
