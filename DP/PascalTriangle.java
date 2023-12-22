/*
 * 118. Pascal's Triangle

 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (numRows == 0) {
            return result;
        }
        
        // Initialize the first row with a single element 1
        result.add(Arrays.asList(1));
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = result.get(i - 1);
            
            // First element in each row is always 1
            row.add(1);
            
            for (int j = 1; j < i; j++) {
                // Calculate the current element by summing the two elements above it
                int num = prevRow.get(j - 1) + prevRow.get(j);
                row.add(num);
            }
            
            // Last element in each row is always 1
            row.add(1);
            
            // Add the current row to the result
            result.add(row);
        }
        
        return result;
    }
    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println(p.generate(5));
    }
}
