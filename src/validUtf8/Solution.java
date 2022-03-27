package validUtf8;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        int[] data = { 197, 130, 1 };
        System.out.println(new Solution().validUtf8(data));
    }

    public boolean validUtf8(int[] data) {
        int n = 0;
        for (int bit : data) {
            if (bit >> 7 == 1) { // n�ֽ��ַ�
                if ((bit >> 6 & 1) == 1) { // n�ֽ��ַ��ĵ�һ�ֽ�
                    int i = 6;
                    while ((bit >> i & 1) == 1) {
                        n++;
                        i--;
                    }
                    if (n > 3) {
                        return false;
                    }
                } else {
                    n--;
                }
            }
        }
        return n == 0;
    }
}
