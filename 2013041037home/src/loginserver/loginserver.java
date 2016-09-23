package loginserver;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;	

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
import java.util.StringTokenizer;  


public class loginserver{
	ServerSocket serversocket;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	ServerGui gui;
	String msg;
	File m_file = new File("text");
	public final void setGui(ServerGui gui){
		
		String logindata[] = null;
		// TODO Auto-generated method stub

		
		
		this.gui=gui;
	}
	
	public void Setting(){
		String s= new String();
		try{
			serversocket = new ServerSocket(9000);
			System.out.println("한조대기중");
			socket = serversocket.accept();
			
			
			out= new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			gui.appendMsg(socket.getInetAddress()+"에서 접속했습니다");
			
			try {
				FileReader m_reader	 = new FileReader(m_file);
				int c;
				while(true)
				{
					c = m_reader.read();
					
					if(c==-1){
						break;
					}
					s=s+(char)c;	
					
				}
				System.out.println(s);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			while (in != null) {
				String msg = in.readUTF();
				
				
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				String input;
				input = s;  
				StringTokenizer a = new StringTokenizer(input); 
				
				while(a.hasMoreTokens()){
				if(msg.equals(a.nextToken("^"))==true)
				{
					out.writeUTF("로그인 성공");
					break;
				}
					
				else
					out.writeUTF("실패");
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
			gui.appendMsg("클라가 종료됨");
		}
	}
		

		public void sendMessage(String msg){
			try{
				out.writeUTF(msg);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		public static void main(String[] agrs){
			new ServerGui();
	}
	
	
}// end

class ServerGui extends JFrame implements ActionListener{
	JTextArea jta = new JTextArea(40,25);
	JTextField jtf = new JTextField(25);
	
	loginserver loginserver =new loginserver();
	

	public ServerGui(){
		add(jta,BorderLayout.CENTER);
		add(jtf,BorderLayout.SOUTH);
		
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("서버");
		
		loginserver.setGui(this);
		
		loginserver.Setting();
		
		jta.append("@@@@@@@@@@@@@@");
	}
	
	public void actionPerformed(ActionEvent e){
		String msg = jtf.getText()+"\n";
		jta.append(msg);
		jtf.setText("");
		
		loginserver.sendMessage(msg);
	}
	public void appendMsg(String msg){
		jta.append(msg+"\n");
	}
	
}

