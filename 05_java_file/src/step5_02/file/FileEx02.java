package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 파일 출력(File Output), 로드 , 불러오기
public class FileEx02 {
	
	public static void main(String[] args) {
		
		String fileName = "ex01.txt";
		
		File file = new File(fileName); // 파일 객체 생성
		FileReader fr = null;// 파일을 읽어 오는 객체 생성
		BufferedReader br =null;//텍스트를 불러오는 객체 생성 textReader
		
		//exists() : 파일이 존재하면 true 를 반환하고 존재하지 않으면 false를 반환한다.
		if (file.exists()) {
			
			try {
				 fr = new FileReader(file);
				 br =  new BufferedReader(fr);
				 
				 String outputData = br.readLine();//br.readLine(); 한 줄의 데이터를 읽어온다. 한줄 단위로 제어가 가능하다.
				 System.out.println(outputData);
				 System.out.println();
				 
				 System.out.println(br.readLine());
				 
				 while (true) {
					outputData = br.readLine();
					// 반환할 데이터가 없으면 null로 반환한다.
					if (outputData == null) {
						break;
					}
					System.out.println(outputData);
				}
				 
				 
			} catch (Exception e) { //Exception 모든 예외 처리의 조상..
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {br.close();} catch (IOException e) {e.printStackTrace();}// 나중에 생성한 객체를 먼저 close한다.
				try {fr.close();} catch (IOException e) {e.printStackTrace();}
			}
			
		}
		
	}

}
