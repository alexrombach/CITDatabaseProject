import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Methods {

	CIT345Project gui = new CIT345Project();
	Connection connection; //global connection for all sql statements 
	
	public void connectToDB(){
		connection=sqlConnection.dbConnector();
	}
	
	public void addNewCustomer(String ...strings){
		boolean test = false;
		String fname = ""; 
		String lname = ""; 
		String street = "";
		String city = "";
		String phone1 = "";
		String phone2 = "";
		String phone3 = "";
		String email = ""; 
		String state = "";
		String zip = "";
		
	
			for (int i = 0; i < strings.length; i++){
				if (strings[i] == ""){
					JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
					test = false;
					break;
				} else {
					for (int j = 0; j < strings.length; j++){
				fname = strings[0];
				lname = strings[1];
				street = strings[2];
				city = strings[3];
				phone1 = strings[4];
				phone2 = strings[5];
				phone3 = strings[6];
				email = strings[7];
				state = strings[8];	
				zip = strings[9];
			}
					test = true;
				}
			}
		
		if (test == true){
			String phoneNum = (phone1 + "-" + phone2 + "-" + phone3);
			int zipCode = Integer.parseInt(zip);
			String q1 = "insert into customer (FirstName, LastName, Email, PhoneNumber, State, Street, City, Zip) VALUES ('"+fname+"','"+lname+
				"','"+email+"','"+phoneNum+"','"+state+"','"+street+"','"+city+"',"+zipCode+");";
			String q2 = "select CustomerID from customer where FirstName = '"+fname+"' and LastName = '"+lname+"' and Email = '"+email+"';";
		
		try{
			PreparedStatement posted = connection.prepareStatement(q1);
			posted.executeUpdate();
			PreparedStatement retrieve = connection.prepareStatement(q2);
			ResultSet set = retrieve.executeQuery();
				if (set.next()){
					CIT345Project.CID = set.getInt(1);
					CIT345Project.customerCheck = true;
				}
		} catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
			
			}
		finally{
			System.out.println("insert completed");
			System.out.println(CIT345Project.CID);
			};
		System.out.println(q1);
		System.out.println(fname);
		}
		
//    	String fname = gui.NCF_fName.getText();
//    	String lname = gui.NCF_lName.getText();
//    	String street = gui.NCF_street.getText();
//    	String city = gui.NCF_city.getText();
//    	String zip = gui.NCF_zip.getText();
//    	//int zip = Integer.parseInt(gui.NCF_zip.getText());
//    	String phone1 = gui.NCF_phone1.getText();
//    	String phone2 = gui.NCF_phone2.getText();
//    	String phone3 = gui.NCF_phone3.getText();
//    	String email = gui.NCF_email.getText();
//    	String state = gui.NCF_state.getSelectedItem().toString();
//    	
//    	String phoneNum = (phone1 + "-" + phone2 + "-" + phone3);
		
		
	}
	
	public void calculate(String...strings){
		int a = 0,b = 0,c = 0,d = 0;
		String speed = "";
		String inter = "";
		String haz = "";
		String size = "";
		String id = "";
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime ldt;
		String d1 = "";

		for (int i = 0; i < strings.length; i++){
			speed = strings[0];
			inter = strings[1];
			haz = strings[2];
			size = strings[3];
	}
		switch(speed){
		case "Overnight":
			a = 4;
			ldt = LocalDateTime.now().plusDays(1);
			d1 = dtf.format(ldt);
			break;
		case "Express":
			a = 5;
			ldt = LocalDateTime.now().plusDays(3);
			d1 = dtf.format(ldt);
			break;
		case "Regular":
			a = 6;
			ldt = LocalDateTime.now().plusDays(7);
			d1 = dtf.format(ldt);
			break;
		}
		
		switch(inter){
		case "Yes":
			b = 1;
			break;
		case "No":
			b = 0;
			break;
		}
		
		switch(size){
		case "Yes":
			c = 1;
			break;
		case "No":
			c = 0;
			break;
		}
		
		switch(haz){
		case "Yes":
			d = 1;
			break;
		case "No":
			d = 0;
			break;
		}
		
		id = "" + a+b+c+d;
		int methodID = Integer.parseInt(id);
		
		String q1 = "select price from shipmentmethod where shipmentmethodid =" +methodID+";";
		try{
			PreparedStatement retrieve = connection.prepareStatement(q1);
			ResultSet set = retrieve.executeQuery();
				if (set.next()){
					CIT345Project.price = set.getInt(1);
					CIT345Project.dDate = d1;
				}
		} catch(Exception e1) {
			}
		System.out.println(speed + inter + haz + size + methodID);
	}
	
	public void seachCustomer(String...strings){
		boolean test = false;
		String fname = "";
		String lname = "";
		String phone1 = "";
		String phone2 = "";
		String phone3 = "";
		String email = "";

		for (int i = 0; i < strings.length; i++){
			if (strings[i] == ""){
				JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
				test = false;
				break;
			} else {
				for (int j = 0; j < strings.length; j++){
			fname = strings[0];
			lname = strings[1];
			phone1 = strings[2];
			phone2 = strings[3];
			phone3 = strings[4];
			email = strings[5];

			
		}
				test = true;
			}
		}
		
		try {
			
			String phoneNum = (phone1 + "-" + phone2 + "-" + phone3);
			String q1 = "select * from customer where (FirstName = '"+fname+"' and LastName = '"+lname+"') or PhoneNumber = '"+phoneNum+"' or email = '"+email+"';";

			PreparedStatement retrieve = connection.prepareStatement(q1);

			ResultSet rs=retrieve.executeQuery();
			
			CIT345Project.CSR_table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		

		
		
		
	}
	

}
