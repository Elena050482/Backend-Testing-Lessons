package org.example.lesson3;

public class PalindromeChecker {

   public static boolean isPalindrome(String text) {

       int i = text.length()-1;
       int j=0;
       while(i > j) {
           if(text.charAt(i) != text.charAt(j)) {
           return false;
           }
           i--;
           j++;
       }

       // убираем все ненужные символы и пробелы
       return text.replaceAll("\\W","")
               // создаем вторую строку, пересортированную в обратном порядке и игнорим регистр
               .equalsIgnoreCase(new StringBuilder(text.replaceAll("\\W",""))
                       .reverse().toString());
   }
}

