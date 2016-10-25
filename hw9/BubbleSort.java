public class BubbleSort{
	public static void main(String[] argv){
		int[] list = new int[]{3,4,1,7,2,5,9};
		int count = 0;
		int swap = 0;
		int err = 0;	
		int cur = 0;	
		do {

			if ((cur != list.length) && (list[cur] > list[cur + 1])){
				int prev = list[count];
				list[count] = list[count+1];
				list[count + 1] = prev;
				swap++;
				err++;
				System.out.println("Hello");
			}	
			cur++;	
			count++;

			if (cur >= list.length){
				cur = 0;
				err = 0;
			}

		} while (err != 0);

		System.out.println(count + " <-- Count");
	}
}

