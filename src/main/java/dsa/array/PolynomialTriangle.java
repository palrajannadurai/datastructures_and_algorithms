package com.dsa.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolynomialTriangle {

    private static List<List<Integer>> generate(int numOfRows) {
        List<List<Integer>> triangle = new ArrayList<>(numOfRows);
        triangle.add(Collections.singletonList(1));
        for (int i = 1; i < numOfRows; i++) {
            List<Integer> integers = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) { /* Beginning or ending of the array */
                    integers.add(1);
                } else {
                    integers.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(integers);
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }

}
