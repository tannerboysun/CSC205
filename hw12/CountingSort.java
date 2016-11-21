/*
 * @creator Tanner Boysun
 * @modified 11/20/2016
 * 
 * Original program created by gdt. This program was heavily modified
 * to support negative numbers, store bytes instead of integers and
 * provide a working example of its extended functionality.
 *
 * Original code written by GDT
 * Heavily modified by Tanner Boysun
 *
 * this implemention of a "counting sort" only works for positive
 * integers n such that 0 <= n < array length. <-- major caveat
 *
 * @creator gdt
 * @created 02016.10.21
 */

public class CountingSort {
	public static void main(String[] argv) {

		byte[] a = {7, -128, 0, 7, -7, 127, 0, 7, -128, 7, 42, -42};
		int negativeCount = getNeg(a);
		byte[] negCounts = new byte[128];
		byte[] negatives = new byte[negativeCount];
		byte[] positives = new byte[a.length - negativeCount];
		byte[] counts = new byte[128];
		int indexCount = 0;
		int posIndexCount = 0;
		for (int i = 0; i < counts.length; i++) {
			counts[i] = 0;
		}

		indexCount = 0;

		for (int i = 0; i < negCounts.length; i++){
			negCounts[i] = 0;
		}

		for (int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
			if (a[i] < 0) {
				negatives[indexCount] = a[i];
				indexCount++;
			} else{
				positives[posIndexCount] = a[i];
				posIndexCount++;
			}
		}


		for (int i = 0; i < negatives.length; i++) negCounts[(negatives[i]*-1)-1]++;
		for (int i = 0; i < positives.length; i++) counts[positives[i]]++;

		System.out.print("sorted is ");
		
		byte[] finalNegatives = new byte[negatives.length];
		for (int i = negCounts.length-1; i >= 0; i--)
			if (negCounts[i] > 0)
				for (int j = 0; j < negCounts[i]; j++)
					System.out.print((i+1)*-1 + " ");
					
		for (int i = 0; i < counts.length; i++)
			if (counts[i] > 0)
				for (int j = 0; j < counts[i]; j++)
					System.out.print(i + " ");
		System.out.println();
	}

	public static int getNeg(byte[] array){
		int negCount = 0; 	
		for(int i = 0; i < array.length; i++){
			if (array[i] < 0) {
				negCount++;
			}
		}

		return negCount;
	}
}           

/*

 *

 8 0 2 5 8 8 3 5 8 5 2 sorted is 0 2 2 3 5 5 5 8 8 8 8 

 *
 */
