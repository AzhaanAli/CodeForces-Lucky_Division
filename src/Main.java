import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /** DIRECTIONS:
         * A lucky number is defined as a positive integer whose base 10 representation composes only of the digits 4 and 7.
         * For example, 47, 74, 447, 4447447, and 7474 are all lucky numbers, but 27 is not.
         *
         * An almost-lucky number is a number who can be expressed as a lucky number times some positive integer.
         *
         * Determine whether a given integer is an almost-lucky number. If it is, print "YES". Otherwise, print "NO".
         */

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        System.out.println(isAlmostLucky(num)? "YES" : "NO");
        
    }

    public static boolean isLuckyNumber(int num){

        char[] asCharArr = (num + "").toCharArray();
        // Check every character. If a character is neither 4 nor 7, num is not lucky so return false.
        // If all numbers are either 4 or 7, return true.
        for(char c : asCharArr)
            if(!(c == '4' || c == '7'))
                return false;
        return true;

    }
    public static boolean isAlmostLucky(int num){

        // Loop through all factors of num.
        // If one is found who is lucky, return true.
        // If no lucky factor is found, return false.
        for(int i = 1; i < num / 2; i++) // We can loop to just half of num if we check both i and num / i per step.
            if(num % i == 0)
                if(isLuckyNumber(i) || isLuckyNumber(num / i))
                    return true;
        return false;

    }

}