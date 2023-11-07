
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

class Message {
	String command;
	String to;
	
	Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
}

public class Ex03_Queue {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
		//선입선출 FIFO
		
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "김유신"));
		messageQueue.offer(new Message("sendKTalk", "이순신"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			
			switch (message.command) {
			case "sendMail" : System.out.println(message.to + " 메일 전송");
				break;
			case "sendSMS" : System.out.println(message.to + " 메일 전송");
				break;
			case "sendKTalk" : System.out.println(message.to + " 메일 전송");
				break;
			}
		}
		
		Date now = Calendar.getInstance().getTime();         
		System.out.println(now);          
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy년MM월dd일"); 
		SimpleDateFormat formatter2 = new SimpleDateFormat("HH시mm분"); 
		
		String date = formatter1.format(now);
		System.out.println(date);   
		String time = formatter2.format(now);
		System.out.println(time);   

	}

}
