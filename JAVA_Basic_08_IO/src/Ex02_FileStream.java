/*
 Point
 
 Byte 데이터를 read / write 대상이 >> File (a.txt)
 
 FileInputStream
 FileOutputStream
 
 자료실(이미지, 엑셀) read, write
 
 File > 1.txt, log.png, l.data
 
 I/O 자원은 개발자가 직접적으로 자원 해제 -> 가비지 컬렉터가 다루지 못함	(워드 파일 작업중(열려 있으면) 다른 사람이 read, write...기존 파일을 닫아줘야함)
 close() 자원해제
 I/O 예외처리 강제되어 있다 (자바를 설계한 사람이 생각 > I/O는 문제가 많이 생길거다 > 강제적 종료 안돼 > 권고(try 강제))
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex02_FileStream {

	public static void main(String[] args) {
		FileInputStream fs = null;
		FileOutputStream fos = null;
		
		String path = "C:\\temp\\a.txt"; 
		
		try {
			fs = new FileInputStream(path);
			fos = new FileOutputStream("C:\\temp\\new.txt", true);
			//현재 new.txt 파일은 없다
			
			/*
			 File 클래스 >> 파일 생성 >> write
			 
			 FileOutputStream
			 1. write 파일 존재하지 않으면 >> File create
			 2. fos = new FileOutputStream("C:\\temp\\new.txt", false);
			    false >> Overwrite
			 3. fos = new FileOutputStream("C:\\temp\\new.txt", true);
			    true >> append
			 */
			
			int data = 0;
			while((data = fs.read()) != -1) {
				fos.write(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//정상, 비정상 종료 
			//강제 실행
			//함수가 return 종료되어도 finally 실행
			try {
				fs.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
