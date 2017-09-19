import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class urlToStr {
    public static void main (String[] args) {
        System.out.println("Please enter the url you want to print");
        Scanner url = new Scanner(System.in);
        String str = url.next();
        urlToStr obj = new urlToStr();
        System.out.println(obj.wordCount(urlToString(str)));
    }

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount (String x) {
        int count = 0;
        char ch[] = new char[x.length()];
        for (int i = 0; i < x.length(); i++) {
            ch[i] = x.charAt(i);
            if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0))) {
                count++;
            }
        }
        return count;
    }

}