public class Calculator {

    private double lastResult;
    private static int operationCount = 0;

    public double add(double a, double b) {
        operationCount++;
        lastResult = a + b;
        return lastResult;
    }

    public double subtract(double a, double b) {
        operationCount++;
        lastResult = a - b;
        return lastResult;
    }

    public double multiply(double a, double b) {
        operationCount++;
        lastResult = a * b;
        return lastResult;
    }

    public double divide(double a, double b) {
        operationCount++;

        if (b == 0) {
            lastResult = Double.NaN;
            return Double.NaN;
        }

        lastResult = a / b;
        return lastResult;
    }

    public double getLastResult() {
        return lastResult;
    }

    public static int getOperationCount() {
        return operationCount;
    }

    public static void resetOperationCount() {
        operationCount = 0;
    }
}