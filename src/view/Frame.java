package view;

import data.GridData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener {
    private final int start = 0;
    private final JTextField field = new JTextField();
    private final Grid grid = new Grid();
    private final int N = 9;

    public Frame() throws HeadlessException {
        //窗口
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //按钮
        JButton runButton = new JButton("运算");
        JButton clearButton = new JButton("清除");
        runButton.addActionListener(this);
        clearButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(runButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.NORTH);

        //表格
        add(grid, BorderLayout.CENTER);

        //反馈
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setFont(new Font("宋体", Font.PLAIN, 20));
        add(field, BorderLayout.SOUTH);

        //居中
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Frame().setVisible(true);
    }

    //获取
    public int[][] getGridData() {
        int[][] gridData = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid.getField(i, j).isEmpty()) {
                    grid.setFieldForeground(i, j, Color.black);
                } else {
                    gridData[i][j] = Integer.parseInt(grid.getField(i, j));
                }
            }
        }
        return gridData;
    }

    private void setGrid(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid.setField(i, j, solution[i][j]);
            }
        }
    }

    public void setField(ArrayList<int[][]> solutionSet) {
        if (solutionSet.size() == 1) {
            field.setText("存在唯一解");
            setGrid(solutionSet.get(0));
        } else if (solutionSet.size() <= 1000) {
            field.setText("存在" + solutionSet.size() + "个解");
            int selection = Integer.parseInt(JOptionPane.showInputDialog(null, "选择"));
            setGrid(solutionSet.get(selection - 1));
        } else {
            field.setText("存在大于1000个解");
            int selection = Integer.parseInt(JOptionPane.showInputDialog(null, "选择"));
            setGrid(solutionSet.get(selection - 1));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("运算")) {
            GridData data = new GridData(getGridData());
            data.solve(start);
            setField(data.getSolutionSte());
        } else if (e.getActionCommand().equals("清除")) {
            grid.clear();
            field.setText("");
        }
    }
}
