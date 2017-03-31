import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

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
	
}
