package kr.or.kosa;

import java.util.List;
import java.util.Map;

//MVC (Model(DTO, DAO : DB 연결 CRUD)(java), View(html, jsp), Controller(servlet(웹으로 쓸 수 있는 자바 파일))
public class EmpDAO {
	//DAO (CRUD)
	//함수 5개
	//전체조회
	//조건조회
	//삽입
	//수정
	//삭제
	//조회(검색)
	
	public List<Emp> getEmpAllList() {
		//select empno, ename, job from emp;
		return null;
	}
	public Emp getEmpListByEmpno(int empno) {
		//select empno, ename, job from emp where empno=7788;
		return null;
	} 
	
	//Map map = new HashMap();
	//map.put("title", "자바과정")
	//getEmpFindBySearchCondition
	public List<Emp> getEmpFindBySearchCondition(Map<String, String> search) {
		//select empno, ename, job from emp where title like '%자바과정%';
		return null;
	}
}
