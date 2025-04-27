package com.tca;

import com.tca.controllar.HomeScreen;

public class App 
{

	public static void main(String[] args)  
	{
		
		HomeScreen ob = new HomeScreen (); 
		
		
/*
		// Test Code - Update()
				int er = 107;
				String nsname = "QQQ";
				double nper   = 99.00;
				StudentDao dao = new StudentDao();
				
				if(  dao.updateStudent(er, nsname, nper)  )
				{
					System.out.println("Record Updated for Roll Number : " + er);
				}
				else
				{
					System.out.println("Unable to Update Record for Roll Number : " + er ); 
				}
		
*/		
		
/*		
		// Test Code - deleteStudent()
		int r = 103;
		StudentDao dao = new StudentDao();
		
		if(  dao.deleteStudent(r)  )
		{
			System.out.println("Record Deleted for Roll Number : " + r);
		}
		else
		{
			System.out.println("Unable to delete Record for Roll Number : " + r ); 
		}
*/		
/*
		// Test Code - searchStudet()
		StudentDao dao = new StudentDao();
		
		Student S = dao.searchStudent(107);
		
		if(S==null)
		{
			System.out.println("No Record Found !!!");
		}
		else
		{
			System.out.println("***** Record Found *****");
			System.out.println("Roll Number : " + S.getRno());
			System.out.println("Name        : " + S.getName());
			System.out.println("Percentage  : " + S.getPer());
		}
*/		
		
		
		
/*		
 		// Test Code  - getAllStudent()
 		
		StudentDao dao = new StudentDao();
		
		List<Student> L = dao.getAllStudents();
		
		if(L.isEmpty())
		{
			System.out.println("No Records Found !!");
		}
		else
		{
		
			for(Student S : L)
			{
				S.display();
			}
		}
		System.out.println("done....");
*/		
	}

}
