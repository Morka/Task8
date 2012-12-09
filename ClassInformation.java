import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //for reflection
@Target(ElementType.TYPE)
public @interface ClassInformation {
	
	String author() default "GOD";
	String date() default "01.01.1970";

}
