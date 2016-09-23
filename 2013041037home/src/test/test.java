package test;

import java.io.*;


public class test {
	

	public static void main(String[] args) {
		String s= new String();
		String logindata[] = null;
		// TODO Auto-generated method stub
		File m_file = new File("text");
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
	}

}
