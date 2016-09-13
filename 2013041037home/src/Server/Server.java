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
			System.out.println("서버가 준비되었습니다.");
			System.out.println("클라이언트를 기달리고 있습니다.");
			
			soc = server_soc.accept();
			System.out.println("클라이언트가 접속했습니다!");
			
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			pw = new PrintWriter(soc.getOutputStream());
			
			String readData = "";
			while(!(readData=br.readLine()).equals(null));{
				System.out.println("from Client >"+readData);
				pw.println(readData);
				pw.flush();
			}
			soc.close();
			System.out.println("접속이 끊어졌습니다");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	


public static void main(String[] args){
	new Server();
}
}