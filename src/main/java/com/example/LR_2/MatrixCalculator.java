package com.example.LR_2;

import java.util.Random;
import java.util.Scanner;

public class MatrixCalculator {

    // Константи для діапазону випадкових чисел
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;
    private static final int MAX_SIZE = 20;

    // Метод для створення матриці вручну
    public static int[][] createMatrixManually(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[rows][cols];

        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("matrix[%d][%d] = ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    // Метод для створення матриці випадковим чином
    public static int[][] createMatrixRandomly(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }

        return matrix;
    }

    // Метод для знаходження мінімального елемента матриці
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

    // Метод для знаходження максимального елемента матриці
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

    // Метод для обчислення середнього арифметичного елементів матриці
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

    // Метод для обчислення середнього геометричного елементів матриці
    public static double calculateGeometricMean(int[][] matrix) {
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

    // Метод для виведення матриці
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

        // Введення розміру матриці
        System.out.print("Введіть кількість рядків матриці: ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців матриці: ");
        int cols = scanner.nextInt();

        if (rows > MAX_SIZE || cols > MAX_SIZE) {
            System.out.println("Розмір матриці не може бути більшим за 20x20.");
            return;
        }

        // Вибір між ручним вводу або випадковим створенням
        System.out.println("Виберіть спосіб створення матриці:");
        System.out.println("1. Ручне введення");
        System.out.println("2. Випадкове створення");
        int choice = scanner.nextInt();

        int[][] matrix = null;
        if (choice == 1) {
            matrix = createMatrixManually(rows, cols);
        } else if (choice == 2) {
            matrix = createMatrixRandomly(rows, cols);
        } else {
            System.out.println("Невірний вибір.");
            return;
        }

        // Виведення матриці
        System.out.println("Матриця:");
        printMatrix(matrix);

        // Обчислення мінімуму, максимуму, середнього арифметичного
        int min = findMin(matrix);
        int max = findMax(matrix);
        double arithmeticMean = calculateArithmeticMean(matrix);
        double geometricMean = calculateGeometricMean(matrix);

        // Виведення результатів
        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + arithmeticMean);
        System.out.println("Середнє геометричне: " + geometricMean);
    }
}