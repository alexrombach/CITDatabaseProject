import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;

public class Frame1 {

	private JFrame frame;
	private JLabel lblMessage;
	private JCheckBox btnNewButton;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
		
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Frame1 window = new Frame1();
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
	public Frame1() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JButton btnClickMe = new JButton("Click Me!");
		btnClickMe.setFont(new Font("Palatino Linotype", Font.BOLD, 29));
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					tests();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(btnClickMe, BorderLayout.CENTER);
		
		lblMessage = new JLabel("MESSAGE");
		frame.getContentPane().add(lblMessage, BorderLayout.NORTH);
		
		btnNewButton = new JCheckBox("New button");
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
	}
	
	public void tests() throws ClassNotFoundException,SQLException{
		System.out.println("helloooo");
		JOptionPane.showMessageDialog(null, "test");
		lblMessage.setText("test");
		
		String connectionURL = "jdbc:mysql://localhost:3306/university?autoReconnect=true&useSSL=false";
		Connection connection = DriverManager.getConnection(connectionURL, "root", "integertombob");
		Statement statement = connection.createStatement();
		//Table Creation
		//String q1 = "create table emp(eid int, ename char(30), esal double(7,2))";
		String q1 = "CREATE TABLE EMP " + "(eid INTEGER not NULL, " + " ename VARCHAR(30), " + " esal double(7,2), " + " PRIMARY KEY ( eid ))";
		int a = statement.executeUpdate(q1);
		System.out.println("----------------X----------X--------------------");
		System.out.println("Table created successfully: "+a);
		//Data Insertion
		String q2 = "insert into emp(eid,ename,esal) values(111,'Joe',70000)";
		String q3 = "insert into emp(eid,ename,esal) values(112,'Jack',80000)";
		String q4 = "insert into emp(eid,ename,esal) values(113,'Jinny',90000)";
		
		statement.executeUpdate(q2);
		statement.executeUpdate(q3);
		statement.executeUpdate(q4);
	
		System.out.println("----------------X----------X--------------------");
		System.out.println("Values are inserted successfully");
		//Data Retrieval
		String q5 = "select * from EMP";
		ResultSet set = statement.executeQuery(q5);
		while(set.next()){
		System.out.println(set.getInt(1)+"------"+set.getString("ename")+"------"+set.getDouble(3));
		}
		System.out.println("----------------X----------X--------------------");
		System.out.println("Data display is completed");
		//Data Update
		String q6 = "Update emp set esal = esal+200 where esal>70000";
		int x = statement.executeUpdate(q6);
		System.out.println("Number of record updated: "+x);
		System.out.println("----------------X----------X--------------------");
		System.out.println("Data updation is completed");
		//Data Drop
		//String q7 = "drop table emp";
		//int y = statement.executeUpdate(q7);
		//System.out.println("----------------X----------X--------------------");
		//System.out.println("Table dropped successfully: "+y);
		//Connection Close
		connection.close();
		
		
	}

}
