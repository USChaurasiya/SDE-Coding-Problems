package com.us.mediumlevel;

/**
 * @author Uma Shankar
 * <pre>
 * ---------------------------------------------------------------------------------------------
 *  There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot
 *  turn around and drive west).
 *  You are given the integer capacity and an array trips where 
 *  trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi 
 *  passengers and the locations to pick them up and drop them off are fromi and toi respectively. 
 *  The locations are given as the number of kilometers due east from the car's initial location.
 *  
 *  
 *  Return true if it is possible to pick up and drop off all passengers for all the given trips, 
 *  or false otherwise.
 * 
 * 
 * Sample Input:
 *  trips = [[2,1,5],[3,3,7]], capacity = 4
 *  
 * Sample Output:
 * 	false
 * 
 * ----------------------------------------------------------------------------------------------
 */
public class CarPooling {

	public static void main(String[] args) {
		int[][] inputTrips = new int[][] { { 9, 0, 1 }, { 3, 3, 7 } };
		int capacity = 4;

		System.out.println("Is Car Pooling possible: " + carPooling(inputTrips, capacity));
	}

	// O(n) Time and O(1) Space Complexity
	public static boolean carPooling(int[][] trips, int capacity) {

		int destination = -1;
		for (int[] trip : trips) {
			destination = Math.max(destination, trip[2]);
		}

		int[] tripPoints = new int[destination + 1];
		for (int[] trip : trips) {
			tripPoints[trip[1]] += trip[0];
			tripPoints[trip[2]] -= trip[0];
		}

		if (trips[0][0] > capacity)
			return false;

		for (int i = 1; i <= destination; i++) {
			tripPoints[i] += tripPoints[i - 1];
			if (tripPoints[i] > capacity) {
				return false;
			}
		}

		return true;
	}

}
