package step5_02.file;
//2023-11-19  
//느낀점:: 파일 불러오기 등의 구문식이 아직 헷갈림..;; 더 연습 필요

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Spliterator;

import javax.print.attribute.PrintJobAttribute;

//파일 로드하기 : 연습문제2

public class FileEx06_연습 {

	public static void main(String[] args) {
		
	// 4번 연습문제에서 작성된 텍스트파일을 읽어들여와 아래 배열에 저장하시오.
		
		// momk/1111/20000
		// megait/2222/30000
		// github/3333/40000
		
		String[] names = new String[3];			// momk , megait , github
		String[] pws   = new String[3];			// 1111 , 2222   , 3333
		int[] moneys   = new int[3];			// 20000, 30000 , 40000
		
		String fileName = "fileTest02.txt";
		File file = new File(fileName);// fileName의 파일 객체 생성
		
		//파일을 읽어들여야 하니깐.. 
		if (file.exists()) {
			FileReader fr = null;//파일을 읽어오는 객체 생성
			BufferedReader br = null;// 텍스트를 불러오는 객체 생성
			try {
				 fr = new FileReader(file);
				 br = new BufferedReader(fr);
			
				 for (int i = 0; i < moneys.length; i++) {
					 
					String line = br.readLine();
					 
					 if (line == null) {//if 문 사용으로 만약 line==null true 라면 빠져나온다.
							break;
						}
					 String[] temp = line.split("/");
					 names[i]= temp[0]; 
					 pws[i] = temp[1];
					 moneys[i] = Integer.parseInt(temp[2]);
				}
				System.out.println(Arrays.toString(names));
				System.out.println(Arrays.toString(pws));
				System.out.println(Arrays.toString(moneys));
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {br.close();} catch (IOException e) {e.printStackTrace();}
				try {fr.close();} catch (IOException e) {e.printStackTrace();}
					
				}
			}
		
	}	
	
}

					
				
			
				 
			
		
	
	

		
	



