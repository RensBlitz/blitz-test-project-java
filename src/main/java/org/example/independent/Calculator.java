package org.example.independent;

public class Calculator {
    
    public double calculateQuadraticResult(double a, double b, double c) {
        double discriminant = calculateDiscriminant(a, b, c);
        
        if (discriminant < 0) {
            throw new IllegalArgumentException("No real roots exist");
        }
        
        return calculatePositiveRoot(a, b, discriminant);
    }
    
    private double calculateDiscriminant(double a, double b, double c) {
        return multiply(b, b) - multiply(4, multiply(a, c));
    }
    
    private double calculatePositiveRoot(double a, double b, double discriminant) {
        double sqrtDiscriminant = Math.sqrt(discriminant);
        double numerator = add(-b, sqrtDiscriminant);
        double denominator = multiply(2, a);
        return divide(numerator, denominator);
    }
    
    public long calculateFactorial(int n) {
        validateFactorialInput(n);
        return computeFactorial(n);
    }
    
    private void validateFactorialInput(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Factorial too large for long type");
        }
    }
    
    private long computeFactorial(int n) {
        if (isBaseCase(n)) {
            return 1;
        }
        return multiply(n, computeFactorial(n - 1));
    }
    
    private boolean isBaseCase(int n) {
        return n <= 1;
    }
    
    public boolean isPrime(int n) {
        if (!isPrimeCandidate(n)) {
            return false;
        }
        
        return checkPrimality(n);
    }
    
    private boolean isPrimeCandidate(int n) {
        return n > 1;
    }
    
    private boolean checkPrimality(int n) {
        int limit = calculatePrimalityCheckLimit(n);
        
        for (int i = 2; i <= limit; i++) {
            if (isDivisible(n, i)) {
                return false;
            }
        }
        return true;
    }
    
    private int calculatePrimalityCheckLimit(int n) {
        return (int) Math.sqrt(n);
    }
    
    private boolean isDivisible(int dividend, int divisor) {
        return dividend % divisor == 0;
    }
    
    private double add(double a, double b) {
        return a + b;
    }
    
    private double multiply(double a, double b) {
        return a * b;
    }
    
    private long multiply(long a, long b) {
        return a * b;
    }
    
    private double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}