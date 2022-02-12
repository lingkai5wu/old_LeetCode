package maxNumberOfBalloons;

public class Solution {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根

	String text = "nlaebolko";
	System.out.println(new Solution().maxNumberOfBalloons(text));
    }

    public int maxNumberOfBalloons(String text) {
	int[] cnt = new int[26];
	for (char ch : text.toCharArray()) {
	    cnt[ch - 'a']++;
	}

	int res = Integer.MAX_VALUE;
	for (char ch : "balon".toCharArray()) {
	    if (ch == 'l' || ch == 'o') {
		res = Math.min(res, cnt[ch - 'a'] / 2);
	    } else {
		res = Math.min(res, cnt[ch - 'a']);
	    }
	}

	return res;
    }
}
