package abcd;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class menu implements ActionListener{
 JFrame frame = new JFrame("�޴�");// ������ ����
 JMenu m1, m2, m3; //�����޴�
 JMenuItem  mi11,mi12,mi21,mi22,mi23,mi31,mi32;//�����޴�
 
 public void menugui() {
  //���๮
  JMenuBar m = new JMenuBar(); // JMenuBar() Ŭ���� ����
  frame.setJMenuBar(m); // �����ӿ� �Ŵ��� ���̱�
  
  //�޴� ���� 
  m1 = new JMenu("����");  
  mi11 = new JMenuItem("����");
  mi12 = new JMenuItem("��");

  m2 = new JMenu("����");  
  mi21 = new JMenuItem("��");
  mi22 = new JMenuItem("��");
  mi23 = new JMenuItem("�ζ��ҷ�");
 
  m3 = new JMenu("����");  
  mi31 = new JMenuItem("��");
  mi32 = new JMenuItem("��");
 
  
  //�޴� ��ġ
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

  mi23.addActionListener(this);//mi23�� �������� ���� 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// x���� �� ���α׷� �������
  frame.setSize(300, 260);// ������ ������(����, ����)
  frame.setVisible(true);// ������ ���
 }
 
 public void actionPerformed(ActionEvent e) {
	  String as = e.getActionCommand();//
	  
	  // �޴��� �̺�Ʈ
	  if ("�ζ��ҷ�".equals(as)) {
	   lotto a = new lotto();
	   a.lotto();//�ζ� �Լ� ȣ��
	  }

	 }

	 // ����
	 public static void main(String[] args) {
	   menu a= new menu();
	   a.menugui();
	 }
}


