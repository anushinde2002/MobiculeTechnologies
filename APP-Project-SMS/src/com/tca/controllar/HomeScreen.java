package com.tca.controllar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.tca.view.AddStudentScreen;
import com.tca.view.DeleteStudentScreen;
import com.tca.view.DisplayStudentScreen;
import com.tca.view.UpdateStudentScreen;

public class HomeScreen extends JFrame implements ActionListener
{
	JMenuBar mbr;
	JMenu  mStudent, mTeacher, mFees;
	JMenuItem miAddStudent, miDisplayStudent, miDeleteStudent, miUpdateStudent,miExit;
	
	public HomeScreen()
	{
		setLayout(null);
		Font f = new Font("Ink Free", Font.BOLD | Font.ITALIC, 15);
		
		mbr = new JMenuBar();
		mbr.setSize(1200,30);
		mbr.setLocation(0, 0);
		add(mbr);
		
		mStudent = new JMenu("Student");
		mStudent.setFont(f);
		mbr.add(mStudent);
		
		
		miAddStudent = new JMenuItem("Add Student");
		miAddStudent.addActionListener(this);
		miAddStudent.setFont(f);
		mStudent.add(miAddStudent);
		
		miDisplayStudent = new JMenuItem("Display Student");
		miDisplayStudent.addActionListener(this);
		miDisplayStudent.setFont(f);
		mStudent.add(miDisplayStudent);
		
		miDeleteStudent = new JMenuItem("Delete Student");
		miDeleteStudent.addActionListener(this);
		miDeleteStudent.setFont(f);
		mStudent.add(miDeleteStudent);
		
		miUpdateStudent = new JMenuItem("Update Student");
		miUpdateStudent.addActionListener(this);
		miUpdateStudent.setFont(f);
		mStudent.add(miUpdateStudent);
		
		mStudent.addSeparator();
		
		miExit = new JMenuItem("EXIT");
		miExit.addActionListener(this);
		miExit.setFont(f);
		mStudent.add(miExit);
		
		
		setTitle("TCA -  Home Screen");
		setSize(1200,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		String command = ae.getActionCommand();
		
		if(command.equals("Add Student"))
		{
			AddStudentScreen ob = new AddStudentScreen();
		}
		
		if(command.equals("Display Student"))
		{
			DisplayStudentScreen ob = new DisplayStudentScreen();
		}
		if(command.equals("Delete Student"))
		{
			DeleteStudentScreen ob = new DeleteStudentScreen();
		}
		if(command.equals("Update Student"))
		{
			UpdateStudentScreen ob = new UpdateStudentScreen();
		}
		if(command.equals("EXIT"))
		{
			JOptionPane.showMessageDialog(null, "Shuting Down....!!");
			System.exit(0);
		}
		
	}

}




