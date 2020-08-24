public class CreditCourse extends Course
{	
	private String  semester;
	public  double  grade;
	public  boolean active;
	// add a constructor method with appropriate parameters
	// should call the super class constructor
	public CreditCourse(String name, String code, String descr, String fmt,String semester, double grade)
	{
		super(name,code,descr,fmt);
		this.semester = semester;
		this.grade = grade;
	}
	
	//returns the boolean value of active variable (true or false)
	public boolean getActive()
	{
		// add code and remove line below
		return active;
	}
	
	//sets active variable as true
	public void setActive()
	{
		// add code
		active = true;
	}
	
	//sets active varaible as false 
	public void setInactive()
	{
		// add code
		active = false;
	}
	
	//returns the courses info, the semester, and the numeric grade achieved 
	public String displayGrade()
	{
		// Change line below and print out info about this course plus which semester and the grade achieved
		// make use of inherited method in super class
		return getInfo() + semester + convertNumericGrade(grade);

	}
	//sets the grade variable as the passed in param value g
	public void setGrade(double g)
	{
		grade = g;
	}	
}