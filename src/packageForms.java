import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class packageForms extends JFrame {

	private JPanel packageForm;
	private JTextField pF_weight;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					packageForms frame = new packageForms();
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
	public packageForms() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		packageForm = new JPanel();
		packageForm.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(packageForm);
		packageForm.setLayout(null);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(32, 35, 74, 44);
		packageForm.add(lblWeight);
		
		pF_weight = new JTextField();
		pF_weight.setBounds(116, 47, 86, 20);
		packageForm.add(pF_weight);
		pF_weight.setColumns(10);
		
		JLabel lblDimensionslxwxh = new JLabel("<html>Dimensions <br> (LxWxH)</html>");
		lblDimensionslxwxh.setBounds(32, 108, 86, 44);
		packageForm.add(lblDimensionslxwxh);
		
		textField = new JTextField();
		textField.setBounds(116, 113, 86, 20);
		packageForm.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Fragile?");
		chckbxNewCheckBox.setBounds(32, 180, 97, 23);
		packageForm.add(chckbxNewCheckBox);
		
		JCheckBox chckbxHazardous = new JCheckBox("Hazardous?");
		chckbxHazardous.setBounds(136, 180, 97, 23);
		packageForm.add(chckbxHazardous);
		
		JLabel lblContents = new JLabel("Contents");
		lblContents.setBounds(32, 263, 74, 14);
		packageForm.add(lblContents);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 260, 86, 20);
		packageForm.add(textField_1);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(32, 303, 74, 14);
		packageForm.add(lblValue);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 300, 86, 20);
		packageForm.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAddPackage = new JButton("Add Package");
		btnAddPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAddPackage.setBounds(32, 381, 111, 23);
		packageForm.add(btnAddPackage);
	}
}
