import java.util.*;

/*
 * class RadixSort was written to help introduce the "radix" sort.
 *
 * Note: Executing this program with a dummy command-line argument
 * causes it to run with tracing on.
 *
 * @creator gdt
 * @created 02016.10.22
 * @caveats lots, but here are a couple...
 *          + sorts only arrays of ints and all int values must be >= 0
 *          + is hogish with respect to memory usage
*/

public class RadixSort {

static final int EMPTY_SLOT = -1;

public static void main(String[] argv) {
	boolean tracing = (argv.length == 1);

		int[] a = { 201, 1024, 23, 301, 98, 7, 0, 401, 98, 7, };
		int[] s = new int[a.length];

		int max = -1;
		for (int i = 0; i < a.length; i++) {
			s[i] = a[i];
			if (s[i] > max) max = s[i];
		}

		int[][] buckets = new int[10][a.length];
		init_buckets(buckets);

		if (tracing) print(s);

		int div = 1;
		do {

			// fill in the buckets...
			for (int i = 0; i < s.length; i++) {
				int digit = (s[i] / div) % 10;
				for (int j = 0; j < buckets[i].length; j++) {
					if (buckets[digit][j] == EMPTY_SLOT) {
						buckets[digit][j] = s[i];
						if (tracing)
							System.out.println("buckets[" + digit + "][" + j + 
									"] = " + s[i]);
						break;
					}
				}
			}

			// copy buckets into sorted array and reset buckets...
			for (int i = 0, k = 0; i < buckets.length; i++)
				for (int j = 0; j < buckets[i].length; j++)
					if (buckets[i][j] != EMPTY_SLOT) {
						s[k++] = buckets[i][j];
						buckets[i][j] = EMPTY_SLOT;
					}
			if (tracing) print(s);

			div *= 10;

		} while (div < max);

		System.out.print("\noriginal: ");
		print(a);
		System.out.print("sorted: ");
		print(s);
	}

	static void init_buckets(int[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++)
				x[i][j] = EMPTY_SLOT;
		}
	}

	static void print(int[] x) {
		for (int i = 0; i < x.length; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}
}

/*
 *

 201 1024 23 301 98 7 0 401 98 7 
 buckets[1][0] = 201
 buckets[4][0] = 1024
 buckets[3][0] = 23
 buckets[1][1] = 301
 buckets[8][0] = 98
 buckets[7][0] = 7
 buckets[0][0] = 0
 buckets[1][2] = 401
 buckets[8][1] = 98
 buckets[7][1] = 7
 0 201 301 401 23 1024 7 7 98 98 
 buckets[0][0] = 0
 buckets[0][1] = 201
 buckets[0][2] = 301
 buckets[0][3] = 401
 buckets[2][0] = 23
 buckets[2][1] = 1024
 buckets[0][4] = 7
 buckets[0][5] = 7
 buckets[9][0] = 98
 buckets[9][1] = 98
 0 201 301 401 7 7 23 1024 98 98 
 buckets[0][0] = 0
 buckets[2][0] = 201
 buckets[3][0] = 301
 buckets[4][0] = 401
 buckets[0][1] = 7
 buckets[0][2] = 7
 buckets[0][3] = 23
 buckets[0][4] = 1024
 buckets[0][5] = 98
 buckets[0][6] = 98
 0 7 7 23 1024 98 98 201 301 401 
 buckets[0][0] = 0
 buckets[0][1] = 7
 buckets[0][2] = 7
 buckets[0][3] = 23
 buckets[1][0] = 1024
 buckets[0][4] = 98
 buckets[0][5] = 98
 buckets[0][6] = 201
 buckets[0][7] = 301
 buckets[0][8] = 401
 0 7 7 23 98 98 201 301 401 1024 

original: 201 1024 23 301 98 7 0 401 98 7 
sorted: 0 7 7 23 98 98 201 301 401 1024 

 *
 */
