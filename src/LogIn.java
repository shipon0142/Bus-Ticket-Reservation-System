import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;
import java.io.FilterInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;

import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;
import javax.swing.DropMode;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class LogIn extends JFrame {
	private JTextField txt1;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		LogIn frame = new LogIn();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   Connection conn = null;
   private JPasswordField pwdErf;
   
   
	public LogIn() {
		setType(Type.UTILITY);
		setForeground(Color.DARK_GRAY);
		setLocationByPlatform(true);
		setTitle("Project");
		first();
		conn = connection.dbConnection();	
	}
	 public  void first(){
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 889, 526);
			JPanel contentPane = new JPanel();
			contentPane.setBackground(new Color(135, 206, 235));
			contentPane.setBorder(new LineBorder(Color.DARK_GRAY, 10));
			contentPane.setForeground(Color.YELLOW);
			contentPane.setToolTipText("");
			setContentPane(contentPane);
			
			txt1 = new JTextField();
			txt1.setToolTipText("Username");
			txt1.setFont(new Font("Tahoma", Font.BOLD, 11));
			txt1.setForeground(Color.BLACK);
			txt1.setBounds(612, 195, 187, 20);
			txt1.setColumns(10);
			JButton btnLogIn = new JButton("Log In");
			btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnLogIn.setForeground(Color.DARK_GRAY);
			btnLogIn.setBounds(717, 283, 82, 23);
			JLabel smess = new JLabel("");
			smess.setForeground(Color.RED);
			smess.setFont(new Font("Tahoma", Font.BOLD, 11));
			smess.setBounds(612, 339, 187, 23);
			contentPane.add(smess);
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						String query="Select * from user_info where user_name = ? and password=?";
						PreparedStatement pStatement = conn.prepareStatement(query);
						pStatement.setString(1, txt1.getText());
						pStatement.setString(2, pwdErf.getText());
						ResultSet rs = pStatement.executeQuery();
						int co=0;
						while(rs.next()){
							String quer="update user_info set login=1 where user_name='"+txt1.getText()+"' and password='"+pwdErf.getText()+"'";
							co=1;
						pStatement = conn.prepareStatement(quer);
						pStatement.executeUpdate();
						Welcome fr= new Welcome();
				     	fr.setVisible(true);
				     	setVisible(false);
					    break;
						}
						if(co==0){
							smess.setText("Incorrect Username or Password");
							txt1.setText("");
							pwdErf.setText("");
						}
					}
					catch(Exception ex){
						ex.printStackTrace();
						
					}
					
				}
			});
			
			JLabel us = new JLabel("User Name :");
			us.setForeground(Color.BLUE);
			us.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			us.setBounds(520, 195, 72, 20);
			
			JLabel pa = new JLabel("PassWord :");
			pa.setForeground(Color.BLUE);
			pa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			pa.setBounds(520, 247, 82, 14);
			
			JButton btnRegister = new JButton("Sign Up");
			btnRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnRegister.setForeground(Color.DARK_GRAY);
			btnRegister.setBounds(612, 283, 82, 23);
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Register rg = new Register();
					rg.setVisible(true);
				}
			});
			
			pwdErf = new JPasswordField();
			pwdErf.setToolTipText("Password");
			pwdErf.setBounds(612, 241, 187, 20);
			contentPane.setLayout(null);
			contentPane.add(txt1);
			contentPane.add(btnLogIn);
			contentPane.add(us);
			contentPane.add(pa);
			contentPane.add(btnRegister);
			contentPane.add(pwdErf);
			
			JLabel lblLogIn = new JLabel("LogIn Panel");
			lblLogIn.setForeground(Color.BLUE);
			lblLogIn.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 16));
			lblLogIn.setBounds(520, 136, 94, 48);
			contentPane.add(lblLogIn);
			
			JLabel label = new JLabel("");
			Image img = new ImageIcon(this.getClass().getResource("/bus.png")).getImage();
			label.setIcon(new ImageIcon(img));
			
			label.setBounds(79, 98, 382, 225);
			contentPane.add(label);
			
			JLabel lblNewLabel = new JLabel("Bus Ticket Reservation System");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel.setBounds(251, 29, 432, 36);
			contentPane.add(lblNewLabel);
			
			
	    	
	    }
}
