package pl.andrusz.demos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import pl.andrusz.demos.JqGridColumnAnnotation.ALIGN;

@Entity
@Data
@Table (name="maindata")
public class DBRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column Integer id;
	
	@JqGridColumnAnnotation(name="firstName",label="First name",columnNumber=1)
	@Column(name="[First name]")
	String firstName;
	
	@JqGridColumnAnnotation(name="lastName",label="Last name",columnNumber=2)
	@Column(name="[Last name]") 
	String lastName;
	
	@JqGridColumnAnnotation(name="Category",label="Category",columnNumber=3,align=ALIGN.CENTER)
	@Column(name="Category") 
	String category;
}
