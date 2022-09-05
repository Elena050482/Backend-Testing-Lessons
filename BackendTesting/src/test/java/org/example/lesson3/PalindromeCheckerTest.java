package org.example.lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.lesson3.PalindromeChecker.isPalindrome;



class PalindromeCheckerTest {
    @Test
    @DisplayName("Метод проверки палиндрома с вводом слова с одинаковым регистром, четное количетсво символов")
    void givenPalindrome() {
        boolean result = isPalindrome("ABBA");
        Assertions.assertEquals(true, result);

    }

    @Test
    @DisplayName("ввод текста с пробелами")
    void givenPalindrome2() {
        boolean result = isPalindrome("A B B A");
        Assertions.assertEquals(true, result);

    }

    @Test
    @DisplayName("ввод текста с нечетным количеством символов")
    void givenPalindrome3() {
        boolean result = isPalindrome("ABBAB");
        Assertions.assertEquals(true, result);

    }

    @Test
    @DisplayName("ввод текста с четным количеством, но разных символов")
    void givenPalindrome4() {
        boolean result = isPalindrome("AB");
        Assertions.assertEquals(true, result);

    }

    @Test
    @DisplayName("ввод текста с разным регистром")
    void givenPalindrome5() {
        boolean result = isPalindrome("AbBA");
        Assertions.assertEquals(true, result);

    }

    @Test
    @DisplayName("ввод текста c одним символом")
    void givenPalindrome6() {
        boolean result = isPalindrome("A");
        Assertions.assertEquals(true, result);

    }
}