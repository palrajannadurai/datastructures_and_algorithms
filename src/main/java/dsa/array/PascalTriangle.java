package dsa.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*
* *     1
* *    1 1
* *   1 2 1
* *  1 3 3 1
* *
* **/

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    t.add(1);
                } else {
                    t.add(pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
                }
            }
            pascalTriangle.add(t);
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        System.out.println(generate(4));

    }
}
