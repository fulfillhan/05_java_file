package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//파일 로드하기 : 연습문제1
public class FileEx05_정답예시 {

	public static void main(String[] args) {
		
		// 3번 연습문제에서 작성된 텍스트파일을 읽어들여와 아래 배열에 저장하시오.
		
		String[] names = new String[3]; // 김철수 , 이만수 , 이영희
		int[] ages = new int[3];		//  20 , 30 , 40
		
		String fileName = "fileTest01.txt";
		
		File file = new File(fileName); 		
		FileReader fr = null;					
		BufferedReader br = null;				
		
		if (file.exists()) {
			
			try {
				
				fr = new FileReader(file);  	
				br = new BufferedReader(fr);  
				
				String outputData = br.readLine();
				
				String[] temp1 = outputData.split(",");
				for (int i = 0; i < temp1.length; i++) {
					String[] temp2 = temp1[i].split("/");
					names[i] = temp2[0];
					ages[i] = Integer.parseInt(temp2[1]);
				}
				
				System.out.println("names : " + Arrays.toString(names));
				System.out.println("ages : " + Arrays.toString(ages));
				
			} catch (Exception e) {
				e.printStackTrace();
			}  finally {
				try {br.close();} catch (IOException e) {e.printStackTrace();}
				try {fr.close();} catch (IOException e) {e.printStackTrace();}
			}
			
		}

		
	}

}
