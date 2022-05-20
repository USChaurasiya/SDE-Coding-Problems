package com.us.hardlevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * ---------------------------------------------------------------------------------------
 * You're given three inputs, all of which are instances of an OrgChart Class that have a 
 * directReports property pointing to their direct reports. The first input is the top 
 * manager in an organizational Chart and the other two inputs are reports in the chart.
 * The two reports are guaranteed to be distinct.
 * 
 * Write a function that returns the lowest common manager to the two reports.
 * 
 * Sample Input:
 * 	topManager = Node A
 *  reportOne = Node E
 *  reportTwo = Node I
 *  
 *                A
 *              /   \
 *             B     c
 *            / \   / \
 *           D   E F   G
 *          / \
 *         H   I
 *         
 *  Sample Output:
 *  	Node B
 *
 * Hint: <b>To Find the lowest subtree containing both of the input reports, try recursively
 * traversing the organizational chart and keeping track of the number of those reports
 * contained in each subtree as well as the lowest common manager in each subtree.
 * Some Subtree might contain either of the two reports, some might contains one of them,
 * and 	other might contain both. The first to contain both should return the lowest common
 * manager for all of the subtrees above in that contain it, including the entire organizational
 * Chart.<b/>
 *
 * -----------------------------------------------------------------------------------------
 */
public class LowestCommonManager {

	public static void main(String[] args) {
		var orgCharts = getOrgCharts();
		orgCharts.get('A').addDirectReports(new OrgChart[] { orgCharts.get('B'), orgCharts.get('C') });
		orgCharts.get('B').addDirectReports(new OrgChart[] { orgCharts.get('D'), orgCharts.get('E') });
		orgCharts.get('C').addDirectReports(new OrgChart[] { orgCharts.get('F'), orgCharts.get('G') });
		orgCharts.get('D').addDirectReports(new OrgChart[] { orgCharts.get('H'), orgCharts.get('I') });

		var lowestCommonManager = getLowestCommonManager(orgCharts.get('A'), orgCharts.get('E'), orgCharts.get('I'));
		System.out.println("Lowest Common Manager in given Organizational Chart is : " + lowestCommonManager.name);
	}

	static class OrgChart {
		public char name;
		public List<OrgChart> directReports;

		OrgChart(char name) {
			this.name = name;
			this.directReports = new ArrayList<OrgChart>();
		}

		public void addDirectReports(OrgChart[] directReports) {
			for (OrgChart directReport : directReports) {
				this.directReports.add(directReport);
			}
		}
	}

	static class OrgInfo {
		public OrgChart lowestCommonManager;
		int numImportantReports;

		OrgInfo(OrgChart lowestCommonManager, int numImportantReports) {
			this.lowestCommonManager = lowestCommonManager;
			this.numImportantReports = numImportantReports;
		}
	}

	// O(n) Time and O(d) Space Complexity where d is the depth of org Chart.
	public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {

		return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
	}

	public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
		int numImportantReports = 0;
		for (OrgChart directReport : manager.directReports) {
			OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
			if (orgInfo.lowestCommonManager != null)
				return orgInfo;
			numImportantReports += orgInfo.numImportantReports;
		}
		if (manager == reportOne || manager == reportTwo)
			numImportantReports++;
		OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;
		OrgInfo newOrgInfo = new OrgInfo(lowestCommonManager, numImportantReports);
		return newOrgInfo;
	}

	public static HashMap<Character, OrgChart> getOrgCharts() {
		var orgCharts = new HashMap<Character, OrgChart>();
		var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (char a : alphabet.toCharArray()) {
			orgCharts.put(a, new OrgChart(a));
		}
		orgCharts.get('X').addDirectReports(new OrgChart[] { orgCharts.get('Z') });
		return orgCharts;
	}
}
