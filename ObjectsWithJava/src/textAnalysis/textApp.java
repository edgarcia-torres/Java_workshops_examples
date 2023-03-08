/**********************************************
Workshop #5
Course:JAC444 - Semester4
Last Name:Garcia Torres
First Name:Edgar David
ID:104433206
Section:ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:10/07/2022
**********************************************/

package textAnalysis;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class textApp {
	
	public static int wordCounter (String line) {
        int count=0;  
        
        char ch[]= new char[line.length()];     
        for(int i=0;i<line.length();i++)  
        {  
            ch[i]= line.charAt(i);  
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                count++;  
        }  
        return count;  
	}

	public static void main(String[] args)  throws IOException  {
        try {
			Util.displayMsg("The name of the file is:              "  + args[0]);
			Util.displayMsg("The word to perform text analysis is: "  + args[1]);
			Util.displayMsg("==================================================");
		
		
		
		int lines = 0;
		int totWords = 0;
		int occurrence = 0;

		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(args[0]));	
			String l;
			while((l = inputStream.readLine())!=null){
				totWords = totWords + wordCounter(l);
				int matchinline = 0;
				int index = l.indexOf(args[1]);
				int space = 0;
				
				if (index < 0) {
					Util.displayMsg("In line: " + (lines+  1)+" NOTHING FOUND");
				}else {
					Util.displayMsg("In line: " + (lines+  1)  +" WORD: \"" +args[1]+"\" exact match found " );
				}
				while(index>0) {
					occurrence++;
					matchinline++;
					l = l.substring(index,  l.length());
					space = l.indexOf(" ");
					if (space > 0) {
						String word = l.substring(0,space);
						Util.displayMsg("   string found in the word: "+ word);
					}else {
						Util.displayMsg("   string found in the word: "+ args[1]);
					}

					l = l.substring(args[1].length() ,  l.length());
					index = l.indexOf(args[1]);
				}
				if (matchinline > 0)
				Util.displayMsg("     OCCURRENCE OF THE WORD IN LINE "+ (lines+  1) + " is " + matchinline +" times");
 
				lines++;
			}
		}finally {
			if(inputStream !=null) {
				inputStream.close();
			}
	
		}

		Util.displayMsg("==================================================");
		Util.displayMsg("===============       ANALITICS     ==============");
		Util.displayMsg("TOTAL NUMBER OF LINES IS:       "+lines);
		Util.displayMsg("TOTAL WORDS IS:                 "+totWords);
		Util.displayMsg("TOTAL NUMBER OF OCCURRENCES IS: "+occurrence);
	}catch(Exception e){
		Util.displayMsg("   ERROR: you must enter 2 arguments Nameof the file to read and the word to search in the file.");
	}
	}
}
