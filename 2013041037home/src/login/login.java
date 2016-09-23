package login;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;	


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class login {
	String loginid;
	String loginpwd;
	
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	gui gui;
	public static void main(String[] args){
		new gui();
	}
	public final void setgui(gui gui){
		this.gui=gui;
	}
	
	public void connet(){

		try{
			socket = new Socket("127.0.0.1",9000);
			System.out.println("¼­¹ö¿¬°áµÊ");
			
			
			out= new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			while (in != null) {
			
			String msg = in.readUTF();
			System.out.println(msg);
			 	
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void sendidpwd(String msg2){
		try{
			out.writeUTF(msg2);
		}catch(IOException e){
			e.printStackTrace();
		}
	}




}
	
	
class gui extends Frame implements ActionListener{
	int index=0;
	String loginid;
	String loginpwd;
	Button btn = new Button("Login");
	TextField id = new TextField(10);
	TextField pwd = new TextField(10);
	
	login lg=new login();
	

	
	public gui(){
		super("AWT");
		setLayout(new BorderLayout());
		Label t1 = new Label("ID");
		Label t2 = new Label("Passwd");
		
		Panel p1 = new Panel();
		p1.add(t1);
		p1.add(id);
		Panel p2 = new Panel();
		p2.add(t2);
		p2.add(pwd);
		p2.add(btn);
		btn.addActionListener(this);
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		
		setSize(250,200);
		setVisible(true);
		lg.setgui(this);
		lg.connet();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==btn)
		{
			loginid=id.getText();
			loginpwd=pwd.getText();
			lg.sendidpwd(loginid+"&&&"+loginpwd);

		
		}
	}
	

}
