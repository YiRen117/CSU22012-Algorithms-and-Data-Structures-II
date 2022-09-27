import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
//				insertionSort		selectionSort		quickSort		mergeSortRecursive		mergeSortIterative
//Random		   7.1498			   7.7854			 1.3479				0.6260					 0.2395
//Duplicates	   8.1650			   6.9430			 1.2942			    0.6256					 0.2537
//Nearly
//Ordered	       5.9397			   6.4291			 1.6765				0.6182					 0.2943
//Reverse		   5.9186			   6.3931			 5.5604				0.6950					 0.2484
//Sorted		   6.8241			   6.5809			 4.6600				0.6493					 0.2541
//10000			   8.1748			   6.3413			 1.3301				0.6269					 0.2682
//
// a.	Which of these sorting algorithms does the order of input have an impact on? Why? 
//
// The order of input has an impact on the quick sort algorithm. As we are choosing the leftmost element in the array as a pivot, 
// the input for the worst case will be reverse-order array or sorted array. So the order of input will influence the running time
// of the quick sort algorithm.
//
// b.	Which algorithm has the biggest difference between the best and worst performance, based on the type of input, for the input
// of size 1000? Why? 
//
// According to my results, quick sort seems to have the biggest difference between the best and worst performance. However, I think
// the actual answer should be insertion sort and selection sort. Since their worst case time complexity is O(n^2) and their best case
// complexity is Omega(n), while the best case time complexity of quick sort is O(nlog(n)), they should have the biggest difference 
// between the best and worst performance.
// c.	Which algorithm has the best/worst scalability, i.e., the difference in performance time based on the input size? Please consider
// only input files with random order for this answer. 
// Insertion sort has the worst scalability and merge sort has the best scalability.
// d.	Did you observe any difference between iterative and recursive implementations of merge sort? 
// I observed that recursive merge sort uses recursive function calls while iterative merge sort uses nested loop instead.
// e.	Which algorithm is the fastest for each of the 7 input files?
// According to my results, iterative merge sort seems to be the fastest for each of the 7 input files. However, I think my test result 
// is not reliable and the fastest should be the recursive merge sort.



/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] expected = new double[0];
        assertArrayEquals("insertionSort failed with an empty array", expected, SortComparison.insertionSort(new double[0]), 0);
        assertArrayEquals("selectionSort failed with an empty array", expected, SortComparison.selectionSort(new double[0]), 0);
        assertArrayEquals("quickSort failed with an empty array", expected, SortComparison.quickSort(new double[0]), 0);
        assertArrayEquals("mergeSortRecursive failed with an empty array", expected, SortComparison.mergeSortRecursive(new double[0]), 0);
        assertArrayEquals("mergeSortIterative failed with an empty array", expected, SortComparison.mergeSortIterative(new double[0]), 0);
    }

    @Test
    public void testInsertion()
    {
    	double[] original_1 = {5,4,3,2,1};
    	double[] original_2 = {1,2,3,4,5};
    	double[] original_3 = {4,3,1,5,2};
    	double[] original_4 = {2,2,2,2,1};
    	double[] expected = {1,2,3,4,5};
    	double[] duplicated = {1,2,2,2,2};
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.insertionSort(original_1), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.insertionSort(original_2), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.insertionSort(original_3), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", duplicated, SortComparison.insertionSort(original_4), 5);
    }
    
    @Test
    public void testSelection()
    {
    	double[] original_1 = {5,4,3,2,1};
    	double[] original_2 = {1,2,3,4,5};
    	double[] original_3 = {4,3,1,5,2};
    	double[] original_4 = {2,2,2,2,1};
    	double[] expected = {1,2,3,4,5};
    	double[] duplicated = {1,2,2,2,2};
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.selectionSort(original_1), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.selectionSort(original_2), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.selectionSort(original_3), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", duplicated, SortComparison.selectionSort(original_4), 5);
    }
    
    @Test
    public void testQuick()
    {
    	double[] original_1 = {5,4,3,2,1};
    	double[] original_2 = {1,2,3,4,5};
    	double[] original_3 = {4,3,1,5,2};
    	double[] original_4 = {2,2,2,2,1};
    	double[] expected = {1,2,3,4,5};
    	double[] duplicated = {1,2,2,2,2};
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.quickSort(original_1), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.quickSort(original_2), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.quickSort(original_3), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", duplicated, SortComparison.quickSort(original_4), 5);
    }
    
    @Test
    public void testMergeRecursive()
    {
    	double[] original_1 = {5,4,3,2,1};
    	double[] original_2 = {1,2,3,4,5};
    	double[] original_3 = {4,3,1,5,2};
    	double[] original_4 = {2,2,2,2,1};
    	double[] expected = {1,2,3,4,5};
    	double[] duplicated = {1,2,2,2,2};
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.mergeSortRecursive(original_1), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.mergeSortRecursive(original_2), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.mergeSortRecursive(original_3), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", duplicated, SortComparison.mergeSortRecursive(original_4), 5);
    }
    
    @Test
    public void testMergeIterative()
    {
    	double[] original_1 = {5,4,3,2,1};
    	double[] original_2 = {1,2,3,4,5};
    	double[] original_3 = {4,3,1,5,2};
    	double[] original_4 = {2,2,2,2,1};
    	double[] expected = {1,2,3,4,5};
    	double[] duplicated = {1,2,2,2,2};
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.mergeSortIterative(original_1), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.mergeSortIterative(original_2), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", expected, SortComparison.mergeSortIterative(original_3), 5);
        assertArrayEquals("insertionSort failed with a 5-element array", duplicated, SortComparison.mergeSortIterative(original_4), 5);
    }
    

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    /**
     * @param args
     */
    public static void main(String[] args)
    {    	
    	double[] numbers1000 = readFile("numbers1000.txt", 1000);
    	double[] numbers1000Duplicates = readFile("numbers1000Duplicates.txt", 1000);
    	double[] numbersNearlyOrdered1000 = readFile("numbersNearlyOrdered1000.txt", 1000);
    	double[] numbersReverse1000 = readFile("numbersReverse1000.txt", 1000);
    	double[] numbersSorted1000 = readFile("numbersSorted1000.txt", 1000);
    	double[] numbers10000 = readFile("numbers10000.txt", 1000);
    	
    	long start = System.nanoTime();
    	SortComparison.quickSort(numbersReverse1000);
    	long now = System.nanoTime();
    	System.out.println((now - start) / 1000000.0);
    }
    
    private static double[] readFile(String fileName, int length) {
        double[] array = new double[length];
    	try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;
            int index = 0;
            while(!endOfFile){
                String number = bufferedReader.readLine();
                if (number != null && index < length){
                	array[index++] = Double.parseDouble(number);
                }
                else{
                    endOfFile = true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (FileNotFoundException e){
        	e.printStackTrace();
        }
        catch (IOException e){
        	e.printStackTrace();
        }
        return array;
    }
    
}


