'use strict'

$(document).ready(function(){
	$.get('/model',function(columnModel){
		var $grid=$('#grid');
		$grid.jqGrid({
			caption:	'Simple annotation demo',
			guiStyle:	'bootstrap',
		    iconSet:'	fontAwesome',
		    url:		'/api/dBRecords',
		    datatype: 	'json',
		    loadonce:	true,
		    jsonReader: { repeatitems : false, root:'_embedded.dBRecords',id: '0'},
		    colModel:	columnModel
		});
	})
})