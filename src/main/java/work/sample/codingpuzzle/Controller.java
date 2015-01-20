package work.sample.codingpuzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author aamir
 * A controller class to control the activities needed to test the Puzzle
 * Thread Management
 * Input handling
 * Execution of tests
 */
public class Controller 
{

	private List<String> testPatterns = new ArrayList<String>();
	private ThreadManager threadManager = ThreadManager.getInstance();
	
	
	/**
	 * Processes user given tests and signal the stoppage of threads execution 
	 */
	public void processTests(){
		readInput();
		executeUserTests();
		threadManager.reportExecutionEnded();
	}


	/**
	 * Take input from standard input and store it in a list having ArrayList implementation
	 */
	private void readInput(){
		System.out.println("Enter the string patterns to test. and issue Exit command to finish the input.");
		Scanner stdin = new Scanner(System.in);
	    while(stdin.hasNextLine())
	    {
	    	
	        String input = stdin.nextLine();
	        if("Exit".equalsIgnoreCase(input)){
	        	break;
	        }
	        testPatterns.add(input);
		}
	}
	
	
	/**
	 * Use the threadManger to execute all input cases with given number of threads available
	 */
	private void executeUserTests() {
		int inputIterator = 0;
	    while(testPatterns.size() > inputIterator)
	    {
	    	threadManager.execute(new WellFormTemplate(inputIterator, testPatterns.get(inputIterator)));
	    	inputIterator++;
		}
	}

	
	/**
	 * @param args
	 * The starting point of our small puzzle. The controller initiates the Testing
	 * and ends while all the threads finished with input strings
	 */
	public static void main(String args[]){
		Controller kickStarter = new Controller();
		kickStarter.processTests();
		System.exit(0);
	}
}
