package com.prashanth;

import java.util.LinkedList;
import java.util.Queue;

public class NestedArrays {
	
	public static void main(String[] args) {
		//sample for this output [[1,2,[3]],4] -> [1,2,3,4]
		Object[] objArr = new Object[2];
		objArr[0] = new Object[3];
		((Object[]) objArr[0])[0] = new Integer(1);
		((Object[]) objArr[0])[1] = new Integer(2);
		((Object[]) objArr[0])[2] = new Object[1];
		((Object[])((Object[]) objArr[0])[2])[0] = new Integer(3);
		objArr[1] = new Integer(4);
		Queue<Integer> resultQueue = new LinkedList<Integer>();
		mergeArrays(objArr, resultQueue);
		System.out.println(resultQueue);
	}

	//simple depth first search for this solution
	private static void mergeArrays(Object[] objArr, Queue<Integer> resultQueue) {
		for(int i = 0; i < objArr.length; i++) {
			if(objArr[i] instanceof Object[]) {
				mergeArrays((Object[]) objArr[i], resultQueue);
			} else if(objArr[i] instanceof Integer) {
				resultQueue.add((Integer)objArr[i]);
			} else {
				System.out.println("what?");
			}
		}
	}
}
