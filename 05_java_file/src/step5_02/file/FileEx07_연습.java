package step5_02.file;
//2023-11-20  
import java.util.Scanner;

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
				
				System.out.print("[추가] 데이터 입력 : ");
				int data = scan.nextInt();
				
				for (int i = 0; i <= elementCnt; i++) {
					arrayList[elementCnt] += data;
					System.out.println();
				}
			}
			else if (selectMenu == 2) {
				
				System.out.print("[삭제] 인덱스 값 입력 : ");
				int delIdx = scan.nextInt();
				//continue 로 빠져나온다( 이문장만 실행 안함)
				if (delIdx < 0 || arrayList.length < delIdx) {
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
					continue;
				}
			//내가 입력한 값이 하나만 있을때
				if (elementCnt == 1) {//"1"을 입력하면 arrayList에 들어있는값은 없다.
					arrayList = null;
				}
				else if (elementCnt > 1) {
					int[] temp = arrayList;// tmep 에 임시 저장한다.
					arrayList = new int[elementCnt -1];//arrayList 재 생성..선언
					
					//삭제 코딩
					int j = 0;// 삭제하는 인덱스 전의 데이터횟수..
					for (int i = 0; i < elementCnt; i++) {// elementCnt 된 만큼 진행
						if (i != delIdx) {// ex delIdx = 1 i =0 이면  
							arrayList[j] = temp[i];// arrayList[0] = temp[0]
							j++;
						}
					}temp = null; //여기서 temp를 null로 초기화 하는 이유가 무엇이지..??
					
				}
				elementCnt--;
			}
			else if (selectMenu == 3) {
				
			}
			else if (selectMenu == 4) {
				
			}
			else if (selectMenu == 5) {
				System.out.println("==프로그램 종료==");
				scan.close();
				break;
			
			} 
		}
		
	}

}
