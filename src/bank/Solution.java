package bank;

class Bank {
	long[] balance;
	int n;

	public Bank(long[] balance) {
		this.balance = balance;
		n = balance.length;
	}

	public boolean transfer(int account1, int account2, long money) {
		if (check(account1) || check(account2)) {
			return false;
		}
		if (balance[account1 - 1] < money) {
			return false;
		}
		balance[account1 - 1] -= money;
		balance[account2 - 1] += money;
		return true;
	}

	public boolean deposit(int account, long money) {
		if (check(account)) {
			return false;
		}
		balance[account - 1] += money;
		return true;
	}

	public boolean withdraw(int account, long money) {
		if (check(account)) {
			return false;
		}
		if (balance[account - 1] < money) {
			return false;
		}
		balance[account - 1] -= money;
		return true;
	}

	boolean check(int account) {
		return !(1 <= account && account <= balance.length);
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Bank bank = new Bank(new long[] { 10, 100, 20, 50, 30 });
		System.out.println(bank.withdraw(3, 10)); // ���� true ���˻� 3 ������� $20 �����Կ���ȡ�� $10 ��
		// �˻� 3 ���Ϊ $20 - $10 = $10 ��
		System.out.println(bank.transfer(5, 1, 20)); // ���� true ���˻� 5 ������� $30 �����Կ���ת�� $20 ��
		// �˻� 5 �����Ϊ $30 - $20 = $10 ���˻� 1 �����Ϊ $10 + $20 = $30 ��
		System.out.println(bank.deposit(5, 20)); // ���� true ���������˻� 5 ��� $20 ��
		// �˻� 5 �����Ϊ $10 + $20 = $30 ��
		System.out.println(bank.transfer(3, 4, 15)); // ���� false ���˻� 3 �ĵ�ǰ����� $10 ��
		// �����޷�ת�� $15 ��
		System.out.println(bank.withdraw(10, 50)); // ���� false ��������Ч����Ϊ�˻� 10 �������ڡ�
	}

}
