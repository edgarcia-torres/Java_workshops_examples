package interfaceWeather;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileInformation {
	public String content[] = new String[7] ;
	public String info [][]  = new String[7][3];
	public int coursor= 0 ; 

	public String[] getContent() {
		return content;
	}

	public void setContent(String[] content) {
		this.content = content;
	}

	public String[][] getInfo() {
		return info;
	}

	public void setInfo(String[][] info) {
		this.info = info;
	}

	public fileInformation() throws IOException {
		
		BufferedReader inputStream = null;
		try {		
			inputStream = new BufferedReader(new FileReader("WT.csv"));	
			String l;
			while((l = inputStream.readLine())!=null){
				System.out.println(l);
				
				content[coursor] = l;
				coursor++;
			}
		}finally {
			if(inputStream !=null) {
				inputStream.close();
				System.out.println("-------The total number of lines is: " + coursor);
			}
		}
		// ORGANIZE INFORMATION INTO A 2 DIMENTION ARRAY  
		if(coursor ==7) {
			
			for(int i  = 0; i< coursor;i++) {
				int index = 0;
				
				while(index < 3) {
					
					int coma = content[i].indexOf(",");//look for the comma 
					if(coma ==-1) {
						info[i][index] = content[i];
					}else {
						info[i][index] = content[i].substring(0, coma);//cut string from 0 to comma 
						content[i] = content[i].substring(coma+1, content[i].length());//redefine string
					}
					System.out.println(info[i][index]);
					index++;
				}
			}
		}
	}

}
