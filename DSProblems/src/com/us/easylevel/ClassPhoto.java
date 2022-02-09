package com.us.easylevel;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * It's Photo day at the local school, and you are the photographer assigned to take class Photos.
 * Class has an even number of Students, and all the students are wearing red or blue shirts, in fact 
 * Exactly half of the class is wearing Red shirt and other half is wearing Blue shirt.
 * You're responsible for arranging the students in two rows before taking the photo. Each row should
 * contain the same number of students and should follow the given guidelines:
 * 1: All students wearing red Shirts must be in the same row.
 * 2: All students wearing blue Shirts must be in the same row.
 * 3: Each Student in the back row must strictly taller then the student directly in front of them in 
 * the front row.
 * 
 * 
 * Write a function that returns whether or not a class photo that follows the stated guidelines can be taken.
 * 
 * 
 * <pre>
 * 
 * Sample Input: 
 * 
 * 		redShirtHeights = [5,8,1,3,4]<br>
 * 		blueShirtHeights = [6,9,2,4,5]
 * 		
 * Sample Output: true
 * 
 * ======================================================================
 *
 */
public class ClassPhoto {
	
	public static void main(String[] args) {
		ArrayList<Integer> redShirtHeights = new ArrayList<Integer>();
		redShirtHeights.add(5);
		redShirtHeights.add(8);
		redShirtHeights.add(1);
		redShirtHeights.add(3);
		redShirtHeights.add(4);
		
		ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>();
		blueShirtHeights.add(6);
		blueShirtHeights.add(9);
		blueShirtHeights.add(2);
		blueShirtHeights.add(4);
		blueShirtHeights.add(5);
		
		System.out.println(canTakeClassPhoto(redShirtHeights, blueShirtHeights));
		
	}

	public static boolean canTakeClassPhoto(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
		Collections.sort(redShirtHeights, Collections.reverseOrder());
		Collections.sort(blueShirtHeights, Collections.reverseOrder());
		
		String shirtColorInFrontRow = (redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED":"BLUE");
		
		for(int i=0; i<redShirtHeights.size(); i++) {
			int redShirtHeight = redShirtHeights.get(i);
			int blueShirtHeight = blueShirtHeights.get(i);
			
			if(shirtColorInFrontRow == "RED") {
				if(redShirtHeight>=blueShirtHeight) {
					return false;
				}
			}else {
				if(blueShirtHeight>=redShirtHeight) {
					return false;
				}
			}
		}
		
		return true;
	}
}
