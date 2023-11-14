package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//롬복 사용
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
}
