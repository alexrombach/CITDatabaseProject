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
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CIT345Project extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTable table;
	private JTextField TrackPackageNumber;
	
	public boolean customerCheck = false;
	private JTable table_1;

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
		
		JPanel MainCard = new JPanel();
		mainScreen.add(MainCard, BorderLayout.CENTER);
		MainCard.setLayout(new CardLayout(0, 0));
		
		JPanel BottomCard = new JPanel();
		BottomPanel.add(BottomCard);
		BottomCard.setLayout(new CardLayout(0, 0));
		
		JPanel startPage_bot = new JPanel();
		BottomCard.add(startPage_bot, "name_84649739000345");
		startPage_bot.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel startPage = new JPanel();
		MainCard.add(startPage, "name_83865946577291");
		startPage.setLayout(null);
		
		JPanel HomePage = new JPanel();
		MainCard.add(HomePage, "name_84201404307733");
		
		JPanel HomePage_bot = new JPanel();
		BottomCard.add(HomePage_bot, "name_84649750227452");
		HomePage_bot.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel NewCustomerForm = new JPanel();
		MainCard.add(NewCustomerForm, "name_86198528038333");
		
		JPanel NewCustomerForm_bot = new JPanel();
		BottomCard.add(NewCustomerForm_bot, "name_86316388569319");
		
		JPanel CustomerSearch = new JPanel();
		MainCard.add(CustomerSearch, "name_133701589026577");
		CustomerSearch.setLayout(null);
		
		JPanel CustomerSearch_bot = new JPanel();
		BottomCard.add(CustomerSearch_bot, "name_134240995581362");
		
		
		JScrollPane CustomerSearchResult = new JScrollPane();
		MainCard.add(CustomerSearchResult, "name_137144002255503");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"First Name", "Last Name", "Address", "Phone #", "Email"
			}
		));
		table.setFont(new Font("Candara", Font.PLAIN, 11));
		CustomerSearchResult.setViewportView(table);
		
		JPanel CustomerSearchResult_bot = new JPanel();
		BottomCard.add(CustomerSearchResult_bot, "name_137230421348979");
		
		JPanel ActionPage = new JPanel();
		MainCard.add(ActionPage, "name_137776991583519");
		ActionPage.setLayout(null);
		
		JPanel ActionPage_bot = new JPanel();
		BottomCard.add(ActionPage_bot, "name_138087668219438");
		
		JPanel TrackPackagePage = new JPanel();
		MainCard.add(TrackPackagePage, "name_138911800654494");
		TrackPackagePage.setLayout(null);
		
		JPanel TrackPackagePage_bot = new JPanel();
		BottomCard.add(TrackPackagePage_bot, "name_139254578885868");
		
		JScrollPane TrackPackageResult = new JScrollPane();
		MainCard.add(TrackPackageResult, "name_140724520562752");
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Location", "Date", "Status", "Mode"
			}
		));
		TrackPackageResult.setViewportView(table_1);
		
		JPanel TrackPackageResult_bot = new JPanel();
		BottomCard.add(TrackPackageResult_bot, "name_141567230056212");
		
		
		//Form elements for Start and Home Page
		JButton StartButton = new JButton("Start");
		startPage_bot.add(StartButton);
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
		StartButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton newCustomer = new JButton("New Customer");
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
		newCustomer.setFont(new Font("Candara", Font.PLAIN, 16));
		HomePage_bot.add(newCustomer);
		
		JButton ReturnCustomer = new JButton("Returning Customer");
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
		ReturnCustomer.setFont(new Font("Candara", Font.PLAIN, 16));
		HomePage_bot.add(ReturnCustomer);
		
		JButton TrackPackage = new JButton("Track Package");
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
		TrackPackage.setFont(new Font("Candara", Font.PLAIN, 16));
		HomePage_bot.add(TrackPackage);
		
		JLabel label = new JLabel("'Company Name' Shipping Service");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Candara", Font.PLAIN, 24));
		label.setBounds(10, 11, 446, 209);
		startPage.add(label);
		NewCustomerForm_bot.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		// New Customer Form Page
		
	
		
		JButton NCF_Save = new JButton("Save");
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
		NCF_Save.setFont(new Font("Candara", Font.PLAIN, 16));
		NewCustomerForm_bot.add(NCF_Save);
		
		JButton NCF_Cancel = new JButton("Cancel");
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
		NCF_Cancel.setFont(new Font("Candara", Font.PLAIN, 16));
		NewCustomerForm_bot.add(NCF_Cancel);
		
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerSearch_bot.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerSearch_bot.add(btnNewButton_1);
		
		
		
		JButton CSR_select = new JButton("Select");
		CSR_select.setFont(new Font("Candara", Font.PLAIN, 16));
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
		CustomerSearchResult_bot.add(CSR_select);
		
		JButton CSR_back = new JButton("Back");
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
		CSR_back.setFont(new Font("Candara", Font.PLAIN, 16));
		CustomerSearchResult_bot.add(CSR_back);
		
		
		
		JButton AP_Ship = new JButton("Start Shipment");
		AP_Ship.setFont(new Font("Candara", Font.PLAIN, 16));
		ActionPage_bot.add(AP_Ship);
		
		JButton AP_track = new JButton("Track Package");
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
		AP_track.setFont(new Font("Candara", Font.PLAIN, 16));
		ActionPage_bot.add(AP_track);
		
		JButton AP_cInfo = new JButton("Customer Info");
		AP_cInfo.setFont(new Font("Candara", Font.PLAIN, 16));
		ActionPage_bot.add(AP_cInfo);
		
		
		JButton TPP_search = new JButton("Search");
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
		TPP_search.setFont(new Font("Candara", Font.PLAIN, 16));
		TrackPackagePage_bot.add(TPP_search);
		
		JButton TPP_Back = new JButton("Back");
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
		TPP_Back.setFont(new Font("Candara", Font.PLAIN, 16));
		TrackPackagePage_bot.add(TPP_Back);
		
		JButton TPR_trackAnother = new JButton("Search Another Package");
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
		TPR_trackAnother.setFont(new Font("Candara", Font.PLAIN, 16));
		TrackPackageResult_bot.add(TPR_trackAnother);
		
		NewCustomerForm.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("29px"),
				ColumnSpec.decode("80px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("51px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("50px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("36px:grow"),
				ColumnSpec.decode("162px"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("21px"),
				RowSpec.decode("20px"),
				RowSpec.decode("21px"),
				RowSpec.decode("19px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("21px"),
				RowSpec.decode("20px"),
				RowSpec.decode("19px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),}));
		
		JLabel label_1 = new JLabel("Name");
		NewCustomerForm.add(label_1, "2, 2, fill, fill");
		
		JLabel label_2 = new JLabel("First Name");
		NewCustomerForm.add(label_2, "2, 4, center, fill");
		
		textField = new JTextField();
		textField.setColumns(10);
		NewCustomerForm.add(textField, "4, 4, 5, 1, fill, top");
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		NewCustomerForm.add(label_3, "2, 6, center, fill");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		NewCustomerForm.add(textField_1, "4, 6, 5, 1, fill, top");
		
		JLabel label_4 = new JLabel("Address");
		NewCustomerForm.add(label_4, "2, 8, fill, fill");
		
		JLabel label_5 = new JLabel("Street");
		NewCustomerForm.add(label_5, "2, 10, center, fill");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		NewCustomerForm.add(textField_2, "4, 10, 6, 1, fill, top");
		
		JLabel label_6 = new JLabel("City");
		NewCustomerForm.add(label_6, "2, 12, center, fill");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		NewCustomerForm.add(textField_3, "4, 12, 3, 1, fill, top");
		
		JLabel label_7 = new JLabel("State");
		NewCustomerForm.add(label_7, "8, 12, center, center");
		
		JLabel label_8 = new JLabel("Zip");
		NewCustomerForm.add(label_8, "2, 14, center, bottom");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		NewCustomerForm.add(textField_4, "4, 14, 3, 1, fill, fill");
		
		JLabel label_9 = new JLabel("Contact");
		NewCustomerForm.add(label_9, "2, 16, fill, top");
		
		JLabel lblPhone = new JLabel("Phone #");
		NewCustomerForm.add(lblPhone, "2, 18, center, center");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		NewCustomerForm.add(textField_5, "4, 18, fill, top");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		NewCustomerForm.add(textField_6, "6, 18, left, top");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		NewCustomerForm.add(textField_7, "8, 18, fill, default");
		
		JLabel label_11 = new JLabel("Email ");
		NewCustomerForm.add(label_11, "2, 20, center, center");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		NewCustomerForm.add(textField_8, "4, 20, 3, 1, fill, top");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		comboBox.setMaximumRowCount(10);
		NewCustomerForm.add(comboBox, "9, 12, left, top");
		
		
		
		JLabel lblNewLabel = new JLabel("Search Customer By...");
		lblNewLabel.setBounds(132, 11, 221, 30);
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CustomerSearch.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(38, 74, 50, 22);
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 18));
		CustomerSearch.add(lblNewLabel_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(117, 75, 99, 20);
		CustomerSearch.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(254, 75, 99, 20);
		CustomerSearch.add(textField_10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Candara", Font.PLAIN, 18));
		lblEmail.setBounds(38, 188, 50, 22);
		CustomerSearch.add(lblEmail);
		
		textField_11 = new JTextField();
		textField_11.setBounds(117, 189, 236, 20);
		CustomerSearch.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblPhone_1 = new JLabel("Phone:");
		lblPhone_1.setFont(new Font("Candara", Font.PLAIN, 18));
		lblPhone_1.setBounds(38, 291, 64, 22);
		CustomerSearch.add(lblPhone_1);
		
		textField_12 = new JTextField();
		textField_12.setBounds(117, 292, 35, 20);
		CustomerSearch.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(162, 292, 35, 20);
		CustomerSearch.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(207, 292, 50, 20);
		CustomerSearch.add(textField_14);
		
		JLabel lblNewLabel_2 = new JLabel("OR");
		lblNewLabel_2.setFont(new Font("Candara", Font.BOLD, 18));
		lblNewLabel_2.setBounds(38, 137, 46, 14);
		CustomerSearch.add(lblNewLabel_2);
		
		JLabel label_10 = new JLabel("OR");
		label_10.setFont(new Font("Candara", Font.BOLD, 18));
		label_10.setBounds(38, 249, 46, 14);
		CustomerSearch.add(label_10);
		
	
		
		JButton ActionPage_home = new JButton("Home");
		ActionPage_home.addActionListener(new ActionListener() {
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
		ActionPage_home.setFont(new Font("Candara", Font.PLAIN, 18));
		ActionPage_home.setBounds(373, 11, 89, 23);
		ActionPage.add(ActionPage_home);
		
		JLabel lblCustomerInfosummary = new JLabel("Customer Info/Summary");
		lblCustomerInfosummary.setFont(new Font("Candara", Font.PLAIN, 18));
		lblCustomerInfosummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerInfosummary.setBounds(31, 97, 411, 237);
		ActionPage.add(lblCustomerInfosummary);
		
		
		JLabel lblTracking = new JLabel("Tracking #");
		lblTracking.setFont(new Font("Candara", Font.PLAIN, 18));
		lblTracking.setBounds(97, 152, 86, 44);
		TrackPackagePage.add(lblTracking);
		
		TrackPackageNumber = new JTextField();
		TrackPackageNumber.setBounds(207, 164, 178, 20);
		TrackPackagePage.add(TrackPackageNumber);
		TrackPackageNumber.setColumns(10);
		
		JLabel lblShipmentIdAnd = new JLabel("Shipment ID and Estimated Delivery Date");
		lblShipmentIdAnd.setFont(new Font("Candara", Font.PLAIN, 18));
		lblShipmentIdAnd.setHorizontalAlignment(SwingConstants.CENTER);
		TrackPackageResult.setColumnHeaderView(lblShipmentIdAnd);
		
		
	
		
	}
}
