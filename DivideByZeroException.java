
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 

public class DivideByZeroException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DivideByZeroException(String message) {
		super(message);
	}
	
	DivideByZeroException() {
		super("Division by Zero");
	}
	
}