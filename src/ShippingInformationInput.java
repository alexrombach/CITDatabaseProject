import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Enumeration;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class ShippingInformationInput {

	private JFrame frame;
	private JTextField Customer_ID;
	private JTextField Destination;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JRadioButton rdbtn_speed1 = new JRadioButton("Over Night");
	JRadioButton rdbtn_speed2 = new JRadioButton("Express");
	JRadioButton rdbtn_speed3 = new JRadioButton("Regular");
	JCheckBox chckbx_international = new JCheckBox("International");
	JCheckBox chckbxOversize = new JCheckBox("Oversized");
	JCheckBox chckbx_Hazard = new JCheckBox("Hazardous ");
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					ShippingInformationInput window = new ShippingInformationInput();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShippingInformationInput() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnClickMe = new JButton("Click Me!");
		btnClickMe.setBounds(10, 218, 414, 32);
		btnClickMe.setFont(new Font("Palatino Linotype", Font.BOLD, 29));
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					submitSQL();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(btnClickMe);
		
		JLabel lblNewLabel = new JLabel("Shipment Information Input:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD));
		lblNewLabel.setBounds(10, 11, 226, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("Customer ID:");
		lblFirstName.setBounds(10, 42, 103, 14);
		frame.getContentPane().add(lblFirstName);
		
		Customer_ID = new JTextField();
		Customer_ID.setBounds(107, 39, 86, 20);
		frame.getContentPane().add(Customer_ID);
		Customer_ID.setColumns(10);
		
		Destination = new JTextField();
		Destination.setBounds(107, 60, 86, 20);
		frame.getContentPane().add(Destination);
		Destination.setColumns(10);
		
		JLabel lblSendingLocation = new JLabel("Destination:");
		lblSendingLocation.setBounds(10, 63, 87, 14);
		frame.getContentPane().add(lblSendingLocation);
		
		
		rdbtn_speed1.setSelected(true);
		buttonGroup_1.add(rdbtn_speed1);
		rdbtn_speed1.setBounds(10, 91, 97, 23);
		frame.getContentPane().add(rdbtn_speed1);
		

		buttonGroup_1.add(rdbtn_speed2);
		rdbtn_speed2.setBounds(10, 117, 87, 23);
		frame.getContentPane().add(rdbtn_speed2);
		
	
		buttonGroup_1.add(rdbtn_speed3);
		rdbtn_speed3.setBounds(10, 143, 87, 23);
		frame.getContentPane().add(rdbtn_speed3);
		
		
		chckbx_international.setBounds(107, 87, 97, 23);
		frame.getContentPane().add(chckbx_international);
		
		
		chckbxOversize.setBounds(107, 117, 97, 23);
		frame.getContentPane().add(chckbxOversize);
		
		
		chckbx_Hazard.setBounds(107, 143, 97, 23);
		frame.getContentPane().add(chckbx_Hazard);
		
		
	}
	
	
	public void submitSQL() throws ClassNotFoundException,SQLException{

		String connectionURL = "jdbc:mysql://localhost:3306/projecttest?autoReconnect=true&useSSL=false";
		Connection connection = DriverManager.getConnection(connectionURL, "root", "integertombob");
		Statement statement = connection.createStatement();
		//Table Creation
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now)); //2016/11/16 12:08:43
		
		String CID = Customer_ID.getText();
		String PDestination = Destination.getText();
		int ShipType = 0000;
		
		  
		if(rdbtn_speed1.isSelected()){
			if(chckbx_international.isSelected() && chckbxOversize.isSelected() && chckbx_Hazard.isSelected()){
				System.out.println("Over Night, interational, oversize, hazard");
				ShipType = 4111;
			}
			else if(chckbx_international.isSelected() && chckbxOversize.isSelected()){
				System.out.println("Over Night, interational, oversize");
				ShipType = 4110;
			}
			else if(chckbxOversize.isSelected() && chckbx_Hazard.isSelected()){
				System.out.println("Over Night, oversize, Hazard");
				ShipType = 4011;
			}
			else if(chckbx_international.isSelected() && chckbx_Hazard.isSelected()){
				System.out.println("Over Night, international, Hazard");
				ShipType = 4101;
			}
			else if(chckbx_international.isSelected()){
				System.out.println("Over Night, international");
				ShipType = 4100;
			}
			else if(chckbx_Hazard.isSelected()){
				System.out.println("Over Night, chckbx_Hazard");
				ShipType = 4001;
			}
			else if(chckbxOversize.isSelected()){
				System.out.println("Over Night, chckbxOversize");
				ShipType = 4010;
			}
			else{
				System.out.println("Over Night");
				ShipType = 4000;
			}
        }
        else if(rdbtn_speed2.isSelected()){
			if(chckbx_international.isSelected() && chckbxOversize.isSelected() && chckbx_Hazard.isSelected()){
				System.out.println("Express, interational, oversize, hazard");
				ShipType = 5111;
			}
			else if(chckbx_international.isSelected() && chckbxOversize.isSelected()){
				System.out.println("Express, interational, oversize");
				ShipType = 5110;
			}
			else if(chckbxOversize.isSelected() && chckbx_Hazard.isSelected()){
				System.out.println("Express, oversize, Hazard");
				ShipType = 5011;
			}
			else if(chckbx_international.isSelected() && chckbx_Hazard.isSelected()){
				System.out.println("Express, international, Hazard");
				ShipType = 5101;
			}
			else if(chckbx_international.isSelected()){
				System.out.println("Express, international");
				ShipType = 5100;
			}
			else if(chckbx_Hazard.isSelected()){
				System.out.println("Express, chckbx_Hazard");
				ShipType = 5001;
			}
			else if(chckbxOversize.isSelected()){
				System.out.println("Express, chckbxOversize");
				ShipType = 5010;
			}
			else{
				System.out.println("Express");
				ShipType = 5000;
			}
        }
        else if(rdbtn_speed3.isSelected()){
			if(chckbx_international.isSelected() && chckbxOversize.isSelected() && chckbx_Hazard.isSelected()){
				System.out.println("Regular, interational, oversize, hazard");
				ShipType = 6111;
			}
			else if(chckbx_international.isSelected() && chckbxOversize.isSelected()){
				System.out.println("Regular, interational, oversize");
				ShipType = 6110;
			}
			else if(chckbxOversize.isSelected() && chckbx_Hazard.isSelected()){
				System.out.println("Regular, oversize, Hazard");
				ShipType = 6011;
			}
			else if(chckbx_international.isSelected() && chckbx_Hazard.isSelected()){
				System.out.println("Regular, international, Hazard");
				ShipType = 6101;
			}
			else if(chckbx_international.isSelected()){
				System.out.println("Regular, international");
				ShipType = 6100;
			}
			else if(chckbx_Hazard.isSelected()){
				System.out.println("Regular, chckbx_Hazard");
				ShipType = 6001;
			}
			else if(chckbxOversize.isSelected()){
				System.out.println("Regular, chckbxOversize");
				ShipType = 6010;
			}
			else{
				System.out.println("Regular");
				ShipType = 6000;
			}      	
        }                                      
		System.out.println(ShipType);
		
		String thedate = dtf.format(now);
		
		String insertintosql = "insert into shipment  (CID, Destination, ShipType, ShipDate)  VALUES  ('"+CID+"','"+PDestination+"','"+ShipType+"','"+thedate+"');";
		
		statement.executeUpdate(insertintosql);
		
	//	String pullback = "select idshipment from shipment where cid = "+CID+" and ShipDate = "+thedate+";";
		//statement.executeUpdate(pullback);
		
		
		
		connection.close();

		
	}
	
}
