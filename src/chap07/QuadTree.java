package chap07;

import java.text.StringCharacterIterator;

public class QuadTree {
    public static void main(String[] args) {
        StringCharacterIterator str = new StringCharacterIterator("xbwwb");
        System.out.println(reverse(str));
    }

    public static String reverse(StringCharacterIterator it) {
        char head = it.current();
        it.next();

        if(head != 'x')
            return Character.toString(head);

        String upperLeft = reverse(it);
        String upperRight = reverse(it);
        String lowerLeft = reverse(it);
        String lowerRight = reverse(it);

        return 'x' + lowerLeft + lowerRight + upperLeft + upperRight;
    }
}
