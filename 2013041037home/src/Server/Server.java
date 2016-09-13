package Server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private ServerSocket server_soc;
	private BufferedReader br;
	private PrintWriter pw;
	private Socket soc;
	private Server(){
		init();
	}
	
	public void init(){
		
		try{
			server_soc = new ServerSocket(9000);
			System.out.println("������ �غ�Ǿ����ϴ�.");
			System.out.println("Ŭ���̾�Ʈ�� ��޸��� �ֽ��ϴ�.");
			
			soc = server_soc.accept();
			System.out.println("Ŭ���̾�Ʈ�� �����߽��ϴ�!");
			
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			pw = new PrintWriter(soc.getOutputStream());
			
			String readData = "";
			while(!(readData=br.readLine()).equals(null));{
				System.out.println("from Client >"+readData);
				pw.println(readData);
				pw.flush();
			}
			soc.close();
			System.out.println("������ ���������ϴ�");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	


public static void main(String[] args){
	new Server();
}
}