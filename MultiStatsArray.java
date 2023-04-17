
import java.util.Random;  //for our random number generator
import java.text.DecimalFormat;

public class MultiStatsArray {

	private int rowSize;  //number of rows
	private int colSize; //number of columns
	private int[][]stats; // an array of integers
	DecimalFormat fmt1 = new DecimalFormat("0.0");
	//default constructor
	//by default the array has 10 rows and 5 columns
	MultiStatsArray() {
		rowSize = 10;
		colSize = 5;
		stats = new int[rowSize][colSize];
	}
	
	//fill array with random numbers (int) in the range 0 - 100	
	public void randomFill() {
		Random random = new Random();
		for(int i = 0 ; i < stats.length ; i++) {
			for (int j = 0 ; j < stats[i].length ; j++) {
				stats[i][j] = random.nextInt(101);
			}
		}
	}
	//add up all the values in the array
	public int getTotal() {
		//add up all the values in the array
		int total = 0;
		for(int i = 0 ; i < stats.length ; i++) {
			for (int j = 0 ; j < stats[i].length ; j++) {
				total += stats[i][j];
			}
		}
		return total; //make sure to return the total
	}

	//return the average for the entire array
	public double getAvg() {
		double avg = (double)getTotal() / (stats.length * stats[0].length);
		return avg; //make sure to return the avg
	}
	//computes and returns the sum of a given row
	public int  getRowTotal(int row) {
		int rowTotal = 0;
		for (int i = 0; i < stats[row].length ; i++) {
			rowTotal += stats[row][i];
		}
		return rowTotal; //make sure to return the row total	
	}
	//computes and return the avg of the given row
	public double getRowAvg(int row) {
		double rowAvg = (double)getRowTotal(row) / stats[row].length;
		return rowAvg; //make sure to return the row avg
	}
	//return the maximum value in the array
	public int getLargest() {
		int largest = stats[0][0];
		for(int i = 0; i < stats.length; i++) {
			for(int j = 0; j < stats[i].length; j++) {
				if(stats[i][j] > largest) {
					largest = stats[i][j];
				}
			}
		}
		return largest;
	}
	//return the minimum value in the array
	public int getSmallest() {
		int smallest = stats[0][0];
		for(int i = 0; i < stats.length; i++) {
			for(int j = 0; j < stats[i].length; j++) {
				if(stats[i][j] < smallest) {
					smallest = stats[i][j];
				}
			}
		}
		return smallest;
	}
	//count how many numbers are >= lowRange and <= highRange
	public int findLetterGrade(int lowRange, int highRange) {
		int count = 0;
		for(int i = 0 ; i < stats.length ; i++) {
			for (int j = 0 ; j < stats[i].length ; j++) {
				if(stats[i][j] >= lowRange && stats[i][j] <= highRange) {
					count++;
				}
			}
		}
		return count;
	}
	//returns true if a someNumber is in the array otherwise false
	public boolean isNumberFound(int someNumber) {
		boolean found = false;  //Good idea to initialize it to false
		for(int i = 0 ; i < stats.length ; i++) {
			for (int j = 0 ; j < stats[i].length ; j++) {
				if(stats[i][j] == someNumber) {
					found = true;
				}
			}
		} 
		return found;  
	}
	//displays the array with row total and row average at the end of each row
	//See the expected output in the assignment specification
	public void display() {
		for(int i = 0 ; i < stats.length ; i++) {
			System.out.print("[" + i + "]\t" );
			for (int j = 0 ; j < stats[i].length ; j++) {
				System.out.print(stats[i][j] + "\t");
			}
			System.out.print("Total: " + fmt1.format(getRowTotal(i)));
			System.out.print("\tAvg: " + fmt1.format(getRowAvg(i)));
			System.out.println();
		}
	}
}//end of MultiStatsArray class