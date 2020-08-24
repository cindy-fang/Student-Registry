import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Active University Course
public class ActiveCourse extends Course  
{
	private ArrayList<Student> students; 
	private String             semester;
	
	   
   // Add a constructor method with appropriate parameters
   // should call super class constructor to initialize inherited variables
   // make sure to *copy* students array list being passed in into new arraylist of students
   // see class Registry to see how an ActiveCourse object is created and used
   public ActiveCourse(String name, String code, String descr, String fmt,String semester,ArrayList<Student> students)
   {
		super(name, code, descr, fmt);
      this.semester = semester;
      this.students = new ArrayList<Student>(students);
   }
   
   public String getSemester()
   {
	   return semester;
   }
   
   // Prints the students in this course  (name and student id)
   public void printClassList()
   {
      //iterate through the students in the course to print every name and id 
      for (int i = 0; i < students.size(); i++)
      {
         System.out.println(students.get(i).toString());
      }
   }
   
   // Prints the grade of each student in this course (along with name and student id)
   public void printGrades()
   {
      for (int i = 0; i < students.size(); i++)
      {
         System.out.println(students.get(i).getId() + " " + students.get(i).getName() + " " + getGrade(students.get(i).getId()));
      }
   }
   
   // Returns the numeric grade in this course for this student
   public double getGrade(String studentId)
   {
	  // Search the student's list of credit courses to find the course code that matches this active course
	  // see class Student method getGrade() 
     for (int i = 0; i < students.size(); i++)
     {
        if (students.get(i).getId().equals(studentId)) 
        {	  
           // return the grade stored in the credit course object
           return students.get(i).getGrade(getCode());
        }
      }
      // If student not found in course, return 0 
      return 0;
  }

   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // must override method in the superclass Course and use super class method getDescription()
   public String getDescription()
   {
	   return super.getDescription() + " " + semester + " Enrolment: " + students.size() +  "\n";
   }
   
   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortByName()
   {
      Collections.sort(students, new NameComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student name
   private class NameComparator implements Comparator<Student>
   {
      //compare method returns int value after comparing param values s2 and s2
      public int compare(Student s1, Student s2)
      {
         //call compareTo method, passing in s2 as param
         return s1.getName().compareTo(s2.getName());
      }
   }
   
   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortById()
   {
      Collections.sort(students, new IdComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student id
   private class IdComparator implements Comparator<Student>
   {
      public int compare (Student s1, Student s2)
      {
         return s1.getId().compareTo(s2.getId());
      }
   }

   //method that removes a student from students at index value s 
   public void removeStudentFromAC(String id)
   {
	   for (int j = 0; j < students.size(); j++)
	   {
   		   Student s = students.get(j);
   		   if (s.getId().equals(id))
   		   {
   		     students.remove(j);
   		     return;
   		   }
       }   
   }

   //method that adds a students into students at index value s 
   public void addStudents(Student s)
   {
      this.students.add(s);
   }
}
