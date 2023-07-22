package pl.andrusz.demos;


import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JqGridColumnAnnotation {
	public enum ALIGN {
		LEFT,
		RIGHT,
		CENTER
	}
	String 	name();
	String 	label();
	int 	columnNumber();
	boolean editable() 		default false;
	String 	edittype() 		default "";
	String 	formatter() 	default "";
	String 	sorttype()		default "text";
	int 	width() 		default 100;
	ALIGN 	align() 		default ALIGN.LEFT;
}
