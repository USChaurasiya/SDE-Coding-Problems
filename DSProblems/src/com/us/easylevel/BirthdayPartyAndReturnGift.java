package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------
 *  Birthday party was attended by N number of kids and each kid was given an unique id ranging from 1 to N. 
 *  As a return gift, there are T toys that must be given to the kids.
 *  The party host decides the best way to do this is by sitting the kids down in a circle ordered by 
 *  ascending id and then starting with a random number D (between 1 and N) and distribute one toy at a time 
 *  to each sequentially numbered kid and till all toys are distributed.
 *
 *	For example if the host picks a random number (D), 2, then gift distribution order would be (2,3,4,5,.., N-1,N, 1,2,3,4..) 
 *  until all T toys are distributed. But the very last toy is damaged. 
 *  The task is to find and display the id number of the last kid, who will recieve the damaged toy, 
 *  so that the kid can be informed about the same and the host will ask him to go and exchange from the shop.
 *	
 *	Input :
 *	N - The number of kids
 *	T - The number of toys
 *	D - Random number from where distribution should start
 *	
 *	Output :
 *	For each test case print the id number of the kid who receives the damaged toy.
 *	
 *	Sample Input :
 *	5
 *	2
 *	1
 *	
 *	Sample Output:
 *	2
 *
 */
public class BirthdayPartyAndReturnGift {

	public static void main(String[] args) {
		int numberOfKids = 5;
		int numberOfToys = 2;
		int startingPoint = 1;
		System.out.println("Id of Last kids who receive Damaged Toy is : "
				+ getLastKidsId(numberOfKids, numberOfToys, startingPoint));
	}

	public static int getLastKidsId(int noOfKids, int noOfToys, int startingPoint) {

		int lastKidId = (noOfToys + startingPoint - 1) % noOfKids;

		return lastKidId > 0 ? lastKidId : noOfKids;
	}

}
