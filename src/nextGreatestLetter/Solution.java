package nextGreatestLetter;

public class Solution {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        char[] letters = { 'c', 'f', 'j' };
        char target = 'z';
        System.out.println(new Solution().nextGreatestLetter(letters, target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return letters[l % n];
    }
}
