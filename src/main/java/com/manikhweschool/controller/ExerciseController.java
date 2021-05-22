package com.manikhweschool.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

public class ExerciseController {

	protected final String video = "\\Exercises Videos";
	protected final String code = "\\Exercises Code";
	protected String fileType;
	protected String fullFileName;
	protected String language;
	
	protected final String name = 
	Paths.get(".").toAbsolutePath().toString(
	).substring(0, Paths.get(".").toAbsolutePath(
	).toString().length()-1) +
	"src\\main\\resources\\static";
	
	protected final String partOne = "\\Part One\\";
	protected final String partTwo = "\\Part Two\\";
	protected final String partThree = "\\Part Three\\";
	protected final String partFour = "\\Part Four\\";
	protected final String partFive = "\\Part Five\\";
	
	
	// I still need to combine mp4 files.
	protected @ResponseBody ResponseEntity<byte[]> getResource(
	byte part, byte chapter, boolean isVideo,String exercise) throws IOException, URISyntaxException {
						
			fullFileName = name + ((isVideo)?video:code);

			if(language != null && language.equalsIgnoreCase("python"))
				fullFileName += "\\Python";
			
			switch(part) {
			case 1 : 
				fullFileName += partOne; 
				break;
			case 2 : 
				fullFileName += partTwo;
				break;
			case 3 : 
				fullFileName += partThree;
				break;
			case 4 :
				fullFileName += partFour; 
				break;
			default :
				fullFileName += partFive; 
			}
			
			switch(chapter) {
			case 1 : fullFileName += "Chapter One\\Exercise ";break; 
			case 2 : fullFileName += "Chapter Two\\Exercise ";break; 
			case 3 : fullFileName += "Chapter Three\\Exercise ";break; 
			case 4 : fullFileName += "Chapter Four\\Exercise ";break; 
			case 5 : fullFileName += "Chapter Five\\Exercise ";break; 
			case 6 : fullFileName += "Chapter Six\\Exercise ";break; 
			case 7 : fullFileName += "Chapter Seven\\Exercise ";break; 
			case 8 : fullFileName += "Chapter Eight\\Exercise ";break; 
			case 9 : fullFileName += "Chapter Nine\\Exercise ";break; 
			case 10 : fullFileName += "Chapter Ten\\Exercise ";break;
			case 11 : fullFileName += "Chapter Eleven\\Exercise ";break;
			case 12 : fullFileName += "Chapter Twelve\\Exercise ";break; 
			case 13 : fullFileName += "Chapter Thirteen\\Exercise ";break; 
			case 14 : fullFileName += "Chapter Fourteen\\Exercise ";break; 
			case 15 : fullFileName += "Chapter Fifteen\\Exercise ";break; 
			case 16 : fullFileName += "Chapter Sixteen\\Exercise ";break; 
			case 17 : fullFileName += "Chapter Seventeen\\Exercise ";break; 
			case 18 : fullFileName += "Chapter Eighteen\\Exercise ";break; 
			case 19 : fullFileName += "Chapter Nineteen\\Exercise ";break; 
			case 20 : fullFileName += "Chapter Twenty\\Exercise ";break; 
			case 21 : fullFileName += "Chapter Twenty One\\Exercise ";break; 
			case 22 : fullFileName += "Chapter Twenty Two\\Exercise ";break; 
			case 23 : fullFileName += "Chapter Twenty Three\\Exercise ";break; 
			case 24 : fullFileName += "Chapter Twenty Four\\Exercise ";break; 
			case 25 : fullFileName += "Chapter Twenty Five\\Exercise ";break; 
			case 26 : fullFileName += "Chapter Twenty Six\\Exercise ";break; 
			case 27 : fullFileName += "Chapter Twenty Seven\\Exercise ";break; 
			case 28 : fullFileName += "Chapter Twenty Eight\\Exercise ";break; 
			case 29 : fullFileName += "Chapter Twenty Nine\\Exercise ";break; 
			case 30 : fullFileName += "Chapter Thirty\\Exercise ";break;
			case 31 : fullFileName += "Chapter Thirty One\\Exercise ";break;
			case 32 : fullFileName += "Chapter Thirty Two\\Exercise ";break; 
			case 33 : fullFileName += "Chapter Thirty Three\\Exercise ";break; 
			}
		
			FileInputStream is = null;
			try
			{
			    fileType = (!isVideo)?"zip":"mp4";
			    fullFileName += exercise + '.' + fileType;

			    File file = new File(fullFileName);
			    is = new FileInputStream(file);

			    return ResponseEntity.status(HttpStatus.OK)
			    .header("Content-Type", ((isVideo)?MediaType.APPLICATION_OCTET_STREAM_VALUE:("jar/"+fileType)))
			    .header("Content-Length", String.valueOf(file.length()))
			    .header("Content-Disposition", "attachment; filename=" + "Exercise " + exercise)
			    // Read the object and convert it to as bytes
			    .body(IOUtils.toByteArray(is));
			            
			}
			catch (IOException ioe)
			{
				 ioe.printStackTrace();
			}
			        
			return null;
					
		}

	
}
