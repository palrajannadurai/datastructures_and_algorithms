package dsa.string;

public class ExcelSheetToNumber {
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result *= 26;
            System.out.println(columnTitle.charAt(i) - 'A' + 1);
            result += columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
}
