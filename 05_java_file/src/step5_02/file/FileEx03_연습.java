package step5_02.file;

import java.io.FileWriter;
import java.io.IOException;

public class FileEx03_연습 {
	
public static void main(String[] args) {
		
		// 김철수/20,이만수/30,이영희/40
		
		String[] names = {"김철수", "이만수", "이영희"};
		int[] ages     = {	   20,     30,     40};
		
		String fileName = "fileTest01.txt";
		
		String data = "";

		for (int i = 0; i < names.length; i++) {
			data+= names[i]+ "/"+ ages[i];//data = 김철수/20 이만수/30 이영희/40
			
			if (i < names.length - 1) { //data= 김철수/20, 이만수/30, ...
				data= data+ ",";
			}
		}
		// 위에서 코딩한 값을 파일로 불러오기
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
