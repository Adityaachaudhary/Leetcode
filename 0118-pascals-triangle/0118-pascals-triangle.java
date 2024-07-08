// class Solution {

//   public List<List<Integer>> generate(int numRows) {

//     List<List<Integer>> result = new ArrayList<List<Integer>>();

//     if (numRows == 0) return result;

//     List<Integer> row = new ArrayList<>();
//     row.add(1);
//     result.add(row);

//     if (numRows == 1) return result;

//     for (int i = 2; i <= numRows; i++) {
//       List<Integer> prevList = result.get(i - 2);
//       ArrayList<Integer> line = new ArrayList<>();

//       line.add(1);
//       for (int j = 0; j < i - 2; j++) {
//         line.add(prevList.get(j) + prevList.get(j + 1));
//       }
//       line.add(1);

//       result.add(line);
//     }

//     return result;
//   }

// }

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result;
        }

        result = generate(numRows - 1);
        List<Integer> prevRow = result.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }

        currentRow.add(1);
        result.add(currentRow);

        return result;
    }
}