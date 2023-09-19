import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("====프로그램 실행====");
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			
			System.out.println("명령어 : ");
			String commend = sc.nextLine();
			
			if (commend.length() == 0) {
				System.out.println("명령어를 입력하세요.");
			}
			
			else {
				System.out.println("없는 명령어 입니다.");
			}
			
			if (commend.equals("exit")) {
				
				break;
			}
			
		}
		
		System.out.println("====프로그램 종료====");
		
		sc.close();
	}
}
	

