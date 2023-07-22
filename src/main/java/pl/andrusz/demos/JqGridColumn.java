package pl.andrusz.demos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JqGridColumn {
	protected final String name;
	protected final String label;
	protected final String formatter;
	
	@Builder.Default protected final Boolean editable=false;	
	@Builder.Default protected final Integer width=100;
	@Builder.Default protected final String edittype="";
	@Builder.Default protected final String align="left";
	
	@Builder.Default protected final String sorttype="text";
	@Builder.Default protected final String classes="";
			
	
	protected final JqGridColumnEditoptions editoptions;
}
