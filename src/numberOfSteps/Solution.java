package numberOfSteps;

public class Solution {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������

	int num = 14;
	System.out.println(new Solution().numberOfSteps(num));
    }

    public int numberOfSteps(int num) {
	int step = 0;
	while (num > 0) {
	    step += (num > 1 ? 1 : 0) + (num & 1);
	    num >>= 1;
	}
	return step;
    }
}
