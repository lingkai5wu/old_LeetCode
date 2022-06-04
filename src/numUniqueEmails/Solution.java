package numUniqueEmails;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };
        System.out.println(new Solution().numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            int i = s.indexOf('@');
            set.add(s.substring(0, i).split("\\+")[0].replace(".", "") + s.substring(i));
        }
        return set.size();
    }
}
