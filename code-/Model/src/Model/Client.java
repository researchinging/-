package Model;
abstract class AbstractSort {
	
	/**
	 * ������array��С��������
	 * @param array
	 */
	protected abstract void sort(int[] array);
	
	public void showSortResult(int[] array){
		this.sort(array);
		System.out.print("��������");
		for (int i = 0; i < array.length; i++){
			System.out.printf("%3s", array[i]);
		}
	}
}


class ConcreteSort extends AbstractSort {

	@Override
	protected void sort(int[] array){
		for(int i=0; i<array.length-1; i++){
			selectSort(array, i);
		}
	}
	
	private void selectSort(int[] array, int index) {
		int MinValue = 32767; // ��Сֵ����
		int indexMin = 0; // ��Сֵ��������
		int Temp; // �ݴ����
		for (int i = index; i < array.length; i++) {
			if (array[i] < MinValue){ // �ҵ���Сֵ
				MinValue = array[i]; // ������Сֵ
				indexMin = i; 
			}
		}
		Temp = array[index]; // ��������ֵ
		array[index] = array[indexMin];
		array[indexMin] = Temp;
	}
}

public class Client {
	public static int[] a = { 10, 32, 1, 9, 5, 7, 12, 0, 4, 3 }; // Ԥ����������
	public static void main(String[] args){
		AbstractSort s = new ConcreteSort();
		s.showSortResult(a);
	}
}

