package step5_02.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

//# 파일 컨트롤러[3단계] : 장바구니

public class FileEx09_연습 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",   "2222", "3333"};
		String[] items = {"사과", "바나나", "딸기"};
		
		final int MAX_SIZE = 100;
		int[][] cart = new int[MAX_SIZE][2];

		String fileName = "jang.txt";
		
		int count = 0;// 장바구니에 담기는 아이템 수
		int log = -1;//(로그인 여부)
		
		while (true) {
			
			//상태값 로직
			System.out.println("----------------");
			
			
			System.out.println("[MEGA SHOP]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int selectMenu = scan.nextInt();
			
				if (selectMenu == 1) {
					if(log == -1) {
						System.out.print("[로그인]ID 입력 : ");
						String myId = scan.next();
						System.out.print("[로그인]PW 입력 : ");
						String myPw = scan.next();
						
						for (int i = 0; i < ids.length; i++) {
							if (myId.equals(ids[i]) && myPw.equals(pws[i])) {
								log = i;
							}
						}
						if (log == -1) {
							System.out.println("로그인 후 이용해주세요");
						}
					}
					else {//log == 1 로그인 중
						System.out.println( ids[log] +"님 로그인 중");
					}
					
				} else if (selectMenu == 2) {
					//로그아웃
					if(log == -1){
						System.out.println("로그인 후 이용가능합니다.");
					}else {
						log =-1;
						System.out.println("로그아웃 완료되었습니다");
					}
				} else if (selectMenu == 3) {
					
					if(log == -1){
						System.out.println("로그인 후 이용 가능합니다.");
					}
					
					for (int i = 0; i < items.length; i++) {
						System.out.println((i+1)+"."+items[i]);
					}
					System.out.print("[쇼핑]상품번호를 선택하세요 : ");
					int productNo = scan.nextInt();
					
					//입력한 상품을 카트배열에 담기
					cart[count][0] = log; //-> 이부분 왜? 카트의 처음 배열에 log식별자를 저장한다.
					cart[count][1] = productNo;
					count++;
					System.out.println("장바구니에 담겼습니다.");
					
				} else if (selectMenu == 4) {
				
					if(log == -1){
						System.out.println("로그인 후 이용가능합니다.");
					}
					
					System.out.println("["+ids[log]+"님의 장바구니]");
					int j = 0;//다음의 반복문 내에서 번호를 매기기 위한 변수
					for (int i = 0; i < count; i++) {
						if(log == cart[i][0]){//현재 사용자의 장바구니에 속한 아이템인지 확인
						 System.out.print((j+1)+".");
						if(cart[i][1] == 1)       System.out.println("사과");
						else if (cart[i][1] == 2) System.out.println("바나나");
						else if (cart[i][1] == 3) System.out.println("딸기");
							j++;
						}
						
					}
				
				} else if (selectMenu == 5) {
					// 파일로 저장하기(데이터 저장 로직)
					String data = "";
					
					for (int i = 0; i < count; i++) {
						data += cart[i][0];
						data += "/";
						data += cart[i][1];
						data += "\n";
					}
					FileWriter fw = null;
					try {
						 fw = new FileWriter(fileName);//파일에 쓰기
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						if(fw != null) {try {fw.close();} catch (IOException e) {}}
					}
					
				} else if (selectMenu == 6) {
					//로드하기
					//파일 불러오기
					File file = new File(fileName);
				     
					if(file.exists()) {
						FileReader fr = null;
						BufferedReader br = null;
						
						try {
							fr = new FileReader(file);
							br = new BufferedReader(fr);
							
							count = 0;
							String line = br.readLine();
							while(line != null) {}
								String[] temp = line.split("/n");
								cart[count][0] = Integer.parseInt(temp[0]);
								cart[count][1] = Integer.parseInt(temp[1]);
								count++;
								
								line = br.readLine();//다시 한줄 불러오기
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
						 if(fr != null) { try {fr.close();} catch (Exception e) {e.printStackTrace();}}
						 if(br != null) {try {br.close();} catch (Exception e) {e.printStackTrace();}}
						}
						System.out.println("파일을 불러왔습니다.");
					}
				} else if (selectMenu == 0) {
					System.out.println("프로그램 종료");
					scan.close();
					break;
				}
				
			}
		
	}
}
