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

public class DisplayStudentScreen extends JFrame implements ActionListener
{
	JLabel lRno,lName, lPer;
	JTextField tfRno, tfName, tfPer;
	JButton bShow,bClear;
	
	public DisplayStudentScreen()
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
		tfName.setEditable(false);
		add(tfName);
		
		
		lPer = new JLabel("Percentage :");
		lPer.setSize(100,30);
		lPer.setLocation(30,130);
		add(lPer);
		
		tfPer = new JTextField();
		tfPer.setSize(200,30);
		tfPer.setLocation(150,130);
		tfPer.setEditable(false);
		add(tfPer);
		
		bShow = new JButton("Show");
		bShow.setSize(100,30);
		bShow.setLocation(60, 190);
		bShow.addActionListener(this);
		add(bShow);
		
		bClear = new JButton("Clear");
		bClear.setSize(100, 30);
		bClear.setLocation(200,190);
		bClear.addActionListener(this);
		add(bClear);
		
		setTitle("TCA - Display Student");
		setSize(400,300);
		setVisible(true);
		setResizable(false);
		setLocation(400,300);
	}
		
	
	@Override
	public void actionPerformed(ActionEvent ae)   // ae --> sang kontya butanavar click kelai ?
	{
			String command = ae.getActionCommand();
		
			
			// Show Button
			if(command.equals("Show"))  
			{
				int trno = Integer.parseInt(tfRno.getText());    //  "101" --> 101
				
				StudentDao dao = new StudentDao();
				
				Student S = dao.searchStudent(trno);  // S -->[102,BBB, 70]
				
				if(S==null)
				{
					JOptionPane.showMessageDialog(null, "No Data Found for Roll Num:" + trno);
				}
				else
				{
					tfName.setText( S.getName() );
					tfPer.setText( Double.toString( S.getPer()));
					// double  p = S.getPer();  // p =4.5
					// String  sp = Double.toString(p);  // 4.5-->"4.5"
					// tfPer.setText(sp);
				}
				
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
