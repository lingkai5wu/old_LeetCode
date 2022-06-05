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
        TextEditor textEditor = new TextEditor(); // ��ǰ text Ϊ "|" ����'|' �ַ���ʾ��꣩
        textEditor.addText("leetcode"); // ��ǰ�ı�Ϊ "leetcode|" ��
        System.out.println(textEditor.deleteText(4)); // ���� 4
        // ��ǰ�ı�Ϊ "leet|" ��
        // ɾ���� 4 ���ַ���
        textEditor.addText("practice"); // ��ǰ�ı�Ϊ "leetpractice|" ��
        System.out.println(textEditor.cursorRight(3)); // ���� "etpractice"
        // ��ǰ�ı�Ϊ "leetpractice|".
        // ����޷��ƶ����ı����⣬�����޷��ƶ���
        // "etpractice" �ǹ����ߵ� 10 ���ַ���
        System.out.println(textEditor.cursorLeft(8)); // ���� "leet"
        // ��ǰ�ı�Ϊ "leet|practice" ��
        // "leet" �ǹ����ߵ� min(10, 4) = 4 ���ַ���
        System.out.println(textEditor.deleteText(10)); // ���� 4
        // ��ǰ�ı�Ϊ "|practice" ��
        // ֻ�� 4 ���ַ���ɾ���ˡ�
        System.out.println(textEditor.cursorLeft(2)); // ���� ""
        // ��ǰ�ı�Ϊ "|practice" ��
        // ����޷��ƶ����ı����⣬�����޷��ƶ���
        // "" �ǹ����ߵ� min(10, 0) = 0 ���ַ���
        System.out.println(textEditor.cursorRight(6)); // ���� "practi"
        // ��ǰ�ı�Ϊ "practi|ce" ��
        // "practi" �ǹ����ߵ� min(10, 6) = 6 ���ַ���
    }

}
