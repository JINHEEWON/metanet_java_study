package kr.or.kosa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsedMarket {

	private Map<String, Product> productlist;
	private Scanner sc;
	private Product product;
	
	public UsedMarket() {
		productlist = new HashMap<String, Product>();
		sc = new Scanner(System.in);
	}
	
	//상품 판매(등록)
	public void sell() {
		System.out.printf("상품이름: ");
		String name = sc.nextLine();
		System.out.printf("가격: ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.printf("판매자 이름: ");
		String seller = sc.nextLine();
		System.out.printf("종류: 1)의류, 2)가전, 3)완구");
		int input = Integer.parseInt(sc.nextLine());

		//Product product;
		switch (input) {
		case 1:
			System.out.println("옷 사이즈를 입력해주세요.");
			int size = Integer.parseInt(sc.nextLine());
			product = new Clothes(name, price, seller, size);
			break;
		case 2:
			System.out.println("제조사를 입력해주세요.");
			String company = sc.nextLine();
			product = new Appliance(name, price, seller, company);
			break;
		case 3:
			System.out.println("적정 연령을 입력해주세요.");
			int age = Integer.parseInt(sc.nextLine());
			product = new Toy(name, price, seller, age);
			break;
		default:
			System.out.println("잘못입력했습니다");
			break;
		}
		
		productlist.put(name, product);
		product.printDetailInfo();
		System.out.println("등록하였습니다.");
		
		//파일 저장
		saveProductsData();
	}
	
	
	//상품 구매
	public void buy() {
		System.out.println("구매할 상품 이름을 입려해주세요.");
		String productName = sc.nextLine();
		
		if (productlist.containsKey(productName)) {
			Product product = productlist.get(productName);
			productlist.remove(productName);
			System.out.print("구매한 상품의 정보는 ");
			product.printDetailInfo();
		} else {
			System.out.println("구매할 상품이 존재하지 않습니다.");
		}
		saveProductsData();
	
	}
	
	//상품 조회(검색)
	public void getList() {
		loadProductsData();
		System.out.printf("상품이름: ");
		String name = sc.nextLine();

		Product product= productlist.get(name);
		product.printDetailInfo();
	}

	private void loadProductsData() {
			File file = new File("Product.txt");
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				productlist = (HashMap)ois.readObject();
				System.out.println("불러온 상품 데이터");
				for (String key : productlist.keySet()) {
					productlist.get(key).printDetailInfo();
				}
			} catch (Exception e) {
				System.out.println("데이터 불러오기에 실패하셨습니다.");
			} finally {
				try {
					ois.close();
					fis.close();
				} catch (Exception e) {
					System.out.println("스트림 종료에 실패하셨습니다.");
				}
			}
	}

	private void saveProductsData() {
			File file = new File("Product.txt");
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try {
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(productlist);
			} catch (Exception e) {
				System.out.println("데이터 저장에 실패하셨습니다.");
				System.out.println(e.getMessage());
			} finally {
				try {
					oos.close();
					fos.close();
				} catch (Exception e) {
					System.out.println("스트림 종료에 실패하셨습니다.");
				}
			}
		}	
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean end = false;
		
		do {
			System.out.println("1:상품판매  2:상품구매  3:상품조회");
			int select = Integer.parseInt(scanner.nextLine());
			
			switch(select) {
			case 1:
				sell();
				break;
			case 2:
				buy();
				break;
			case 3:
				getList();
				break;
			default:
				end = true;
				System.out.printf("종료합니다...");
			}
		}while(!end);
	}

}