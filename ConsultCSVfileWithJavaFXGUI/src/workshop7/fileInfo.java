package workshop7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileInfo {
	
	public String content[] = new String[100] ;
	public String info [][]  = new String[55][13];
	public int coursor= 0 ; 

	public fileInfo() throws IOException {
		
		BufferedReader inputStream = null;
		try {		
			inputStream = new BufferedReader(new FileReader("WDI.csv"));	
			String l;
			while((l = inputStream.readLine())!=null){
				content[coursor] = l;
				coursor++;
			}
		}finally {
			if(inputStream !=null) {
				inputStream.close();
				Util.displayMsg("-------The total number of lines is: " + coursor);
			}
	
		}
		// ORGANIZE INFORMATION INTO A 2 DIMENTION ARRAY  
		if(coursor ==55) {
			
			for(int i  = 0; i< coursor;i++) {
				int index = 0;
				
				while(index < 13) {
					
					int coma = content[i].indexOf(",");//look for the comma 
					if(coma ==-1) {
						info[i][index] = content[i];
					}else {
						info[i][index] = content[i].substring(0, coma);//cut string from 0 to comma 
						content[i] = content[i].substring(coma+1, content[i].length());//redefine string

					}
					index++;
				}
			}
		}
	}
	
	public String search(String country, String series, String year) {
		String[] res = new String[13];
		String response = "";
		int number = 0;
		try{
             number = Integer.parseInt(year);
            System.out.println(number); 
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
            Util.displayMsg("data not found in database");
        }
		
		int indicator = number - 2011 + 2;

		
		for(int i = 0; i<coursor;i++) {
				if (info[i][0].equalsIgnoreCase(country) && info[i][1].equals(series))	{
					res = info[i];
					response = info[i][indicator];
					Util.displayMsg("Coutry: "+res[0] + " Series: " +res[1] );		
				}
		}
		Util.displayMsg("VALUE RETRIEVED IS" + response);
		
		
		
		
		
		return response;
	}
	
	
	
	public String getRecordValue(String[] infoLine, int index ) {//returns a value from the array entered, adds validation 
	String response = "no value";
		if (infoLine[index].equals("..")  && index < 14 && index > -1 ) {
			response = "no value";
		}else {
			response = infoLine[index];
		}
	return response;
	}

	

}
