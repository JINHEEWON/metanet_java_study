/*
 Set 인터페이스
 (원안에 들어가세요) : 순서를 보장(x), 중복을 허락하지 않아요
 순서가 없고 중복을 허락하지 않는 데이터 집합
 구현하는 클래스
 HashSet, TreeSet (자료구조)
  
 */

import java.util.HashSet;
import java.util.Set;

public class Ex03_Set {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(10);
		hs.add(20);
		System.out.println(hs.add(10));
		
		System.out.println(hs.toString());
		//ex) 로또, 차량번호, 회원id
		
		Set set2 = new HashSet();
		while(set2.size() < 6) {
			int num = (int)(Math.random()*45 + 1);
			set2.add(num);
		}
		System.out.println(set2.toString());

	}

}
