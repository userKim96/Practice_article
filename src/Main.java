import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	
	static List<Article> articles = new ArrayList<Article>();
	
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 3;
		

		
		makeTestData();
		
		
		while (true) {
			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();
			if (command.length() == 0) {
				System.out.println("너 명령어 입력 안했어");
				continue;
			}
			if (command.equals("exit")) {
				break;
			}
			if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
				} else {
					System.out.println("번호   /    제목   /    조회");
					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf(" %d     /   %s     /   %d\n", article.id, article.title, article.view);
					}
				}
			} else if (command.equals("article write")) {
				int id = lastArticleId + 1;
				int view = 0;
				String regdate = Util.getNow();
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				Article article = new Article(id, view, regdate, title, body);
				articles.add(article);
				System.out.printf("%d번글이 생성되었습니다.\n", id);
				lastArticleId++;
			}
				else if (command.startsWith("article detail")) {

					String[] commandDiv = command.split(" "); 
					
					if (commandDiv.length == 2) {
						System.out.println("게시물 번호를 입력하지 않았습니다.");
						continue;
					}


					int id = Integer.parseInt(commandDiv[2]);

			
					boolean found = false;

					for (int i = 0; i < articles.size(); i++) {
						Article article = articles.get(i);
						if (article.id == id) {
							found = true;
							article.view++;
							System.out.println("번호 : " + article.id);
							System.out.println("날짜 : " + article.regDate);
							System.out.println("제목 : " + article.title);
							System.out.println("내용 : " + article.body);
							break;
						}
					}

					if (found == false) {
						System.out.printf("%d번 게시물은 없어\n", id);
					}
					
					

				} else if (command.startsWith("article delete")) {
					
					String[] commandDiv = command.split(" "); 
					
					if (commandDiv.length == 2) {
						System.out.println("게시물 번호를 입력하지 않았습니다.");
						continue;
					}
					
					
					int id = Integer.parseInt(commandDiv[2]);
					
					
					int foundIntdex = -1;
					
					for (int i = 0; i < articles.size(); i++) {
						
						Article article = articles.get(i);
						if (article.id == id) {
							foundIntdex = i;
							break;
						}
						
						
					}
					if (foundIntdex == -1) {
						System.out.printf("%d번 게시물은 없습니다.\n", id);
						continue;
					}
					
					articles.remove(foundIntdex);
					System.out.printf("%d번 게시물을 삭제했습니다.\n", id);
					
					
				} 
				else if (command.startsWith("article modify")) {
					
					String[] commandDiv = command.split(" "); 
					
					if (commandDiv.length == 2) {
						System.out.println("게시물 번호를 입력하지 않았습니다.");
						continue;
					}
					
					
					int id = Integer.parseInt(commandDiv[2]);
					
					
					boolean found = false;
					
					for (int i = 0; i < articles.size(); i++) {
						
						Article article = articles.get(i);
						
						if (article.id == id) {
							
							found = true;
							
							System.out.printf("제목 : %s\n", article.title);
							System.out.printf("내용 : %s\n", article.body);
							break;
						}
						
					}
					
					if (found == false) {
						
						System.out.printf("%d번 게시물은 없습니다.\n", id);
						continue;
						
					}
					
				}
			
			
				
				else {
					System.out.println("존재하지 않는 명령어입니다");
					continue;
				}
			}
			System.out.println("== 프로그램 종료 ==");
			sc.close();
		}

	private static void makeTestData() {
		
		System.out.println("테스트 게시물 생성완료.");
		for (int i = 0; i < 3; i++) {
			
			articles.add(new Article( i + 1,  i, Util.getNow(),  "제목" + (i+1),  "내용" + (i+1)));
			
			
		}
	}
	
	}
	class Article {
		int id;
		int view;
		String regDate;
		String title;
		String body;
		Article(int id, int view, String regDate, String title, String body) {
			this.id = id;
			this.view = view;
			this.regDate = Util.getNow();
			this.title = title;
			this.body = body;
		}
	}