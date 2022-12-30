import java.util.regex.Pattern;

/**
 * @author Chen Manman
 * @since 2022/12/2 14:32
 */
public class Regex {
    public static void main(String[] args) {
        String content = "I am noob" + "from runoob.com";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println(isMatch);
    }
}
