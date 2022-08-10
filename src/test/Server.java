package test;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
			ServerSocket server=new ServerSocket(11112);
			System.out.println("서버 접속대기중...... ");
			Socket client=server.accept();
			System.out.println("클라이언트 접속 ");

			InputStream is = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			DataInputStream in =new DataInputStream(is);
			long beforeTime = Long.valueOf(in.readUTF());
			
			Classinfo Classinfo = (Classinfo) ois.readObject();
			long afterTime=System.currentTimeMillis();
			long diffTime= afterTime-beforeTime;
			System.out.println("전송시간:"+diffTime);
			
			String id = Classinfo.getId();
			String name = Classinfo.getName();
			int kor = Classinfo.getKor();
			int eng = Classinfo.getEng();
			int math = Classinfo.getMath();
			System.out.println("id : " + id + "\nname : " + name+ "\nkor : " + kor+ "\neng : " + eng+ "\nmath : " + math);
			
			ois.close();
			is.close();
			client.close();
			server.close();
		
	}

}
