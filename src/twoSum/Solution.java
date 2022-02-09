package twoSum;

import java.util.HashMap;
import java.util.Map;

import array.IntegerArrayOperation;

public class Solution {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������

	int[] nums = { 2, 7, 11, 15 };
	int target = 9;

	IntegerArrayOperation.println(new Solution().twoSum1(nums, target));
	IntegerArrayOperation.println(new Solution().twoSum2(nums, target));
    }

    /**
     * ����һ������ö�� ˼·���㷨
     *
     * �������뵽�ķ�����ö�������е�ÿһ���� x��Ѱ���������Ƿ���� target - x��
     *
     * ������ʹ�ñ�����������ķ�ʽѰ�� target - x ʱ����Ҫע�⵽ÿһ��λ�� x ֮ǰ��Ԫ�ض��Ѿ��� x
     * ƥ�������˲���Ҫ�ٽ���ƥ�䡣��ÿһ��Ԫ�ز��ܱ�ʹ�����Σ���������ֻ��Ҫ�� x �����Ԫ����Ѱ�� target - x��
     *
     * ���ߣ�LeetCode-Solution
     * ���ӣ�https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
     * ��Դ�����ۣ�LeetCode�� ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
	for (int i = 0; i < nums.length; i++) {
	    for (int j = i + 1; j < nums.length; j++) {
		if (nums[i] + nums[j] == target) {
		    return new int[] { i, j };
		}
	    }
	}
	return new int[0];
    }

    /**
     * ����������ϣ�� ˼·���㷨
     *
     * ע�⵽����һ��ʱ�临�ӶȽϸߵ�ԭ����Ѱ�� target - x
     * ��ʱ�临�Ӷȹ��ߡ���ˣ�������Ҫһ�ָ�����ķ������ܹ�����Ѱ���������Ƿ����Ŀ��Ԫ�ء�������ڣ�������Ҫ�ҳ�����������
     *
     * ʹ�ù�ϣ�����Խ�Ѱ�� target - x ��ʱ�临�ӶȽ��͵��� O(N) ���͵� O(1)��
     *
     * �������Ǵ���һ����ϣ������ÿһ�� x���������Ȳ�ѯ��ϣ�����Ƿ���� target - x��Ȼ�� x ���뵽��ϣ���У����ɱ�֤������ x ���Լ�ƥ�䡣
     *
     * ���ߣ�LeetCode-Solution
     * ���ӣ�https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
     * ��Դ�����ۣ�LeetCode�� ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < nums.length; ++i) {
	    if (map.containsKey(target - nums[i])) {
		return new int[] { map.get(target - nums[i]), i };
	    }
	    map.put(nums[i], i);
	}
	return new int[0];
    }
}
