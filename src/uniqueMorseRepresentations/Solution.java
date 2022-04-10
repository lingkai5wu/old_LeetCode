package uniqueMorseRepresentations;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        String[] words = { "gin", "zen", "gig", "msg" };
        System.out.println(new Solution().uniqueMorseRepresentations(words));
    }

    final String[] Morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(Morse[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
