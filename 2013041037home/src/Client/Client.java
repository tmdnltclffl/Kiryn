package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private Socket soc;
	private BufferedReader br;
	private PrintWriter pw;
	private Scanner scan;
	private Client(){
		init();
	}
	public void init(){
		
		try{
		soc = new Socket("localhost",9000);
		System.out.println("������ ����Ǿ����ϴ�.");
		
		br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		
		pw = new PrintWriter(soc.getOutputStream());
		
		scan = new Scanner(System.in);
		
		System.out.println("���� ä���� ������ �� �ֽ��ϴ�.");
		
		String inputData = "";
		
		while(!inputData.equals("disconnect")){
			System.out.println("to Server >");
			
			pw.println(scan.nextLine());
			
			pw.flush();
			
			System.out.println("from Server>"+br.readLine());
			
		}
		soc.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		new Client();
	}
}
