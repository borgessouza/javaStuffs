package Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class List01 {


    public static void main(String[] args) {
        System.out.println("Starting");

        List<String> names = Arrays.asList("abb", "aab", "aa", "aba", "a");
        System.out.println(names);

        names.sort(Collections.reverseOrder());
        System.out.println(names);

       Collections.sort(names, new Comparator<String>() {
           @Override
           public int compare(String a, String b) { return a.compareTo(b); }
         }
       );
        System.out.println(names);

        names.sort(Collections.reverseOrder());
        //less verbose
       Collections.sort(names, (String a, String b) -> {
           return a.compareTo(b);
        });
        System.out.println(names);

        names.sort(Collections.reverseOrder());
        // less less verbose
        Collections.sort(names, (a,b) -> a.compareTo(b));
        System.out.println(names);

        System.out.println("Ending");
    }
}
