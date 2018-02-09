import java.util.Arrays;

public class ArrayMethods2 {

	public static void main(String[] args) {
		String[] list1 = {"apple","cucumber","microsoft","zorro"};
		String[] list2 = {"banana","cherry","mahogany","oreos", "pinata"};
		int[] list = {3,4,2,7,12,22,0,1};
	
		long start = System.nanoTime();
		String[] mergeResult = merge(list1, list2);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Test1 took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(mergeResult));
		
		start = System.nanoTime();
		int pivotFinalPos = partition(list);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Test2 took: " + time + " nanoseconds");
		System.out.println("Final Pivot Position: " + pivotFinalPos);
		System.out.println(list);
	}
	

//https://stackoverflow.com/questions/5958169/how-to-merge-two-sorted-arrays-into-a-sorted-array

	public static String[] merge(String[] list1 , String[] list2) {
			String [] combinedArray = new String[list1.length + list2.length]; //new array must be length of both arrays combined
			int x=0; //list1
			int y=0; //list2
			int z=0; //new array (combinedArray)
			  while (x < list1.length && y < list2.length)
		        {
		            if (list1[x].compareTo(list2[y]) < 0)
		            {
		               combinedArray[z] = list1[x];
		                x++;
		              
		            }
		            else
		            {
		            	combinedArray[z] = list2[y];
		                y++; 
		            }
		            z++;
		        	}
			  
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

			    return combinedArray;
		
			    
		}
		
	
	

	//http://www.dummies.com/programming/java/how-to-use-the-partition-method-for-quicksort-in-java/
	
	
	public static int partition(int[]list) {
		int i = 0;
		int j = list.length-1;
		int pivot = list[0];
		 while (i < j)
		 {
		  for (i++; list[i] < pivot; i++) {
		  for (j--; list[j] > pivot; j--) {
		  if (i < j)
		   swap(list, i, j);
		 
		 }
		
		 return j;
		
	}


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