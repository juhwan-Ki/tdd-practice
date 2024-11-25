package com.study.chapter02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    /*
    * 암호 검사기 테스트 코드 작성
    * 규칙
    * 1. 길이가 8글자 이상인가?
    * 2. 0부터 9 사이의 숫자를 포함하는가?
    * 3. 대문자가 포함되어 있는가?
    * -------------------------------
    * 암호 등급
    * 1. 강함 : 3가지 규칙을 모두 충족
    * 2. 중간 : 2가지 규칙을 충족
    * 3. 약함 : 1개 이하의 규칙을 충족
    * */

    private final PasswordStrengthMeter meter = new PasswordStrengthMeter();

    // 모든 조건을 충족하는 경우
    @Test
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    // 길이만 8글자 미만이고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NOMAL);
    }

    // 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ASDQW", PasswordStrength.NOMAL);
    }

    private void assertStrength(String password, PasswordStrength strength) {
        PasswordStrength result = meter.meter(password);
        assertEquals(strength, result);
    }

}
