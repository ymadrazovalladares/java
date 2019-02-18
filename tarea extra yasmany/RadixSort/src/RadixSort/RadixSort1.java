package RadixSort;
//import java.io.*; 
import java.util.*; 
  
class RadixSort1 { 
  
    static int getMax(ArrayList arr, int n)
    { 
        Integer mx = (Integer) arr.get(0);
        for (int i = 1; i < n; i++) 
            if ((Integer)arr.get(i) > mx)
                mx = (Integer) arr.get(i);
        return mx; 
    } 
  
    static void countSort(ArrayList arr, int n, int exp)
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        for (i = 0; i < n; i++) {
            //double a = ((arr.get(i) / exp) *10);
            count[((Integer) arr.get(i) / exp) % 10]++;
        }
            for (i = 1; i < 10; i++)
            count[i] += count[i - 1]; 
  
        for (i = n - 1; i >= 0; i--)
        { 
            output[count[ ((Integer)arr.get(i)/exp)%10 ] - 1] = (Integer)arr.get(i);
            count[ ((Integer)arr.get(i)/exp)%10 ]--;
        } 
  
        for (i = 0; i < n; i++)
            arr.set(i, output[i]);
    } 
  
    static void radixsort(ArrayList arr, int n)
    { 
        int m = getMax(arr, n);
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp); 
    } 

    static void print(ArrayList arr, int n)
    { 
        for (int i=0; i<n; i++) 
            System.out.print(arr.get(i)+" ");
    } 
  
    public static void main (String[] args)
    { 
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(113);
        arr.add(19);
        arr.add(45);

        int n = arr.size();
        radixsort(arr, n); 
        print(arr, n); 
    } 
} 
/* This code is contributed by Devesh Agrawal */