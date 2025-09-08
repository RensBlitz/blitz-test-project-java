package org.example;

import java.util.*;

public class ArrayProcessor {
    
    public int[] sortAndRemoveDuplicates(int[] array) {
        if (isNullOrEmpty(array)) {
            return new int[0];
        }
        
        int[] sortedArray = createSortedCopy(array);
        return extractUniqueElements(sortedArray);
    }
    
    private boolean isNullOrEmpty(int[] array) {
        return array == null || array.length == 0;
    }
    
    private int[] createSortedCopy(int[] array) {
        int[] copy = copyArray(array);
        sortArray(copy);
        return copy;
    }
    
    private int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }
    
    private void sortArray(int[] array) {
        Arrays.sort(array);
    }
    
    private int[] extractUniqueElements(int[] sortedArray) {
        List<Integer> uniqueList = buildUniqueList(sortedArray);
        return convertListToArray(uniqueList);
    }
    
    private List<Integer> buildUniqueList(int[] sortedArray) {
        List<Integer> uniqueList = new ArrayList<>();
        
        for (int i = 0; i < sortedArray.length; i++) {
            if (shouldAddElement(sortedArray, i, uniqueList)) {
                addToList(uniqueList, sortedArray[i]);
            }
        }
        
        return uniqueList;
    }
    
    private boolean shouldAddElement(int[] array, int index, List<Integer> uniqueList) {
        return isFirstElement(index) || isDifferentFromPrevious(array, index);
    }
    
    private boolean isFirstElement(int index) {
        return index == 0;
    }
    
    private boolean isDifferentFromPrevious(int[] array, int index) {
        return array[index] != array[index - 1];
    }
    
    private void addToList(List<Integer> list, int value) {
        list.add(value);
    }
    
    private int[] convertListToArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public double[] calculateMovingAverage(int[] array, int windowSize) {
        validateMovingAverageInput(array, windowSize);
        
        int resultSize = calculateResultSize(array.length, windowSize);
        return computeMovingAverages(array, windowSize, resultSize);
    }
    
    private void validateMovingAverageInput(int[] array, int windowSize) {
        validateArrayNotNull(array);
        validateWindowSize(windowSize, array.length);
    }
    
    private void validateArrayNotNull(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
    }
    
    private void validateWindowSize(int windowSize, int arrayLength) {
        if (windowSize <= 0) {
            throw new IllegalArgumentException("Window size must be positive");
        }
        if (windowSize > arrayLength) {
            throw new IllegalArgumentException("Window size cannot exceed array length");
        }
    }
    
    private int calculateResultSize(int arrayLength, int windowSize) {
        return arrayLength - windowSize + 1;
    }
    
    private double[] computeMovingAverages(int[] array, int windowSize, int resultSize) {
        double[] results = new double[resultSize];
        
        for (int i = 0; i < resultSize; i++) {
            double average = calculateWindowAverage(array, i, windowSize);
            results[i] = average;
        }
        
        return results;
    }
    
    private double calculateWindowAverage(int[] array, int startIndex, int windowSize) {
        long sum = calculateWindowSum(array, startIndex, windowSize);
        return convertToAverage(sum, windowSize);
    }
    
    private long calculateWindowSum(int[] array, int startIndex, int windowSize) {
        long sum = 0;
        int endIndex = calculateEndIndex(startIndex, windowSize);
        
        for (int i = startIndex; i < endIndex; i++) {
            sum = addToSum(sum, array[i]);
        }
        
        return sum;
    }
    
    private int calculateEndIndex(int startIndex, int windowSize) {
        return startIndex + windowSize;
    }
    
    private long addToSum(long currentSum, int value) {
        return currentSum + value;
    }
    
    private double convertToAverage(long sum, int count) {
        return (double) sum / count;
    }
    
    public int findKthLargest(int[] array, int k) {
        validateKthLargestInput(array, k);
        
        Integer[] boxedArray = convertToBoxedArray(array);
        Integer[] sortedDescending = sortDescending(boxedArray);
        
        return extractKthElement(sortedDescending, k);
    }
    
    private void validateKthLargestInput(int[] array, int k) {
        validateArrayNotNull(array);
        validateArrayNotEmpty(array);
        validateKInRange(k, array.length);
    }
    
    private void validateArrayNotEmpty(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
    }
    
    private void validateKInRange(int k, int arrayLength) {
        if (k < 1 || k > arrayLength) {
            throw new IllegalArgumentException("k must be between 1 and array length");
        }
    }
    
    private Integer[] convertToBoxedArray(int[] array) {
        Integer[] boxed = new Integer[array.length];
        
        for (int i = 0; i < array.length; i++) {
            boxed[i] = boxValue(array[i]);
        }
        
        return boxed;
    }
    
    private Integer boxValue(int value) {
        return Integer.valueOf(value);
    }
    
    private Integer[] sortDescending(Integer[] array) {
        Arrays.sort(array, createDescendingComparator());
        return array;
    }
    
    private Comparator<Integer> createDescendingComparator() {
        return Collections.reverseOrder();
    }
    
    private int extractKthElement(Integer[] sortedArray, int k) {
        int index = convertToZeroBasedIndex(k);
        return unboxValue(sortedArray[index]);
    }
    
    private int convertToZeroBasedIndex(int k) {
        return k - 1;
    }
    
    private int unboxValue(Integer boxedValue) {
        return boxedValue.intValue();
    }
}