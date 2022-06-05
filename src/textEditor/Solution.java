package textEditor;

class TextEditor {

    StringBuilder sb;
    int i;

    public TextEditor() {
        sb = new StringBuilder();
        i = -1;
    }

    public void addText(String text) {
        sb.insert(i + 1, text);
        i += text.length();
    }

    public int deleteText(int k) {
        int n = Math.min(i + 1, k);
        for (int j = 0; j < n; j++) {
            sb.deleteCharAt(i - j);
        }
        i -= n;
        return n;
    }

    public String cursorLeft(int k) {
        i = Math.max(i - k, -1);
        return sb.substring(Math.max(0, i - 9), i + 1);
    }

    public String cursorRight(int k) {
        i = Math.min(i + k, sb.length() - 1);
        return sb.substring(Math.max(0, i - 9), i + 1);
    }
}

public class Solution {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
        textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
        System.out.println(textEditor.deleteText(4)); // 返回 4
        // 当前文本为 "leet|" 。
        // 删除了 4 个字符。
        textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
        System.out.println(textEditor.cursorRight(3)); // 返回 "etpractice"
        // 当前文本为 "leetpractice|".
        // 光标无法移动到文本以外，所以无法移动。
        // "etpractice" 是光标左边的 10 个字符。
        System.out.println(textEditor.cursorLeft(8)); // 返回 "leet"
        // 当前文本为 "leet|practice" 。
        // "leet" 是光标左边的 min(10, 4) = 4 个字符。
        System.out.println(textEditor.deleteText(10)); // 返回 4
        // 当前文本为 "|practice" 。
        // 只有 4 个字符被删除了。
        System.out.println(textEditor.cursorLeft(2)); // 返回 ""
        // 当前文本为 "|practice" 。
        // 光标无法移动到文本以外，所以无法移动。
        // "" 是光标左边的 min(10, 0) = 0 个字符。
        System.out.println(textEditor.cursorRight(6)); // 返回 "practi"
        // 当前文本为 "practi|ce" 。
        // "practi" 是光标左边的 min(10, 6) = 6 个字符。
    }

}
