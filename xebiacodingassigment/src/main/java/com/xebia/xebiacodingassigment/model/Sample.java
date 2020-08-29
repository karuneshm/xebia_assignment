package com.xebia.xebiacodingassigment.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;



public class Sample {
	
	
	
	
	
	

	public static void main(String[] args) {
	  
	   List<Integer> numbers = new ArrayList<Integer>();
	   
	    numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		Object[] array = numbers.toArray();
	   
		
		int [] arr = {1,2,3,4,5,6,7,8,9,10};
		
		//
		
//		for ( int i = 0 ;i < arr.length ; i++) {
//			for (int j = i+1; j <arr.length ;j++ ) {
//				if(arr[i] + arr[j] == 15 ) {
//					System.out.println(" Pair Found at i = "+i+ " j = " +j);
//					
//				}
//			}
//			
//		}
		
		
		//Arrays.sort(arr);
		
		int lowest = 0;
		int highest = arr.length - 1;
		
		while(lowest< highest) {
			if(arr[lowest] + arr[highest] == 15 ) {
				System.out.println("Pair Found  @ lowest " + lowest + " highset " +highest );
			}
			
			if(arr[lowest] + arr[highest]<15 ) {
				lowest++;
			} else {
				highest--;
			}
			
		}

	}

}
