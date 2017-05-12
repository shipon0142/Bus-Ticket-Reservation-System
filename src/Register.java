import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.management.Query;
import javax.management.loading.PrivateClassLoader;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.jar.Attributes.Name;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Register extends JFrame {
	Connection con=null;

	private JPanel contentPane;
	private JTextField first_nam;
	private JTextField emai;
	private JTextField contac;
	private JPasswordField passwor;
	private JTextField usernam;
	private JPasswordField passwordField_1;
	private JTextField last_nam;
	private JTextField addres;
	private JTextField postal_cod;
	private ButtonGroup bg = new ButtonGroup();
	String sex;

	/**
	 * Launch the application.
	 */
	public static void Register() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(173, 74, 84, 14);
		contentPane.add(lblName);
		
		first_nam = new JTextField();
		first_nam.setBounds(336, 73, 214, 20);
		contentPane.add(first_nam);
		first_nam.setColumns(10);
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(173, 133, 84, 17);
		contentPane.add(lblUsername);
		
		emai = new JTextField();
		emai.setColumns(10);
		emai.setBounds(336, 133, 214, 20);
		contentPane.add(emai);
		
		JLabel lblEmail = new JLabel("Contact");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(173, 196, 70, 14);
		contentPane.add(lblEmail);
		
		contac = new JTextField();
		contac.setBounds(336, 190, 214, 20);
		contentPane.add(contac);
		contac.setColumns(10);
		
		passwor = new JPasswordField();
		passwor.setBounds(335, 314, 215, 20);
		contentPane.add(passwor);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(173, 320, 98, 14);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmPassword.setBounds(173, 346, 141, 14);
		contentPane.add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(336, 345, 214, 20);
		contentPane.add(passwordField_1);

		JLabel regshow = new JLabel("");
		regshow.setForeground(Color.RED);
		regshow.setFont(new Font("Tahoma", Font.BOLD, 11));
		regshow.setBounds(579, 351, 171, 14);
		contentPane.add(regshow);
		JLabel emailmessege = new JLabel("");
		emailmessege.setForeground(Color.RED);
		emailmessege.setFont(new Font("Tahoma", Font.BOLD, 11));
		emailmessege.setBounds(560, 136, 171, 14);
		contentPane.add(emailmessege);
		JLabel labelcontact = new JLabel("");
		labelcontact.setForeground(Color.RED);
		labelcontact.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelcontact.setBounds(560, 193, 171, 14);
		contentPane.add(labelcontact);
		JLabel labelpostalcode = new JLabel("");
		labelpostalcode.setForeground(Color.RED);
		labelpostalcode.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelpostalcode.setBounds(560, 260, 171, 14);
		contentPane.add(labelpostalcode);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				 con =connection.dbConnection();
				
				try {
					String qurey= "insert into user_info(first_name,last_name,contact,address,postal_code,email,password,user_name,sex,login) values(?,?,?,?,?,?,?,?,?,?)";
					//name =name.getText();
					
					PreparedStatement pst = con.prepareStatement(qurey);
					pst.setString(1,first_nam.getText());
					pst.setString(2,last_nam.getText());
					pst.setString(3,contac.getText());
					pst.setString(4,addres.getText());
					pst.setString(5,postal_cod.getText());
					pst.setString(6,emai.getText());
					
					pst.setString(7,passwor.getText());
					pst.setString(8,usernam.getText());
					pst.setString(9, sex);
					pst.setString(10,"0");

					//JOptionPane.showMessageDialog(null,"Registration");
				String str1=passwor.getText();
				String str2=passwordField_1.getText();
				String emailtext=emai.getText();
				String comp="@gmail.com";
				String comp2="@diu.edu.bd";
				String cont=contac.getText();
				String postext=postal_cod.getText();
				emailmessege.setText("");
				labelcontact.setText("");
				labelpostalcode.setText("");
				regshow.setText("");
				if(emailtext.toString().contains(comp.toString())==true){
					
				}
				else	if(emailtext.toString().contains(comp2.toString())==true){
					
				}
				else{
					emailmessege.setText("Invalid Mail address");
					return;
				}
				
				for(int h=0;h<cont.length();h++){
					if(cont.length()!=11){
						labelcontact.setText("Invalid contact number");
						return;
					}
					if(cont.charAt(h)>='0' && cont.charAt(h)<='9'){
						
					}
					else{
						labelcontact.setText("Invalid contact number");
						return;
					}
				}
				for(int hh=0;hh<postext.length();hh++){
					if(postext.length()!=4){
						labelpostalcode.setText("Invalid postal code");
						return;
					}
					if(postext.charAt(hh)>='0' && postext.charAt(hh)<='9'){
						
					}
					else{
						labelpostalcode.setText("Invalid postal code");
						return;
					}
				}
				
				
			
				      if(str1.equals(str2))	{
				    	  pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registration successful");
				
					LogIn lIn = new LogIn();
					lIn.setVisible(true);
					setVisible(false);
				      }
				      else{
				    	regshow.setText("Password not match");
				    	return;
				      }
					
				
				}
				catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Please Fill up The form Properly");
					
				}
			}
		});
		btnRegister.setBounds(461, 388, 89, 23);
		contentPane.add(btnRegister);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername_1.setBounds(173, 289, 98, 14);
		contentPane.add(lblUsername_1);
		
		usernam = new JTextField();
		usernam.setBounds(336, 283, 214, 20);
		contentPane.add(usernam);
		usernam.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(173, 105, 84, 14);
		contentPane.add(lblLastName);
		
		last_nam = new JTextField();
		last_nam.setColumns(10);
		last_nam.setBounds(336, 104, 214, 20);
		contentPane.add(last_nam);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(173, 227, 84, 14);
		contentPane.add(lblAddress);
		
		addres = new JTextField();
		addres.setBounds(336, 221, 214, 20);
		contentPane.add(addres);
		addres.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPostalCode.setBounds(173, 258, 109, 14);
		contentPane.add(lblPostalCode);
		
		postal_cod = new JTextField();
		postal_cod.setBounds(336, 252, 214, 20);
		contentPane.add(postal_cod);
		postal_cod.setColumns(10);
		
		JRadioButton mal = new JRadioButton("Male");
		mal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sex="Male";
				
				
			}
		});
		
		mal.setBounds(336, 160, 103, 23);
		contentPane.add(mal);
		
		JRadioButton fimal = new JRadioButton("Fimale");
		fimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex="Fimale";
			}
		});
		fimal.setBounds(452, 160, 98, 23);
		contentPane.add(fimal);
		bg.add(mal);
		bg.add(fimal);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSex.setBounds(173, 160, 66, 18);
		contentPane.add(lblSex);
		
		JLabel lblNewLabel = new JLabel("Create Your Ticket Booking Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(180, 25, 434, 20);
		contentPane.add(lblNewLabel);
		
		
		
		
		
	
		
	}
}
