import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.PUBLIC_MEMBER;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.FlowLayout;

import javax.management.modelmbean.ModelMBean;
import javax.print.DocFlavor.STRING;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JToggleButton;
import java.awt.Label;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import java.awt.Choice;
import javax.swing.JCheckBoxMenuItem;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;

public class Welcome extends JFrame {

	private static final String String = null;
	private JPanel contentPane;
	private JTextField textField_from;
	private JTextField textField_to;
	private JTable table;
	public static  String bus_id;
	public int arr[] = new int[100];
	public int flag=0,flag2=0;
public static String busName,name,user_name;
/**
	 * Launch the application.
	 */

	public static void Welcome() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		Connection con = connection.dbConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel sshow = new JLabel("");
		sshow.setFont(new Font("Tahoma", Font.BOLD, 12));
		sshow.setBounds(190, 310, 194, 23);
		contentPane.add(sshow);
		
		JButton btnNewButton = new JButton("Sign out");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="update user_info set login=0 where login=1";
					PreparedStatement pStatement=con.prepareStatement(query);
					pStatement.executeUpdate();
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
				setVisible(false);
				
				LogIn lIn =new LogIn();
				lIn.setVisible(true);
			}
		});
		btnNewButton.setBounds(762, 25, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblShipon = new JLabel("");
		lblShipon.setForeground(Color.BLUE);
		try{
		String query="Select * from user_info where login=1";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rst = pst.executeQuery();
		//
	
			          while(rst.next()){
			        	  name=rst.getString(4)+" "+rst.getString(5);
			        	  user_name=rst.getString(3).toString();
			           lblShipon.setText(user_name);
			    
			          }
		 
		
	
		}
		catch (Exception ex){
			
		}
		lblShipon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblShipon.setBounds(644, 25, 115, 23);
		contentPane.add(lblShipon);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setForeground(new Color(0, 0, 128));
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFrom.setBounds(42, 117, 89, 14);
		contentPane.add(lblFrom);
		
		textField_from = new JTextField();
		textField_from.setBounds(148, 116, 204, 20);
		contentPane.add(textField_from);
		textField_from.setColumns(10);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setForeground(new Color(0, 0, 128));
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setBounds(64, 147, 89, 23);
		contentPane.add(lblTo);
		
		textField_to = new JTextField();
		textField_to.setBounds(148, 153, 204, 20);
		contentPane.add(textField_to);
		textField_to.setColumns(10);
		
		JLabel lblJourneyDate = new JLabel("Date:");
		lblJourneyDate.setForeground(new Color(0, 0, 128));
		lblJourneyDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJourneyDate.setBounds(49, 205, 54, 19);
		contentPane.add(lblJourneyDate);
		String[] str = {"MONTH","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		JComboBox comboBox_Month = new JComboBox(str);
	
		comboBox_Month.setFont(new Font("Tahoma", Font.BOLD, 11));

		comboBox_Month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
		    }
		});
		comboBox_Month.setToolTipText("");
		
		
		
		
		comboBox_Month.setSelectedIndex(0);
		comboBox_Month.setBounds(148, 205, 66, 23);
		contentPane.add(comboBox_Month);
		String[] combo1 = {"DATE","1","2","3","4","5","6","7","8","9","10",
				                  "11","12","13","14","15","16","17","18","19","20"
				                  ,"21","22","23","24","25","26","27","28","29","30"};
		String[] year={"YEAR","2017","2018","2019","2020","2021","2022"};
		JComboBox comboBox_year = new JComboBox(year);
		comboBox_year.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		comboBox_year.setBounds(293, 206, 54, 20);
		contentPane.add(comboBox_year);
		
		JComboBox comboBox_1 = new JComboBox(combo1);
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JLabel viewJlevel = new JLabel("");
		viewJlevel.setForeground(Color.RED);
		viewJlevel.setFont(new Font("Tahoma", Font.BOLD, 16));
		viewJlevel.setBounds(502, 371, 257, 23);
		contentPane.add(viewJlevel);
		
		comboBox_1.setBounds(224, 205, 59, 22);
		contentPane.add(comboBox_1);

		JScrollPane scrollPane = new JScrollPane();	
		scrollPane.addMouseListener(new MouseAdapter() {
	
			
			public void mouseClicked(MouseEvent arg0) {
				// viewJlevel.setText("dfg");
				
				
				//viewJlevel.setText(busName);
				
				
				
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		scrollPane.setToolTipText("");
		
		scrollPane.setBounds(375, 112, 476, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(SystemColor.infoText);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBackground(new Color(100, 149, 237));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				int index = table.getSelectedRow();
		     	TableModel model =table.getModel();
				//textField_from.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
			
			     busName = model.getValueAt(index, 0).toString();
			     int in=table.getSelectedRow()+1;
			    bus_id=Integer.toString(arr[in]);
			  
			     
			
			     flag=1;
				
				
				
				
				
				
				
				
			}
		});
	
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Bus Name","Dep. Time", "Arr. Time","Seats Available", "Price"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		
		scrollPane.setViewportView(table);
		
		
		JButton nb = new JButton("Search");
		nb.setFont(new Font("Tahoma", Font.BOLD, 11));
		nb.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				viewJlevel.setText("");
			
				String query = "SELECT * from route_info where DEPART_FROM=? and DESTINATION=? and JOURNEY_DATE=? and MONTH=? and year=?";
				DefaultTableModel jtable = (DefaultTableModel) table.getModel();
				   jtable.setRowCount(0);
				try {
					
                          flag2=0;
					PreparedStatement pst=con.prepareStatement(query);
					
						pst.setString(1, textField_from.getText());
					pst.setString(2, textField_to.getText());
					pst.setString(3, comboBox_1.getSelectedItem().toString());
					pst.setString(4, comboBox_Month.getSelectedItem().toString());
					pst.setString(5, comboBox_year.getSelectedItem().toString());
					ResultSet rst = pst.executeQuery();
					 // int vall=Integer.parseInt(rst.getObject(4).toString())-Integer.parseInt(rst.getObject(8).toString());
		//
					
					
					//int val2 = rst.getInt(8);
					//int val3 = val1-val2;
					//System.out.println(val1);
				
					//   String strr=String.valueOf(val1);
			
		    int ii=-1;
		    int jj=-1;
		    int index=1;
		    for(int y=0;y<100;y++)arr[y]=-1;
	//table.setModel(DbUtils.resultSetToTableModel(rst));
				   while(rst.next()){
						ii = rst.getInt(4);
						jj = rst.getInt(8);
						int kk = ii-jj;
						String strrr = Integer.toString(kk);

						arr[index++]=rst.getInt(13);
				
				flag2=1;
				sshow.setText("");
					   //table.setModel(DbUtils.resultSetToTableModel(rst));
				        jtable.addRow(new Object[]{rst.getObject(9),rst.getObject(6),rst.getObject(11),strrr,rst.getObject(12)});
				   }
				   if(flag2==0){
					 sshow.setText("Sorry No Bus Available");  
				   }
				 
					
				} catch (Exception e) {
					sshow.setText("Sorry Something Went Wrong");
					// TODO: handle exception
				}
				
				
				
			}
		
		});
		nb.setBounds(258, 259, 89, 23);
		contentPane.add(nb);
		
		
		
		JButton btnNewButton_1 = new JButton("View Seats");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flag2==0){
			          viewJlevel.setText("Sorry No Available Bus");
				}
				else	if(flag==1 && flag2==1){
			    Bus_info vSeat=new Bus_info();
			     vSeat.setVisible(true);
				   setVisible(false);
				}
				else{
					viewJlevel.setText("Please Selecet Properly.");
				}
			}
		});
		btnNewButton_1.setBounds(556, 417, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Available Bus");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(541, 64, 230, 23);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
	public static String bString(){
		return bus_id;
	}
	public static String passusername(){
		return user_name;
	}
	
}
