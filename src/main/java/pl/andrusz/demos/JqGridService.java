package pl.andrusz.demos;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JqGridService {
	 public List<JqGridColumn> readColumnModel(Class gridField	)  {
		   List<JqGridColumn> listaKolumn=new ArrayList<JqGridColumn>();
		   Field[] fieldList=gridField.getDeclaredFields();
		   for(Field column:fieldList) {
			   Annotation columnAnnotation=column.getAnnotation(JqGridColumnAnnotation.class);
			   if (columnAnnotation instanceof JqGridColumnAnnotation) {
				   Object odczytanePole;
				   JqGridColumnAnnotation jqGridModel=(JqGridColumnAnnotation) columnAnnotation;
				   
				   JqGridColumnEditoptions editoptions=null;
				   String classes="";
				   String formatter;
				   String label;
				   String sorttype="text";
				   
				   label=jqGridModel.label();
				   if (!jqGridModel.formatter().equals("")) {
					   formatter=jqGridModel.formatter();
					   sorttype=jqGridModel.sorttype();
				   } else {
						try {
							odczytanePole = column.getGenericType();
							formatter="";
		 				   if (odczytanePole == Integer.class) {
		 					  formatter="integer";
		 					  sorttype="int";
		 				   }
		 				   if (odczytanePole == BigDecimal.class) {
		 					  formatter="currency";
		 					  sorttype="number";
		 				   }
		 				   if (odczytanePole == String.class) {
		 					  formatter="";
		 				   }
		 				   if (odczytanePole == Date.class) {
		 					  formatter="date";
		 					  sorttype="date";
		 				   }
		 				   if (odczytanePole == Boolean.class) {
		 					  formatter="checkbox";
		 					  editoptions=JqGridColumnEditoptions.builder().disabled(false).build();
		 					  classes=column.getName();
		 				   }
						} catch (IllegalArgumentException e) {
							formatter="";
						}				   
				   }				   
				   
				   JqGridColumn kolumna=JqGridColumn.builder()
						   	.name(column.getName())
						   	.label(label)
						   	.formatter(formatter)
						   	.sorttype(sorttype)
						   	.width(jqGridModel.width())
						   	.editable(jqGridModel.editable())
						   	.edittype(jqGridModel.edittype())
						   	.editoptions(editoptions)
						   	.classes(classes)
						   	.align(jqGridModel.align().toString())
						   	.build();
				   listaKolumn.add(kolumna);
			   }
		   }
		   return listaKolumn;
	   }	
}
