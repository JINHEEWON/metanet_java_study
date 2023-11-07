package kr.or.kosa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookManager {
	private HashMap<String, Book> booklist;
	private Scanner scanner;
	
	public BookManager() {
		this.booklist = new HashMap<String, Book>();
		scanner = new Scanner(System.in);
	}
	
	public void addBook(String isbn, String title, int price) {
		Book book = new Book(isbn, title, price);
		booklist.put(isbn, book);
		System.out.println(book + " 생성하였습니다.");
	}
	
	public void deleteBook(String isbn) {	
		this.booklist.remove(isbn);
		System.out.println("삭제하였습니다");
	}
	
	public void searchBook(String isbn) {
		Book book = booklist.get(isbn);
		System.out.println("검색 결과>>" + book);
	}
	
	public void printBookList() {
		System.out.println("도서목록");
		System.out.println("도서 수: " + booklist.size());
		
		Iterator<Map.Entry<String, Book>> entry = booklist.entrySet().iterator();
		while(entry.hasNext()) {
			System.out.println(entry.next().getValue());
		}
	}
	
	public void printISBNList() {
		System.out.println("ISBN 목록");
		System.out.println("도서 수: " + booklist.size());
		
		Set set = booklist.keySet();
		Iterator it = set.iterator();	
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void run() {
		String isbn = "";
		String title = "";
		int price = 0;
		boolean end = false;
		
		do {
			System.out.println("1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록 0:종료");
			int select = Integer.parseInt(scanner.nextLine());
			
			switch(select) {
			case 1:
				System.out.printf("추가할 도서 ISBN: ");
				isbn = scanner.nextLine();
				System.out.printf("도서제목: ");
				title = scanner.nextLine();
				System.out.printf("가격: ");
				price = Integer.parseInt(scanner.nextLine());
				
				addBook(isbn, title, price);
				break;
			case 2:
				System.out.printf("삭제할 도서 ISBN:");
				isbn = scanner.nextLine();
				
				deleteBook(isbn);
				break;
			case 3:
				System.out.printf("검색할 도서 ISBN:");
				isbn = scanner.nextLine();
				
				searchBook(isbn);
				break;
			case 4:
				printBookList();
				break;
			case 5:
				printISBNList();
				break;
			case 0:
				end = true;
				System.out.printf("종료합니다...");
			}
		}while(!end);
		
	}
}
