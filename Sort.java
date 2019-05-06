// Name:
// Student number:
import java.util.Arrays;

public class Sort
{
	
	////// Implement the functions below this line //////
	
	/********** MERGE **********/
	public static <T extends Comparable<? super T>> void mergesort(T[] data, int first, int last, boolean debug)
	{
		if(first < last){
			int mid = (first + last)/2;
			mergesort(data, first, mid, debug);
			mergesort(data, mid+1, last, debug);
			merge(data, first, last, debug);
		}
	}
     
	private static <T extends Comparable<? super T>> void merge(T[] data, int first, int last, boolean debug)
	{
		int mid = (first + last)/2;
		int i1 = first;
		int i2 = first;
		int i3 = mid + 1;

		T[] temp = data.clone();

		for(int i = first; i <= last; i++)
			temp[i] = data[i];

		while(i2 <= mid && i3 <= last){
			if(temp[i2].compareTo(temp[i3]) < 0){
				data[i1] = temp[i2];
				i2++;
			} else {
				data[i1] = temp[i3];
				i3++;
			}
			i1++;
		}

		while(i2 <= mid){
			data[i1] = temp[i2];
			i1++;
			i2++;
		}
			
		
		//DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}
     
	/********** COUNTING **********/
	public static void countingsort(int[] data, boolean debug)
	{

		int i, largest = data[0], n = data.length;
		int[] tmp = new int[n];

		for (i = 1; i < n; i++)
			if (largest < data[i])
				largest = data[i];
		int[] count = new int[largest+1];
		for(i = 0; i <= largest; i++)
			count[i] = 0;
		for(i = 0; i < n; i++)
			count[data[i]]++;
		for(i =1; i <= largest; i++)
			count[i] = count[i-1] + count[i];
		for(i = n-1; i>= 0; i--){
			tmp[count[data[i]]-1] = data[i];
			count[data[i]]--;
		}
		for(i=0; i<n; i++)
			data[i] = tmp[i];
			
		

		//DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}

}