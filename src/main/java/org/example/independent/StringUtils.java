package org.example.independent;

public class StringUtils {
    
    public String processText(String text) {
        if (isNullOrEmpty(text)) {
            return "";
        }
        
        String cleaned = removeExtraSpaces(text);
        String capitalized = capitalizeWords(cleaned);
        return trimResult(capitalized);
    }
    
    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
    
    private String removeExtraSpaces(String text) {
        String trimmed = trimWhitespace(text);
        return collapseMultipleSpaces(trimmed);
    }
    
    private String trimWhitespace(String text) {
        return text.trim();
    }
    
    private String collapseMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }
    
    private String capitalizeWords(String text) {
        String[] words = splitIntoWords(text);
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String capitalizedWord = capitalizeWord(words[i]);
            result.append(capitalizedWord);
            
            if (shouldAddSpace(i, words.length)) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    private String[] splitIntoWords(String text) {
        return text.split(" ");
    }
    
    private String capitalizeWord(String word) {
        if (isEmptyWord(word)) {
            return word;
        }
        
        char firstChar = getCapitalizedFirstChar(word);
        String remainingChars = getLowercaseRemainingChars(word);
        
        return firstChar + remainingChars;
    }
    
    private boolean isEmptyWord(String word) {
        return word.length() == 0;
    }
    
    private char getCapitalizedFirstChar(String word) {
        return Character.toUpperCase(word.charAt(0));
    }
    
    private String getLowercaseRemainingChars(String word) {
        if (word.length() <= 1) {
            return "";
        }
        return word.substring(1).toLowerCase();
    }
    
    private boolean shouldAddSpace(int currentIndex, int totalWords) {
        return currentIndex < totalWords - 1;
    }
    
    private String trimResult(String text) {
        return text.trim();
    }
    
    public boolean isPalindrome(String text) {
        if (isNullOrEmpty(text)) {
            return true;
        }
        
        String normalized = normalizeForPalindrome(text);
        return checkPalindrome(normalized);
    }
    
    private String normalizeForPalindrome(String text) {
        String lowercased = convertToLowercase(text);
        return removeNonAlphanumeric(lowercased);
    }
    
    private String convertToLowercase(String text) {
        return text.toLowerCase();
    }
    
    private String removeNonAlphanumeric(String text) {
        return text.replaceAll("[^a-zA-Z0-9]", "");
    }
    
    private boolean checkPalindrome(String text) {
        int length = text.length();
        int halfLength = calculateHalfLength(length);
        
        for (int i = 0; i < halfLength; i++) {
            if (!charactersMatch(text, i, length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
    private int calculateHalfLength(int length) {
        return length / 2;
    }
    
    private boolean charactersMatch(String text, int leftIndex, int rightIndex) {
        return text.charAt(leftIndex) == text.charAt(rightIndex);
    }
    
    public int countVowels(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        
        String normalized = prepareForVowelCount(text);
        return performVowelCount(normalized);
    }
    
    private String prepareForVowelCount(String text) {
        return convertToLowercase(text);
    }
    
    private int performVowelCount(String text) {
        int count = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (isVowel(currentChar)) {
                count = incrementCount(count);
            }
        }
        
        return count;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    private int incrementCount(int count) {
        return count + 1;
    }
}