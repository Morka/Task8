
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
@ClassInformation(author="Wolfgang", date="11.12.2012")  
public class DivideByZeroException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DivideByZeroException(String message) {
		super(message);
	}
	
	DivideByZeroException() {
		super();
	}
	
}