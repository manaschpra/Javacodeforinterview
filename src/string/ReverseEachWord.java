package string;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWord {
    public static void main(String[] args) {

        String str = "java program";
        String str2 = "java is coding language";
        String str3 = "hello world";

        //using StringBuilder
        String result = Stream.of(str.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("Reverse Each Word in String using StringBuilder : " + result);

        // using reduce method
        String result3 = Arrays.stream(str3.split(" "))
                .map(word->new String(
                        Arrays.stream(word.split(""))
                                .reduce((a,b)-> b+a)
                        .orElse("")
                ))
        .collect(Collectors.joining(" "));
        System.out.println("Reverse Each Word in String using reduce method : " + result3 );

    // for Recursive method
        String result2= Arrays.stream(str2.split(" "))
                .map(ReverseEachWord::reverseWordRecursive)
                .collect(Collectors.joining(" "));
       System.out.println("Reverse Each Word in String Recursive method  : " + result2);
    }

    //using Recursive method
    private static String reverseWordRecursive(String word) {
        if(word.isEmpty() || word.length() == 1){
            return word;
        }
        return reverseWordRecursive(word.substring(1)) + word.charAt(0);
    }
}
