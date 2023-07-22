package pl.andrusz.demos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelDemoRestController {
	@GetMapping(value="/model") 
	List<JqGridColumn> jqGridModel(){
		return JqGridService.readColumnModel(DBRecord.class);
	}

}
