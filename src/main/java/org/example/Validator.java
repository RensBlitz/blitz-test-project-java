package org.example;

public class Validator {
    
    public boolean isValidEmail(String email) {
        if (!hasBasicEmailStructure(email)) {
            return false;
        }
        
        String[] parts = splitEmailParts(email);
        return validateEmailParts(parts);
    }
    
    private boolean hasBasicEmailStructure(String email) {
        return email != null && 
               containsAtSymbol(email) && 
               hasMinimumLength(email, 5);
    }
    
    private boolean containsAtSymbol(String email) {
        return email.contains("@");
    }
    
    private boolean hasMinimumLength(String text, int minLength) {
        return text.length() >= minLength;
    }
    
    private String[] splitEmailParts(String email) {
        return email.split("@");
    }
    
    private boolean validateEmailParts(String[] parts) {
        if (!hasCorrectNumberOfParts(parts)) {
            return false;
        }
        
        String localPart = parts[0];
        String domainPart = parts[1];
        
        return validateLocalPart(localPart) && validateDomainPart(domainPart);
    }
    
    private boolean hasCorrectNumberOfParts(String[] parts) {
        return parts.length == 2;
    }
    
    private boolean validateLocalPart(String localPart) {
        return isNotEmpty(localPart) && 
               hasValidLength(localPart, 1, 64) &&
               containsOnlyValidLocalCharacters(localPart);
    }
    
    private boolean validateDomainPart(String domainPart) {
        return isNotEmpty(domainPart) && 
               containsDot(domainPart) &&
               hasValidDomainStructure(domainPart);
    }
    
    private boolean isNotEmpty(String text) {
        return text != null && !text.isEmpty();
    }
    
    private boolean hasValidLength(String text, int min, int max) {
        int length = text.length();
        return length >= min && length <= max;
    }
    
    private boolean containsOnlyValidLocalCharacters(String localPart) {
        return localPart.matches("[a-zA-Z0-9._%+-]+");
    }
    
    private boolean containsDot(String domain) {
        return domain.contains(".");
    }
    
    private boolean hasValidDomainStructure(String domain) {
        String[] domainParts = domain.split("\\.");
        return validateDomainParts(domainParts);
    }
    
    private boolean validateDomainParts(String[] domainParts) {
        if (domainParts.length < 2) {
            return false;
        }
        
        for (String part : domainParts) {
            if (!isValidDomainPart(part)) {
                return false;
            }
        }
        
        return hasValidTopLevelDomain(domainParts);
    }
    
    private boolean isValidDomainPart(String part) {
        return isNotEmpty(part) && 
               containsOnlyValidDomainCharacters(part) &&
               hasValidLength(part, 1, 63);
    }
    
    private boolean containsOnlyValidDomainCharacters(String part) {
        return part.matches("[a-zA-Z0-9-]+");
    }
    
    private boolean hasValidTopLevelDomain(String[] domainParts) {
        String tld = domainParts[domainParts.length - 1];
        return hasValidLength(tld, 2, 10) && containsOnlyLetters(tld);
    }
    
    private boolean containsOnlyLetters(String text) {
        return text.matches("[a-zA-Z]+");
    }
    
    public boolean isStrongPassword(String password) {
        if (!meetsBasicPasswordRequirements(password)) {
            return false;
        }
        
        return meetsComplexityRequirements(password);
    }
    
    private boolean meetsBasicPasswordRequirements(String password) {
        return password != null && hasMinimumPasswordLength(password);
    }
    
    private boolean hasMinimumPasswordLength(String password) {
        return password.length() >= 8;
    }
    
    private boolean meetsComplexityRequirements(String password) {
        return containsLowercase(password) &&
               containsUppercase(password) &&
               containsDigit(password) &&
               containsSpecialCharacter(password);
    }
    
    private boolean containsLowercase(String password) {
        return hasCharacterType(password, "[a-z]");
    }
    
    private boolean containsUppercase(String password) {
        return hasCharacterType(password, "[A-Z]");
    }
    
    private boolean containsDigit(String password) {
        return hasCharacterType(password, "[0-9]");
    }
    
    private boolean containsSpecialCharacter(String password) {
        return hasCharacterType(password, "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]");
    }
    
    private boolean hasCharacterType(String password, String regex) {
        return password.matches(".*" + regex + ".*");
    }
    
    public boolean isValidPhoneNumber(String phoneNumber) {
        if (!hasBasicPhoneStructure(phoneNumber)) {
            return false;
        }
        
        String normalized = normalizePhoneNumber(phoneNumber);
        return validateNormalizedPhone(normalized);
    }
    
    private boolean hasBasicPhoneStructure(String phoneNumber) {
        return phoneNumber != null && isNotEmpty(phoneNumber);
    }
    
    private String normalizePhoneNumber(String phoneNumber) {
        String withoutSpaces = removeSpaces(phoneNumber);
        String withoutDashes = removeDashes(withoutSpaces);
        return removeParentheses(withoutDashes);
    }
    
    private String removeSpaces(String text) {
        return text.replaceAll(" ", "");
    }
    
    private String removeDashes(String text) {
        return text.replaceAll("-", "");
    }
    
    private String removeParentheses(String text) {
        return text.replaceAll("[()]", "");
    }
    
    private boolean validateNormalizedPhone(String normalized) {
        return hasValidPhoneLength(normalized) && containsOnlyDigitsAndPlus(normalized);
    }
    
    private boolean hasValidPhoneLength(String phone) {
        int length = phone.length();
        return (length >= 10 && length <= 15) || 
               (startsWithPlus(phone) && length >= 11 && length <= 16);
    }
    
    private boolean startsWithPlus(String phone) {
        return phone.startsWith("+");
    }
    
    private boolean containsOnlyDigitsAndPlus(String phone) {
        return phone.matches("\\+?[0-9]+");
    }
}