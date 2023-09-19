import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//	필드
	public static void main(String[] args) {
//		메소드
		
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("====프로그램 실행====");
		
		Scanner sc = new Scanner(System.in);
		
		List<Article> articles = new ArrayList<Article>();

		int lastArticleId = 0;
		
		while (true) {
			
			
			System.out.println("명령어 : ");
			String commend = sc.nextLine();
			
			if (commend.length() == 0) {
				System.out.println("명령어를 입력하세요.");
				continue;
			}
			
			
			if (commend.equals("article write")) {
				
				
				int id = lastArticleId+1;
				
				String regDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
				
				System.out.println("제목 : ");
				String title = sc.nextLine();
				
				System.out.println("내용 : ");
				String body = sc.nextLine();
				
				System.out.printf("%d번 글이 생성되었습니다.\n", id);
				
				Article article = new Article(id, regDate, title, body);
				
				articles.add(article);
						
				lastArticleId++;
				
			}
			
			else if (commend.equals("article list")) {
				
				if (articles.size() == 0) {
					
					System.out.println("게시물이 없습니다.");
					
					
				}
				else if(articles.size() > 0) {
					
					System.out.println("번호   /   제목");
					
					for (int i = articles.size()-1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf("%d   /   %s\n", article.id, article.title);
					}
				}
			}
			else if (commend.startsWith("article detail ")) {
				String[] splitCommend = commend.split(" "); 
				int commendId = Integer.parseInt(splitCommend[2]);
				
				boolean found = false;
				
				for (int i = 0; i <=articles.size(); i++) {
					Article article = articles.get(i);
					if (commendId == article.id) {
						found = true;
						System.out.printf("번호 : %d\n", article.id);
						System.out.printf("날짜 : %s\n", article.regDate);
						System.out.printf("제목 : %s\n", article.title);
						System.out.printf("내용 : %s\n", article.body);
						break;
						
					}
					
					
				}
				if (found == false) {
					System.out.printf("%d번 게시물은 없는 게시물입니다.", commendId);
				}
				
												
			}
			
			else {
				System.out.println("없는 명령어 입니다.");
				continue;
			}
			
			if (commend.equals("exit")) {
				
				break;
			}
			
		}
		
		System.out.println("====프로그램 종료====");
		
		sc.close();
	}
}

class Article {
	
	int id;
	String regDate;
	String title;
	String body;
	
	Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}
}

