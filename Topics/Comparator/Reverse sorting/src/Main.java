import java.util.List;

class Utils {

    public static void sortStrings(List<String> strings) {
        // your code here
        strings.sort((s1,s2)->s2.compareTo(s1));
    }
}