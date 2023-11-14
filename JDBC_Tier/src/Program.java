import java.util.List;

import DAO.DeptDao;
import DTO.Dept;

public class Program {

	public static void main(String[] args) {
		// 요청 받고 ... 처리 담당
		// Controller ... View 역할
		
		DeptDao dao = new DeptDao();
		
		//1. 부서 테이블 데이터 전체 조회 화면 출력
		List<Dept> deptlist = dao.selectAll();
		System.out.println(deptlist);
		
		//2. 부서번호로 조건 조회 1건의 부서 정보 화면 출력
		Dept dept = dao.selectByDeptno(30);
		System.out.println(dept);
		
		
		//3. 데이터 삽입 (1건) (50, 'IT', 'SEOUL')
		Dept dept2 = new Dept();
		dept2.setDeptno(50);
		dept2.setDname("IT");
		dept2.setLoc("SEOUL");
		int ret = dao.insert(dept2);
		System.out.println(ret);
		//3.1 다시 전체 조회
		List<Dept> deptlist2 = dao.selectAll();
		System.out.println(deptlist2);
		
		//4. 방금전 삽입 했던 데이터 수정
		Dept dept3 = new Dept();
		dept3.setDeptno(50);
		dept3.setDname("IT_UP");
		dept3.setLoc("BUSAN");
		int ret2 = dao.update(dept3);
		System.out.println(ret2);
		//4.1 부서이름 ('IT_UP' , 'BUSAN')
		//4.2 다시 전체 조회
		List<Dept> deptlist3 = dao.selectAll();
		System.out.println(deptlist3);
		
		//5. 방금전 업데이트했던 데이터 삭제
		int ret3 = dao.delete(50);
		System.out.println(ret3);
		//5.1 50번 삭제
		//5.2 다시 전체 조회
		List<Dept> deptlist4 = dao.selectAll();
		System.out.println(deptlist4);
		
		System.out.println(dao.selectByDname("C"));
	}

}
