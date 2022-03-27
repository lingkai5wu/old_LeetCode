package generate;

import java.util.ArrayList;
import java.util.List;

import list.ArrayListOperation;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        int numRows = 5;
        List<List<Integer>> res = new Solution().generate(numRows);

        for (List<Integer> row : res) {
            for (int is : row) {
                System.out.print(is + " ");
            }
            System.out.println();
        }
        ArrayListOperation.printlnLnt2dList(res);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
