package step5_02.file;
//2023-11-20  Array35 연습 먼저하기!
import java.util.Scanner;

import jdk.nashorn.api.tree.ForInLoopTree;

// 파일 컨트롤러
public class FileEx07_연습 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int [] arrayList = null;
		int elementCnt = 0;
		
		String fileNameString = "arrayList.txt";
		
		while (true) {
			
			System.out.println("[어레이리스트 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.println("메뉴 선택 : ");
			int selectMenu = scan.nextInt();
			
			if (selectMenu == 1) {
				}
			else if (selectMenu == 2) {
				
		
	        }
			 else if (selectMenu == 3) {
				
			}
			else if (selectMenu == 4) {
				
			}
			else if (selectMenu == 5) {
				System.out.println("==프로그램 종료==");
				
				break;
			
			} 
		}
		
	}

}
