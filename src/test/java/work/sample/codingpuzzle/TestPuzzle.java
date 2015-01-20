package work.sample.codingpuzzle;

import junit.framework.TestCase;

import org.junit.Test;


/**
 * @author Aamir
 * This class tests all patterns given in the task description
 * While executing install the console messages are furnished for 
 * each of the tests *
 */
public class TestPuzzle extends TestCase {


	/**
	 * For static defined tests in the task description
	 */
	private WellFormTemplate service = new WellFormTemplate();
	
	/**
	 * Each type of bracket needs to be first opened then closed
	 * Good: () or [] or {}
	 */
	@Test
    public void testCase1a() {		
		System.out.println("Testing static test 1, positive case");
        assertTrue( service.isWellFormed("()"));
        assertTrue( service.isWellFormed("[]"));
        assertTrue( service.isWellFormed("{}"));
    }
	
	/**
	 * Each type of bracket needs to be first opened then closed
	 * Bad: (() or {}}
	 */
	@Test
    public void testCase1b() {
		System.out.println("Testing static test 1, negative case");
        assertFalse( service.isWellFormed("(()"));
        assertFalse( service.isWellFormed("{}}"));
        
    }
	
	/**
	 * You can only close the last bracket that was opened
	 * Good: ({})
	 */
	@Test
    public void testCase2a() {
		System.out.println("Testing static test 2, positive case");
        assertTrue( service.isWellFormed("({})"));
    }
	
	/**
	 * You can only close the last bracket that was opened
	 * Bad: ({)}
	 */
	@Test
    public void testCase2b() {
		System.out.println("Testing static test 2, negative case");
        assertFalse( service.isWellFormed("({)}"));
    }
	
	/**
	 * Inside parenthesis () only braces {} are allowed
	 * Good: ({})
	 */ 
	@Test
    public void testCase3a() {
		System.out.println("Testing static test 3, positive case");
        assertTrue( service.isWellFormed("({})"));
    }    
    
    /**
	 * Inside parenthesis () only braces {} are allowed
	 * Bad: ([]) or (())
	 */
	@Test
    public void testCase3b() {
		System.out.println("Testing static test 3, negative case");
        assertFalse( service.isWellFormed("([])"));
        assertFalse( service.isWellFormed("(())"));
    }	

	/**
	 * Inside braces {} only square brackets [] are allowed
	 * Good: {[]}
	 */
	@Test
    public void testCase4a() {
		System.out.println("Testing static test 4, positive case");
        assertTrue( service.isWellFormed("{[]}"));
    }
	
	/**
	 * Inside braces {} only square brackets [] are allowed
	 * Bad: {()} or {{}}
	 */
	@Test
    public void testCase4b() {
		System.out.println("Testing static test 4, negative case");
        assertFalse( service.isWellFormed("{()}"));
        assertFalse( service.isWellFormed("{{}}"));
    }
	
	/**
	 * Any bracket can appear (directly) inside square brackets []
	 * Good: [()] or [{}] or [[]] or [[[]]]
	 */
	@Test
    public void testCase5a() {
		System.out.println("Testing static test 5, positive case");
        assertTrue( service.isWellFormed("[()]"));
        assertTrue( service.isWellFormed("[{}]"));
        assertTrue( service.isWellFormed("[[]]"));
        assertTrue( service.isWellFormed("[[[]]]"));
    }
	
    /**
	 * Any bracket can appear (directly) inside square brackets []
	 * Bad: [([])]
	 */
	@Test
    public void testCase5b() {
		System.out.println("Testing static test 5, negative case");
        assertFalse( service.isWellFormed("[([])]"));
    }
	
  	/**
	 * You can use a list of braces where a single one is allowed of that
	 * Good: [()()] or {[][()()]} or ()()
	 */
	@Test
    public void testCase6() {
		System.out.println("Testing static test 6");
        assertTrue( service.isWellFormed("[()()]"));
        assertTrue( service.isWellFormed("{[][()()]}"));
        assertTrue( service.isWellFormed("()()"));
    }

	/**
	 * An empty string is not valid a expression
	 */
	@Test
    public void testCase7() {
		System.out.println("Testing static test 7");
        assertFalse( service.isWellFormed(""));
    }

	/**
	 * Any other characters than (){}[] will invalidate the string
	 */
	@Test
    public void testCase8() {
		System.out.println("Testing static test 8");
        assertFalse( service.isWellFormed("blahblah_@"));
    }

}
