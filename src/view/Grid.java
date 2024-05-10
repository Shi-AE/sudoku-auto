package view;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {

    private final int N = 9;

    private final int[][] testData = {
            {0, 0, 0, 0, 0, 0, 6, 7, 0,},
            {0, 4, 0, 0, 7, 0, 0, 0, 0,},
            {0, 3, 0, 9, 0, 5, 0, 0, 0,},
            {0, 0, 9, 8, 0, 0, 3, 0, 0,},
            {8, 0, 0, 0, 6, 0, 0, 2, 0,},
            {0, 0, 3, 0, 0, 0, 0, 0, 1,},
            {0, 0, 0, 7, 0, 0, 0, 9, 2,},
            {0, 6, 7, 0, 0, 9, 0, 4, 0,},
            {0, 2, 0, 0, 0, 1, 0, 0, 0,},
    };
    private final JTextField[][] fields = new JTextField[N][N];

    private final JPanel[] grid = new JPanel[N];

    public Grid() {
        setLayout(new GridLayout(N / 3, N / 3, 4, 4));
        for (int i = 0; i < grid.length; i++) {
            grid[i] = new JPanel();
            grid[i].setLayout(new GridLayout(N / 3, N / 3));
            for (int j = i / 3 * 3; j < (i / 3 + 1) * 3; j++) {
                for (int k = i % 3 * 3; k < (i % 3 + 1) * 3; k++) {
                    fields[j][k] = new JTextField();
                    fields[j][k].setHorizontalAlignment(JTextField.CENTER);
                    fields[j][k].setForeground(Color.RED);
                    fields[j][k].setFont(new Font("宋体", Font.PLAIN, 30));
                    grid[i].add(fields[j][k]);
                }
            }
            add(grid[i]);
        }


        //测试数据
        FieldsInitialize();
    }

    public String getField(int x, int y) {
        return fields[x][y].getText();
    }

    public void setField(int x, int y, int value) {
        fields[x][y].setText(String.valueOf(value));
    }

    public void setFieldForeground(int x, int y, Color color) {
        fields[x][y].setForeground(color);
    }

    public void FieldsInitialize() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (testData[i][j] != 0)
                    fields[i][j].setText(testData[i][j] + "");
            }
        }
    }

    public void clear() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fields[i][j].setText("");
                fields[i][j].setForeground(Color.RED);
            }
        }
    }
}
