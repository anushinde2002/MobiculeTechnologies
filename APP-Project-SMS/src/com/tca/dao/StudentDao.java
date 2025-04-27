package com.tca.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tca.config.Configuration;
import com.tca.entities.Student;

public class StudentDao 
{
	
	public boolean save(Student ob)   
	{
		FileWriter fw = null;
		try
		{
			int    rno  = ob.getRno();
			String name = ob.getName();
			double per  = ob.getPer();
			
			fw = new FileWriter(Configuration.FILE_NAME,true); // Append
			fw.write(rno+","+name+","+per+"\n");
			
			//System.out.println("Record is Saved for Roll Number : " + rno);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				fw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
		
	}
	
	public void saveAll( List<Student> L) // L --> [101 PPP 95], [103.. ]
	{
		
		for(Student S : L)
		{
			save(S);
		}
		
	}
	
	public List<Student> getAllStudents()
	{
		List<Student> L = new ArrayList<>(); // L -->[   [101,AAA, 60] [102,BBB. 70.... ]
		
		FileReader fr = null;
		BufferedReader br = null;
		
		
		try
		{
			fr = new FileReader(Configuration.FILE_NAME);
			br = new BufferedReader(fr);
			
			while(true)
			{
				String line =  br.readLine();  //line : null
				
				if(line==null)
				{
					break;
				}
				
				String tok[] = line.split(",");  // tokenzing string comma wise
				
				int trno     = Integer.parseInt(tok[0]);
				String tname = tok[1];
				double tper  = Double.parseDouble(tok[2]);
				
				Student ob = new Student(trno, tname, tper);
				L.add(ob);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try 
			{
				fr.close();
			} catch (IOException e) 
			{
				
				e.printStackTrace();
				return null;
			}
		}
		
		
		return L;
	}
	
	
	public Student searchStudent(int trno)
	{
		
		List<Student>  L = getAllStudents();  // L -->[101,....]   [102,....]
		
		if(L.isEmpty())
		{
			return null;
		}
		else
		{            
			for(Student ob : L)
			{      
				if(ob.getRno() == trno)
				{
					return ob;
				}
			}
			
		}
		
		return null;
	}
	
	
	public boolean deleteStudent(int trno)
	{
		List<Student> L = getAllStudents(); // L --> [101...] [102...] [103....]
		
		for( Student ob : L)
		{
			       
			if(ob.getRno() == trno)
			{
				L.remove(ob);
				
				File f = new File(Configuration.FILE_NAME);
				f.delete();
				try
				{
					f.createNewFile();
					saveAll(L);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return false;
				}
				return true;
			}
		}
		
		return false; // returning false bcz 107 wala student didnt able to find
	}
	
	
	
	public boolean updateStudent(int trno, String tname, double tper)
	{
		List<Student> L = getAllStudents(); // L --> [101...] [102,PPP, 60] [103....]
			
			
		for( Student ob : L)
		{
			      
			if(ob.getRno() == trno)
			{
				ob.setName(tname);
				ob.setPer(tper);
				
				File f = new File(Configuration.FILE_NAME);
				f.delete();
				try
				{
					f.createNewFile();
					saveAll(L);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return false;
				}
				return true;
			}
		}
		
		return false; // returning false bcz 107 wala student didnt able to find
	}
	
}










