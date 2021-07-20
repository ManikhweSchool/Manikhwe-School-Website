package com.manikhweschool.music.model;

import java.util.ArrayList;
import java.util.List;

public class Page {

	private List<String> allTracks = new ArrayList<>();
	private List<String> pageTracks = new ArrayList<>();
	private int pageStartingIndex = 0;
	
	public Page() {
		populationTracks();
		updatePageTracks();
	}

	public void visitNextPage() {
		if(pageStartingIndex + 12<allTracks.size())
			pageStartingIndex += 12;
		updatePageTracks();
	}
	
	public void visitPrevPage() {
		if(pageStartingIndex - 12>=0)
			pageStartingIndex -= 12;
		updatePageTracks();
	}
	
	private void populationTracks() {
		
		if(allTracks.isEmpty())
			for(short i = 0; i < 1000;i++) 
				allTracks.add("Artist " + (int)(Math.random()*100) + " - Track " + (int)(Math.random()*100));
		
	}
	
	public void updatePageTracks() {
		
		pageTracks.clear();
		
		for(int i = pageStartingIndex; 
		i <= pageStartingIndex+11 && 
		i<allTracks.size();i++)
			pageTracks.add(allTracks.get(i));
	}

	public List<String> getPageTracks() {
		return pageTracks;
	}

	public void setPageTracks(List<String> pageTracks) {
		this.pageTracks = pageTracks;
	}
	
	
}
