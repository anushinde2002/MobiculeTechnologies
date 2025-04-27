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

public class UpdateStudentScreen extends JFrame implements ActionListener
{
	JLabel lRno,lName, lPer;
	JTextField tfRno, tfName, tfPer;
	JButton bSearch,bUpdate;
	
	public UpdateStudentScreen()
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
		//tfName.setEditable(false);
		add(tfName);
		
		
		lPer = new JLabel("Percentage :");
		lPer.setSize(100,30);
		lPer.setLocation(30,130);
		add(lPer);
		
		tfPer = new JTextField();
		tfPer.setSize(200,30);
		tfPer.setLocation(150,130);
		//tfPer.setEditable(false);
		add(tfPer);
		
		bSearch = new JButton("Search");
		bSearch.setSize(100,30);
		bSearch.setLocation(60, 190);
		bSearch.addActionListener(this);
		add(bSearch);
		
		bUpdate = new JButton("Update");
		bUpdate.setSize(100, 30);
		bUpdate.setLocation(200,190);
		bUpdate.addActionListener(this);
		add(bUpdate);
		
		setTitle("TCA - UPdate Student");
		setSize(400,300);
		setVisible(true);
		setResizable(false);
		setLocation(400,300);
	}
		
	
	@Override
	public void actionPerformed(ActionEvent ae)   // ae --> sang kontya butanavar click kelai ?
	{
			String command = ae.getActionCommand();
		
			
			// Search Button
			if(command.equals("Search"))  
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
				}
				
			}
			
			// clear Button
			if(command.equals("Update"))
			{
				String srno = tfRno.getText();   // srno = ""
				String sname = tfName.getText(); // sname= ""  it means string is empty
				String sper  = tfPer.getText();
				
				if(srno.isEmpty() || sname.isEmpty() || sper.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Some Fields Are Missing.. Can not Update !!");
					return;
				}
				
				
				int trno     = Integer.parseInt(srno);
				String tname = sname;
				double tper  = Double.parseDouble(sper);
				
				
				StudentDao dao = new StudentDao();
				boolean status = dao.updateStudent(trno, tname, tper);
				
				if(status== true)
				{
					JOptionPane.showMessageDialog(null, "Record Updated Successfully for Roll number :" + trno);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unable to Update Record for Roll number :" + trno);
				}
				
				tfRno.setText("");
				tfName.setText("");
				tfPer.setText("");
				tfRno.requestFocus();
			}
	}
	
}




