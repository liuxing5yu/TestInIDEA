package _regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Java正则表达式详解
 *
 * @author 80953
 */
public class Test1 {

    @Test
    public void test1() {
        String text = "This is the text to be searched " + "for occurrences of the http:// pattern.";
        String pattern = ".*http://.*";
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("matches = " + matches);
    }

    @Test
    public void test2() {
        String text = "This is the text to be searched " + "for occurrences of the pattern.";
        String pattern = ".*is.*";
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("matches = " + matches);

    }

    @Test
    public void test3() {
        String text = "This is the text to be searched " + "for occurrences of the http:// pattern.";
        String patternString = ".*http://.*";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        boolean matches = matcher.matches();
        System.out.println("matches = " + matches);
    }

    @Test
    public void test4() {
        String text = "A sep Text sep With sep Many sep Separators";
        String patternString = "sep";
        Pattern pattern = Pattern.compile(patternString);
        String[] split = pattern.split(text);
        System.out.println("split.length = " + split.length);
        for (String element : split) {
            System.out.println("element = " + element);
        }
    }

    @Test
    public void test5() {
        String text = "This is the text to be searched " + "for occurrences of the http:// pattern.";
        String patternString = ".*http://.*";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
    }
}
