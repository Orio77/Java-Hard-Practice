package generics.exercise16_documentation.scenario3;

import java.lang.reflect.Array;

public class Matrix<T extends Number> implements MathOperations<Matrix<T>>{
    private T[][] matrix;

    /**
     * A generic matrix class.
     * @param matrix has a matrix field with any type of Number.
     */
    public Matrix(T[][] matrix) {
        this.matrix = matrix;
    }


    /**
     * Adds two matrices. The parameter one and field one.
     * @param matrix2 takes in a matrix
     * @throws IllegalArgumentException if the matrices are of different sizes
     * @return new result matrix
     */
    @SuppressWarnings("unchecked")
    public T[][] add(T[][] matrix2) {
        if (matrix.length != matrix2.length || matrix[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions to be added.");
        }

        T[][] result = (T[][]) Array.newInstance(matrix.getClass().getComponentType().getComponentType(), matrix.length, matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Number sum = matrix[i][j].doubleValue() + matrix2[i][j].doubleValue();
                result[i][j] = (T) sum;
            }
        }

        return result;
    }
    // AI Generated ^^
    
    /**
     * Multiplies two matrices - the parameter one and the field one.
     * @param matrix2 takes in a matrix as a parameter
     * @throws IllegalArgumentException if the number of columns in the first matrix is different from the number of rows of the second one
     * @return
     */
    @SuppressWarnings("unchecked")
    public T[][] multiply(T[][] matrix2) {
        if (matrix[0].length != matrix2.length) {
            throw new IllegalArgumentException("Number of columns in first matrix must be equal to number of rows in second matrix.");
        }

        T[][] result = (T[][]) Array.newInstance(matrix.getClass().getComponentType().getComponentType(), matrix.length, matrix2[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                Number sum = 0;
                for (int k = 0; k < matrix[0].length; k++) {
                    sum = sum.doubleValue() + matrix[i][k].doubleValue() * matrix2[k][j].doubleValue();
                }
                result[i][j] = (T) sum;
            }
        }
        return result;
    }
    // AI Generated ^^

    /**
     * A method that return the matrix field
     * @return the matrix field
     */
    public T[][] getMatrix() {
        return matrix;
    }


    @SuppressWarnings("unchecked")
    @Override
    public Matrix<T> add(Matrix<T> other) {
        if (matrix.length != other.getMatrix().length || matrix[0].length != other.getMatrix()[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions to be added.");
        }

        T[][] result = (T[][]) Array.newInstance(matrix.getClass().getComponentType().getComponentType(), matrix.length, matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Number sum = matrix[i][j].doubleValue() + other.getMatrix()[i][j].doubleValue();
                result[i][j] = (T) sum;
            }
        }

        return new Matrix<>(result);
    }


    @SuppressWarnings("unchecked")
    @Override
    public Matrix<T> multiply(Matrix<T> other) {
        if (matrix[0].length != other.getMatrix().length) {
            throw new IllegalArgumentException("Number of columns in first matrix must be equal to number of rows in second matrix.");
        }

        T[][] result = (T[][]) Array.newInstance(matrix.getClass().getComponentType().getComponentType(), matrix.length, other.getMatrix()[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < other.getMatrix()[0].length; j++) {
                Number sum = 0;
                for (int k = 0; k < matrix[0].length; k++) {
                    sum = sum.doubleValue() + matrix[i][k].doubleValue() * other.getMatrix()[k][j].doubleValue();
                }
                result[i][j] = (T) sum;
            }
        }
        return new Matrix<>(result);
    }
    
}
