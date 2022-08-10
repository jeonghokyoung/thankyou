package test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		try {
			Socket socket = new Socket("192.168.0.77", 11112);
			System.out.println("클라이언트");

			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			Classinfo Classinfo = new Classinfo();
			Classinfo.setId("test");
			Classinfo.setName("홍길동");
			Classinfo.setKor(100);
			Classinfo.setEng(80);
			Classinfo.setMath(90);
			
			long beforeTime = System.currentTimeMillis();
			System.out.println("beforeTime:" + beforeTime);
			
			DataOutputStream out = new DataOutputStream(os);
			
			out.writeUTF(String.valueOf(beforeTime));
			out.flush();

			oos.writeObject(Classinfo);
			oos.flush();

			oos.close();
			os.close();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

}
