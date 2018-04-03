/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

     public static void binarySearch() {
        int counter, num, item, array[], first, last, middle;
        //To capture user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        num = input.nextInt();

        //Creating array to store all the numbers
        array = new int[num];

        System.out.println("Enter " + num + " integers");
        //Loop to store each numbers in array
        for (counter = 0; counter < num; counter++){
            array[counter] = input.nextInt();
        }
        // MUST Sort the array prior to doing the binary search.
        // TODO Call Arrays. )
       
        System.out.println("Enter the search value:");
        item = input.nextInt();
Arrays.sort(array);
        // Below is the binary search algorithm.
        // TODO Try a simpler way by using Arrays.binarySearch()
                
        
        first = 0;
        last = num - 1;
        middle = (first + last) / 2 + 1 ;

        while (first <last) {
            if (array[middle] < item)
                first = middle + 1;
            else if (array[middle] == item) {
                System.out.println(item + " found at location " + (middle + 1) + ".");
                break;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2 + 1;
        }
        if (first > last)
            System.out.println(item + " is not found.\n");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        String filename = "random.dat";
		String data = "Your first message"; 
		int location = 0;
		System.out.println("message length1 = "  + data.length());
		
		writeToRandomAccessFile(filename, location, data); 
		//System.out.println("String written to RandomAccessFile: " + data); 	
		data = "Second message";
		System.out.println("message length1 = "  + data.length());
		appendToRandomAccessFile(filename, data);
		//String fromFile = readFromRandomAccessFile(filename, location); 
		//System.out.println("String read from RandomAccessFile: " + fromFile); 	
		
	}
        // binarySearch();  
    
        
private static String readFromRandomAccessFile(String file, int position) { 
		String record = null; 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "r"); // read mode
			// moves file pointer to position specified 
			fileStore.seek(position); 
			// read String from RandomAccessFile 
			record = fileStore.readUTF(); 
			//record = fileStore.readLine();
			fileStore.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		return record; 
	}  
	
	private static void writeToRandomAccessFile(String file, int position, String record) { 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "rw"); // read write mode
			// moves file pointer to position specified 
			fileStore.seek(position); 
			// write String to RandomAccessFile 
			fileStore.writeUTF(record); 
			fileStore.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
		}  
	}
	
	public static void appendToRandomAccessFile(String file, String record) { 
		try { 
			RandomAccessFile fileStore = new RandomAccessFile(file, "rw"); // read write mode
			// moves file pointer to position specified 
			System.out.println("Appending at position " + fileStore.length());
			fileStore.seek(fileStore.length()); 
			// write String to RandomAccessFile 
			fileStore.writeUTF(record); 
			fileStore.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
		}  
	}

}

