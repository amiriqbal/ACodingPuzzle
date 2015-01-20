package work.sample.codingpuzzle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aamir
 * A singleton class responsible for creating, assigning and executing 
 * test to threads, here singleton pattern implemented to ensure threads 
 * remain under single control
 */
public class ThreadManager {

	private ExecutorService anExecutor;
	private int availableProcessors;
	
	
	private static ThreadManager threadManager;
	
	
	/**
	 * initialize executor to manage execution of task with available 
	 * processors
	 */
	private ThreadManager() {
		super();
		availableProcessors = Runtime.getRuntime().availableProcessors(); 
		initializeExecutor();
		announceProcessors();
	}
	
	/**
	 * To make sure as many number of threads would be used at a time
	 * as many processors are available 
	 */
	private void announceProcessors() {
		System.out.println("The number of processor cores and hence " +
				"number of threads equal "+ availableProcessors);
	}

	/**
	 * Create as many threads as many cores are available in the system
	 */
	private void initializeExecutor(){
		anExecutor = Executors.newFixedThreadPool(availableProcessors);
	}

	/**
	 * part of singleton pattern to manage one instance of this class.
	 */
	public static ThreadManager getInstance() {
		if(threadManager == null){
			threadManager = new ThreadManager();
		}
		return threadManager;
	}
	
	/**
	 * execute the input command on a particular processor either until its not finished
	 * or exception not get raised.
	 */
	public void execute(Runnable command){
		anExecutor.execute(command);
	}	
	
	/**
	 * At the end of execution it releases the thread in the thread pool and 
	 * report/ensure their termination
	 */
	public void reportExecutionEnded(){
		anExecutor.shutdown();
        while (!anExecutor.isTerminated()) {
        }
	}	
	
}
