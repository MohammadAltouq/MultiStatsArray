/**
 *Description: MultiStatsArrayTester creates and displays a 2-dimensional array with random numbers from 0-100
 * 		also display the minimum, maximum, array total, array average, number of A's, and perfect score
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class MultiStatsArrayTester {
	
  public static void main(String arg[]) {	
	  
	/*instantiate your MultiArray object called examScores
	  Its constructor creates array of size 10 rows and 5 columns
	  */
	
	MultiStatsArray examScores = new MultiStatsArray( );
	Scanner scan = new Scanner(System.in);
	String again = ""; //declare an empty string to use later
	DecimalFormat fmt1 = new DecimalFormat("0.#");
	do
	  {
		   //fill array with random exam scores	  
		   examScores.randomFill();
		   System.out.println("Exam Scores");
		   System.out.println("------------");
	       //call display method to display the array with Row total and row average 
		   examScores.display();
		   //display additional stats array statistics such as maximum, minimum, full array total,
	       //array average, number of A's, and a perfect score
		   System.out.println("\nThe minimum value : " + examScores.getSmallest());
		   System.out.println("The maximum value : " + examScores.getLargest());
		   System.out.println("The total is      : " + examScores.getTotal());
		   System.out.println("The average is    : " + fmt1.format(examScores.getAvg()));
		   System.out.println("Number of A's     : " + examScores.findLetterGrade(90, 100));
		   if(examScores.isNumberFound(100)) {
			   System.out.println("Congrats you have a perfect exam score!");
		   }else {
			   System.out.println("Sorry you Don't have a perfect exam score");   
		   }
		 System.out.println("\nDo you want to try again?  (Y or N) ");
		 again = scan.next(); 
	  } while ( again.equalsIgnoreCase("Y"));
	 scan.close();
	 System.out.println("Goodbye");
  	}
}