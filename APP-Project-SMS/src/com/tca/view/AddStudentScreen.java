package com.tca.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.tca.dao.StudentDao;
import com.tca.entities.Student;

public class AddStudentScreen extends JFrame implements ActionListener
{
	JLabel lRno,lName, lPer;
	JTextField tfRno, tfName, tfPer;
	JButton bSave,bClear;
	
	public AddStudentScreen()
	{
		setLayout(null);
		lRno = new JLabel("Roll Number :");
		lRno.setSize(100,30);
		lRno.setLocation(30, 30);
		add(lRno);
		
		tfRno = new JTextField();
		tfRno.setSize(200,30);
		tfRno.setLocation(150 ,30);
		add(tfRno);
		
		lName = new JLabel("Name :");
		lName.setSize(100,30);
		lName.setLocation(30,80);
		add(lName);
		
		tfName = new JTextField();
		tfName.setSize(200,30);
		tfName.setLocation(150,80);
		add(tfName);
		
		
		lPer = new JLabel("Percentage :");
		lPer.setSize(100,30);
		lPer.setLocation(30,130);
		add(lPer);
		
		tfPer = new JTextField();
		tfPer.setSize(200,30);
		tfPer.setLocation(150,130);
		add(tfPer);
		
		bSave = new JButton("Save");
		bSave.setSize(100,30);
		bSave.setLocation(60, 190);
		bSave.addActionListener(this);
		add(bSave);
		
		bClear = new JButton("Clear");
		bClear.setSize(100, 30);
		bClear.setLocation(200,190);
		bClear.addActionListener(this);
		add(bClear);
		
		setTitle("TCA - Add Student");
		setSize(400,300);
		setVisible(true);
		setResizable(false);
		setLocation(400,300);
	}
		
	
	@Override
	public void actionPerformed(ActionEvent ae)   // ae --> sang kontya butanavar click kelai ?
	{
			String command = ae.getActionCommand();
		
			
			// Save Button
			if(command.equals("Save"))  
			{
				int rno     = Integer.parseInt(tfRno.getText());    //  "101" --> 101
				String name = tfName.getText();
				double per  = Double.parseDouble(tfPer.getText());
				
				Student S = new Student(rno, name, per);
				
				StudentDao dao = new StudentDao();
				boolean status = dao.save(S);
				
				if(status == true)
					JOptionPane.showMessageDialog(null, "Data is Saved Succesfully for Roll Num:"+ rno);
				else
					JOptionPane.showMessageDialog(null, "Unable to Save Student for Roll Num:"+rno);
				
				
				 //String messge = service-layer(S)
				//JOptionPane.showMessageDialog(null, messge);
				  
				tfRno.setText("");
				tfName.setText("");
				tfPer.setText("");
				tfRno.requestFocus();
				
				
			}
			
			// clear Button
			if(command.equals("Clear"))
			{
				tfRno.setText("");
				tfName.setText("");
				tfPer.setText("");
				tfRno.requestFocus();
			}
	}
	
}
