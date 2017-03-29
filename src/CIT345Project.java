import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.ScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.JTextArea;
import java.awt.Color;

public class CIT345Project extends JFrame {

	private JPanel contentPane;
	private JTextField NFC_fName;
	private JTextField NFC_lName;
	private JTextField NFC_street;
	private JTextField NFC_city;
	private JTextField NFC_zip;
	private JTextField NFC_phone1;
	private JTextField NFC_phone2;
	private JTextField NFC_email;
	private JTextField NFC_phone3;
	private JTextField CS_fName;
	private JTextField CS_lName;
	private JTextField CS_email;
	private JTextField CS_phone1;
	private JTextField CS_phone2;
	private JTextField CS_phone3;
	private JTable CSR_table;
	private JTextField TPP_number;
	private JTable TPR_table;
	private JTextField SF_storeid;
	private JTextField SF_shipdate;
	private JTextField SF_street;
	private JTextField SF_city;
	private JTextField SF_zip;
	
	public boolean customerCheck = false;
	private JTextField SF_price;
	private JTextField SF_deliverydate;
	private JTextField CIP_fname;
	private JTextField CIP_lname;
	private JTextField CIP_address;
	private JTextField CIP_city;
	private JTextField CIP_zip;
	private JTextField CIP_phone1;
	private JTextField CIP_phone2;
	private JTextField CIP_phone3;
	private JTextField CIP_email;
	private JTextField CIP_username;
	private JTable ChargeTable;
	private JTable PaymentTable;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CIT345Project frame = new CIT345Project();
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
	public CIT345Project() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Panel Creation
		JPanel mainScreen = new JPanel();
		contentPane.add(mainScreen, BorderLayout.CENTER);
		mainScreen.setLayout(new BorderLayout(0, 0));
		
		JPanel BottomPanel = new JPanel();
		contentPane.add(BottomPanel, BorderLayout.SOUTH);
		BottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Used Cardlayout to move between multiple panels
		JPanel MainCard = new JPanel();
		mainScreen.add(MainCard, BorderLayout.CENTER);
		MainCard.setLayout(new CardLayout(0, 0));
		
		JPanel BottomCard = new JPanel();
		BottomPanel.add(BottomCard);
		BottomCard.setLayout(new CardLayout(0, 0));
		
		//-------Start Page-------//
		
		JPanel startPage = new JPanel();
		MainCard.add(startPage);
		startPage.setLayout(null);
		
		JPanel startPage_bot = new JPanel();
		BottomCard.add(startPage_bot);
		startPage_bot.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//-------Home Page-------//
		
		JPanel HomePage = new JPanel();
		MainCard.add(HomePage);
		
		JPanel HomePage_bot = new JPanel();
		BottomCard.add(HomePage_bot);
		HomePage_bot.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//-------New Customer Form Page-------//
		
		JPanel NewCustomerForm = new JPanel();
		MainCard.add(NewCustomerForm);
		NewCustomerForm.setLayout(null);
		
		JPanel NewCustomerForm_bot = new JPanel();
		BottomCard.add(NewCustomerForm_bot);
		NewCustomerForm_bot.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//-------Customer Search Page-------//
		
		JPanel CustomerSearch = new JPanel();
		MainCard.add(CustomerSearch);
		CustomerSearch.setLayout(null);
		
		JPanel CustomerSearch_bot = new JPanel();
		BottomCard.add(CustomerSearch_bot);
		
		//-------Customer Search Result Page-------//
		
		JScrollPane CustomerSearchResult = new JScrollPane();
		MainCard.add(CustomerSearchResult);
		
		JPanel CustomerSearchResult_bot = new JPanel();
		BottomCard.add(CustomerSearchResult_bot);
		
		//-------Action Page-------//
		
		JPanel ActionPage = new JPanel();
		MainCard.add(ActionPage);
		ActionPage.setLayout(null);
		
		JPanel ActionPage_bot = new JPanel();
		BottomCard.add(ActionPage_bot);
		
		//-------Track Package Page-------//
		
		JPanel TrackPackagePage = new JPanel();
		MainCard.add(TrackPackagePage);
		TrackPackagePage.setLayout(null);
		
		JPanel TrackPackagePage_bot = new JPanel();
		BottomCard.add(TrackPackagePage_bot);
		
		//-------Track Package Result Page-------//
		
		JScrollPane TrackPackageResult = new JScrollPane();
		MainCard.add(TrackPackageResult);
		
		JPanel TrackPackageResult_bot = new JPanel();
		BottomCard.add(TrackPackageResult_bot);
		
		//-------Shipment Form Page-------//
		
		JPanel ShipmentForm = new JPanel();
		MainCard.add(ShipmentForm);
		ShipmentForm.setLayout(new BorderLayout(0, 0));
		
		JPanel shipFormFields = new JPanel();
		ShipmentForm.add(shipFormFields, BorderLayout.CENTER);
		shipFormFields.setLayout(null);
		
		JPanel ShipmentForm_bot = new JPanel();
		BottomCard.add(ShipmentForm_bot);
		
		JPanel shipSummary = new JPanel();
		ShipmentForm.add(shipSummary, BorderLayout.SOUTH);
		shipSummary.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel PackageSummary = new JPanel();
		ShipmentForm.add(PackageSummary, BorderLayout.EAST);
		
		//-------Customer Info Page-------//
		
		JPanel CustomerInfoPage = new JPanel();
		MainCard.add(CustomerInfoPage);
		CustomerInfoPage.setLayout(null);
		
		JPanel CustomerInfoPage_bot1 = new JPanel();
		BottomCard.add(CustomerInfoPage_bot1);
		
		JPanel CustomerInfoPage_bot2 = new JPanel();
		BottomCard.add(CustomerInfoPage_bot2);
		
		//-------Contract Info Page-------//
		
		JPanel ContractPage = new JPanel();
		MainCard.add(ContractPage);
		ContractPage.setLayout(new BoxLayout(ContractPage, BoxLayout.Y_AXIS));
		
		JPanel ContractPage_bot = new JPanel();
		BottomCard.add(ContractPage_bot);
		
		JPanel Bronze = new JPanel();
		ContractPage.add(Bronze);
		Bronze.setLayout(new BorderLayout(0, 0));
		
	
		JPanel Silver = new JPanel();
		ContractPage.add(Silver);
		Silver.setLayout(new BorderLayout(0, 0));
		
		JPanel Gold = new JPanel();
		ContractPage.add(Gold);
		Gold.setLayout(new BorderLayout(0, 0));
		
		//-------Charge History Page-------//
		
		JScrollPane ChargeHistory = new JScrollPane();
		MainCard.add(ChargeHistory);
		
		JPanel ChargeHistory_bot = new JPanel();
		BottomCard.add(ChargeHistory_bot);
		
		JScrollPane PaymentHistory = new JScrollPane();
		MainCard.add(PaymentHistory);
		
		
		
		
		
		
	//components and fields of GUI 
		
		//-------Start Page-------//
		
		JLabel label = new JLabel("'Company Name' Shipping Service");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Candara", Font.PLAIN, 24));
		label.setBounds(10, 11, 446, 209);
		startPage.add(label);
		
		JButton StartButton = new JButton("Start");
		startPage_bot.add(StartButton);
		StartButton.setFont(new Font("Candara", Font.PLAIN, 16));
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(HomePage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(HomePage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		//-------Home Page-------//
		
		JButton newCustomer = new JButton("New Customer");
		newCustomer.setFont(new Font("Candara", Font.PLAIN, 16));
		HomePage_bot.add(newCustomer);
		newCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(NewCustomerForm);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(NewCustomerForm_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		
		JButton ReturnCustomer = new JButton("Returning Customer");
		ReturnCustomer.setFont(new Font("Candara", Font.PLAIN, 16));
		HomePage_bot.add(ReturnCustomer);
		ReturnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainCard.removeAll();
				MainCard.add(CustomerSearch);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(CustomerSearch_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JButton TrackPackage = new JButton("Track Package");
		TrackPackage.setFont(new Font("Candara", Font.PLAIN, 16));
		HomePage_bot.add(TrackPackage);
		TrackPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(TrackPackagePage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(TrackPackagePage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		//-------New Customer Form Page-------//
		
		JLabel NCF_nameHeading = new JLabel("Name");
		NCF_nameHeading.setBounds(29, 11, 80, 19);
		NewCustomerForm.add(NCF_nameHeading);
		
		JLabel NFC_fnameHeading = new JLabel("First Name");
		NFC_fnameHeading.setBounds(43, 41, 92, 20);
		NewCustomerForm.add(NFC_fnameHeading);
		
		NFC_fName = new JTextField();
		NFC_fName.setBounds(115, 41, 111, 20);
		NFC_fName.setColumns(10);
		NewCustomerForm.add(NFC_fName);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setBounds(44, 82, 102, 20);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		NewCustomerForm.add(label_3);
		
		NFC_lName = new JTextField();
		NFC_lName.setBounds(115, 82, 111, 20);
		NFC_lName.setColumns(10);
		NewCustomerForm.add(NFC_lName);
		
		JLabel label_4 = new JLabel("Address");
		label_4.setBounds(29, 123, 80, 19);
		NewCustomerForm.add(label_4);
		
		JLabel label_5 = new JLabel("Street");
		label_5.setBounds(54, 156, 55, 20);
		NewCustomerForm.add(label_5);
		
		NFC_street = new JTextField();
		NFC_street.setBounds(115, 156, 237, 20);
		NFC_street.setColumns(10);
		NewCustomerForm.add(NFC_street);
		
		JLabel label_6 = new JLabel("City");
		label_6.setBounds(59, 187, 50, 21);
		NewCustomerForm.add(label_6);
		
		NFC_city = new JTextField();
		NFC_city.setBounds(115, 187, 111, 20);
		NFC_city.setColumns(10);
		NewCustomerForm.add(NFC_city);
		
		JLabel label_7 = new JLabel("State");
		label_7.setBounds(257, 190, 53, 14);
		NewCustomerForm.add(label_7);
		
		JLabel label_8 = new JLabel("Zip");
		label_8.setBounds(62, 233, 47, 14);
		NewCustomerForm.add(label_8);
		
		NFC_zip = new JTextField();
		NFC_zip.setBounds(115, 228, 111, 19);
		NFC_zip.setColumns(10);
		NewCustomerForm.add(NFC_zip);
		
		JLabel label_9 = new JLabel("Contact");
		label_9.setBounds(29, 258, 80, 14);
		NewCustomerForm.add(label_9);
		
		JLabel lblPhone = new JLabel("Phone #");
		lblPhone.setBounds(48, 281, 61, 14);
		NewCustomerForm.add(lblPhone);
		
		NFC_phone1 = new JTextField();
		NFC_phone1.setBounds(115, 278, 35, 20);
		NFC_phone1.setColumns(10);
		NewCustomerForm.add(NFC_phone1);
		
		NFC_phone2 = new JTextField();
		NFC_phone2.setBounds(160, 278, 35, 20);
		NFC_phone2.setColumns(10);
		NewCustomerForm.add(NFC_phone2);
		
		NFC_phone3 = new JTextField();
		NFC_phone3.setBounds(205, 278, 55, 20);
		NFC_phone3.setColumns(10);
		NewCustomerForm.add(NFC_phone3);
		
		JLabel label_11 = new JLabel("Email ");
		label_11.setBounds(55, 315, 54, 14);
		NewCustomerForm.add(label_11);
		
		NFC_email = new JTextField();
		NFC_email.setBounds(115, 312, 111, 20);
		NFC_email.setColumns(10);
		NewCustomerForm.add(NFC_email);
		
		JComboBox NFC_state = new JComboBox();
		NFC_state.setBounds(297, 187, 55, 20);
		NFC_state.setModel(new DefaultComboBoxModel(new String[] {"", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		NFC_state.setMaximumRowCount(10);
		NewCustomerForm.add(NFC_state);
		
		
		JButton NCF_Save = new JButton("Save");
		NCF_Save.setFont(new Font("Candara", Font.PLAIN, 16));
		NewCustomerForm_bot.add(NCF_Save);
		NCF_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerCheck = true;
				
				MainCard.removeAll();
				MainCard.add(ActionPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(ActionPage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		
		JButton NCF_Cancel = new JButton("Cancel");
		NCF_Cancel.setFont(new Font("Candara", Font.PLAIN, 16));
		NewCustomerForm_bot.add(NCF_Cancel);
		NCF_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(HomePage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(HomePage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		//-------Customer Search Page-------//
		
		JLabel lblNewLabel = new JLabel("Search Customer By...");
		lblNewLabel.setBounds(132, 11, 221, 30);
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CustomerSearch.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(38, 74, 50, 22);
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 18));
		CustomerSearch.add(lblNewLabel_1);
		
		CS_fName = new JTextField();
		CS_fName.setBounds(117, 75, 99, 20);
		CustomerSearch.add(CS_fName);
		CS_fName.setColumns(10);
		
		CS_lName = new JTextField();
		CS_lName.setColumns(10);
		CS_lName.setBounds(254, 75, 99, 20);
		CustomerSearch.add(CS_lName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Candara", Font.PLAIN, 18));
		lblEmail.setBounds(38, 188, 50, 22);
		CustomerSearch.add(lblEmail);
		
		CS_email = new JTextField();
		CS_email.setBounds(117, 189, 236, 20);
		CustomerSearch.add(CS_email);
		CS_email.setColumns(10);
		
		JLabel lblPhone_1 = new JLabel("Phone:");
		lblPhone_1.setFont(new Font("Candara", Font.PLAIN, 18));
		lblPhone_1.setBounds(38, 291, 64, 22);
		CustomerSearch.add(lblPhone_1);
		
		CS_phone1 = new JTextField();
		CS_phone1.setBounds(117, 292, 35, 20);
		CustomerSearch.add(CS_phone1);
		CS_phone1.setColumns(10);
		
		CS_phone2 = new JTextField();
		CS_phone2.setColumns(10);
		CS_phone2.setBounds(162, 292, 35, 20);
		CustomerSearch.add(CS_phone2);
		
		CS_phone3 = new JTextField();
		CS_phone3.setColumns(10);
		CS_phone3.setBounds(207, 292, 50, 20);
		CustomerSearch.add(CS_phone3);
		
		JLabel lblNewLabel_2 = new JLabel("OR");
		lblNewLabel_2.setFont(new Font("Candara", Font.BOLD, 18));
		lblNewLabel_2.setBounds(38, 137, 46, 14);
		CustomerSearch.add(lblNewLabel_2);
		
		JLabel label_10 = new JLabel("OR");
		label_10.setFont(new Font("Candara", Font.BOLD, 18));
		label_10.setBounds(38, 249, 46, 14);
		CustomerSearch.add(label_10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(132, 100, 70, 14);
		CustomerSearch.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(264, 100, 70, 14);
		CustomerSearch.add(lblLastName);
		
		JButton CS_search = new JButton("Search");
		CS_search.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerSearch_bot.add(CS_search);
		CS_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(CustomerSearchResult);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(CustomerSearchResult_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JButton CS_back = new JButton("Back");
		CS_back.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerSearch_bot.add(CS_back);
		CS_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(HomePage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(HomePage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
				
		//-------Customer Search Result Page-------//
		
		CSR_table = new JTable();
		CSR_table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"First Name", "Last Name", "Address", "Phone #", "Email"
			}
		));
		CSR_table.setFont(new Font("Candara", Font.PLAIN, 11));
		CustomerSearchResult.setViewportView(CSR_table);
		
		JButton CSR_select = new JButton("Select");
		CSR_select.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerSearchResult_bot.add(CSR_select);
		CSR_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customerCheck = true;
				
				MainCard.removeAll();
				MainCard.add(ActionPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(ActionPage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JButton CSR_back = new JButton("Back");
		CSR_back.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerSearchResult_bot.add(CSR_back);
		CSR_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(CustomerSearch);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(CustomerSearch_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		//-------Action Page-------//
		
		JButton AP_home = new JButton("Home");
		AP_home.setFont(new Font("Candara", Font.PLAIN, 18));
		AP_home.setBounds(373, 11, 89, 23);
		ActionPage.add(AP_home);
		AP_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customerCheck = false;
				
				MainCard.removeAll();
				MainCard.add(HomePage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(HomePage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JLabel lblCustomerInfosummary = new JLabel("Customer Info/Summary");
		lblCustomerInfosummary.setFont(new Font("Candara", Font.PLAIN, 18));
		lblCustomerInfosummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerInfosummary.setBounds(31, 97, 411, 237);
		ActionPage.add(lblCustomerInfosummary);
		
		JButton AP_Ship = new JButton("Start Shipment");
		AP_Ship.setFont(new Font("Candara", Font.PLAIN, 16));
		ActionPage_bot.add(AP_Ship);
		AP_Ship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainCard.removeAll();
				MainCard.add(ShipmentForm);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(ShipmentForm_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JButton AP_track = new JButton("Track Package");
		AP_track.setFont(new Font("Candara", Font.PLAIN, 16));
		ActionPage_bot.add(AP_track);
		AP_track.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(TrackPackagePage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(TrackPackagePage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JButton AP_cInfo = new JButton("Customer Info");
		AP_cInfo.setFont(new Font("Candara", Font.PLAIN, 16));
		ActionPage_bot.add(AP_cInfo);
		AP_cInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(CustomerInfoPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(CustomerInfoPage_bot1);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		//-------Track Package Page-------//
		
		JLabel lblTracking = new JLabel("Tracking #");
		lblTracking.setFont(new Font("Candara", Font.PLAIN, 18));
		lblTracking.setBounds(97, 152, 86, 44);
		TrackPackagePage.add(lblTracking);
		
		TPP_number = new JTextField();
		TPP_number.setBounds(207, 164, 178, 20);
		TrackPackagePage.add(TPP_number);
		TPP_number.setColumns(10);
		
		JButton TPP_search = new JButton("Search");
		TPP_search.setFont(new Font("Candara", Font.PLAIN, 16));
		TrackPackagePage_bot.add(TPP_search);
		TPP_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainCard.removeAll();
				MainCard.add(TrackPackageResult);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(TrackPackageResult_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		
		JButton TPP_Back = new JButton("Back");
		TPP_Back.setFont(new Font("Candara", Font.PLAIN, 16));
		TrackPackagePage_bot.add(TPP_Back);
		TPP_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (customerCheck == true){
					MainCard.removeAll();
					MainCard.add(ActionPage);
					MainCard.repaint();
					MainCard.revalidate();
			
					BottomCard.removeAll();
					BottomCard.add(ActionPage_bot);
					BottomCard.repaint();
					BottomCard.revalidate();
			} else {
					MainCard.removeAll();
					MainCard.add(HomePage);
					MainCard.repaint();
					MainCard.revalidate();
				
					BottomCard.removeAll();
					BottomCard.add(HomePage_bot);
					BottomCard.repaint();
					BottomCard.revalidate();
			}
				}
				
		});
		
		//-------Track Package Result Page-------//
		
		JLabel lblShipmentIdAnd = new JLabel("Shipment ID and Estimated Delivery Date");
		lblShipmentIdAnd.setFont(new Font("Candara", Font.PLAIN, 18));
		lblShipmentIdAnd.setHorizontalAlignment(SwingConstants.CENTER);
		TrackPackageResult.setColumnHeaderView(lblShipmentIdAnd);
		
		TPR_table = new JTable();
		TPR_table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Location", "Date", "Status", "Mode"
			}
		));
		TrackPackageResult.setViewportView(TPR_table);
		
		JButton TPR_trackAnother = new JButton("Search Another Package");
		TPR_trackAnother.setFont(new Font("Candara", Font.PLAIN, 16));
		TrackPackageResult_bot.add(TPR_trackAnother);
		TPR_trackAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainCard.removeAll();
				MainCard.add(TrackPackagePage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(TrackPackagePage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		//-------Shipment Form Page-------//
		
		JLabel lblShipLocation = new JLabel("Ship Location");
		lblShipLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblShipLocation.setBounds(10, 11, 97, 14);
		shipFormFields.add(lblShipLocation);
		
		SF_storeid = new JTextField();
		SF_storeid.setBounds(101, 8, 86, 20);
		shipFormFields.add(SF_storeid);
		SF_storeid.setColumns(10);
		
		JLabel lblShipDate = new JLabel("Ship Date");
		lblShipDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblShipDate.setBounds(10, 48, 65, 14);
		shipFormFields.add(lblShipDate);
		
		SF_shipdate = new JTextField();
		SF_shipdate.setEnabled(false);
		SF_shipdate.setColumns(10);
		SF_shipdate.setBounds(101, 45, 86, 20);
		shipFormFields.add(SF_shipdate);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(10, 85, 65, 14);
		shipFormFields.add(lblDestination);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStreet.setBounds(10, 110, 65, 14);
		shipFormFields.add(lblStreet);
		
		SF_street = new JTextField();
		SF_street.setColumns(10);
		SF_street.setBounds(90, 107, 215, 20);
		shipFormFields.add(SF_street);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(10, 142, 65, 14);
		shipFormFields.add(lblCity);
		
		SF_city = new JTextField();
		SF_city.setColumns(10);
		SF_city.setBounds(90, 138, 86, 20);
		shipFormFields.add(SF_city);
		
		JLabel label_12 = new JLabel("State");
		label_12.setBounds(186, 142, 41, 14);
		shipFormFields.add(label_12);
		
		JComboBox SF_state = new JComboBox();
		SF_state.setModel(new DefaultComboBoxModel(new String[] {"", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		SF_state.setMaximumRowCount(10);
		SF_state.setBounds(222, 139, 83, 20);
		shipFormFields.add(SF_state);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZip.setBounds(10, 177, 65, 14);
		shipFormFields.add(lblZip);
		
		SF_zip = new JTextField();
		SF_zip.setColumns(10);
		SF_zip.setBounds(90, 174, 42, 20);
		shipFormFields.add(SF_zip);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(36, 215, 71, 14);
		shipFormFields.add(lblCountry);
		
		JComboBox SF_country = new JComboBox();
		SF_country.setModel(new DefaultComboBoxModel(new String[] {"United States", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"}));
		SF_country.setMaximumRowCount(10);
		SF_country.setBounds(90, 212, 129, 20);
		shipFormFields.add(SF_country);
		
		JRadioButton SF_overnight = new JRadioButton("Over Night");
		SF_overnight.setSelected(true);
		SF_overnight.setBounds(68, 275, 97, 23);
		shipFormFields.add(SF_overnight);
		
		JRadioButton SF_express = new JRadioButton("Express");
		SF_express.setBounds(68, 305, 87, 23);
		shipFormFields.add(SF_express);
		
		JRadioButton SF_regular = new JRadioButton("Regular");
		SF_regular.setBounds(68, 331, 87, 23);
		shipFormFields.add(SF_regular);
		
		JCheckBox SF_international = new JCheckBox("International");
		SF_international.setBounds(165, 275, 97, 23);
		shipFormFields.add(SF_international);
		
		JCheckBox SF_oversized = new JCheckBox("Oversized");
		SF_oversized.setBounds(165, 305, 97, 23);
		shipFormFields.add(SF_oversized);
		
		JCheckBox SF_hazardous = new JCheckBox("Hazardous ");
		SF_hazardous.setBounds(165, 331, 97, 23);
		shipFormFields.add(SF_hazardous);
		
		JLabel lblShippingMethod = new JLabel("Shipping Method");
		lblShippingMethod.setBounds(10, 255, 97, 14);
		shipFormFields.add(lblShippingMethod);
		
		ButtonGroup shipSpeed = new ButtonGroup();
		shipSpeed.add(SF_overnight);
		shipSpeed.add(SF_express);
		shipSpeed.add(SF_regular);
		
		JLabel lblPrice = new JLabel("Price");
		shipSummary.add(lblPrice);
		
		SF_price = new JTextField();
		SF_price.setEnabled(false);
		shipSummary.add(SF_price);
		SF_price.setColumns(10);
		
		JLabel lblExpectedDelivery = new JLabel("Expected Delivery");
		shipSummary.add(lblExpectedDelivery);
		
		SF_deliverydate = new JTextField();
		SF_deliverydate.setEnabled(false);
		shipSummary.add(SF_deliverydate);
		SF_deliverydate.setColumns(10);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Packages");
		lblNewLabel_3.setFont(new Font("Candara", Font.PLAIN, 18));
		PackageSummary.add(lblNewLabel_3);
		
		
		JButton SF_submit = new JButton("Submit");
		SF_submit.setFont(new Font("Candara", Font.PLAIN, 16));
		ShipmentForm_bot.add(SF_submit);
		SF_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(ActionPage);
				MainCard.repaint();
				MainCard.revalidate();
		
				BottomCard.removeAll();
				BottomCard.add(ActionPage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JButton SF_package = new JButton("Add Package");
		SF_package.setFont(new Font("Candara", Font.PLAIN, 16));
		ShipmentForm_bot.add(SF_package);
		SF_package.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				packageForms pf = new packageForms();
				pf.setVisible(true);
			}
		});
		
		JButton SF_cancel = new JButton("Cancel");
		SF_cancel.setFont(new Font("Candara", Font.PLAIN, 16));
		ShipmentForm_bot.add(SF_cancel);
		SF_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(ActionPage);
				MainCard.repaint();
				MainCard.revalidate();
		
				BottomCard.removeAll();
				BottomCard.add(ActionPage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		//-------Customer Info Page-------//
		
		JLabel lblCustomerId = new JLabel("Customer ID: _____________");
		lblCustomerId.setBounds(26, 11, 159, 19);
		CustomerInfoPage.add(lblCustomerId);
		
		JLabel label_14 = new JLabel("First Name");
		label_14.setBounds(40, 41, 92, 20);
		CustomerInfoPage.add(label_14);
		
		CIP_fname = new JTextField();
		CIP_fname.setEditable(false);
		CIP_fname.setColumns(10);
		CIP_fname.setBounds(112, 41, 111, 20);
		CustomerInfoPage.add(CIP_fname);
		
		JLabel label_15 = new JLabel("Last Name");
		label_15.setHorizontalAlignment(SwingConstants.LEFT);
		label_15.setBounds(41, 82, 102, 20);
		CustomerInfoPage.add(label_15);
		
		CIP_lname = new JTextField();
		CIP_lname.setEditable(false);
		CIP_lname.setColumns(10);
		CIP_lname.setBounds(112, 82, 111, 20);
		CustomerInfoPage.add(CIP_lname);
		
		JLabel label_16 = new JLabel("Address");
		label_16.setBounds(26, 123, 80, 19);
		CustomerInfoPage.add(label_16);
		
		JLabel label_17 = new JLabel("Street");
		label_17.setBounds(51, 156, 55, 20);
		CustomerInfoPage.add(label_17);
		
		CIP_address = new JTextField();
		CIP_address.setEditable(false);
		CIP_address.setColumns(10);
		CIP_address.setBounds(112, 156, 237, 20);
		CustomerInfoPage.add(CIP_address);
		
		JLabel label_18 = new JLabel("City");
		label_18.setBounds(56, 187, 50, 21);
		CustomerInfoPage.add(label_18);
		
		CIP_city = new JTextField();
		CIP_city.setEditable(false);
		CIP_city.setColumns(10);
		CIP_city.setBounds(112, 187, 111, 20);
		CustomerInfoPage.add(CIP_city);
		
		JLabel label_19 = new JLabel("State");
		label_19.setBounds(254, 190, 53, 14);
		CustomerInfoPage.add(label_19);
		
		JLabel label_20 = new JLabel("Zip");
		label_20.setBounds(59, 233, 47, 14);
		CustomerInfoPage.add(label_20);
		
		CIP_zip = new JTextField();
		CIP_zip.setEditable(false);
		CIP_zip.setColumns(10);
		CIP_zip.setBounds(112, 228, 111, 19);
		CustomerInfoPage.add(CIP_zip);
		
		JLabel label_21 = new JLabel("Contact");
		label_21.setBounds(26, 258, 80, 14);
		CustomerInfoPage.add(label_21);
		
		JLabel label_22 = new JLabel("Phone #");
		label_22.setBounds(45, 281, 61, 14);
		CustomerInfoPage.add(label_22);
		
		CIP_phone1 = new JTextField();
		CIP_phone1.setEditable(false);
		CIP_phone1.setColumns(10);
		CIP_phone1.setBounds(112, 278, 35, 20);
		CustomerInfoPage.add(CIP_phone1);
		
		CIP_phone2 = new JTextField();
		CIP_phone2.setEditable(false);
		CIP_phone2.setColumns(10);
		CIP_phone2.setBounds(157, 278, 35, 20);
		CustomerInfoPage.add(CIP_phone2);
		
		CIP_phone3 = new JTextField();
		CIP_phone3.setEditable(false);
		CIP_phone3.setColumns(10);
		CIP_phone3.setBounds(202, 278, 55, 20);
		CustomerInfoPage.add(CIP_phone3);
		
		JLabel label_23 = new JLabel("Email ");
		label_23.setBounds(52, 315, 54, 14);
		CustomerInfoPage.add(label_23);
		
		CIP_email = new JTextField();
		CIP_email.setEditable(false);
		CIP_email.setColumns(10);
		CIP_email.setBounds(112, 312, 111, 20);
		CustomerInfoPage.add(CIP_email);
		
		JComboBox CIP_state = new JComboBox();
		CIP_state.setModel(new DefaultComboBoxModel(new String[] {"", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		CIP_state.setEnabled(false);
		CIP_state.setMaximumRowCount(10);
		CIP_state.setBounds(294, 187, 55, 20);
		CustomerInfoPage.add(CIP_state);
		
		JLabel lblContract = new JLabel("Contract: _____________");
		lblContract.setBounds(278, 13, 159, 19);
		CustomerInfoPage.add(lblContract);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBounds(34, 351, 68, 14);
		CustomerInfoPage.add(lblUserName);
		
		CIP_username = new JTextField();
		CIP_username.setEditable(false);
		CIP_username.setColumns(10);
		CIP_username.setBounds(112, 348, 111, 20);
		CustomerInfoPage.add(CIP_username);
		
	
		
		JButton CIP_Edit = new JButton("Edit Info");
		CIP_Edit.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerInfoPage_bot1.add(CIP_Edit);
		CIP_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CIP_fname.setEditable(true);
				CIP_lname.setEditable(true);
				CIP_address.setEditable(true);
				CIP_city.setEditable(true);
				CIP_state.setEnabled(true);
				CIP_zip.setEditable(true);
				CIP_phone1.setEditable(true);
				CIP_phone2.setEditable(true);
				CIP_phone3.setEditable(true);
				CIP_email.setEditable(true);
				CIP_username.setEditable(true);
				
				BottomCard.removeAll();
				BottomCard.add(CustomerInfoPage_bot2);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JButton CIP_payment = new JButton("Check Payments");
		CIP_payment.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerInfoPage_bot1.add(CIP_payment);
		CIP_payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(ChargeHistory);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(ChargeHistory_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			
			}
		});
		
		
		JButton CIP_contract = new JButton("Add Contract");
		CIP_contract.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerInfoPage_bot1.add(CIP_contract);
		CIP_contract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(ContractPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(ContractPage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JButton CIP_back = new JButton("Back");
		CIP_back.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerInfoPage_bot1.add(CIP_back);
		CIP_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(ActionPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(ActionPage_bot);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		

		JButton CIP2_save = new JButton("Save Info");
		CIP2_save.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerInfoPage_bot2.add(CIP2_save);
		CIP2_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CIP_fname.setEditable(false);
				CIP_lname.setEditable(false);
				CIP_address.setEditable(false);
				CIP_city.setEditable(false);
				CIP_state.setEnabled(false);
				CIP_zip.setEditable(false);
				CIP_phone1.setEditable(false);
				CIP_phone2.setEditable(false);
				CIP_phone3.setEditable(false);
				CIP_email.setEditable(false);
				CIP_username.setEditable(false);
				
				BottomCard.removeAll();
				BottomCard.add(CustomerInfoPage_bot1);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		JButton CIP2_pay = new JButton("Check Payments");
		CIP2_pay.setEnabled(false);
		CIP2_pay.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerInfoPage_bot2.add(CIP2_pay);
		
		JButton CIP2_contract = new JButton("Add Contract");
		CIP2_contract.setEnabled(false);
		CIP2_contract.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerInfoPage_bot2.add(CIP2_contract);
		
		JButton CIP2_cancel = new JButton("Cancel");
		CIP2_cancel.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerInfoPage_bot2.add(CIP2_cancel);
		CIP2_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CIP_fname.setEditable(false);
				CIP_lname.setEditable(false);
				CIP_address.setEditable(false);
				CIP_city.setEditable(false);
				CIP_state.setEnabled(false);
				CIP_zip.setEditable(false);
				CIP_phone1.setEditable(false);
				CIP_phone2.setEditable(false);
				CIP_phone3.setEditable(false);
				CIP_email.setEditable(false);
				CIP_username.setEditable(false);
				
				BottomCard.removeAll();
				BottomCard.add(CustomerInfoPage_bot1);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		//-------Contract Info Page-------//
		
		JLabel lblNewLabel_4 = new JLabel("Bronze");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Candara", Font.PLAIN, 43));
		Bronze.add(lblNewLabel_4, BorderLayout.WEST);
		
		JTextArea CP_bronzeinfo = new JTextArea();
		CP_bronzeinfo.setBackground(Color.LIGHT_GRAY);
		CP_bronzeinfo.setEditable(false);
		CP_bronzeinfo.setText("Sed metus magna, dictum id rutrum sed, tincidunt non sapien. Praesent a feugiat mi. Donec consequat commodo velit sed porttitor.");
		CP_bronzeinfo.setLineWrap(true);
		Bronze.add(CP_bronzeinfo, BorderLayout.CENTER);
		
		JButton CP_bronze = new JButton("Add Contract");
		CP_bronze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(CustomerInfoPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(CustomerInfoPage_bot1);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		Bronze.add(CP_bronze, BorderLayout.SOUTH);
		
		
		JLabel lblSilver = new JLabel("  Silver ");
		lblSilver.setHorizontalAlignment(SwingConstants.CENTER);
		lblSilver.setFont(new Font("Candara", Font.PLAIN, 43));
		Silver.add(lblSilver, BorderLayout.WEST);
		
		JButton CP_silver = new JButton("Add Contract");
		CP_silver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(CustomerInfoPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(CustomerInfoPage_bot1);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		Silver.add(CP_silver, BorderLayout.SOUTH);
		
		JTextArea CP_silverinfo = new JTextArea();
		CP_silverinfo.setBackground(Color.GRAY);
		CP_silverinfo.setEditable(false);
		CP_silverinfo.setText("Sed metus magna, dictum id rutrum sed, tincidunt non sapien. Praesent a feugiat mi. Donec consequat commodo velit sed porttitor.");
		CP_silverinfo.setLineWrap(true);
		Silver.add(CP_silverinfo, BorderLayout.CENTER);
		
		
		JLabel lblGold = new JLabel("  Gold  ");
		lblGold.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold.setFont(new Font("Candara", Font.PLAIN, 43));
		Gold.add(lblGold, BorderLayout.WEST);
		
		JButton CP_gold = new JButton("Add Contract");
		CP_gold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(CustomerInfoPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(CustomerInfoPage_bot1);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		Gold.add(CP_gold, BorderLayout.SOUTH);
		
		JTextArea CP_goldinfo = new JTextArea();
		CP_goldinfo.setBackground(Color.LIGHT_GRAY);
		CP_goldinfo.setEditable(false);
		CP_goldinfo.setText("Sed metus magna, dictum id rutrum sed, tincidunt non sapien. Praesent a feugiat mi. Donec consequat commodo velit sed porttitor.");
		CP_goldinfo.setLineWrap(true);
		Gold.add(CP_goldinfo, BorderLayout.CENTER);
		
		JButton CP_back = new JButton("Back");
		CP_back.setFont(new Font("Candara", Font.PLAIN, 16));
		ContractPage_bot.add(CP_back);
		CP_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(CustomerInfoPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(CustomerInfoPage_bot1);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
		});
		
		//-------Charge History Page-------//
		
		ChargeTable = new JTable();
		ChargeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Shipment ID", "Date Paid", "Total", "Credit Card"
			}
		));
		ChargeHistory.setViewportView(ChargeTable);
		
		PaymentTable = new JTable();
		PaymentTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Shipment ID", "Amount", "Due Date", "Date Paid"
			}
		));
		PaymentHistory.setViewportView(PaymentTable);
		
		
		
		JButton CH_pay = new JButton("Billed Payments");
		
		JButton CH_charge = new JButton("Charge History");
		CH_charge.setEnabled(false);
		CH_charge.setFont(new Font("Candara", Font.PLAIN, 16));
		ChargeHistory_bot.add(CH_charge);
		CH_charge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(ChargeHistory);
				MainCard.repaint();
				MainCard.revalidate();
				
				CH_charge.setEnabled(false);
				CH_pay.setEnabled(true);
			}
		});
		
		
		
		CH_pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainCard.removeAll();
				MainCard.add(PaymentHistory);
				MainCard.repaint();
				MainCard.revalidate();
				
				CH_pay.setEnabled(false);
				CH_charge.setEnabled(true);
			}
		});
		
		CH_pay.setFont(new Font("Candara", Font.PLAIN, 16));
		ChargeHistory_bot.add(CH_pay);
		
		JButton CH_back = new JButton("Back");
		CH_back.setFont(new Font("Candara", Font.PLAIN, 16));
		ChargeHistory_bot.add(CH_back);
		CH_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCard.removeAll();
				MainCard.add(CustomerInfoPage);
				MainCard.repaint();
				MainCard.revalidate();
				
				BottomCard.removeAll();
				BottomCard.add(CustomerInfoPage_bot1);
				BottomCard.repaint();
				BottomCard.revalidate();
			}
			
		});
		
		
		
	}
}