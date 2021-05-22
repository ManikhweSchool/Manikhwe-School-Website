package com.manikhweschool.music.controller.extraction;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ExtractionTask implements Runnable{

	
	protected Scanner scanner;
	protected File file;
	
	protected ArrayList<String> fileNames;
	protected int fileNameIndex;
	
	
	
	protected ExtractionTask() {
		
		fileNames = new ArrayList<>();
		fileNameIndex = 0;
		
		
		
		fillFileNames();
	}
	
	public void justFetch() {
		
		fetch();
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				fetch();
				Thread.sleep((10000/*1000*60*60*24*/)/10);
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	protected abstract void fillFileNames();
	protected abstract void fetch();
}

