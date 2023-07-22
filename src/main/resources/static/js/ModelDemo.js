'use strict'

$(document).ready(function(){
	$.get('/model',function(columnModel){
		var $grid=$('#grid');
		$grid.jqGrid({
			caption:	'Simple demo',
			guiStyle:	'bootstrap',
		    iconSet:'	fontAwesome',
		    colModel:	columnModel
		});
	})
})