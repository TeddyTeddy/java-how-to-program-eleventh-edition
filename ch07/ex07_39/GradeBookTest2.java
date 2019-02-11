// Fig. 7.19: GradeBookTest.java
// GradeBookTest creates GradeBook object using a two-dimensional array  
// of grades, then invokes method processGrades to analyze them.
import java.util.Scanner;

public class GradeBookTest2 {
   // main method begins program execution
   public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  
	  System.out.print("Enter number of students:");
	  int studentsNumber = input.nextInt();
	  
      System.out.print("Enter number of exams");
      int examsNumber = input.nextInt();
      
      GradeBook2 myGradeBook = new GradeBook2("CS101 Introduction to Java Programming", studentsNumber, examsNumber);
      System.out.printf("Welcome to the grade book for%n%s%n%n", myGradeBook.getCourseName());
      
      System.out.println("Enter grades per student:");
      for(int student = 1; student <= studentsNumber; ++student) {
    	  for(int exam = 1; exam <= examsNumber; ++exam) {
    		  System.out.printf("Student %d's Exam %d: ", student, exam );
    		  int grade = input.nextInt();
    		  myGradeBook.setGrade(student, exam, grade);
    	  }
      }
      myGradeBook.processGrades();
      
      input.close();
   } 
} 

