package hu.nye.jatekelmelet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Point {

    private int SIZE = 4;
    private double[][] array = new double[SIZE][SIZE];

    public Point() {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while (scanner.hasNextLine()) {
                for (int i = 0; i < array.length; i++) {
                    String[] line = scanner.nextLine().trim().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        array[i][j] = Double.parseDouble(line[j]);
                    }
                }
            }
            //System.out.println(Arrays.deepToString(array));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public double rowMin(double[][] array, int row) {
        double minimum = array[row][0];
        for (int i = 0; i < SIZE; i++) {
            if(array[row][i] < minimum) {
                minimum = array[row][i];
            }
        }
        return minimum;
    }

    public double columnMax(double[][] array, int col) {
        double maximum = array[0][col];
        for (int i = 0; i < SIZE; i++) {
            if(array[i][col] > maximum) {
                maximum = array[i][col];
            }
        }
        return maximum;
    }

    public boolean validPoint() {
        double rowMinMax, colMaxMin;
        int rowIndex, colIndex;

        double[] arrayRowMin = new double[SIZE];
        double[] arrayColMax = new double[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arrayRowMin[i] = rowMin(array, i);
        }

        for (int i = 0 ; i < SIZE; i++) {
            arrayColMax[i] = columnMax(array, i);
        }

        rowMinMax = arrayRowMin[0];
        rowIndex = 0;
        for (int i = 0; i < SIZE; i++) {
            if(arrayRowMin[i] > rowMinMax) {
                rowMinMax = arrayRowMin[i];
                rowIndex = i;
            }
        }

        colMaxMin = arrayColMax[0];
        colIndex = 0;
        for (int i = 0; i < SIZE; i++) {
            if(arrayColMax[i] < colMaxMin) {
                colMaxMin = arrayColMax[i];
                colIndex = i;
            }
        }

        if (array[rowIndex][colIndex] == rowMinMax && rowMinMax == colMaxMin) {
            return true;
        } else {
            return false;
        }
    }

    public void setArray(double[][] array) {
        this.array = array;
    }

    public void setSIZE(int SIZE) {
        this.SIZE = SIZE;
    }

    public static void main(String[] args){
        Point point = new Point();
        System.out.println(point.validPoint());
    }
}
