
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 

public class DivideByZeroException extends Exception{
	DivideByZeroException(String message) {
		super(message);
	}
	
	DivideByZeroException() {
		super("Division by Zero");
	}
	
}