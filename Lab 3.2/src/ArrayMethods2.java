import java.util.Arrays;

/*
 * Evan Wu
 * AP CSA Period 2
 * Lab 3.2
 */

public class ArrayMethods2 {

	//starter code
	public static void main(String[] args) {
		String[] list1 = {"apple","cucumber","microsoft","zorro"};
		String[] list2 = {"banana","cherry","mahogany","oreos", "pinata"};
		int[] list = {3,4,2,7,12,22,0,1};
	
		long start = System.nanoTime();
		String[] mergeResult = merge(list1, list2);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Merge test took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(mergeResult));
		
		start = System.nanoTime();
		int pivotFinalPos = partition(list);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Partition test took: " + time + " nanoseconds");
		System.out.println("Final Pivot Position: " + pivotFinalPos);
		System.out.println(Arrays.toString(list));
	}
	

//Sourced from: https://stackoverflow.com/questions/5958169/how-to-merge-two-sorted-arrays-into-a-sorted-array

	public static String[] merge(String[] list1 , String[] list2) {
		/*
		 * This method will combine two pre-conditioned sorted arrays into one sorted arrays.
		 * To do so, a new array must be created, which in this case is combinedArray.
		 * To add the values into the arrays, the two arrays must be compared.
		 * So in this case, if the comparing of two strings is less than zero, then the compared value will be added to the array first as it is smaller.
		 * To find the values, there are two loops that loop through each of the two arrays if the values are less than the array length, as
		 * going over will break it.
		 * 
		 */
			String [] combinedArray = new String[list1.length + list2.length]; //new array must be length of both arrays combined
			int x=0; //list1 indexes
			int y=0; //list2 indexes
			int z=0; //new array (combinedArray)
			  while (x < list1.length && y < list2.length) //both arrays must be less than their intended length (any longer with break the code)
		        {
		            if (list1[x].compareTo(list2[y]) < 0) //compares the values in the 2 arrays and see which is smaller
		            {
		               combinedArray[z] = list1[x]; //since the value in list1 is smaller in this case, list1[x] becomes part of the sorted array before list2[y]
		                x++;
		            }
		            else
		            {
		            	combinedArray[z] = list2[y]; //since list2[y] is smaller, it is placed before list1[x]
		                y++; 
		            }
		            z++;
		        	}
			  		
			  		//loops through the arrays to find values
			  		if (x < list1.length)
			  		{
			        combinedArray[z] = list1[x];
			        x++; z++;
			  		}

			  		if (y < list2.length)
			  		{
			        combinedArray[z] = list2[y];
			        y++; z++;
			  		}

			    return combinedArray; //returns the combined sorted array 
		}
		
	
 
	public static int partition(int[]list) {
		
		int pivotLocation = 0;
		int pivot = list[0];//pivot is the first value in the array
		int k = list.length - 1; //last value in array
		for(int j = 1; j < list.length; j++) { //loops through values after pivot
		/*
		 * While running the loop, any value j will get compared to the pivot. The pivot compares the value and if the value is less,
		 * then value j will swapped with the closest value that is greater than the value of the pivot, which would be j-1. The 
		 * pivot location will be at j since pivot is supposed to be between those values when sorted.
		 * 
		 * If j is greater than the pivot, then the larger value will swap will swap with the last value of the array as the values
		 * that were found to be greater than pivot are pushed down and the opposite is true for smaller values.   
		 *
		 */
		if (list[j] <= pivot) 
		 {
			swap(list, j, j-1); 
			pivotLocation = j;
		 }
		 
		else if(list[j] > pivot && k > j)
		 {
		
			swap(list, j, k);
			j--;
			k--;
		 }
		 
		}
		 
		return pivotLocation;	//returns the location/index of the pivot
	}

	//swaps values
	public static void swap(int []arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}


/*
public static int partition(int[]list) {
int pivotLocation = 0;
for(int i=0; i < list.length-1; i++ ) {
	int pivot = i;
	pivotLocation = list[i];
	for(int j = list.length-1; j >0; j-- ) {
		if(j> pivot) {
			pivotLocation = list[j];
			swap(list, pivot ,j );
		}
		else if (pivot >j) {
			pivotLocation = list[i];
			swap( list, pivot, j);
		}
	}
}
return pivotLocation;
}
} 

*/