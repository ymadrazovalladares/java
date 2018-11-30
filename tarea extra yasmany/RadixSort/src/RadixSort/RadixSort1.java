package RadixSort;
//import java.io.*; 
import java.util.*; 
  
class RadixSort1 { 
  
    // A utility function to get maximum value in arr[] 
    static int getMax(ArrayList arr, int n)
    { 
        Integer mx = (Integer) arr.get(0);
        for (int i = 1; i < n; i++) 
            if ((Integer)arr.get(i) > mx)
                mx = (Integer) arr.get(i);
        return mx; 
    } 
  
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    static void countSort(ArrayList arr, int n, int exp)
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ ((Integer)arr.get(i)/exp)%10 ]++;
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ ((Integer)arr.get(i)/exp)%10 ] - 1] = (Integer)arr.get(i);
            count[ ((Integer)arr.get(i)/exp)%10 ]--;
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++)
            arr.set(i, output[i]);
    } 
  
    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    static void radixsort(ArrayList arr, int n)
    { 
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
  
    // A utility function to print an array 
    static void print(ArrayList arr, int n)
    { 
        for (int i=0; i<n; i++) 
            System.out.print(arr.get(i)+" ");
    } 
  
  
    /*Driver function to check for above function*/
    public static void main (String[] args) 
    { 
       // int arr[] = {183, 1, 45, 20, 75, 91, 756, 24, 2, 757, 184, 55};
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(183);
        arr.add(1);
        arr.add(45);
        arr.add(20);
        arr.add(75);
        arr.add(91);
        arr.add(756);
        arr.add(24);
        arr.add(2);
        arr.add(757);
        arr.add(184);
        arr.add(55);





        int n = arr.size();
        radixsort(arr, n); 
        print(arr, n); 
    } 
} 
/* This code is contributed by Devesh Agrawal */