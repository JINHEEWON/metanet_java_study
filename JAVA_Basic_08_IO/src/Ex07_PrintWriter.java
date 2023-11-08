
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Ex07_PrintWriter {

	public static void main(String[] args) {
		try {
			//출력 양식 정의 (format)
			/*
			PrintWriter pw = new PrintWriter("C:\\temp\\homework.txt");
			pw.println("*********************************************");
			pw.println("******************HOMEWORK***************");
			pw.printf("%3s: %5d, %5d, %5d, %5.1f", "아무개", 100, 88, 90, (float)((100+88+90)/3));
			pw.println();
			pw.close();
			*/
			
			FileReader fr = new FileReader("C:\\temp\\homework.txt");
			BufferedReader bReader = new BufferedReader(fr);
			String s = "";
			while((s=bReader.readLine()) != null) {
				System.out.println(s);
			}
			bReader.close();
			fr.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}

	}

}
