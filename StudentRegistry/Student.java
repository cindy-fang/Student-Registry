import java.util.ArrayList;
// Make class Student implement the Comparable interface
// Two student objects should be compared by their name

public class Student implements Comparable<Student>
{
  private String name;
  private String id;
  public  ArrayList<CreditCourse> courses;
  
  
  public Student(String name, String id)
  {
	 this.name = name;
	 this.id   = id;
	 courses   = new ArrayList<CreditCourse>();
  }
  
  public String getId()
  {
	  return id;
  }
  
  public String getName()
  {
	  return name;
  }
  
  // add a credit course to list of courses for this student
  public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
  {
	  // create a CreditCourse object
    CreditCourse a = new CreditCourse(courseName, courseCode, descr, format, sem,grade);
    // set course active
    a.setActive();
    // add to courses array list
    courses.add(a);
  }
  
  // Prints a student transcript
  // Prints all completed (i.e. non active) courses for this student (course code, course name, 
  // semester, letter grade
  // see class CreditCourse for useful methods
  public void printTranscript()
  {
    //iterate through courses 
    for (int i = 0; i < courses.size(); i++)
    {
      //if value at index i is not active, print out course code, course name, sem, and letter grade 
      if (courses.get(i).getActive() == false)
      {
        System.out.println(courses.get(i).displayGrade());
      }
    }
  }

  // Prints all active courses this student is enrolled in
  // see variable active in class CreditCourse
  public void printActiveCourses()
  {
    for (int i = 0; i < courses.size(); i++)
    {
      //if course in courses at index i is active, print the descr of it
      if (courses.get(i).getActive() == true)
      {
        System.out.println(courses.get(i).getDescription());
      }
    }
  }
  
  // Drop a course (given by courseCode)
  public void removeActiveCourse(String courseCode)
  {
    // Find the credit course in courses arraylist above and remove it
    for (int i = 0; i < courses.size(); i++)
    {
      // only remove it if it is an active course
      if (courses.get(i).getCode().equals(courseCode) && courses.get(i).getActive() == true)
      {
        courses.remove(i);
        return;
      }
    }
  }
  
  public String toString()
  {
	  return "Student ID: " + id + " Name: " + name;
  }
  
  // override equals method inherited from superclass Object
  public boolean equals(Object other)
  {
    // Hint: you will need to cast other parameter to a local Student reference variable
    Student otherStudent = (Student) other;
    // if student names are equal *and* student ids are equal (of "this" student
    // and "other" student) then return true
    if (this.getName().equals(otherStudent.getName()) && this.getId().equals(otherStudent.getId()))
    {
      return true;
    }
    // otherwise return false
    return false;
  }

  //method that compares 2 names 
  public int compareTo(Student other)
  {
    int compare = this.getName().compareTo(other.getName());
    return compare;
  }

  //method that returns the numeric grade value based on course code 
  public double getGrade(String courseCode)
  {
    //iterate through courses to find course that matches the param courseCode
    for (int i = 0; i < courses.size(); i++)
    {
      //if found return the grade of it 
      if (courses.get(i).getCode().equals(courseCode)) 
      {
        return courses.get(i).grade;
      }
    }
    //otherwise return 0 
    return 0;
  }
  
  //method that returns courses
  public  ArrayList<CreditCourse> getCourses()
  {
    return courses;
  }


  
  
}