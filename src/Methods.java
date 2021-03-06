

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
		
		connectToDB();
		
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
					JOptionPane.showMessageDialog(null, "Customer has been added");
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
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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
					CIT345Project.shipMethod = methodID;
				}
		} catch(Exception e1) {
			}
		System.out.println(speed + inter + haz + size + methodID);
	}
	 public void shipinsert(String...strings){
		 boolean test = false;
		 int cid = CIT345Project.CID;
		 int shipMethod = CIT345Project.shipMethod;
		 String dDate = CIT345Project.dDate;
		 double price = CIT345Project.price;
		 String storeid = "";
		 String street = "";
		 String city = "";
		 String state = "";
		 String zip = "";
		 String sDate = "";
		 String country = "";
		 String ccnumber = "";
		 
		 for (int i = 0; i < strings.length; i++){
			 if (strings[i] == ""){
					JOptionPane.showMessageDialog(null, "Please make sure all shipping fields are filled out");
					test = false;
					break;
				} else {
					for (int j = 0; j < strings.length; j++){
				storeid = strings[0];
				street = strings[1];
				city = strings[2];
				state = strings[3];
				zip = strings[4];
				sDate = strings[5];
				country = strings[6];
				ccnumber = strings[7];
			}
					test = true;
		 }
		 
		 }
		 if (test == true){
			 int strID = Integer.parseInt(storeid);
			 int dzip = Integer.parseInt(zip);
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			 LocalDateTime stime = LocalDateTime.parse(sDate, dtf);
			 LocalDateTime etime = LocalDateTime.parse(CIT345Project.dDate, dtf);
			 
			 String q1 = "insert into shipment (ShipCustomerID, StoreID, ShipMethod, Street, City, State, Zip, ExpectedDelivery, ShipmentDate, Country) Values ("+cid+","+strID+","+shipMethod+",'"+street+"','"+city+"','"+state+"',"+dzip+",'"+etime+"','"+stime+"','"+country+"');";
			 String q2 = "select ShipmentID from shipment where ShipCustomerID = "+cid+" and ExpectedDelivery = '" +etime+"';";
			 try{
					PreparedStatement posted = connection.prepareStatement(q1);
					posted.executeUpdate();
					PreparedStatement retrieve = connection.prepareStatement(q2);
					ResultSet set = retrieve.executeQuery();
						if (set.next()){
							CIT345Project.SID1 = set.getInt(1);
						}
				} catch(Exception e1) {
					//JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
					return;
					}
				finally{
					System.out.println("insert completed");
					System.out.println(CIT345Project.SID1);
					};
		 }
		 if(test == true){
			 String q3 = "select accountID from account where customerID = '"+cid+"';";
			 try{
				 PreparedStatement accountcheck = connection.prepareStatement(q3);
				 ResultSet ac = accountcheck.executeQuery();
					if ((ac.next() == true) && (CIT345Project.accountchk == true)){
						String acnum = ac.getString("AccountID");
						String q4 = "insert into payments (AccoutNumber, ShipmentID, DueDate, AmountDue) values ('"+acnum+"','"+CIT345Project.SID1+"', '"+LocalDateTime.now().plusDays(3)+"', '"+CIT345Project.price+"');";
						System.out.println(q4);
						PreparedStatement posted = connection.prepareStatement(q4);
						posted.executeUpdate(); 
					}
					else if((CIT345Project.ccchk == true)){
						System.out.println("Test point 3");
						String q5 = "insert into chargehistory (CustomerID, ShipmentID, DatePaid, TotalPrice, CreditCardID) values ('"+CIT345Project.CID+"','"+CIT345Project.SID1+"', '"+LocalDateTime.now()+"', '"+CIT345Project.price+"', '"+ccnumber+"');";
						System.out.println(q5);
						PreparedStatement posted = connection.prepareStatement(q5);
						posted.executeUpdate();
					}
			 }
			 catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
					return;
					}
		 };
	 }
	 
	public void packageinsert(String...strings){
		boolean test = false;
		int sid = CIT345Project.SID1;
		double weight = CIT345Project.weight;
		String dim = "";
		String fragile = "";
		String haz = "";
		
		 for (int i = 0; i < strings.length; i++){
			 if (strings[i] == ""){
					JOptionPane.showMessageDialog(null, "Please make sure all package fields are filled out");
					test = false;
					break;
				} else {
					for (int j = 0; j < strings.length; j++){
				dim = strings[0];
				fragile = strings[1];
				haz = strings[2];
			}
					test = true;
		 }
		 }
			 if (test){
				 String q1 = "insert into packages (shipmentID, Dimensions, Weight, Fragile) Values ("+sid+",'"+dim+"',"+weight+",'"+fragile+"');";
				 String q2 = "select PackageID from packages where ShipmentID = "+sid+";";
				 System.out.println(q1);
				 try{
						PreparedStatement posted = connection.prepareStatement(q1);
						posted.executeUpdate();
						PreparedStatement retrieve = connection.prepareStatement(q2);
						ResultSet set = retrieve.executeQuery();
							if (set.next()){
								CIT345Project.PID = set.getInt(1);
								CIT345Project.shipped = true;
							}
							
					} catch(Exception e1) {
						//JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
						return;
						}
					finally{
						System.out.println("insert completed");
						
						};
			 }
	}
	

	public void declarationinsert(String ...strings){
		boolean test = false;
		int pid = CIT345Project.PID;
		String contents = "";
		String value = "";
		
		 for (int i = 0; i < strings.length; i++){
			 if (strings[i] == ""){
					JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
					test = false;
					break;
				} else {
					for (int j = 0; j < strings.length; j++){
				contents = strings[0];
				value = strings[1];
			}
					test = true;
		 }
		 }
		 
		 if (test){
			 double val = Double.parseDouble(value);
			 String q1 = "insert into declarationform (PackageID, Contents, Value) Values ("+pid+",'"+contents+"',"+val+");";
			 	try{
			 		PreparedStatement posted = connection.prepareStatement(q1);
			 		posted.executeUpdate();
			 	} catch (Exception e1){
			 		JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
					return;
			 	} finally {
			 		System.out.println("insert completed");
			 	}
		 }
	}

	public void seachCustomer(String...strings){
		boolean test = false;
		String fname = null;
		String lname = null;
		String phone1 = null;
		String phone2 = null;
		String phone3 = null;
		String email = null;

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
		
		
		
		//JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
		CIT345Project.customerCheck = true;
		if(phone1.isEmpty() && phone2.isEmpty() && phone3.isEmpty() && lname.isEmpty() && fname.isEmpty() && email.isEmpty()){
				CIT345Project.customerCheck = false;
				JOptionPane.showMessageDialog(null, "Pleas meake sure that at least one feild has been entered");
			
		}
		if(!phone1.isEmpty() || !phone2.isEmpty() || !phone3.isEmpty()){
			if(phone1.isEmpty() || phone2.isEmpty() || phone3.isEmpty() ){
				CIT345Project.customerCheck = false;
				JOptionPane.showMessageDialog(null, "Please make sure that all phone number feilds are entered");
			}
		}
		
		if (test == true){
			String phoneNum = ( phone1 + "-" + phone2 + "-" + phone3);
			String q1 = "select * from customer where FirstName = '"+fname+"' or LastName = '"+lname+"' or PhoneNumber = '"+phoneNum+"' or email = '"+email+"';";
		try{
			PreparedStatement retrieve = connection.prepareStatement(q1);

			ResultSet rs=retrieve.executeQuery();
			
			CIT345Project.CSR_table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Please make sure all fields are filled out");
			
			}
		
		}
	}
	
	public  void grabCIDfromCustomerList(){
		
		
		int row = CIT345Project.CSR_table.getSelectedRow();
		Object Selected_CID = null;
		try{
			 Selected_CID = CIT345Project.CSR_table.getModel().getValueAt(row, 0);
			System.out.println(Selected_CID.toString());
			String cid = Selected_CID.toString();
			CIT345Project.CID = Integer.parseInt(cid);
			CIT345Project.customerCheck = true;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Select a customer!");
			CIT345Project.customerCheck = false;
			
			}		
		
		

	}	
	
	public void grabAccount (){
		String q1 = "select AccountID from account where CustomerID = "+CIT345Project.CID+";";
		
		try {
			PreparedStatement retrieve = connection.prepareStatement(q1);
			ResultSet set = retrieve.executeQuery();
				if (set.next()){
					CIT345Project.ACT_NO = set.getInt(1);
				}else{
					CIT345Project.ACT_NO = 0;
				}
		}catch(Exception e) {
				return;
			}
	}
	
	public void grabContract(){
		String q1 = "select ContractTier from contract where AccountNumber = "+CIT345Project.ACT_NO+";";
		try {
			PreparedStatement retrieve = connection.prepareStatement(q1);
			ResultSet set = retrieve.executeQuery();
				if (set.next()){
					CIT345Project.contractType = set.getString(1);
				}else{
					CIT345Project.contractType = "";
				}
		}catch(Exception e) {
				return;
			}
	}
	
	public void grabDiscount(){
		String q1 = "select Discount from contracttype where Teir = '"+CIT345Project.contractType+"';";
		try {
			PreparedStatement retrieve = connection.prepareStatement(q1);
			ResultSet set = retrieve.executeQuery();
				if (set.next()){
					CIT345Project.discount = set.getInt(1);
				}else{
					CIT345Project.discount = 0;
				}
		}catch(Exception e) {
				return;
			}
	}
	
	public void addBronze(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt;
		String d = "";
		ldt = LocalDateTime.now();
		d = dtf.format(ldt);
		CIT345Project.NowTime = d;
		ldt = LocalDateTime.now().plusYears(1);
		d = dtf.format(ldt);
		CIT345Project.EndTime = d;
		
		LocalDateTime stime = LocalDateTime.parse(CIT345Project.NowTime, dtf);
		LocalDateTime etime = LocalDateTime.parse(CIT345Project.EndTime, dtf);
		
		String q1 = "insert into contract (AccountNumber, ContractTier, StartDate, EndDate)"
				+ "Values ("+CIT345Project.ACT_NO+",'Bronze','"+stime+"','"+etime+"');";

		try{
	 		PreparedStatement posted = connection.prepareStatement(q1);
	 		posted.executeUpdate();
	 	} catch (Exception e1){
			return;
	 	}
		
	}
	
	public void addSilver(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt;
		String d = "";
		ldt = LocalDateTime.now();
		d = dtf.format(ldt);
		CIT345Project.NowTime = d;
		ldt = LocalDateTime.now().plusYears(1);
		d = dtf.format(ldt);
		CIT345Project.EndTime = d;
		
		LocalDateTime stime = LocalDateTime.parse(CIT345Project.NowTime, dtf);
		LocalDateTime etime = LocalDateTime.parse(CIT345Project.EndTime, dtf);
		
		String q1 = "insert into contract (AccountNumber, ContractTier, StartDate, EndDate)"
				+ "Values ("+CIT345Project.ACT_NO+",'Silver','"+stime+"','"+etime+"');";

		try{
	 		PreparedStatement posted = connection.prepareStatement(q1);
	 		posted.executeUpdate();
	 	} catch (Exception e1){
			return;
	 	}
		
	}
	
	public void addGold(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt;
		String d = "";
		ldt = LocalDateTime.now();
		d = dtf.format(ldt);
		CIT345Project.NowTime = d;
		ldt = LocalDateTime.now().plusYears(1);
		d = dtf.format(ldt);
		CIT345Project.EndTime = d;
		
		LocalDateTime stime = LocalDateTime.parse(CIT345Project.NowTime, dtf);
		LocalDateTime etime = LocalDateTime.parse(CIT345Project.EndTime, dtf);
		
		String q1 = "insert into contract (AccountNumber, ContractTier, StartDate, EndDate)"
				+ "Values ("+CIT345Project.ACT_NO+",'Gold','"+stime+"','"+etime+"');";

		try{
	 		PreparedStatement posted = connection.prepareStatement(q1);
	 		posted.executeUpdate();
	 	} catch (Exception e1){
			return;
	 	}
		
	}

	public void grabBilling(){

		boolean test = true;
		if (test == true){
			String q1 = "select ShipmentID, DatePaid, TotalPrice, CreditCardID from chargehistory where CustomerID = "+CIT345Project.CID+";";
			String q2 = "select payments.ShipmentID, payments.DueDate, payments.AmountDue, payments.DatePaid, payments.paymentscol from account join payments on account.AccountID = payments.AccoutNumber where CustomerID = "+CIT345Project.CID+";"; 
		try{         
			PreparedStatement retrieve1 = connection.prepareStatement(q1);
			PreparedStatement retrieve2 = connection.prepareStatement(q2);
			ResultSet rs1=retrieve1.executeQuery();
			ResultSet rs2=retrieve2.executeQuery();
			
			CIT345Project.ChargeTable.setModel(DbUtils.resultSetToTableModel(rs1));
			CIT345Project.PaymentTable.setModel(DbUtils.resultSetToTableModel(rs2));
			
			CIT345Project.customerCheck = true;
		} catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "No Payment History or Charge History Present");
			CIT345Project.customerCheck = false;
			
			}
		
		}
	}
	
	public void discountPrice(){
		double discount;
		discount = (CIT345Project.price * CIT345Project.discount)/100;
		CIT345Project.price = CIT345Project.price - discount;
	}

}


