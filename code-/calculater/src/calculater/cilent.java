package calculater;

import java.util.Scanner;

public class cilent {

	public static void main(String[] args) throws Exception {
		Operation op = null;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {
			do {
				System.out.println("��������A��");
				double numA = scanner.nextDouble();
				System.out.println("���������(+��-��*��/)��");
				String operate = scanner.next();
				System.out.println("��������B��");
				double numB = scanner.nextDouble();

				op = OperationFactory.createOperation(operate);
				op.setNumA(numA);
				op.setNumB(numB);
				
				double result = op.getresult();
				System.out.println("������Ϊ��" + result);
				System.out.println("�Ƿ��������(Y/N)��");
			} while(!scanner.next().equalsIgnoreCase("n"));
		} catch (RuntimeException e) {
			System.err.println("�������쳣�˳���");
			e.printStackTrace();
		}
	}

}