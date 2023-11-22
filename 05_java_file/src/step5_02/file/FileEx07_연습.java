package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.Scanner;
//2023-11-21
// 파일 컨트롤러
public class FileEx07_연습 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int [] arrayList = null;
		int elementCnt = 0;
		
		String fileName = "arrayList.txt";
		
		while (true) {
			for (int i = 0; i < elementCnt; i++) {
				System.out.println(arrayList[i]+ " ");
			}
			
			System.out.println("[어레이리스트 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.println("메뉴 선택 : ");
			int selectMenu = scan.nextInt();
			// 추가하기
			if (selectMenu == 1) {
				System.out.print("[추가]데이터 입력 : ");
				int myData = scan.nextInt();
				
				//int[] arrayList 배열을 저장
				if (elementCnt == 0) {
					arrayList =  new int[elementCnt + 1];//arrayList= []
				}
				else if (elementCnt > 0) {
					int [] temp = arrayList;
					arrayList = new int[elementCnt+ 1];
					
					for (int i = 0; i < temp.length; i++) {
					arrayList[i] = temp[i];
					}
					temp =  null;
					}
				
				arrayList[elementCnt] = myData;
				elementCnt++;
			}
			else if (selectMenu == 2) {
				System.out.print("[삭제]인덱스 입력 : ");
				int delIdx = scan.nextInt();
				
				//삭제 인덱스 불가능한 범위 정하기
				//continu로 빠져나오기
				if (delIdx < 0 || delIdx > elementCnt - 1) {
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
					continue;
				}
				if (elementCnt == 1) {
					arrayList = null;
					System.out.println("삭제할 인덱스 값이 없습니다.");
				}
				else if (elementCnt > 1) {
					int[] temp = arrayList;
					arrayList = new int[elementCnt -1];
					
					int j =0;
					for (int i = 0; i < elementCnt; i++) {
						if (i != delIdx) {
							arrayList[j]= temp[i];
							j++;
						}
					}
					temp = null;
				}
				elementCnt--;
	        }
			//저장하기
			 else if (selectMenu == 3) {
				String data = "";
				if (elementCnt > 0) {
					for (int i = 0; i < elementCnt; i++) {
						data += arrayList[i]+ "/";
					}
					FileWriter fW = null;
					try {
						fW = new FileWriter(fileName);
						fW.write(data);
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							fW.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}else System.out.println("[메세지]저장할 데이터가 없습니다.");
			}
			//로드하기
			else if (selectMenu == 4) {
				String data = "";
				File file =  new File(fileName);// fileNmale 객체 다시 생성
				
				if (file.exists()) {
					
					FileReader fReader = null;
					BufferedReader bReader = null;
					
					
					try {
						fReader =  new FileReader(fileName);
						bReader = new BufferedReader(fReader);
						
						while (true) {
							String line = bReader.readLine();// txt파일의한줄 내용들을 가져오기
						if (line == null) {
							break;
						}
						data += line+ "\n";
						}
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			}
			else if (selectMenu == 5) {
				System.out.println("==프로그램 종료==");
				
				break;
			
			} 
		}
		
	}

}
