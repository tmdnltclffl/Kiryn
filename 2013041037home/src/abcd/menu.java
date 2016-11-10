package abcd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class menu implements ActionListener {

	JFrame frame = new JFrame("메뉴");
	JMenu menu;
	JMenuBar menubar;
	JMenuItem  menu11,menu12,menu13,menu21,menu22,menu23,menu31,menu32,menu33;
	
	
	private String first="";  		// 숫자 누적
	private String result=""; 		// 결과값  "=" 출력
	ArrayList<Integer> ee=new ArrayList<Integer>();  		// 값들 누적으로 받기.
	ArrayList<String> store=new ArrayList<String>();        // 연산자 누적으로 저장.

	JTextField number = new JTextField("0");
	JTextField number2 = new JTextField();
	
	public static void main(String[] args){
		 menu menu = new menu();
	}
	public menu(){
		menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		menu = new JMenu("파일");
		menu11 = new JMenuItem("로또");
		menu11.addActionListener(this);
		menu12=new JMenuItem("파일2");
		menu13=new JMenuItem("파일3");
		menu.add(menu11);
		menu.add(menu12);
		menu.add(menu13);
		menubar.add(menu);
		
		menu = new JMenu("편집");
		menu21=new JMenuItem("편집");
		menu22=new JMenuItem("편집2");
		menu23=new JMenuItem("편집3");
		menu.add(menu21);
		menu.add(menu22);
		menu.add(menu23);
		menubar.add(menu);
		
		
		menu = new JMenu("보기");
		menu31=new JMenuItem("보기");
		menu32=new JMenuItem("보기2");
		menu33=new JMenuItem("보기3");
		menu.add(menu31);
		menu.add(menu32);
		menu.add(menu33);
		menubar.add(menu);

		//계산기
		JPanel p1 = new JPanel();
		p1.setSize(50,200 );
		p1.setLayout(new GridLayout(4,4,5,5));
		JButton c = new JButton("C");
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton devision = new JButton("/");
		JButton multiplication = new JButton("*");
		JButton B1 = new JButton("1");
		JButton B2 = new JButton("2");
		JButton B3 = new JButton("3");
		JButton B4 = new JButton("4");
		JButton B5 = new JButton("5");
		JButton B6 = new JButton("6");
		JButton B7 = new JButton("7");
		JButton B8 = new JButton("8");
		JButton B9 = new JButton("9");
		JButton B0 = new JButton("0");
		JButton equal = new JButton("=");
		
		p1.add(B1);
		p1.add(B2);
		p1.add(B3);
		p1.add(devision);
		p1.add(B4);
		p1.add(B5);
		p1.add(B6);
		p1.add(multiplication);
		p1.add(B7);
		p1.add(B8);
		p1.add(B9);
		p1.add(plus);
		p1.add(c);
		p1.add(B0);
		p1.add(equal);
		p1.add(minus);
		
		JPanel p3 = new JPanel();
		number.setEditable(false);
		number2.setEditable(false);
		p3.add(number);
		p3.add(number2);
		p3.setLayout(new GridLayout(2,1,5,5));
		
		
		
		c.addActionListener(this);
		plus.addActionListener(this);
		devision.addActionListener(this);
		multiplication.addActionListener(this);
		B1.addActionListener(this);
		B2.addActionListener(this);
		B3.addActionListener(this);
		B4.addActionListener(this);
		B5.addActionListener(this);
		B6.addActionListener(this);
		B7.addActionListener(this);
		B8.addActionListener(this);
		B9.addActionListener(this);
		B0.addActionListener(this);
		equal.addActionListener(this);
		
		frame.add(p1,BorderLayout.SOUTH);
		frame.add(p3,BorderLayout.NORTH);
		frame.setSize(450,230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	

		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		String read;
		if("로또".equals(str)){
			lotto a = new lotto();
		}

			//연산기호가 아닌 숫자이면 true 이다.
			if(str!="/" && str!= "*"&& str!= "-"&& str!= "+"&& str!= "C"&& str!= "="){	
				number2.setText(first);  		// 0을지우고 숫자누적하기위해 필요.
				number2.getText();  			// 누적 출력
				number.setText("");		// 연산자 텍스트 초기화
				number.getText(); 		// 출력
				
				read=number2.getText();  		// 텍스트에 있는값 불러옴.
				first=read+str;
				number2.setText(first);		// 누적 저장
				number2.getText(); 			// 누적 출력
			}// if
			
			
			
			//연산기호가 들어왔을때 true.
			if(str=="/" || str== "*"|| str== "-"|| str== "+"|| str== "="){
				number.setText(str); 				 // 연산자 기호 저장
				number.getText();  					// 연산자 기호 출력
				
				ee.add(Integer.parseInt(first));  // 연산하려는 값 하나씩 ArrayList에 저장
				first="";						// 다시 누적하도록 초기화
				
				store.add(str); 			   // 연산자 ArrayList에 저장		
			}// if
			
			
			
			//연산기호 "=" 결과값 눌렀을때.
			if(str=="="){		
				int sum=0;
				sum=ee.get(0); 		// 최초 시작값을 받고 시작 , 1(+2)(+3)(+4)=result 초기값만 알면 3번만 "()" 연산해주면 된다. 
				
				for(int a=0,h=1; a<ee.size(); a++,h++){   // ArrayList 크기만큼 반복
					int ve=store.size(); 				// 연산자 누적 횟수 저장
					if(ve>0){							// 연산자 누적 모두 사용할때까지 반복.
						ve--;			
						//if문 또는 switch문으로 가능.
						if(store.get(a)=="+"){			// 연산자 + 일때
							sum=sum+ee.get(h);  			// (+2) 두번째 숫자와 연산
						}else if(store.get(a)=="-"){	// 아래부터 반복..	
							sum=sum-ee.get(h);	
						}else if(store.get(a)=="*"){
							sum=sum*ee.get(h);
						}else if(store.get(a)=="/"){
								sum=sum/ee.get(h);
						}			
					}
				}
				result=sum+"";						//총 결과값
				number2.setText(result);  		// 결과값 저장
				number2.getText(); 				// 결과출력	
			}// if
			
			//모든 값 초기화 시키고 다시 연산.
			if(str=="C"){
				first="";
				number2.setText("0"); 			 // 텍스트창 내용 지우고 0출력
				number2.getText();  			
				number.setText(""); 	// 연산자 텍스트창 초기화
				number.getText(); 
				ee.clear();  					// 모든 요소들 제거
				store.clear();  				// 모든 요소들 제거
			}
			
		}
}

		




