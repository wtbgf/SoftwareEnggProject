package project.excelSpike;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class DistributionTester {

	public static void main(String[] args) {
		
		//Create courses to test
		Course course1 = new Course("Math101", "01B", "A+", 3.0, "Fall");
		Course course2 = new Course("Math102", "02B", "C-", 3.0, "Winter");
		Course course3 = new Course("Engl101", "01B", "F", 3.0, "Fall");
		Course course4 = new Course("Engl101", "01B", "B-", 3.0, "Fall");
		
		//Add courses to transcripts
		Transcript testTranscript1 = new Transcript();
		testTranscript1.addCourse(course1);
		testTranscript1.addCourse(course3);
		
		Transcript testTranscript2 = new Transcript();
		testTranscript2.addCourse(course2);
		testTranscript2.addCourse(course4);
		
		//Add transcript to transcriptlist
		ArrayList<Transcript> trList = new ArrayList<Transcript>() {
			{
				add(testTranscript1);
				add(testTranscript2);
			}
		};
		TranscriptList testList = new TranscriptList(trList);

		//Testing if this worked
		Set<String> courseNames = testList.getAllCourseNames();
		System.out.println("Printing all courses in all transcripts");
		for (String course : courseNames) {
			System.out.println(course);
		}
		System.out.println();
		
		//Set the areas in the distribution
		ArrayList<String> mathList = new ArrayList<String>() {
			{
				add("Math101");
				add("Math102");
			}
		};
		
		ArrayList<String> englList = new ArrayList<String>() {
			{
				add("Engl101");
				add("Engl102");
			}
		};
		
		AreaSchema.addArea("Math", mathList);
		AreaSchema.addArea("Engl", englList);
		
		ArrayList<Course> mathCourses = testList.getAllCoursesInArea("Math");
		System.out.println("Math Courses:");
		for (Course course : mathCourses) {
			System.out.println(course.getCourseID());
		}
		System.out.println();

		
		//Set the grades in the distribution
		GradeSchema.addGradeToLevel("Exceeds", "A+");
		GradeSchema.addGradeToLevel("Exceeds", "A");
		GradeSchema.addGradeToLevel("Exceeds", "A-");
		GradeSchema.addGradeToLevel("Meets", "B+");
		GradeSchema.addGradeToLevel("Meets", "B");
		GradeSchema.addGradeToLevel("Meets", "B-");
		GradeSchema.addGradeToLevel("Marginal", "C+");
		GradeSchema.addGradeToLevel("Marginal", "C");
		GradeSchema.addGradeToLevel("Marginal", "C-");
		GradeSchema.addGradeToLevel("Fail", "D");
		GradeSchema.addGradeToLevel("Fail", "F");
		
		//Create an area distribution to test
		AreaDistribution testAreaDist = new AreaDistribution(testList);
		
		ArrayList<String> areas = AreaSchema.getAllAreas();

		for (String area : AreaSchema.getAllAreas()) {
			System.out.println(area);
			Map<String, Integer> areaMap = testAreaDist.getDistributionForArea(area);
			for (String level : areaMap.keySet()) {
				System.out.print(level + "    ");
				System.out.println(areaMap.get(level));
			}
			System.out.println();
		}
		
		
	}
}