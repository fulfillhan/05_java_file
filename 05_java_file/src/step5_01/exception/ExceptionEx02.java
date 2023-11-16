package step5_01.exception;

/*
 *  # finally 
 * 
 *  - 예외발생과 상관없이 무조건 실행할 명령어를 작성한다.
 *  - 주로 외부모듈과의 컨넥션을 종료할때 사용한다.
 *  
 * */


public class ExceptionEx02 {

	public static void main(String[] args) {
		
            try {
			
			int[] testArr = new int[5];
			
			System.out.println(testArr[0]);
			System.out.println(testArr[999]);
			//System.out.println(testArr[0] / 0);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 초과 오류 대응(로깅,백업,복구,전파)");
			e.printStackTrace();
		}finally {
			System.out.println("예외발생과 상관없이 무조건 실행할 명령어를 작성한다.");
			/* 예외발생과 상관없이 무조건 실행할 명령어를 작성한다.
			 *  - 주로 외부모듈과의 컨넥션을 종료할때 사용한다.*/
		}

	}

}
