package ua.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class App extends JFrame 
{

	public App() {
		super("Dota2Pudge");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		setLayout(null);
		URL url = this.getClass().getClassLoader().getResource("pudge1.png");
		ImageIcon pudge1 = new ImageIcon(url);
		ImageIcon pudge2 = new ImageIcon("pudge2.png");

		JLabel label1 = new JLabel(new ImageIcon(url));
		JLabel label2 = new JLabel(pudge2);
		JTextArea text1 = new JTextArea(textFromResources("/pudge.txt"));
		JTextArea text2 = new JTextArea(textNearJar("pudge2.txt"));


		text1.setBounds(0, pudge1.getIconHeight(), pudge1.getIconWidth(), 130);
		text2.setBounds(pudge1.getIconWidth(), pudge1.getIconHeight(), pudge2.getIconWidth(), 130);
		//text.setLineWrap(true);
		label1.setBounds(0, 0, pudge1.getIconWidth(), pudge1.getIconHeight());
		label2.setBounds(pudge1.getIconWidth(),0,pudge2.getIconWidth(),pudge1.getIconHeight());
		add(label1);
		add(label2);
		add(text1);
		add(text2);
		setVisible(true);



	}

	public String textFromResources (String file) {
		InputStream is = App.class.getResourceAsStream(file);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		String storeAllString="";  

		try {
			while(true)  
			{  
				String temp=buffer.readLine();
				if(temp!=null) {
					storeAllString=storeAllString+temp+"\n"; 
				}
				else {
					break;
				}
			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return storeAllString;
	}

	public String textNearJar (String file) {
		File f = new File(file);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		String st=""; 
		while(true)  
		{  
			String temp;
			temp ="";
			try {
				temp = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(temp!=null) {
				st=st+temp+"\n"; 
				System.out.println(temp);
			}
			else {
				break;
			}
		}


		return st;
	}


	public static void main( String[] args )
	{
		new App();

	}
}
