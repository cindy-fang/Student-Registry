import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistrySimulator 
{
  public static void main(String[] args)
  {
	  Registry registry = new Registry();
	  
	  Scanner scanner = new Scanner(System.in);
	  System.out.print(">");
	  
	  while (scanner.hasNextLine())
	  {
		  String inputLine = scanner.nextLine();
		  if (inputLine == null || inputLine.equals("")) continue;
		  
		  Scanner commandLine = new Scanner(inputLine);
		  String command = commandLine.next();
		  
		  if (command == null || command.equals("")) continue;
		  
		  else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
		  {
			  registry.printAllStudents();
		  }
		  else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
		  {
			  return;
		  }		  
		  else if (command.equalsIgnoreCase("REG"))
		  {
			  // register a new student in registry
			  // get name and student id string 
			  // e.g. reg JohnBoy 74345
			  // Checks:
			  //  ensure name is all alphabetic characters
			  //  ensure id string is all numeric characters

			  //create 2 new String variables 
			  String name = null;
			  String id = null;

			  //if has next input, set the input to name var
			  if (commandLine.hasNext())
			  {
				name = commandLine.next();
				// check for all alphabetical
				String lcase = name.toLowerCase();
				if (!isStringOnlyAlphabet(lcase))
				{
					System.out.println("Invalid Characters in Name " + name);
					continue;
				}
			  }
			  //if has next input, set the input to id var
			  if (commandLine.hasNext())
			  {
				id = commandLine.next();
				 // check for all numeric
				if (!isNumeric(id))
				{
					System.out.println("Invalid Characters in ID " + id);
					continue;
				}
				if (!registry.addNewStudent(name,id))
					System.out.println("Student " + name + " already registered");
			  }
			  //if name and id not null, check if name contains only letters and id only numbers
			  if (name!= null && id!=null)
			  {
				//add name and id to registry 
				registry.addNewStudent(name,id);
			  }
		  }
		  else if (command.equalsIgnoreCase("DEL"))
		  {
			  // delete a student from registry
			  // get student id
			  // ensure numeric
			  // remove student from registry
			  String id = null;
			  //get students name and id from input
			  id = commandLine.next();
			  //if id contains only letters, remove student with that id from registry 
			  if (StudentRegistrySimulator.isNumeric(id))
			  {
				  registry.removeStudent(id);
			  }
		  }
		  
		  else if (command.equalsIgnoreCase("ADDC"))
		  {
			 // add a student to an active course
			 // get student id and course code strings
			 // add student to course (see class Registry)
			 String name = null;
			 String id = null;

			 //get student id and name 
			 if (commandLine.hasNext())
			 {
				 id = commandLine.next();
			 }
			 if (commandLine.hasNext())
			 {
				 name = commandLine.next();
				//add student with id and name to active course 
				 registry.addCourse(id, name);
			 }
		  }
		  else if (command.equalsIgnoreCase("DROPC"))
		  {
			  // get student id and course code strings
			  // drop student from course (see class Registry)
			  String name = null;
			  String id = null;
 
			  //get student id and name 
			  if (commandLine.hasNext())
			  {
				id = commandLine.next();
			  }
			  if (commandLine.hasNext())
			  {
				name = commandLine.next();
				//drop student from registry 
				registry.dropCourse(id, name);
			  }
		  }
		  else if (command.equalsIgnoreCase("PAC"))
		  {
			  // print all active courses
			  registry.printActiveCourses();
		  }		  
		  else if (command.equalsIgnoreCase("PCL"))
		  {
			  // get course code string
			  String code = null;
			  if(commandLine.hasNext())
			  {
				code = commandLine.next();
			  }
			  // print class list (i.e. students) for this course
			  if (code!= null)
			  {
				registry.printClassList(code);
			  }			  
		  }
		  else if (command.equalsIgnoreCase("PGR"))
		  {
			  // get course code string
			  String code = null;
			  if (commandLine.hasNext())
			  {
				code = commandLine.next();
			  }
			  // print name, id and grade of all students in active course
			  if (code!= null)
			  {
				registry.printGrades(code);
			  }
		  }
		  else if (command.equalsIgnoreCase("PSC"))
		  {
			  // get student id string
			  String id = null;

			  if(commandLine.hasNext())
			  {
				  id = commandLine.next();
			  }
		      // print all credit courses of student
			  if (id != null)
			  {
				registry.printStudentCourses(id);
			  }			  
		  }
		  else if (command.equalsIgnoreCase("PST"))
		  {
			  // get student id string
			  String id = null;

			  if (commandLine.hasNext())
			  {
				  id = commandLine.next();
			  }
			  // print student transcript
			  if(id != null)
			  {
				registry.printStudentTranscript(id);
			  }			  
		  }
		  else if (command.equalsIgnoreCase("SFG"))
		  {
			  // set final grade of student
			  String code = null;
			  String id = null;
			  Double grade = null;
			  // get course code, student id, numeric grade
			  if (commandLine.hasNext())
			  {
				  code = commandLine.next();
				  id = commandLine.next();
				  grade = commandLine.nextDouble();
			  }
			  // use registry to set final grade of this student (see class Registry)
			  if (code != null && grade!= null && id != null)
			  {
				registry.setFinalGrade(code,id,grade);
			  }
		  }
		  else if (command.equalsIgnoreCase("SCN"))
		  {
			  // get course code
			  // see class Registry
			  String code = null;
			  if (commandLine.hasNext())
			  {
				  code = commandLine.next();
			  }
			  // sort list of students in course by name (i.e. alphabetically)
			  if(code != null)
			  {
				registry.sortCourseByName(code);
			  }
		  }
		  else if (command.equalsIgnoreCase("SCI"))
		  {
			// get course code
			// see class Registry
			String code = null;
			
			if (commandLine.hasNext())
			{
				code = commandLine.next();
			}
			// sort list of students in course by student id
			if(code != null)
			{
				registry.sortCourseById(code);
			}		  }
		  System.out.print("\n>");
	  }
  }

  private static boolean isStringOnlyAlphabet(String str) 
  { 
	  // write method to check if string str contains only alphabetic characters 
	  boolean none = false;
	  //iterate through passed in param str 
	  for (int i = 0; i < str.length(); i++)
	  {
		  //check if str index value at i is a letter
		  if (Character.isLetter(str.charAt(i)))
		  {
			  none = true;
		  }
		  else
		  //otherwise none is false 
		  {
			  none = false;
			  break;
		  }
	  }
	  //return none value 
	  return none;
	}

  public static boolean isNumeric(String str)
  {
	  // write method to check if string str contains only numeric characters
	  for (int i = 0; i < str.length(); i++)
	  {
		  //check if str index value at i is not a digit 
		  if (!Character.isDigit(str.charAt(i)))
		  {
			  return false;
		}
	  }
	  //otherwise return true 
	  return true;
  }
}