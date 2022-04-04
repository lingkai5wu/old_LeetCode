package numArray307;

class NumArray {
    int[] tree;

    int[] nums;
    int n;

    int lowbit(int x) {
        return x & -x;
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] += u;
        }
    }

    // 建图
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    // 修改
    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    // 求和
    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        NumArray numArray = new NumArray(new int[] { 1, 3, 5 });
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 3 + 5 = 9
        numArray.update(1, 2); // nums = [1,2,5]
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 2 + 5 = 8
    }

}
