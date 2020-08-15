import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class frmColorForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmColorForm frame = new frmColorForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmColorForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frmColorForm.class.getResource("/images/pudge2.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//Image image = new ImageIcon(this.getClass().getResource("pudge.jpg")).getImage();
		//lblNewLabel.setIcon(new ImageIcon(frmColorForm.class.getResource("/images/pudge.jpg")));
		lblNewLabel.setBounds(12, 2, 281, 241);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Так много мяса, так мало времени");
		lblNewLabel_1.setBounds(12, 289, 281, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Вы поглядите, сколько сочного мяса вокруг!");
		lblNewLabel_2.setBounds(12, 324, 281, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Дело в шляпе");
		lblNewLabel_3.setBounds(12, 353, 281, 16);
		contentPane.add(lblNewLabel_3);
	
		Locale ruLocale = new Locale("ru", "RU");
		ResourceBundle ruMessage = ResourceBundle.getBundle("lang", ruLocale);
		JButton btnNewButton = new JButton("RU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_1.setText(ruMessage.getString("first"));
				lblNewLabel_2.setText(ruMessage.getString("second"));
				lblNewLabel_3.setText(ruMessage.getString("third"));
				lblNewLabel.setIcon(new ImageIcon(frmColorForm.class.getResource("/images/pudge2.png")));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			}
		});
		btnNewButton.setBounds(350, 285, 97, 25);
		contentPane.add(btnNewButton);
		
		Locale enLocale = new Locale("en", "EN");
		ResourceBundle enMessage = ResourceBundle.getBundle("lang", enLocale);
		JButton btnNewButton_1 = new JButton("EN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText(enMessage.getString("first"));
				lblNewLabel_2.setText(enMessage.getString("second"));
				lblNewLabel_3.setText(enMessage.getString("third"));
				lblNewLabel.setIcon(new ImageIcon(frmColorForm.class.getResource("/images/pudge1.png")));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			}
		});
		btnNewButton_1.setBounds(350, 324, 97, 25);
		contentPane.add(btnNewButton_1);
		
		Locale deLocale = new Locale("de","DE");
		ResourceBundle deMessage = ResourceBundle.getBundle("lang",deLocale);
		JButton btnNewButton_2 = new JButton("DE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText(deMessage.getString("first"));
				lblNewLabel_2.setText(deMessage.getString("second"));
				lblNewLabel_3.setText(deMessage.getString("third"));
				lblNewLabel.setIcon(new ImageIcon(frmColorForm.class.getResource("/images/pudge3.png")));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			}
		});
		btnNewButton_2.setBounds(350, 364, 97, 25);
		contentPane.add(btnNewButton_2);
		
		
		Locale saveLocale = new Locale("sv");
		ResourceBundle saveMessage = ResourceBundle.getBundle("save",saveLocale);
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String a = lblNewLabel_1.getText();
				//String b = lblNewLabel_2.getText();
				//String c = lblNewLabel_3.getText();
				//String d = lblNewLabel.getIcon().toString();
				try {
				File file = new File("Save.txt");
				if(!file.exists())
					file.createNewFile();
				
					PrintWriter pw = new PrintWriter(file);
					pw.println(lblNewLabel_1.getText());
					pw.println(lblNewLabel_2.getText());
					pw.println(lblNewLabel_3.getText());
					pw.println(lblNewLabel.getIcon());
					pw.close();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_3.setBounds(350, 55, 97, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Load");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader br = new BufferedReader(new FileReader("Save.txt"));
					//String line;
						lblNewLabel_1.setText(br.readLine());
						lblNewLabel_2.setText(br.readLine());
						lblNewLabel_3.setText(br.readLine());
						String a = "file:/C:/Users/pshenin/eclipse-workspace/SwingOne/bin/images/pudge1.png";
						String b = "file:/C:/Users/pshenin/eclipse-workspace/SwingOne/bin/images/pudge2.png";
						String c = "file:/C:/Users/pshenin/eclipse-workspace/SwingOne/bin/images/pudge3.png";
						String d = br.readLine();
						if(d.equals(a)) {
							lblNewLabel.setIcon(new ImageIcon(frmColorForm.class.getResource("/images/pudge1.png")));
						}
						else if(d.equals(b)) {
							lblNewLabel.setIcon(new ImageIcon(frmColorForm.class.getResource("/images/pudge2.png")));
						}
						else{
							lblNewLabel.setIcon(new ImageIcon(frmColorForm.class.getResource("/images/pudge3.png")));
						}
						
						//lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(350, 107, 97, 25);
		contentPane.add(btnNewButton_4);
		
		
		
		
	}
}
