package Lab.LR_2;

import java.util.Random;
import java.util.Scanner;

public class MatrixCalculator {

    // Constants for the range of random numbers
    private static final int MIN_OF_MATRIX_ELEMENTS = -100;
    private static final int MAX_OF_MATRIX_ELEMENTS = 100;
    private static final int MAX_MATRIX_SIZE = 20;

    // Method for manually creating the matrix
    public static int[][] createMatrixManually(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("matrix[%d][%d] = ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    // Method for randomly creating the matrix
    public static int[][] createMatrixRandomly(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(MAX_OF_MATRIX_ELEMENTS * 2 + 1) - MAX_OF_MATRIX_ELEMENTS; // Min -100, max 100
            }
        }

        return matrix;
    }

    // Method to find the minimum element in the matrix
    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    // Method to find the maximum element in the matrix
    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    // arithmetic mean
    public static double calculateArithmeticMean(int[][] matrix) {
        double sum = 0;
        int totalElements = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                totalElements++;
            }
        }
        return sum / totalElements;
    }

    // geometric mean
    public static double calculateGeometricMean(int[][] matrix) {
        // Check for negative numbers in the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    System.out.println("Geometric mean cannot be calculated because there are negative values.");
                    return Double.NaN;
                }
            }
        }

        // calculate the geometric mean
        double product = 1;
        int totalElements = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                product *= matrix[i][j];
                totalElements++;
            }
        }

        return Math.pow(product, 1.0 / totalElements);
    }

    // Method for printing the matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entering the matrix size
        System.out.print("Enter the number of rows for the matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the matrix: ");
        int cols = scanner.nextInt();

        if (rows > MAX_MATRIX_SIZE || cols > MAX_MATRIX_SIZE) {
            System.out.println("Matrix size cannot be greater than 20x20.");
            return;
        }

        // Choose between manual input or random creation
        System.out.println("Choose the matrix creation method:");
        System.out.println("1. Manual input");
        System.out.println("2. Random creation");
        int choice = scanner.nextInt();

        int[][] matrix = null;
        if (choice == 1) {
            matrix = createMatrixManually(rows, cols);
        } else if (choice == 2) {
            matrix = createMatrixRandomly(rows, cols);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        // Printing the matrix
        System.out.println("Matrix:");
        printMatrix(matrix);

        // Calculating minimum, maximum, arithmetic mean
        int min = findMin(matrix);
        int max = findMax(matrix);
        double arithmeticMean = calculateArithmeticMean(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        // Printing the results
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
        System.out.println("Arithmetic mean: " + arithmeticMean);
        System.out.println("Geometric mean: " + (Double.isNaN(geometricMean) ? "Cannot calculate" : geometricMean));
    }
}
