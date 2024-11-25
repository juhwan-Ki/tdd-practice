package com.study.chapter02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String password) {
        if(password.length() < 8 )
            return PasswordStrength.NOMAL;

        if(!meetContainingNumberCriteria(password))
            return PasswordStrength.NOMAL;

        return PasswordStrength.STRONG;
    }

    private boolean meetContainingNumberCriteria(String password) {
        for(char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
