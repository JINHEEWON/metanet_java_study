package kr.or.kosa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookManager {
	static private HashMap<String, Book> booklist;		//왜 static..?
	private Scanner scanner;
	private File file;
	
	public BookManager() {
		this.booklist = new HashMap<String, Book>();
		scanner = new Scanner(System.in);
		file = new File("book.txt");
	}
	
	private void addBook() {
		System.out.printf("추가할 도서 ISBN: ");
		String isbn = scanner.nextLine();
		System.out.printf("도서제목: ");
		String title = scanner.nextLine();
		System.out.printf("가격: ");
		int price = Integer.parseInt(scanner.nextLine());
		
		Book book = new Book(isbn, title, price);
		booklist.put(isbn, book);
		System.out.println(book + " 생성하였습니다.");
	}
	
	private void deleteBook() {	
		System.out.printf("삭제할 도서 ISBN:");
		String isbn = scanner.nextLine();
		
		this.booklist.remove(isbn);
		System.out.println("삭제하였습니다");
	}
	
	private void searchBook() {
		System.out.printf("검색할 도서 ISBN:");
		String isbn = scanner.nextLine();
		
		Book book = booklist.get(isbn);
		System.out.println("검색 결과>>" + book);
	}
	
	private void printBookList() {
		System.out.println("도서목록");
		System.out.println("도서 수: " + booklist.size());
		
		Iterator<Map.Entry<String, Book>> entry = booklist.entrySet().iterator();
		while(entry.hasNext()) {
			System.out.println(entry.next().getValue());
		}
	}
	
	private void printISBNList() {
		System.out.println("ISBN 목록");
		System.out.println("도서 수: " + booklist.size());
		
		Set set = booklist.keySet();
		Iterator it = set.iterator();	
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	private void saveBook() {		
		
		try{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(booklist); //map 안에는  (1,new BMI) (2,new BMI) (3, new BMI)
			
			oos.close();
			fos.close();
		}catch(Exception e){
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}
		System.out.println("저장되었습니다.");
	}
	
	private void loadBook() {
		
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);
			
			booklist = (HashMap)oos.readObject();
			
			Set<String> set = booklist.keySet();
			System.out.println("ISBN\ttitle\t가격");
			for (String key : set) {
				String isbn = booklist.get(key).getIsbn();
				String title = booklist.get(key).getTitle();
				int price = booklist.get(key).getPrice();

				System.out.printf("[%s]\t%2s\t%2s\n", isbn, title, price);
			}
			oos.close();
			fis.close();
			
		}catch(Exception e){
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	public void run() {
		String isbn = "";
		String title = "";
		int price = 0;
		boolean end = false;
		
		do {
			System.out.println("1:추가  2:삭제  3:검색  4:도서목록  5:ISBN목록  6:파일저장  7:저장목록  0:종료");
			int select = Integer.parseInt(scanner.nextLine());
			
			switch(select) {
			case 1:
				addBook();
				break;
			case 2:
				deleteBook();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				printBookList();
				break;
			case 5:
				printISBNList();
				break;
			case 6:
				saveBook();
				break;
			case 7:
				loadBook();
				break;
			case 0:
				end = true;
				System.out.printf("종료합니다...");
			}
		}while(!end);
		
	}
}
