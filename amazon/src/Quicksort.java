
public class Quicksort  {
	private static int[] numbers;
	private static int number;

	public static void sort(int[] values) {
		// Check for empty or null array
		if (values ==null || values.length==0){
			return;
		}
		numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

	private static void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high-low)/2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private static void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static void main(String[ ] args)
	   {
	      final String BLANKS = "  "; // A String of two blanks
	      int i;                      // Array index

	      int[ ] data = { 1000, 80, 10, 50, 70, 60, 90, 20, 30, 40, 0, -1000 };

	      // Print the array before sorting:
	      System.out.println("Here is the entire original array:");
	      for (i = 0; i < data.length; i++)
	         System.out.print(data[i] + BLANKS);
	      System.out.println( );

	      // Sort the numbers, and print the result with two blanks after each number.
	      sort(data);
	      System.out.println("I have sorted all but the first and last numbers.");
	      System.out.println("The numbers are now:");
	      for (i = 0; i < numbers.length; i++)
	         System.out.print(data[i] + BLANKS);
	      System.out.println( );
	   }
}
