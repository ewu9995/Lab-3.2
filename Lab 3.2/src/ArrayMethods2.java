import java.util.Arrays;

public class ArrayMethods2 {

	public static void main(String[] args) {
		String[] list1 = {"a","k","m","d"};
		String[] list2 = {"c","e","f","g"};
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
			int l=0;
			for(int k = 0 ; k< combinedArray.length;k++)
			{
				
			}
		}
		
		return combinedArray;
		
	}
	
	public static int partition(int[]list) {
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
