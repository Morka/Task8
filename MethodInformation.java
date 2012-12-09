import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //for reflection
@Target(ElementType.METHOD)
public @interface MethodInformation {
	
	String author() default "JESUS";
	String date() default "30.08.2552";
	String description() default "Does something fancy!";

}