package string;

import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class stringOccurance {
    public static void main(String[] args) {
        String str ="hello world";

       Map<Character, Long> words= str.chars()
                .mapToObj(c->(char)c)
                .filter(ch->!Character.isWhitespace(ch))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
       //occurance of characters
      //  System.out.println(words);
               .entrySet().stream()
               .filter(e->e.getValue() > 1)
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Duplicate characters  " +words );
    }
}
