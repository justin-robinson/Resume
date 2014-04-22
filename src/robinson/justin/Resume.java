package robinson.justin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Resume {
	public Dossier dossier;
	public Education education;
	public ArrayList<Experience> experiences;
	public enum DegreeLevel { AS, AA, BA, BS, MS, MA, PHd }

	public Resume(){
		this.dossier		= new Dossier(
				"Justin O Robinson",
				"2295 Sunshine Rd, Lancaster SC 29720",
				"803.320.9005",
				"justinrobinson@jrobcomputers.com",
				"jrobcomputers.com"
		);
		this.education		= new Education();
		this.experiences	= new ArrayList<>();
	}
	String[] languages = {
			"Java",
			"PHP",
			"C",
			"C++",
			"Objective C",
			"Javascript",
			"MySQL",
			"Python",
			"Ruby on Rails",
			"Bash",
			"Powershell",
			"HTML"
	};
	String[] environments = {
			"Debian Linux",
			"RedHat Linux",
			"Microsoft Windows 7",
			"Microsoft Windows 8.1",
			"Microsoft Windows Server 2008",
			"Microsoft Windows Server 2012",
			"Apache",
			"Android 1.5 - 4.4.3",
			"Xilinx ISE",
			"Eclipse",
			"IntelliJ IDEA",
			"git",
			"subversion"
	};
	String[] certifications = {
			"Security+",
			"Secret Security Clearance"
	};

	public static void main(String[] args) {
		Resume resume = new Resume();
		/*
		 *
		 *   EDUCATION
		 *
		 */
		resume.education.setInstitute("University of South Carolina");
		resume.education.setDegreeLevel(DegreeLevel.BS);
		resume.education.setGraduationYear(2012);
		/*
		 *
		 * SRC
		 *
		 */
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(0);
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONDAY, Calendar.APRIL);
		Date ed = cal.getTime();
		cal.set(Calendar.YEAR, 2013);
		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
		Experience e = new Experience(
				"Scientific Research Corporation",
				"Engineer I",
				cal.getTime(),
				ed
		);
		e.addDuty("Designed and developed OO Java applications");
		e.addDuty("Improved existing Ruby on Rails applications");
		e.addDuty("Developed methods for mass hardware security deployment");
		e.addDuty("Worked in tandem with Scrum team");
		resume.experiences.add(e);
		/*
		 *
		 * LCE
		 *
		 */
		ed = cal.getTime();
		cal.set(Calendar.MONTH, Calendar.JUNE);
		e = new Experience(
				"Life Cycle Engineering",
				"Intern",
				cal.getTime(),
				ed
		);
		e.addDuty("Installed and configured a virtualized network infrastructure using VMware ESX 5i");
		e.addDuty("Installed and configured a firewall to separate the virtual infrastructure with the physical " +
				"network infrastructure.");
		e.addDuty("Installed and configured Windows and Linux virtual machines");
		e.addDuty("Developed with Groovy & Grails");
		resume.experiences.add(e);
	}
}
class Dossier {
	private String name, address, phoneNumber, email, website;
	public Dossier(String n, String a, String p, String e, String w){
		this.name			= n;
		this.address		= a;
		this.phoneNumber	= p;
		this.email			= e;
		this.website		= w;
	}
}
class Education {
	private String institute;
	private Resume.DegreeLevel degreeLevel;
	private int graduationYear;

	public void setInstitute(String i){ this.institute = i; }
	public void setDegreeLevel(Resume.DegreeLevel dl){ this.degreeLevel = dl; }
	public void setGraduationYear(int y){ this.graduationYear = y; }
}
class Experience {
	private String company, title;
	private ArrayList<String> duties;
	private Date startDate, endDate;

	public Experience(String c, String t, Date sd, Date ed){
		this.company	= c;
		this.title		= t;
		this.startDate	= sd;
		this.endDate	= ed;
		duties			= new ArrayList<>();
	}
	public void addDuty(String d){ this.duties.add(d); }
}
