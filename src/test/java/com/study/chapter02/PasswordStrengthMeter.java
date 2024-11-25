package com.study.chapter02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String password) {
        if(password == null || password.isBlank())
            return PasswordStrength.INVALID;

        int metCnt = getMetCnt(password);
        if(metCnt <= 1)
            return PasswordStrength.WEAK;
        if(metCnt == 2)
            return PasswordStrength.NOMAL;

        return PasswordStrength.STRONG;
    }

    private boolean meetContainingNumberCriteria(String password) {
        for(char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9')
                return true;
        }
        return false;
    }

    private boolean meetContainingUpperCaseCriteria(String password) {
        for(char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch))
                return true;
        }
        return false;
    }

    private int getMetCnt(String password) {
        int metCnt = 0;
        if(password.length() >= 8)
            metCnt++;
        if(meetContainingNumberCriteria(password))
            metCnt++;
        if(meetContainingUpperCaseCriteria(password))
            metCnt++;

        return metCnt;
    }
}
