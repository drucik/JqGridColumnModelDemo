package pl.andrusz.demos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DBRecord {
	
	@Id
	@Column Integer id;
	
	@JqGridColumnAnnotation(name="field1",label="First field",columnNumber=1)
	@Column String field1;
	@JqGridColumnAnnotation(name="field2",label="Second field",columnNumber=2)
	@Column String field2;
	@JqGridColumnAnnotation(name="field3",label="Third field",columnNumber=3)
	@Column String field3;
}
