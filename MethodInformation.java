import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface MethodInformation {
	
	String author() default "GOD";
	String date() default "30.08.2552";
	String description() default "Does something fancy!";

}
