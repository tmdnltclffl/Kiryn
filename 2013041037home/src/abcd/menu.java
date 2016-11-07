package abcd;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class menu implements ActionListener{
 JFrame frame = new JFrame("메뉴");// 프레임 선언
 JMenu m1, m2, m3; //상위메뉴
 JMenuItem  mi11,mi12,mi21,mi22,mi23,mi31,mi32;//하위메뉴
 
 public void menugui() {
  //실행문
  JMenuBar m = new JMenuBar(); // JMenuBar() 클레스 생성
  frame.setJMenuBar(m); // 프레임에 매뉴바 붙이기
  
  //메뉴 설정 
  m1 = new JMenu("편집");  
  mi11 = new JMenuItem("복사");
  mi12 = new JMenuItem("집");

  m2 = new JMenu("보기");  
  mi21 = new JMenuItem("보");
  mi22 = new JMenuItem("기");
  mi23 = new JMenuItem("로또할래");
 
  m3 = new JMenu("도움말");  
  mi31 = new JMenuItem("도");
  mi32 = new JMenuItem("움말");
 
  
  //메뉴 배치
  m.add(m1);
  m1.add(mi11);
  m1.add(mi12);
    
  m.add(m2);
  m2.add(mi21);
  m2.add(mi22);
  m2.add(mi23);
  
  m.add(m3);
  m3.add(mi31);
  m3.add(mi32);

  mi23.addActionListener(this);//mi23을 눌렀을때 반응 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// x누를 때 프로그램 정지명령
  frame.setSize(300, 260);// 프레임 사이즈(가로, 세로)
  frame.setVisible(true);// 프레임 출력
 }
 
 public void actionPerformed(ActionEvent e) {
	  String as = e.getActionCommand();//
	  
	  // 메뉴바 이벤트
	  if ("로또할래".equals(as)) {
	   lotto a = new lotto();
	   a.lotto();//로또 함수 호출
	  }

	 }

	 // 실행
	 public static void main(String[] args) {
	   menu a= new menu();
	   a.menugui();
	 }
}


