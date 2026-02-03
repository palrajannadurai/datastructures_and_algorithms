package dsa.string;

public class RemoveAllOccurrenceOfString {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            int index = sb.indexOf(part);
            if (index == -1) {
                break;
            }
            sb.delete(index, index + part.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(new RemoveAllOccurrenceOfString().removeOccurrences(s, part));
    }
}
