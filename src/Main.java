import java.util.Scanner;

public class Main {
//	필드
	public static void main(String[] args) {
//		메소드
		System.out.println("====프로그램 실행====");
		
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		
		while (true) {
			
			
			System.out.println("명령어 : ");
			String commend = sc.nextLine();
			
			if (commend.length() == 0) {
				System.out.println("명령어를 입력하세요.");
			}
			
			
			if (commend.equals("article write")) {
				
				int id = lastArticleId+1;
				
				System.out.println("제목 : ");
				String title = sc.nextLine();
				
				System.out.println("내용 : ");
				String body = sc.nextLine();
				
				System.out.printf("%d번 글이 생성되었습니다.\n", id);
				
				lastArticleId++;
				
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



