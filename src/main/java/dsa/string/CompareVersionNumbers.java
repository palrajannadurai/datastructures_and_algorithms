package dsa.string;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] version1Parts = version1.split("\\.");
        String[] version2Parts = version2.split("\\.");
        int max = Math.max(version1Parts.length, version2Parts.length);
        for (int i = 0; i < max; i++) {
            int num1 = i < version1Parts.length ? Integer.parseInt(version1Parts[i]) : 0;
            int num2 = i < version2Parts.length ? Integer.parseInt(version2Parts[i]) : 0;
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(compareVersion(version1, version2));
    }
}
