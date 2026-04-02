package com.comparableAndcomparator.model;

import java.util.Comparator;

public class MovieComparator implements Comparator<Movie> {
	
	@Override
	public int compare(Movie m1,Movie m2) {
		int yearCompare =Integer.compare(m2.getYear(), m1.getYear());
		
		if(yearCompare!=0) {
			return yearCompare;
		}
		
		return m1.getTitle().compareTo(m2.getTitle());
	}

}
