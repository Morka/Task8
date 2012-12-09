import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //for reflection
@Target(ElementType.METHOD)
public @interface MethodInformation {
	
	String author() default "MASTER CHIEF";
	String date() default "30.08.2552";
	String description() default "Escape from Reach";

}
