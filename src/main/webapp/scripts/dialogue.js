Territory.Dialogue = Class.extend({
	_territoryMap : null,
	_pts : null,
	_currentBlock : null,
	_cong : null,
	_recordTable : null,
	_printDialogInitialized : false,
	_members : [
	            "ANON", "JY", "ZQM", "SH", "WLC", "WL", "YAJ"
	            ],
	
	
	init : function(cong, map) {
		_territoryMap = map;
		_cong = cong;
		this._prepareSaveBlockDialogue();
		//this._prepareWriteRecordDialogue();
		//this._prepareViewRecordDialogue();
		
	},
	
	_prepareSaveBlockDialogue : function() {
		$("#save_block_dialog_form").modal({show: false});

		$("#btnSaveBlock").click(function(e){
            _territoryMap.saveBlock($("#block").val(), $("#number").val(), _pts);
            $("#save_block_dialog_form").modal("hide");
		});

		$("#btnCancelSaveBlock").click(function(e){
		    _territoryMap.finishDrawingBlocks();
        });

	},
	
	_prepareWriteRecordDialogue : function() {
		$("#save_record_dialog_form").dialog({
			autoOpen: false,
			height: 250,
			width: 250,
			modal: true,
			buttons: {
				"Save": function() {
					var record = [];
					record["cong"] = _cong;
					record["block"] = _currentBlock.split("-")[0];
					record["number"] = _currentBlock.split("-")[1];
					record["workDate"] = $("#workDate").val();
					record["initial"] = $("#initial").val();
					_territoryMap.saveWorkRecord(record);
					$(this).dialog("close");
				},
				Cancel: function() {
					$(this).dialog("close");
				}
			}
		});
		
		$("#return_card_dialog_form").dialog({
			autoOpen: false,
			height: 180,
			width: 250,
			modal: true,
			buttons: {
				"Save": function() {
					var record = [];
					record["cong"] = _cong;
					record["block"] = _currentBlock.split("-")[0];
					record["number"] = _currentBlock.split("-")[1];
					record["workDate"] = "2012-12-12"; //dummy data
					record["initial"] = "dummy"; //dummy data
					record["returnDate"] = $("#returnDate").val();
					_territoryMap.returnCard(record);
					$(this).dialog("close");
				},
				Cancel: function() {
					$(this).dialog("close");
				}
			}
		});
		
		$("#workDate").datepicker();
		$("#returnDate").datepicker();
		$("#workDate").datepicker( "option", "showAnim", "drop");
		$("#workDate").datepicker( "option", "dateFormat", "yy-mm-dd" );
		$("#returnDate").datepicker( "option", "showAnim", "drop");
		$("#returnDate").datepicker( "option", "dateFormat", "yy-mm-dd" );
		$( "#initial" ).autocomplete({ source : this._members});
	},
	
	_prepareViewRecordDialogue : function() {
		_recordTable = $("#view_record_dialog").dialog({
			autoOpen: false,
			height: 430,
			width: 500,
			modal: true,
			buttons: {
				Ok: function() {
					$( this ).dialog( "close" );
				}
			}
		});
		
		
	},
	
	_preparePrintDialogue : function() {
	    if(this._printDialogInitialized) return;

	    this._printDialogInitialized = true;
	    $("#save_block_dialog_form").modal({show: false});

	    $("#btnPrintBlocks").click(function(e){
            var blocks = [];
            $("form .printcheck:checked").each(function(){
                if($(this).attr("id") != "printAll") {
                    blocks.push($(this).attr("id"));
                }
            });

            if(_this._printOptionForRecord) {
                window.open("/print/printRecordSheetMultiple/" + _cong + "/" + blocks.join(",") + ",");
            } else if(_this._printOptionForOverall) {
                window.open("/print/printOverallMultiple/" + _cong + "/" + blocks.join(",") + ",");
            } else {
                window.open("/print/printMultiple/" + _cong + "/" + blocks.join(",") + ",");
            }

            $("#print_dialog_form").modal("hide");
        });

        $("#btnCancelPrintBlocks").click(function(e){
             $("#print_dialog_form").modal("hide");
        });

        $(document).on("click", "#printAll", function () {
            if($(this).is(":checked")) {
                $(".printcheck").attr("checked", true);
            } else {
                $(".printcheck").attr("checked", false);
            }
        });

        $(document).on("click", "#printOptionForRecord", function () {
            _this._printOptionForRecord = $(this).is(":checked");

            if($(this).is(":checked")) {
                $("form #printOptionForOverall").attr("checked", false);
                _this._printOptionForOverall = false;
            }
        });

        $(document).on("click", "#printOptionForOverall", function () {
            _this._printOptionForOverall = $(this).is(":checked");

            if($(this).is(":checked")) {
                $("form #printOptionForRecord").attr("checked", false);
                _this._printOptionForRecord = false;
            }
        });
	},
	
	openSaveBlockDialogue : function(pts) {
		$("#save_block_dialog_form").modal("show");
		_pts = pts;
	},
	
	openSaveRecordDialogue : function(block) {
		_currentBlock = block;
		$("#save_record_dialog_form").dialog("open");
	},
	
	openReturnCardDialogue : function(block) {
		_currentBlock = block;
		$("#return_card_dialog_form").dialog("open");
	},
	
	openViewRecordDialogue : function(data) {
		if(_this._recordTable) {
			_this._recordTable.fnClearTable();
			_this._recordTable.fnAddData(data);
		} else {
			_this._recordTable = $('#record').dataTable({
				"bJQueryUI" : true,
				"bRetrieve" : true,
				"bFilter": false,
				"bLengthChange": false,
				"bSort": false,
				"sAjaxDataProp" : "",
				"aaData": data,
				"aoColumns": [
					{ "sTitle" : "Work Date", "mDataProp": "workDate" },
					{ "sTitle" : "Card Return Date", "mDataProp": "returnDate" },
					{ "sTitle" : "Worked By", "mDataProp": "initial" }
				]
			});
		}
		
		$("#view_record_dialog").dialog("open");
	},
	
	openPrintDialogue : function(_blocks) {

		var printOptionTempl = $("#printOptionTempl").html();
		var headerTempl = $("#printHeaderTempl").html();
		var checkboxTempl = $("#printCheckTempl").html();
		
		$("#printFieldSet").html("");
		$("#printFieldSet").append(printOptionTempl);
		
		var uniqueBlockNames = this._getUniqueBlockNames(_blocks);
		var printHtml = "";
		
		for(var i = 0; i < uniqueBlockNames.length; i++) {
			printHtml += "<div class=\"printBlockDiv\">";
			printHtml += headerTempl.replace(/{blockName}/gi, uniqueBlockNames[i]);
			
			for(var j = 0; j < _blocks.length; j++) {
				if(uniqueBlockNames[i] == _blocks[j].block) {
					printHtml +=  checkboxTempl.replace(/{block}/gi, uniqueBlockNames[i] + "-" + _blocks[j].number).replace(/{blockName}/gi, uniqueBlockNames[i]).replace(/{blockNumber}/gi, _blocks[j].number);
				}
			}
			
			printHtml += "</div>";
		}
		
		$("#printFieldSet").append(printHtml);
		
		this._preparePrintDialogue();
        $("#print_dialog_form").modal("show");

	},
	
	_getUniqueBlockNames : function(_blocks) {
		var currentBlock = "";
		var blockNameArray = [];
		for(var i = 0; i < _blocks.length; i++) {
			if(currentBlock != _blocks[i].block) {
				blockNameArray.push(_blocks[i].block);
			}
			
			currentBlock = _blocks[i].block;
		}
		
		return blockNameArray;
	}
	
});