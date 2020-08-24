public class Course 
{
	private String code;
	private String name;
	private String description;
	private String format;
	   
	public Course()
	{
	  this.code        = "";
	  this.name        = "";
	  this.description = "";
	  this.format      = "";
	}
	   
	public Course(String name, String code, String descr, String fmt)
	{
	  this.code        = code;
	  this.name        = name;
	  this.description = descr;
	  this.format      = fmt;
	}
	   
	public String getCode()
	{
	   return code;
	}
	   
	public String getName()
	{
	  return name;
	}
	   
	public String getFormat()
	{
	  return format;
	}
	   
	public String getDescription()
	{
	  return code +" - " + name + "\n" + description + "\n" + format;
	}
	
	 public String getInfo()
	 {
	   return code +" - " + name;
	 }
	 
	 // static method to convert numeric score to letter grade string 
	 // e.g. 91 --> "A+"
	 public static String convertNumericGrade(double score)
	 {
		 // fill in code
		 //if score is larger than or equal to 90, return A+ letter grade 
		if (score >= 90.0)
		{
			return "A+";
		}
		else if (score >= 85.0)
		{
			return "A";
		}
		else if (score >= 80.0)
		{
			return "A-";
		}
		else if (score >= 77.0)
		{
			return "B+";
		}
		else if (score >= 73.0)
		{
			return "B";
		}
		else if (score >= 70.0)
		{
			return "B-";
		}
		else if (score >= 67.0)
		{
			return "C+";
		}
		else if (score >= 63.0)
		{
			return "C";
		}
		else if (score >= 60.0)
		{
			return "C-";
		}
		else if (score >= 57.0)
		{
			return "D+";
		}
		else if (score >= 53.0)
		{
			return "D";
		}
		else if (score >= 50.0)
		{
			return "D-";
		}
		//automatic F letter grade if numeric grade less than 50 
		return "F";	
	 }
	 
}
