package work.sample.codingpuzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Aamir
 * A template class to validate the input strings being well formed
 */
public class WellFormTemplate implements Runnable{

	/**
	 * A map to hold the alphabets of possible patterns 
	 * also the map is use to maintain sequence between brackets
	 */
	private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
    static {
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');
    }  
    
    //the input string representation
    public String testingPattern;
    //its label of the testing pattern from global perspective
    public int patternIndex;

    
    /**
     * A constructor that helps in executing static test cases
     */
    public WellFormTemplate(){
    	patternIndex = 0;
    }
    
    /**
     * A constructor that helps in executing user provided test cases
     */
    public WellFormTemplate(int index, String pattern) {
    	this.patternIndex = index;
    	this.testingPattern = pattern;
    }

    /**
     * Returns true if strings are formed according to the puzzle rules
     * 
     * 
     * @param inputPattern   the input brackets
     * @return	true, if all the rules are satisfied for being well formed
     */
    public boolean isWellFormed(String inputPattern) {
        //empty or zero length patterns results in not well-form
    	if (inputPattern == null || inputPattern.length() == 0) {
            return false;
        }
        // odd number of alphabets in the pattern would always result in false
        if ((inputPattern.length() % 2) != 0) {
            return false;
        }

        final Stack<Character> stack = new Stack<Character>();
        
        //process each alphabet in the input pattern until its get finished or 
        //some decision is made 
        
        for (int i = 0; i < inputPattern.length(); i++) {
        	//tests if selected character is starting bracket or any other character
            if (brackets.containsKey(inputPattern.charAt(i))) {
            	//testing case where inside parenthesis () only braces {} are allowed 
            	if(!stack.empty() && stack.peek() == '('){
            		if(inputPattern.charAt(i) == '{'){
            			stack.push(inputPattern.charAt(i));
            		}else {
            			return false;
            		}
            	//testing case where inside braces {} only square brackets [] are allowed
            	}else if(!stack.empty() && stack.peek() == '{'){
            		if(inputPattern.charAt(i) == '['){
            			stack.push(inputPattern.charAt(i));
            		}else {
            			return false;
            		}
            	}else {
            		stack.push(inputPattern.charAt(i));
            	}
            //tests unexpectedly stack is empty or the closing bracket(unexpected character) unmatched
            } else if (stack.empty() || (inputPattern.charAt(i) != brackets.get(stack.pop()))) {
                return false;
            } 
        }
        return true;
    }

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * A core method that takes the duties(execution) of this class being thread
	 */
	@Override
	public void run() {
		System.out.println(patternIndex+ ":" + (isWellFormed(testingPattern)?"True":"False"));
	} 

}
