import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.management.Query;
import javax.print.DocFlavor.STRING;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ticket extends JFrame {
public static String mess,email,username;
	private JPanel contentPane;
	Connection conn = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
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
	public Ticket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlevelbusname = new JLabel("");
		jlevelbusname.setForeground(new Color(0, 0, 128));
		jlevelbusname.setFont(new Font("Tahoma", Font.BOLD, 20));
		jlevelbusname.setBounds(382, 47, 236, 27);
		contentPane.add(jlevelbusname);
		
		JLabel lblNewLabel_1 = new JLabel("Ticket");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(107, 49, 61, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name Of Passenger:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setBounds(62, 124, 180, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel jlevelname = new JLabel("");
		jlevelname.setForeground(new Color(0, 0, 128));
		jlevelname.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlevelname.setBounds(252, 124, 180, 21);
		contentPane.add(jlevelname);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setForeground(new Color(0, 0, 128));
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhone.setBounds(176, 188, 66, 21);
		contentPane.add(lblPhone);
		
		JLabel jlevelphone = new JLabel("");
		jlevelphone.setForeground(new Color(0, 0, 128));
		jlevelphone.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlevelphone.setBounds(252, 188, 180, 21);
		contentPane.add(jlevelphone);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(new Color(0, 0, 128));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(155, 220, 80, 21);
		contentPane.add(lblAddress);
		
		JLabel jleveladdress = new JLabel("");
		jleveladdress.setForeground(new Color(0, 0, 128));
		jleveladdress.setFont(new Font("Tahoma", Font.BOLD, 16));
		jleveladdress.setBounds(252, 220, 277, 21);
		contentPane.add(jleveladdress);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(176, 156, 61, 21);
		contentPane.add(lblEmail);
		
		JLabel jlevelmail = new JLabel("");
		jlevelmail.setForeground(new Color(0, 0, 128));
		jlevelmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlevelmail.setBounds(252, 156, 217, 21);
		contentPane.add(jlevelmail);
		
		JLabel lblDateOfJourney = new JLabel("Date Of Journey:");
		lblDateOfJourney.setForeground(new Color(0, 0, 128));
		lblDateOfJourney.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateOfJourney.setBounds(454, 188, 146, 21);
		contentPane.add(lblDateOfJourney);
		
		JLabel jleveldate = new JLabel("15-APRIL-2017");
		jleveldate.setForeground(new Color(0, 0, 128));
		jleveldate.setFont(new Font("Tahoma", Font.BOLD, 16));
		jleveldate.setBounds(610, 188, 180, 21);
		contentPane.add(jleveldate);
		
		JLabel lblDeparture = new JLabel("Departure:");
		lblDeparture.setForeground(new Color(0, 0, 128));
		lblDeparture.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDeparture.setBounds(503, 220, 96, 21);
		contentPane.add(lblDeparture);
		
		JLabel jleveltime = new JLabel("9.00 A.M");
		jleveltime.setForeground(new Color(0, 0, 128));
		jleveltime.setFont(new Font("Tahoma", Font.BOLD, 16));
		jleveltime.setBounds(610, 220, 208, 21);
		contentPane.add(jleveltime);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setForeground(new Color(0, 0, 128));
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFrom.setBounds(539, 124, 61, 21);
		contentPane.add(lblFrom);
		
		JLabel jlevelfrom = new JLabel("");
		jlevelfrom.setForeground(new Color(0, 0, 128));
		jlevelfrom.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlevelfrom.setBounds(610, 124, 222, 21);
		contentPane.add(jlevelfrom);
		
		JLabel yyyuuu = new JLabel("To:");
		yyyuuu.setForeground(new Color(0, 0, 128));
		yyyuuu.setFont(new Font("Tahoma", Font.BOLD, 16));
		yyyuuu.setBounds(559, 156, 41, 21);
		contentPane.add(yyyuuu);
		
		JLabel jlevelto = new JLabel("");
		jlevelto.setForeground(new Color(0, 0, 128));
		jlevelto.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlevelto.setBounds(610, 156, 222, 21);
		contentPane.add(jlevelto);
		
		JLabel lblSeatNo = new JLabel("Seat No:");
		lblSeatNo.setForeground(new Color(0, 0, 128));
		lblSeatNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeatNo.setBounds(520, 252, 73, 21);
		contentPane.add(lblSeatNo);
		
		JLabel jpaneseatno = new JLabel("A1,C4");
		jpaneseatno.setForeground(new Color(0, 0, 128));
		jpaneseatno.setFont(new Font("Tahoma", Font.BOLD, 16));
		jpaneseatno.setBounds(610, 252, 253, 21);
		contentPane.add(jpaneseatno);
		
		JLabel lblTotalTaka = new JLabel("Total Taka:");
		lblTotalTaka.setForeground(new Color(0, 0, 128));
		lblTotalTaka.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalTaka.setBounds(492, 284, 101, 21);
		contentPane.add(lblTotalTaka);
		
		JLabel jlevelprice = new JLabel("1100");
		jlevelprice.setForeground(new Color(0, 0, 128));
		jlevelprice.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlevelprice.setBounds(610, 284, 180, 21);
		contentPane.add(jlevelprice);
		
		JLabel lblDateOfIssue = new JLabel("Date Of Issue:");
		lblDateOfIssue.setForeground(new Color(0, 0, 128));
		lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateOfIssue.setBounds(101, 252, 122, 21);
		contentPane.add(lblDateOfIssue);
		
		JLabel jleveldd = new JLabel("14-APRIL-2017");
		jleveldd.setForeground(new Color(0, 0, 128));
		jleveldd.setFont(new Font("Tahoma", Font.BOLD, 16));
		jleveldd.setBounds(252, 252, 180, 21);
		contentPane.add(jleveldd);
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		 Calendar calobj = Calendar.getInstance();
	    //   System.out.println(df.format(calobj.getTime()));
		
		jleveldd.setText(df.format(calobj.getTime()));
		JLabel jlevelmessege = new JLabel("A confirmation message has been sent to your mail. Please check your mail.");
		jlevelmessege.setForeground(new Color(255, 0, 0));
		jlevelmessege.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlevelmessege.setBounds(62, 339, 680, 43);
		contentPane.add(jlevelmessege);
		jpaneseatno.setText(Bus_info.passvalue().toString());
		jlevelprice.setText(Bus_info.passprice().toString());
		jleveldate.setText(Bus_info.passdate().toString());
		jlevelfrom.setText(Bus_info.passfrom().toString());
		jlevelto.setText(Bus_info.passto().toString());
		jleveltime.setText(Bus_info.passtime().toString());
		jlevelbusname.setText(Bus_info.passbusname().toString());
		
		JLabel tusername = new JLabel("");
		tusername.setForeground(Color.BLUE);
		tusername.setFont(new Font("Tahoma", Font.BOLD, 16));
		tusername.setBounds(646, 25, 96, 27);
		contentPane.add(tusername);
		tusername.setText(Bus_info.passusername().toString());
		
		JButton btnNewButton = new JButton("Sign Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="update user_info set login=0 where login=1";
					PreparedStatement pStatement=conn.prepareStatement(query);
					pStatement.executeUpdate();
					
				}
				catch (Exception ex) {
				}
				
				setVisible(false);
				
				LogIn lIn =new LogIn();
				lIn.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(743, 28, 89, 23);
		contentPane.add(btnNewButton);
	 conn=connection.dbConnection();
	try {
	String query="select * from user_info where login=1";
	       PreparedStatement pStatement= conn.prepareStatement(query);
	 ResultSet resultSet=pStatement.executeQuery();
	 while(resultSet.next()){
		  jlevelname.setText(resultSet.getString(4)+" "+resultSet.getString(5));
	  jleveladdress.setText(resultSet.getString(7));
	 jlevelphone.setText(resultSet.getString(6));
	 jlevelmail.setText(resultSet.getString(2));
	  mess="Dear "+resultSet.getString(4)+" "+resultSet.getString(5)+","+System.lineSeparator()+"We approved Your booking ticket."
	  		+ " You will get your ticket within 24 hour by home delivery. You are going from "+Bus_info.passfrom().toString()+" to "
			  +Bus_info.passto().toString()+". Journey Date: "+Bus_info.passdate().toString()+" at "+Bus_info.passtime().toString()+"."
			  +" Your seats: "+Bus_info.passvalue().toString()+" Total Price : "+Bus_info.passprice.toString()+
		              " Have a safe journey. Thank You.";
	  email = resultSet.getString(2);
		SendMailSSL sendMailSSL=new SendMailSSL();
		sendMailSSL.main(null);
		  break;
	 }  
	} catch (Exception e) {
	}
	}
	public static String passmessege(){
		return mess;
	}
	public static String passmail(){
		return email;
	}
}
