package utils;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opencsv.CSVReader;

public class RandomValuesPicker {
	private static final String CSV_LAST_NAMES  = "src/main/resources/lastNames.csv";
	private static final String CSV_FIRST_NAMES = "src/main/resources/firstNames.csv";
	private static List<String[]> list = null;

	public static String getRandomFirstName() {
		return getRandomValue(CSV_FIRST_NAMES);
	}

	public static String getRandomLastName(){
		return getRandomValue(CSV_LAST_NAMES);
	}

	private static String getRandomValue(String file) {
		CSVReader reader = null;
		if (list == null) {
			try {
				reader = new CSVReader(new FileReader(file));
				list = reader.readAll();
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list.get(getRandomNumber(list))[0];
	}

	private static int getRandomNumber(List<String[]> list){
		return (int)(Math.random()*list.size());
	}
	
	// Return unique value
    public static String returnUniqueValue(String value){
        String timeStamp = new SimpleDateFormat("MM.dd.HH.mm.ss").format(new Date());
        String uniqueValue = value + timeStamp;
        //return uniqueValue.replace(".", "");
        
        String randomCompany = getRandomFirstName() + " " + getRandomLastName() + " Inc.";
        return randomCompany;
        
    }
}

