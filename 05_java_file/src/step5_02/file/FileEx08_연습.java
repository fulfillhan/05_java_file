package step5_02.file;
//2024-01-03

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//# 파일 컨트롤러[2단계] : ATM

public class FileEx08_연습 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int atmSize = 5;
		int accsCnt = 0; // 계좌의 요소 갯수
		int identifier = -1;// 로그인 여부
		
		String[] accs = new String[atmSize];// 계좌번호배열 5개
		String[]  pws = new String[atmSize];// 패스워드 배열 5개
		int[] moneys = new int[atmSize];//돈의 배열 5개
		
		String fileName = "atm.txt";//파일 이름
		
		while(true) {
			
			System.out.println("------------");
			for (int i = 0; i < accsCnt; i++) {
				System.out.println(accs[i]+":"+pws[i]+":"+moneys[i]);
			}
			System.out.println("------------");
			
			if(identifier ==-1) System.out.println("[메시지] 로그아웃");
			else                System.out.println("상태 : "+accs[identifier]+"님, 로그인");
			
			System.out.println("------------");
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				//회원가입
				//배열의 전체 크기를 넘어가면 더이상 만들수 없음
				// 가입시 계좌번호 중복있는지 확인
				//계좌번호와 패스워드 입력받으면 회원가입(중복아닐시)
			System.out.print("[회원가입] 계좌 번호를 입력하세요 : ");
			String myAcc = scan.next();
			
			if(accsCnt >= accs.length){
				System.out.println("[메시지] 더 이상 가입할 수 없습니다!");
				return;
			}
			
			//중복 체크(계좌 배열을 기준으로)
				boolean dupCheck = false;// 중복이 아닌경우
				for (int i = 0; i <accs.length ; i++) {
					if (myAcc == accs[i]){
						dupCheck=true;
						break;
					}
				}
			if (!dupCheck){
				System.out.print("[회원가입] 패스워드를 입력하세요 : ");
				String myPw = scan.next();
				
				accs[accsCnt] = myAcc;
				pws[accsCnt] = myPw;
				moneys[accsCnt] = 1000;
				accsCnt++;
				
				System.out.println("[메시지]회원가입을 축하합니다.");
				
			}else System.out.println("[메시지] 아이디가 중복됩니다!");
			
			}
			else if (sel == 2) {
				//회원 탈퇴
				if(identifier ==-1){
					System.out.println("[메시지] 로그인 후 이용가능합니다!");
				}
				else {// 탈퇴하기
					
				}
			}
			
			else if (sel == 3) {
				//로그인 하기
				// 로그인이 되면 identifier = 1;
				//로그인이 안된 상태이면 [메세지]계좌번호와 비밀번호를 확인해주세요.
				// 처음 회원가입 할 시: 데이터 추가만
				//한번  : 임시배열 생성후 배열 정리
				//한번 로그인되면 이중 로그인 안됨 "[메세지]123님 로그인 중...
				
				if(identifier == -1) {// 로그인 과정 입력
					
					System.out.print("[로그인] 계좌 번호를 입력하세요 : ");
					String myAcc = scan.next();
					System.out.print("[로그인] 패스 워드를 입력하세요 : ");
					String myPw = scan.next();
					
					if(accsCnt == 1){
						for (int i = 0; i < accsCnt; i++) {
							accs[0]= myAcc;
							pws[0]=myPw;
							identifier = i;
						}
						System.out.println("[로그인] 로그인이 완료되었습니다.");
						
							
					} else if (accsCnt > 1) {
						
						boolean dupCheck = false;
						for (int i = 0; i < accs.length; i++) {
							if (myAcc.equals(accs[i])) {
								dupCheck = true;
								break;
							}
						}
						if (!dupCheck) {
							for (int i = 0; i < accsCnt; i++) {
								if (myAcc.equals(accs[i]) && myPw.equals(pws[i])) {
									identifier = i;
								}
								accs[identifier] = myAcc;
								pws[identifier] = myPw;
									System.out.println("[로그인] 로그인이 완료되었습니다.");
							}
						} else System.out.println("[메세지]계좌번호와 비밀번호를 확인해주세요.");
					}
					else System.out.println("[메시지] ");
				}
				else System.out.println("[메세지]"+accs[identifier]+"님 가입중...");
				
			}
			else if (sel == 4) {
				//로그아웃
				if(identifier == -1)  System.out.println("[메시지] 로그인후 이용가능합니다!");
				else                  System.out.println("[메시지] 로그아웃 되었습니다!");
			}
			
			else if (sel == 5) {
				//입금하기
				if(identifier != -1) {
					System.out.print("[입금] 금액 입력 : ");
					int myMoney = scan.nextInt();
					moneys[identifier] += myMoney;
					System.out.println();
					System.out.println("[메시지] 입금 완료!");
				}else {
					System.out.println("[메시지] 로그인 후 이용해주세요!");
				}
				
			}
			else if (sel == 6) {
				//출금하기
				if(identifier != -1){
					System.out.print("[출금] 금액 입력 : ");
					int myMoney = scan.nextInt();
					//조건 :  통장의 금액이 내가 출금할 금액보다 크게 있어야한다.
					if(myMoney<= moneys[identifier]){
						moneys[identifier] -= myMoney;
						System.out.println("[메시지] 출금 완료!");
					}
					else{
						System.out.println("[메시지] 잔액이 부족합니다!");
					}
				}
				else System.out.println("[메시지] 로그인 후 이용해주세요!");
			}
			else if (sel == 7) {
				//이체하기
				//이체계좌번호 먼저 입력하기
				if(identifier != -1){
					System.out.print("[이체] 계좌 번호 입력 : ");
					String yourAcc = scan.next();
					
					//이체할 계좌 번호가 해당 배열에 잇는지 중복검사
					int check = -1;
					for (int i = 0; i < accs.length; i++) {
						if(yourAcc.equals(accs[i])){
							check = i;
						}
					}
					if(check != -1){
						//계좌이체 가능
						System.out.print("[이체] 금액 입력 : ");
						int transMoney = scan.nextInt();
						
						if(transMoney <= moneys[identifier]){
							moneys[identifier] -= transMoney;
							moneys[check] += transMoney;
							System.out.println("[메시지] 이체 완료!");
						}
						else {
							System.out.println("[메시지] 이체 잔액이 부족합니다!");
						}
					}
					else {
						System.out.println("[메시지] 계좌 번호가 중복됩니다.");
					}
				}
				else{
					System.out.println("[메시지] 로그인 후 이용해주세요!");
				}
			}
			else if (sel == 8) {
				// 잔액조회하기
				//로그인을 했는지 유무 확인 true/false:로그인 후이용
				//accs 배열 순회하여 계좌 잔액 조회하기
				if(identifier != -1){
					System.out.println(accs[identifier]+"님의 계좌잔액은 "+moneys[identifier]+"원 입니다.");
				}
				else{
					System.out.println("[메시지] 로그인 후 이용해주세요!");
				}

			}
			else if (sel == 9) {
				//저장
				//배열에 있던 데이터를 문자화 시켜 파일에 저장
				//배열의 크기가 0이면 저장할 데이터없음-> 0초과해야 가능
				if(accsCnt == 0){
					System.out.println("[메시지] 저장할 데이터가 없습니다!");
					continue;
				}
				//파일에 넣을 데이터를 data라는 변수에 저장한다.
				String data = "";//초기화
				for (int i = 0; i < accsCnt; i++) {
					data += accs[i];
					data +="/";
					data += pws[i];
					data += "/";
					data += moneys[i];
					data += "\n";
				}
				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					if(fw != null){
						try {fw.close();} catch (IOException e) {throw new RuntimeException(e);
						}
					}
				}
			}
			else if (sel == 10) {
				//로드하기-> 여기서부터 하기
				File file = new File(fileName);
				
						
			}else if (sel == 0) {
				System.out.println("== 시스템이 종료되었습니다.!");
				break;
			}
			
		}
		
	}
}
