import java.util.Arrays;

public class ArrayMethods2 {

	public static void main(String[] args) {
		String[] list1 = {"abc","kab","mqw","dwe"};
		String[] list2 = {"cqw","ewqe","fsdada","gwew"};
		int[] list = {5,6,9,1,3,7};
	
		long start = System.nanoTime();
		merge(list1, list2);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Test1 took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(list1));
		System.out.println(Arrays.toString(list2));
		
		start = System.nanoTime();
		partition(list);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Test2 took: " + time + " nanoseconds");
		System.out.println(list);
	}
	
	



//https://stackoverflow.com/questions/5958169/how-to-merge-two-sorted-arrays-into-a-sorted-array

	public static String[] merge(String[] list1 , String[] list2) {
		boolean sorted1 = false, sorted2 = false;
		String[] combinedArray = new String[list1.length + list2.length];
		for(int i = 0; i < list1.length-1; i++) 
		{
			if(list1[i].compareTo(list1[i+1])>0) {
				sorted1 = true;
			}
		}
		for(int j = 0; j < list2.length-1; j++) 
		{
			if(list2[j].compareTo(list2[j+1])>0) {
				sorted2 = true;
			}
		}
	
		while(sorted1 && sorted2) {
			int x=0;
			int y=0;
			for(int z=0; z< combinedArray.length; z++) { 
			  while (x <list1.length && y < list2.length)
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
			        x++;
			        z++;
			    }

			    if (y < list2.length)
			    {
			        combinedArray[z] = list2[y];
			        y++;
			        z++;
			    }

			    return combinedArray;  
		}
	}
		return combinedArray;
		
		
	}
	
	public static int partition(int[]list) {
		int low=0;
		int high = 0;
		 int i = low - 1;
		 int j = high + 1;
		for(int x =0; x<list.length-1;x++) {
		 high = list.length;
		int pivot = list[x];
		low = pivot;
		 while (i < j)
		 {
		  for (i++; list[i] < pivot; i++);
		  for (j--; list[j] > pivot; j--);
		  if (i < j)
		   swap(list, i, j);
		 }
		}
		 return j;
		
	}

	public static void swap(int []arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}


/*public static int partition(int[]list) {
int pivotLocation = 0;
for(int i=0; i < list.length-1; i++ ) {
	int pivot = i;
	pivotLocation = list[i];
	for(int j = list.length-1; j >0; j-- ) {
		if(j> pivot) {
			pivotLocation = list[j];
		}
		else if (pivot >j) {
			pivotLocation = list[i];
		}
	}
}
return pivotLocation;
}
} 

*/