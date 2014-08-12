Territory.Dialogue = Class.extend({
	_territoryMap : null,
	_pt : null,
	_pts : null,
	_currentBlock : null,
	_cong : null,
	_recordTable : null,
	_printBlockDialogInitialized : false,
	_printBuildingDialogInitialized : false,
	_members : [],
	
	
	init : function(cong, map) {
		_territoryMap = map;
		_cong = cong;
		this._prepareSaveBlockDialogue();
		this._prepareSaveBuildingDialogue();
	},
	
	_prepareSaveBlockDialogue : function() {
		$("#save_block_dialog_form").modal({show: false});

		$("#btnSaveBlock").click(function(e){
            _territoryMap.saveBlock($("#block").val(), $("#number").val(), _pts);
            $("#save_block_dialog_form").modal("hide");
		});
	},

	_prepareSaveBuildingDialogue : function() {
        $("#save_building_dialog_form").modal({show: false});

        $("#btnSaveBuilding").click(function(e){
            _territoryMap.saveBuilding( $("#buildingBlock").val(), $("#buildingNumber").val(), $("#buildingName").val(),
                                        $("#buildingAddress").val(), $("#buildingFloor").val(), _pt);

            $("#save_building_dialog_form").modal("hide");
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
	
	_preparePrintBlocksDialogue : function() {
	    if(this._printBlockDialogInitialized) return;

	    this._printBlockDialogInitialized = true;
	    $("#save_block_dialog_form").modal({show: false});

	    $("#btnPrintBlocks").click(function(e){
            var blocks = [];
            $("form .printBlocksCheck:checked").each(function(){
                if($(this).attr("id") != "printAllBlocks") {
                    blocks.push($(this).attr("id"));
                }
            });

            var isDisplayBusInfo = $("#printBlocksOptionForBusInfo").is(":checked");
            var isDisplayBusinessTypeInfo = $("#printBlocksOptionForBusinessTypeInfo").is(":checked");
            var isDisplayColourDivision= $("#printBlocksOptionForColourDivision").is(":checked");

            if(_this._printBlocksOptionForOverall) {
                window.open("/print/blocks/printOverallMultiple/" + _cong + "/" + isDisplayBusInfo + "/" + isDisplayBusinessTypeInfo + "/" + isDisplayColourDivision + "/" + blocks.join(",") + ",");
            } else {
                window.open("/print/blocks/printMultiple/" + _cong + "/" + isDisplayBusInfo + "/" + isDisplayBusinessTypeInfo + "/" +  isDisplayColourDivision + "/" + blocks.join(",") + ",");
            }

            $("#print_dialog_form").modal("hide");
        });

        $("#btnCancelPrintBlocks").click(function(e){
             $("#print_dialog_form").modal("hide");
        });

        $(document).on("click", "#printAllBlocks", function () {
            if($(this).is(":checked")) {
                $(".printBlocksCheck").attr("checked", true);
            } else {
                $(".printBlocksCheck").attr("checked", false);
            }
        });

        $(document).on("click", "#printBlocksOptionForOverall", function () {
            _this._printBlocksOptionForOverall = $(this).is(":checked");
        });
	},

	_preparePrintBuildingsDialogue : function() {
	    if(this._printBuildingDialogInitialized) return;

	    this._printBuildingDialogInitialized = true;
	    $("#save_building_dialog_form").modal({show: false});

	    $("#btnPrintBuildings").click(function(e){
            var blocks = [];
            $("form .printBuildingsCheck:checked").each(function(){
                if($(this).attr("id") != "printAllBuildings") {
                    blocks.push($(this).attr("id"));
                }
            });

            var isDisplayBusInfo = $("#printBuildingsOptionForBusInfo").is(":checked");
            var isDisplayBusinessTypeInfo = $("#printBuildingsOptionForBusinessTypeInfo").is(":checked");
            var isDisplayColourDivision= $("#printBuildingsOptionForColourDivision").is(":checked");

            if(_this._printBuildingsOptionForOverall) {
                window.open("/print/buildings/printOverallMultiple/" + _cong + "/" + isDisplayBusInfo + "/" + isDisplayBusinessTypeInfo + "/" + isDisplayColourDivision + "/" + blocks.join(",") + ",");
            } else {
                window.open("/print/buildings/printMultiple/" + _cong + "/" + isDisplayBusInfo + "/" + isDisplayBusinessTypeInfo + "/" + isDisplayColourDivision + "/" + blocks.join(",") + ",");
            }

            $("#print_buildings_dialog_form").modal("hide");
        });

        $("#btnCancelPrintBuildings").click(function(e){
             $("#print_buildings_dialog_form").modal("hide");
        });

        $(document).on("click", "#printAllBuildings", function () {
            if($(this).is(":checked")) {
                $(".printBuildingsCheck").attr("checked", true);
            } else {
                $(".printBuildingsCheck").attr("checked", false);
            }
        });

        $(document).on("click", "#printBuildingsOptionForOverall", function () {
            _this._printBuildingsOptionForOverall = $(this).is(":checked");
        });
	},

	openSaveBlockDialogue : function(pts) {
		$("#save_block_dialog_form").modal("show");
		_pts = pts;
	},

	openSaveBuildingDialogue : function(pt) {
		$("#save_building_dialog_form").modal("show");
		_pt = pt;
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
	
	openPrintBlocksDialogue : function(_blocks) {
		var printOptionTempl = $("#printBlocksOptionTempl").html();
		var headerTempl = $("#printBlocksHeaderTempl").html();
		var checkboxTempl = $("#printBlocksCheckTempl").html();
		
		$("#printBlocksFieldSet").html("");
		$("#printBlocksFieldSet").append(printOptionTempl);
		
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
		
		$("#printBlocksFieldSet").append(printHtml);
		
		this._preparePrintBlocksDialogue();
        $("#print_blocks_dialog_form").modal("show");

	},

	openPrintBuildingsDialogue : function(buildings) {
		var printOptionTempl = $("#printBuildingsOptionTempl").html();
		var headerTempl = $("#printBuildingsHeaderTempl").html();
		var checkboxTempl = $("#printBuildingsCheckTempl").html();

		$("#printBuildingsFieldSet").html("");
		$("#printBuildingsFieldSet").append(printOptionTempl);

		var uniqueBlockNames = this._getUniqueBlockNames(buildings);
		var printHtml = "";

		for(var i = 0; i < uniqueBlockNames.length; i++) {
			printHtml += "<div class=\"printBlockDiv\">";
			printHtml += headerTempl.replace(/{blockName}/gi, uniqueBlockNames[i]);

			for(var j = 0; j < buildings.length; j++) {
				if(uniqueBlockNames[i] == buildings[j].block) {
					printHtml +=  checkboxTempl.replace(/{block}/gi, uniqueBlockNames[i] + "-" + buildings[j].number).replace(/{blockName}/gi, uniqueBlockNames[i]).replace(/{blockNumber}/gi, buildings[j].number);
				}
			}

			printHtml += "</div>";
		}

		$("#printBuildingsFieldSet").append(printHtml);

		this._preparePrintBuildingsDialogue();
        $("#print_buildings_dialog_form").modal("show");

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