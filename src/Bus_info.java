import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.ColorSelectionModel;

import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

public class Bus_info extends JFrame {

	private JPanel contentPane;
  public static String db_seat;
  private static int a1=0,b1=0,c1=0,d1=0,a2=0,b2=0,c2=0,d2=0,a3=0,b3=0,c3=0,d3=0,a4=0,b4=0,c4=0,d4=0;
  private static int e1=0,f1=0,g1=0,h1=0,e2=0,f2=0,g2=0,h2=0,e3=0,f3=0,g3=0,h3=0,e4=0,f4=0,g4=0,h4=0;
  private static int i1=0,j1=0,i2=0,j2=0,i3=0,j3=0,i4=0,j4=0,pric,num;
  public static String booking_seat="",pass_seat="",passprice="",from="",to="",dat,tim,buname,busername;
  /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bus_info frame = new Bus_info();
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
	public Bus_info() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String bus_i=Welcome.bString();
		int bus=Integer.parseInt(bus_i);
	Connection	conn = connection.dbConnection();
		try {
			
			String query="select * from bus_seat where bus_id = "+bus;
			
			PreparedStatement pSt=conn.prepareStatement(query);
			
			ResultSet rSet=pSt.executeQuery();
	   
			while(rSet.next()){
				db_seat=rSet.getString("book_seat");
			   }
			
		    	
		    	
			
			
		} 
	     	catch (Exception ex) {
			// TODO: handle exception
	    	}
		JLabel fname = new JLabel("");
		fname.setForeground(new Color(0, 0, 128));
		fname.setFont(new Font("Tahoma", Font.BOLD, 16));
		fname.setBounds(424, 166, 105, 29);
		contentPane.add(fname);
		
		JLabel toname = new JLabel("");
		toname.setForeground(new Color(0, 0, 128));
		toname.setFont(new Font("Tahoma", Font.BOLD, 16));
		toname.setBounds(637, 168, 139, 25);
		contentPane.add(toname);
		JLabel date = new JLabel("");
		date.setForeground(new Color(0, 0, 128));
		date.setFont(new Font("Tahoma", Font.BOLD, 16));
		date.setBounds(424, 206, 126, 19);
		contentPane.add(date);
		JLabel time = new JLabel("");
		time.setForeground(new Color(0, 0, 128));
		time.setFont(new Font("Tahoma", Font.BOLD, 16));
		time.setBounds(637, 206, 89, 17);
		contentPane.add(time);
		JLabel vseat = new JLabel("");
		vseat.setForeground(new Color(0, 0, 128));
		vseat.setFont(new Font("Tahoma", Font.BOLD, 16));
		vseat.setBounds(424, 236, 262, 23);
		contentPane.add(vseat);
		JLabel pr = new JLabel("");
		pr.setForeground(new Color(0, 0, 128));
		pr.setFont(new Font("Tahoma", Font.BOLD, 16));
		pr.setBounds(424, 275, 141, 25);
		contentPane.add(pr);
		JLabel bname = new JLabel("");
		bname.setForeground(new Color(25, 25, 112));
		bname.setFont(new Font("Tahoma", Font.BOLD, 18));
		bname.setBounds(478, 124, 208, 31);
		contentPane.add(bname);
		JLabel lblPleaseSelectAn = new JLabel("");
		lblPleaseSelectAn.setForeground(new Color(255, 0, 0));
		lblPleaseSelectAn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPleaseSelectAn.setBounds(69, 385, 189, 32);
		contentPane.add(lblPleaseSelectAn);
		try {
			String qu="SELECT * from route_info where bus_id = "+bus;
			PreparedStatement preparedStatement =conn.prepareStatement(qu);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				 from= resultSet.getString(1);
				 to=resultSet.getString(2);
				 dat=resultSet.getString(5)+"-"+resultSet.getString(10)+"-"+resultSet.getString(7);
			    tim=resultSet.getString(6);
				pric= resultSet.getInt(12);
				buname=resultSet.getString(9);
				fname.setText(from);
				toname.setText(to);
				date.setText(dat);
				time.setText(tim);
				bname.setText(buname);
				
				
				
			}
			
		} catch (Exception e5) {
			// TODO: handle exception
		}
	num=0;
	Image img1 = new ImageIcon(this.getClass().getResource("/seat.png")).getImage();
		Button A1 = new Button("A1");
		A1.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		
		A1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(a1==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					a1=2;
					booking_seat=booking_seat+"A1,";
					vseat.setText(booking_seat);
				
					A1.setBackground(Color.DARK_GRAY);
				}
				else if(a1==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("A1,","");
					vseat.setText(booking_seat);
					a1=0;
					A1.setBackground(Color.WHITE);
				}
			}
		});
		A1.setBounds(70, 68, 33, 22);
		contentPane.add(A1);
		
		Button A2 = new Button("A2");
		A2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(a2==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"A2,";
					vseat.setText(booking_seat);	
					a2=2;
					A2.setBackground(Color.DARK_GRAY);
				}
				else if(a2==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("A2,","");
					vseat.setText(booking_seat);
					a2=0;
					A2.setBackground(Color.WHITE);
				}
			}
		});
		A2.setBounds(109, 68, 33, 22);
		contentPane.add(A2);
		
		Button B1 = new Button("B1");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b1==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"B1,";
					vseat.setText(booking_seat);
					b1=2;
					B1.setBackground(Color.DARK_GRAY);
				}
				else if(b1==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("B1,","");
					vseat.setText(booking_seat);
					b1=0;
					B1.setBackground(Color.WHITE);
				}
			}
		});
		B1.setBounds(70, 96, 33, 22);
		contentPane.add(B1);
		
		Button B2 = new Button("B2");
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b2==0){
					booking_seat=booking_seat+"B2,";
					vseat.setText(booking_seat);
					num++;
					pr.setText(Integer.toString(pric*num));
					
					b2=2;
					B2.setBackground(Color.DARK_GRAY);
				}
				else if(b2==2){
					booking_seat=booking_seat.replace("B2,","");
					vseat.setText(booking_seat);
					b2=0;
					num--;
					pr.setText(Integer.toString(pric*num));
					B2.setBackground(Color.WHITE);
				}
			}
		});
		B2.setBounds(109, 96, 33, 22);
		contentPane.add(B2);
		
		Button C1 = new Button("C1");
		C1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c1==0){
					booking_seat=booking_seat+"C1,";
					vseat.setText(booking_seat);
					num++;
					pr.setText(Integer.toString(pric*num));
					c1=2;
					C1.setBackground(Color.DARK_GRAY);
				}
				else if(c1==2){
				num--;
				pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("C1,","");
					vseat.setText(booking_seat);
					c1=0;
					C1.setBackground(Color.WHITE);
				}
			}
		});
		C1.setBounds(70, 124, 33, 22);
		contentPane.add(C1);
		
		Button C2 = new Button("C2");
		C2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c2==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"C2,";
					vseat.setText(booking_seat);
					
					c2=2;
					C2.setBackground(Color.DARK_GRAY);
				}
				else if(c2==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("C2,","");
					vseat.setText(booking_seat);
					c2=0;
					C2.setBackground(Color.WHITE);
				}
			}
		});
		C2.setBounds(109, 124, 33, 22);
		contentPane.add(C2);
		
		Button D1 = new Button("D1");
		D1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(d1==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"D1,";
					vseat.setText(booking_seat);
					d1=2;
					D1.setBackground(Color.DARK_GRAY);
				}
				else if(d1==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("D1,","");
					vseat.setText(booking_seat);
					d1=0;
					D1.setBackground(Color.WHITE);
				}
			}
		});
		D1.setBounds(70, 152, 33, 22);
		contentPane.add(D1);
		
		Button D2 = new Button("D2");
		D2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(d2==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"D2,";
					vseat.setText(booking_seat);
					
					d2=2;
					D2.setBackground(Color.DARK_GRAY);
				}
				else if(d2==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("D2,","");
					vseat.setText(booking_seat);
					d2=0;
					D2.setBackground(Color.WHITE);
				}
			}
		});
		D2.setBounds(109, 152, 33, 22);
		contentPane.add(D2);
		
		Button E1 = new Button("E1");
		E1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e1==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"E1,";
					vseat.setText(booking_seat);
					e1=2;
					E1.setBackground(Color.DARK_GRAY);
				}
				else if(e1==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("E1,","");
					vseat.setText(booking_seat);
					e1=0;
					E1.setBackground(Color.WHITE);
				}
			}
		});
		E1.setBounds(70, 180, 33, 22);
		contentPane.add(E1);
		
		Button E2 = new Button("E2");
		E2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e2==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					
					booking_seat=booking_seat+"E2,";
					vseat.setText(booking_seat);
					e2=2;
					E2.setBackground(Color.DARK_GRAY);
				}
				else if(e2==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("E2,","");
					vseat.setText(booking_seat);
					e2=0;
					E2.setBackground(Color.WHITE);
				}
			}
		});
		E2.setBounds(109, 180, 33, 22);
		contentPane.add(E2);
		
		Button F1 = new Button("F1");
		F1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f1==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"F1,";
					vseat.setText(booking_seat);
					f1=2;
					F1.setBackground(Color.DARK_GRAY);
				}
				else if(f1==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("F1,","");
					vseat.setText(booking_seat);
					f1=0;
					F1.setBackground(Color.WHITE);
				}
			}
		});
		F1.setBounds(70, 208, 33, 22);
		contentPane.add(F1);
		
		Button F2 = new Button("F2");
		F2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f2==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"F2,";
					vseat.setText(booking_seat);
					f2=2;
					F2.setBackground(Color.DARK_GRAY);
				}
				else if(f2==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("F2,","");
					vseat.setText(booking_seat);
					f2=0;
					F2.setBackground(Color.WHITE);
				}
			}
		});
		F2.setBounds(109, 208, 33, 22);
		contentPane.add(F2);
		
		Button G1 = new Button("G1");
		G1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(g1==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"G1,";
					vseat.setText(booking_seat);
					g1=2;
					G1.setBackground(Color.DARK_GRAY);
				}
				else if(g1==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("G1,","");
					vseat.setText(booking_seat);
					g1=0;
					G1.setBackground(Color.WHITE);
				}
			}
		});
		G1.setBounds(70, 236, 33, 22);
		contentPane.add(G1);
		
		Button G2 = new Button("G2");
		G2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(g2==0){
					num++;
						pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"G2,";
					vseat.setText(booking_seat);
					g2=2;
					G2.setBackground(Color.DARK_GRAY);
				}
				else if(g2==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("G2,","");
					vseat.setText(booking_seat);
					g2=0;
					G2.setBackground(Color.WHITE);
				}
			}
		});
		G2.setBounds(109, 236, 33, 22);
		contentPane.add(G2);
		
		Button H1 = new Button("H1");
		H1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(h1==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"H1,";
					vseat.setText(booking_seat);
					h1=2;
					H1.setBackground(Color.DARK_GRAY);
				}
				else if(h1==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("H1,","");
					vseat.setText(booking_seat);
					h1=0;
					H1.setBackground(Color.WHITE);
				}
			}
		});
		H1.setBounds(70, 265, 33, 22);
		contentPane.add(H1);
		
		Button I1 = new Button("I1");
		I1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i1==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"I1,";
					vseat.setText(booking_seat);
					i1=2;
					I1.setBackground(Color.DARK_GRAY);
				}
				else if(i1==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("I1,","");
					vseat.setText(booking_seat);
					i1=0;
					I1.setBackground(Color.WHITE);
				}
			}
		});
		I1.setBounds(70, 296, 33, 22);
		contentPane.add(I1);
		
		Button J1 = new Button("J1");
		J1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(j1==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"J1,";
					vseat.setText(booking_seat);
					j1=2;
					J1.setBackground(Color.DARK_GRAY);
				}
				else if(j1==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("J1,","");
					vseat.setText(booking_seat);
					j1=0;
					J1.setBackground(Color.WHITE);
				}
			}
		});
		J1.setBounds(70, 324, 33, 22);
		contentPane.add(J1);
		
		Button H2 = new Button("H2");
		H2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(h2==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"H2,";
					vseat.setText(booking_seat);

					h2=2;
					H2.setBackground(Color.DARK_GRAY);
				}
				else if(h2==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("H2,","");
					vseat.setText(booking_seat);
					h2=0;
					H2.setBackground(Color.WHITE);
				}
			}
		});
		H2.setBounds(109, 264, 33, 22);
		contentPane.add(H2);
		
		Button I2 = new Button("I2");
		I2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i2==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"I2,";
					vseat.setText(booking_seat);
					i2=2;
					I2.setBackground(Color.DARK_GRAY);
				}
				else if(i2==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("I2,","");
					vseat.setText(booking_seat);
					i2=0;
					I2.setBackground(Color.WHITE);
				}
			}
		});
		I2.setBounds(109, 296, 33, 22);
		contentPane.add(I2);
		
		Button J2 = new Button("J2");
		J2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(j2==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"J2,";
					vseat.setText(booking_seat);

					j2=2;
					J2.setBackground(Color.DARK_GRAY);
				}
				else if(j2==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("J2,","");
					vseat.setText(booking_seat);
					j2=0;
					J2.setBackground(Color.WHITE);
				}
			}
		});
		J2.setBounds(109, 324, 33, 22);
		contentPane.add(J2);
		
		Button A3 = new Button("A3");
		A3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(a3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"A3,";
					vseat.setText(booking_seat);
				
					a3=2;
					A3.setBackground(Color.DARK_GRAY);
				}
				else if(a3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("A3,","");
					vseat.setText(booking_seat);
					a3=0;
					A3.setBackground(Color.WHITE);
				}
			}
		});
		A3.setBounds(176, 68, 33, 22);
		contentPane.add(A3);
		
		Button B3 = new Button("B3");
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"B3,";
					vseat.setText(booking_seat);
			
					b3=2;
					B3.setBackground(Color.DARK_GRAY);
				}
				else if(b3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("B3,","");
					vseat.setText(booking_seat);
					b3=0;
					B3.setBackground(Color.WHITE);
				}
			}
		});
		B3.setBounds(176, 96, 33, 22);
		contentPane.add(B3);
		
		Button C3 = new Button("C3");
		C3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"C3,";
					vseat.setText(booking_seat);
					c3=2;
					C3.setBackground(Color.DARK_GRAY);
				}
				else if(c3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("C3,","");
					vseat.setText(booking_seat);
					c3=0;
					C3.setBackground(Color.WHITE);
				}
			}
		});
		C3.setBounds(176, 124, 33, 22);
		contentPane.add(C3);
		
		Button D3 = new Button("D3");
		D3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(d3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"D3,";
					vseat.setText(booking_seat);
					d3=2;
					D3.setBackground(Color.DARK_GRAY);
				}
				else if(d3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("D3,","");
					vseat.setText(booking_seat);
					d3=0;
					D3.setBackground(Color.WHITE);
				}
			}
		});
		D3.setBounds(176, 152, 33, 22);
		contentPane.add(D3);
		
		Button E3 = new Button("E3");
		E3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"E3,";
					vseat.setText(booking_seat);
					
					e3=2;
					E3.setBackground(Color.DARK_GRAY);
				}
				else if(e3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("E3,","");
					vseat.setText(booking_seat);
					e3=0;
					E3.setBackground(Color.WHITE);
				}
			}
		});
		E3.setBounds(176, 180, 33, 22);
		contentPane.add(E3);
		
		Button F3 = new Button("F3");
		F3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"F3,";
					vseat.setText(booking_seat);
					f3=2;
					F3.setBackground(Color.DARK_GRAY);
				}
				else if(f3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("F3,","");
					vseat.setText(booking_seat);
					f3=0;
					F3.setBackground(Color.WHITE);
				}
			}
		});
		F3.setBounds(176, 208, 33, 22);
		contentPane.add(F3);
		
		Button G3 = new Button("G3");
		G3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(g3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"G3,";
					vseat.setText(booking_seat);

					g3=2;
					G3.setBackground(Color.DARK_GRAY);
				}
				else if(g3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("G3,","");
					vseat.setText(booking_seat);
					g3=0;
					G3.setBackground(Color.WHITE);
				}
			}
		});
		G3.setBounds(176, 236, 33, 22);
		contentPane.add(G3);
		
		Button H3 = new Button("H3");
		H3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(h3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"H3,";
					vseat.setText(booking_seat);
					h3=2;
					H3.setBackground(Color.DARK_GRAY);
				}
				else if(h3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("H3,","");
					vseat.setText(booking_seat);
					h3=0;
					H3.setBackground(Color.WHITE);
				}
			}
		});
		H3.setBounds(176, 265, 33, 22);
		contentPane.add(H3);
		
		Button I3 = new Button("I3");
		I3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"I3,";
					vseat.setText(booking_seat);
					i3=2;
					I3.setBackground(Color.DARK_GRAY);
				}
				else if(i3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("I3,","");
					vseat.setText(booking_seat);
					i3=0;
					I3.setBackground(Color.WHITE);
				}
			}
		});
		I3.setBounds(176, 296, 33, 22);
		contentPane.add(I3);
		
		Button J3 = new Button("J3");
		J3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(j3==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"J3,";
					vseat.setText(booking_seat);
					j3=2;
					J3.setBackground(Color.DARK_GRAY);
				}
				else if(j3==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("J3,","");
					vseat.setText(booking_seat);
					j3=0;
					J3.setBackground(Color.WHITE);
				}
			}
		});
		J3.setBounds(176, 324, 33, 22);
		contentPane.add(J3);
		
		Button A4 = new Button("A4");
		A4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"A4,";
					vseat.setText(booking_seat);
				
					a4=2;
					A4.setBackground(Color.DARK_GRAY);
				}
				else if(a4==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("A4,","");
					vseat.setText(booking_seat);
					a4=0;
					A4.setBackground(Color.WHITE);
				}
			}
		});
		A4.setBounds(215, 68, 33, 22);
		contentPane.add(A4);
		
		Button B4 = new Button("B4");
		B4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"B4,";
					vseat.setText(booking_seat);
					b4=2;
					B4.setBackground(Color.DARK_GRAY);
				}
				else if(b4==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("B4,","");
					vseat.setText(booking_seat);
					b4=0;
					B4.setBackground(Color.WHITE);
				}
			}
		});
		B4.setBounds(215, 96, 33, 22);
		contentPane.add(B4);
		
		Button C4 = new Button("C4");
		C4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"C4,";
					vseat.setText(booking_seat);
					
					c4=2;
					C4.setBackground(Color.DARK_GRAY);
				}
				else if(c4==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("C4,","");
					vseat.setText(booking_seat);
					c4=0;
					C4.setBackground(Color.WHITE);
				}
			}
		});
		C4.setBounds(215, 124, 33, 22);
		contentPane.add(C4);
		
		Button D4 = new Button("D4");
		D4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(d4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"D4,";
					vseat.setText(booking_seat);
					d4=2;
					D4.setBackground(Color.DARK_GRAY);
				}
				else if(d4==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("D4,","");
					vseat.setText(booking_seat);
					d4=0;
					D4.setBackground(Color.WHITE);
				}
			}
		});
		D4.setBounds(215, 152, 33, 22);
		contentPane.add(D4);
		
		Button E4 = new Button("E4");
		E4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"E4,";
					vseat.setText(booking_seat);
					e4=2;
					E4.setBackground(Color.DARK_GRAY);
				}
				else if(e4==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("E4,","");
					vseat.setText(booking_seat);
					e4=0;
					E4.setBackground(Color.WHITE);
				}
			}
		});
		E4.setBounds(215, 180, 33, 22);
		contentPane.add(E4);
		
		Button F4 = new Button("F4");
		F4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(f4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"F4,";
					vseat.setText(booking_seat);
					f4=2;
					F4.setBackground(Color.DARK_GRAY);
				}
				else if(f4==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("F4,","");
					vseat.setText(booking_seat);
					f4=0;
					F4.setBackground(Color.WHITE);
				}
			}
		});
		F4.setBounds(215, 208, 33, 22);
		contentPane.add(F4);
		
		Button G4 = new Button("G4");
		G4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(g4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"G4,";
					vseat.setText(booking_seat);

					g4=2;
					G4.setBackground(Color.DARK_GRAY);
				}
				else if(g4==2){
					num--;
					pr.setText(Integer.toString(pric*num));

					booking_seat=booking_seat.replace("G4,","");
					vseat.setText(booking_seat);
					g4=0;
					G4.setBackground(Color.WHITE);
				}
			}
		});
		G4.setBounds(215, 236, 33, 22);
		contentPane.add(G4);
		
		Button H4 = new Button("H4");
		H4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(h4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"H4,";
					vseat.setText(booking_seat);
					h4=2;
					H4.setBackground(Color.DARK_GRAY);
				}
				else if(h4==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("H4,","");
					vseat.setText(booking_seat);
					h4=0;
					H4.setBackground(Color.WHITE);
				}
			}
		});
		H4.setBounds(215, 265, 33, 22);
		contentPane.add(H4);
		
		Button I4 = new Button("I4");
		I4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"I4,";
					vseat.setText(booking_seat);
					i4=2;
					I4.setBackground(Color.DARK_GRAY);
				}
				else if(i4==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("I4,","");
					vseat.setText(booking_seat);
					i4=0;
					I4.setBackground(Color.WHITE);
				}
			}
		});
		I4.setBounds(215, 296, 33, 22);
		contentPane.add(I4);
		
		Button J4 = new Button("J4");
		J4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(j4==0){
					num++;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat+"J4,";
					vseat.setText(booking_seat);
					j4=2;
					J4.setBackground(Color.DARK_GRAY);
				}
				else if(j4==2){
					num--;
					pr.setText(Integer.toString(pric*num));
					booking_seat=booking_seat.replace("J4,","");
					vseat.setText(booking_seat);
					j4=0;
					J4.setBackground(Color.WHITE);
				}
			}
		});
		J4.setBounds(215, 324, 33, 22);
		contentPane.add(J4);
		String temp=db_seat;
		
		int k,co=0;
		for(k=0;k<db_seat.length();k++){
			if(db_seat.charAt(k)==',')co++;
		}
		   String []parts =temp.split(",");
		   for(k=0;k<co;k++){
			   
		
			   
			  if("A1".equals(parts[k])) {
				  A1.setBackground(new Color(154, 205, 50));
				  a1=1;
				  }
			  if("A2".equals(parts[k])) { 
				  A2.setBackground(new Color(154, 205, 50)); 
				  a2=1; 
				  }
			  if("A3".equals(parts[k])){
				  A3.setBackground(new Color(154, 205, 50)); 
				  a3=1; 
				  }
			  if("A4".equals(parts[k])){
				  A4.setBackground(new Color(154, 205, 50)); 
				  a4=1; 
			  }
			  
			  if("B1".equals(parts[k])) {
				  B1.setBackground(new Color(154, 205, 50));
				  b1=1;
			  }
			  if("B2".equals(parts[k])) {
				  B2.setBackground(new Color(154, 205, 50));
				  b2=1;
			  }
			  if("B3".equals(parts[k])) {
				  B3.setBackground(new Color(154, 205, 50));  
				  b3=1;
			  }
			  if("B4".equals(parts[k])){
				  B4.setBackground(new Color(154, 205, 50));
				  b4=1;
			  }
			   if("C1".equals(parts[k])) {
				   C1.setBackground(new Color(154, 205, 50));
				   c1=1;
			   }
			   if("C2".equals(parts[k])) {
				   C2.setBackground(new Color(154, 205, 50));
				   c2=1;
			   }
			   if("C3".equals(parts[k])){
				   C3.setBackground(new Color(154, 205, 50));  
				   c3=1;
			   }
			   if("C4".equals(parts[k])){
				   C4.setBackground(new Color(154, 205, 50));
				   c4=1;
			   }
			   
			   if("D1".equals(parts[k])){
				   D1.setBackground(new Color(154, 205, 50));  
				   d1=1;
			   }
			   if("D2".equals(parts[k])){
				   D2.setBackground(new Color(154, 205, 50)); 
				   d2=1;
			   }
			   if("D3".equals(parts[k])) {
				   D3.setBackground(new Color(154, 205, 50)); 
				   d3=1;
			   }
			   if("D4".equals(parts[k])){
				   D4.setBackground(new Color(154, 205, 50));
				   d4=1;
			   }
			   
			   if("E1".equals(parts[k])){
				   E1.setBackground(new Color(154, 205, 50));  
				   e1=1;
			   }
			   if("E2".equals(parts[k])){
				   E2.setBackground(new Color(154, 205, 50));  
				   e2=1;
			   }
			   if("E3".equals(parts[k])) {
				   E3.setBackground(new Color(154, 205, 50)); 
				   e3=1;
			   }
			   if("E4".equals(parts[k])){
				   E4.setBackground(new Color(154, 205, 50));
				   e4=1;
			   }
			   
			   if("F1".equals(parts[k])){
				   F1.setBackground(new Color(154, 205, 50)); 
				   f1=1;
			   }
			   if("F2".equals(parts[k])){
				   F2.setBackground(new Color(154, 205, 50));  
				   f2=1;
			   }
			   if("F3".equals(parts[k])){
				   F3.setBackground(new Color(154, 205, 50)); 
				   f3=1;
			   }
			   if("F4".equals(parts[k])){
				   F4.setBackground(new Color(154, 205, 50));
				   f4=1;
			   }
			   
			   if("G1".equals(parts[k])){
				   G1.setBackground(new Color(154, 205, 50));  
				   g1=1;
			   }
			   if("G2".equals(parts[k])) {
				   G2.setBackground(new Color(154, 205, 50));
				   g2=1;
			   }
			   if("G3".equals(parts[k])){
				   G3.setBackground(new Color(154, 205, 50)); 
				   g3=1;
			   }
			   if("G4".equals(parts[k])){
				   G4.setBackground(new Color(154, 205, 50));
				   g4=1;
			   }
			   
			   if("H1".equals(parts[k])) {
				   
				   H1.setBackground(new Color(154, 205, 50));
				   h1=1;
			   }
			   if("H2".equals(parts[k])) {
				   H2.setBackground(new Color(154, 205, 50)); 
				   h2=1;
			   }
			   if("H3".equals(parts[k])){
				   H3.setBackground(new Color(154, 205, 50));  
				   h3=1;
			   }
			   if("H4".equals(parts[k])) {
				   H4.setBackground(new Color(154, 205, 50));
				   h4=1;
			   }
			   
			   if("I1".equals(parts[k])){
				   I1.setBackground(new Color(154, 205, 50)); 
				   i1=1;
			   }
			   if("I2".equals(parts[k])) {
				   I2.setBackground(new Color(154, 205, 50));  
				   i2=1;
			   }
			   if("I3".equals(parts[k])){
				   I3.setBackground(new Color(154, 205, 50));  
				   i3=1;
			   }
			   if("I4".equals(parts[k])){
				   I4.setBackground(new Color(154, 205, 50));
				   i4=1;
			   }
			   
			   if("J1".equals(parts[k])){
				   J1.setBackground(new Color(154, 205, 50));
				   j1=1;
			   }
			   if("J2".equals(parts[k])) {
				   J2.setBackground(new Color(154, 205, 50)); 
				   j2=1;
			   }
			   if("J3".equals(parts[k])) {
				   J3.setBackground(new Color(154, 205, 50)); 
				   j3=1;
			   }
			   if("J4".equals(parts[k])){
				   J4.setBackground(new Color(154, 205, 50));
				   j4=1;
			   }
			   
			   
		   }
		   

		
	
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passprice=Integer.toString(pric*num);
				String seat="";
				if(a1==2)seat=seat+"A1,";
				if(a2==2)seat=seat+"A2,";
				if(a3==2)seat=seat+"A3,";
				if(a4==2)seat=seat+"A4,";
				
				if(b1==2)seat=seat+"B1,";
				if(b2==2)seat=seat+"B2,";
				if(b3==2)seat=seat+"B3,";
				if(b4==2)seat=seat+"B4,";
				
				if(c1==2)seat=seat+"C1,";
				if(c2==2)seat=seat+"C2,";
				if(c3==2)seat=seat+"C3,";
				if(c4==2)seat=seat+"C4,";
				
				if(d1==2)seat=seat+"D1,";
				if(d2==2)seat=seat+"D2,";
				if(d3==2)seat=seat+"D3,";
				if(d4==2)seat=seat+"D4,";
				
				if(e1==2)seat=seat+"E1,";
				if(e2==2)seat=seat+"E2,";
				if(e3==2)seat=seat+"E3,";
				if(e4==2)seat=seat+"E4,";
				
				if(f1==2)seat=seat+"F1,";
				if(f2==2)seat=seat+"F2,";
				if(f3==2)seat=seat+"F3,";
				if(f4==2)seat=seat+"F4,";
				
				if(g1==2)seat=seat+"G1,";
				if(g2==2)seat=seat+"G2,";
				if(g3==2)seat=seat+"G3,";
				if(g4==2)seat=seat+"G4,";
				
				if(h1==2)seat=seat+"H1,";
				if(h2==2)seat=seat+"H2,";
				if(h3==2)seat=seat+"H3,";
				if(h4==2)seat=seat+"H4,";
				
				if(i1==2)seat=seat+"I1,";
				if(i2==2)seat=seat+"I2,";
				if(i3==2)seat=seat+"I3,";
				if(i4==2)seat=seat+"I4,";
				
				if(j1==2)seat=seat+"J1,";
				if(j2==2)seat=seat+"J2,";
				if(j3==2)seat=seat+"J3,";
				if(j4==2)seat=seat+"J4,";
			 pass_seat=seat;
				seat=seat+db_seat;
				int y=0,xx=0;
				for(y=0;y<seat.length();y++)if(seat.charAt(y)==',')xx++;
				
				try {
					if(pass_seat.equals("")==true){
						lblPleaseSelectAn.setText("Please select an item.");
						return;
					}
					String que="update bus_seat set  BOOK_SEAT ='"+seat+"' where bus_id="+bus;
					String up="update route_info set booked_seats='"+xx+"' where bus_id="+bus;
					String up_user="update user_info set booking_seat='"+pass_seat+"' , bus_id='"+bus+"' where login=1";
					int congd=JOptionPane.YES_NO_OPTION;
				int confdiolog=	JOptionPane.showConfirmDialog(null, "Are you sure you want to book?","Warning",congd);
				if(confdiolog==JOptionPane.YES_OPTION){
					PreparedStatement pStatement = conn.prepareStatement(que);
					PreparedStatement preparedStatement=conn.prepareStatement(up);
					PreparedStatement pre=conn.prepareStatement(up_user);
					pre.executeUpdate();
					preparedStatement.executeUpdate();
					pStatement = conn.prepareStatement(que);
					pStatement.executeUpdate();
					ResultSet rst = pStatement.executeQuery();
					Ticket tkt =new Ticket();
					tkt.setVisible(true);
					setVisible(false);
					//SendMailSSL sMailSSL= new SendMailSSL();
				    //sMailSSL.getClass();
				}
				
					
				}
				catch (Exception e5) {
					
				}
				
				

				
				
				
			}
		});
		btnNewButton.setBounds(462, 324, 118, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Your Booking Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(424, 68, 225, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblSeat = new JLabel("Seat:");
		lblSeat.setForeground(new Color(0, 0, 128));
		lblSeat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeat.setBounds(363, 232, 46, 32);
		contentPane.add(lblSeat);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setForeground(new Color(0, 0, 128));
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFrom.setBounds(363, 163, 74, 32);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setForeground(new Color(0, 0, 128));
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTo.setBounds(585, 164, 38, 32);
		contentPane.add(lblTo);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(new Color(0, 0, 128));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(363, 275, 52, 32);
		contentPane.add(lblPrice);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(0, 0, 128));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(363, 203, 46, 25);
		contentPane.add(lblDate);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Time:");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(569, 208, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Sign Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="update user_info set login=0 where login=1";
					PreparedStatement pStatement=conn.prepareStatement(query);
					pStatement.executeUpdate();
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
				setVisible(false);
				LogIn lIn =new LogIn();
				lIn.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(763, 24, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel uname = new JLabel("");
		uname.setForeground(new Color(0, 0, 128));
		uname.setFont(new Font("Tahoma", Font.BOLD, 16));
		uname.setBounds(621, 21, 139, 25);
		contentPane.add(uname);
		busername=Welcome.passusername().toString();
		uname.setText(busername);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(203, 31, 46, 31);
		contentPane.add(lblNewLabel_2);
		Image img = new ImageIcon(this.getClass().getResource("/staring.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		
		JLabel lblBusName = new JLabel("Bus Name:");
		lblBusName.setForeground(new Color(0, 0, 128));
		lblBusName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBusName.setBounds(363, 123, 105, 32);
		contentPane.add(lblBusName);
		
		

		
		
		
		
		
		
	
	
		
		
	
}
	public static String passvalue(){
		return pass_seat;
	}
	public static String passprice(){
		return passprice;
	}
	public static String passfrom(){
		return from;
	}
	public static String passto(){
		return to;
	}
	public static String passdate(){
		return dat;
	}
	public static String passtime(){
		return tim;
	}
	public static String passbusname(){
		return buname;
	}
	public static String passusername() {
		return busername;
		
	}
}
