<div id="save_block_dialog_form" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="blockDialogLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    <h3 id="blockDialogLabel">Save Block</h3>
  </div>
  <div class="modal-body">
    <form>
    	<fieldset>
    		<label for="block">Block</label>
    		<input type="text" name="block" id="block" class="text ui-widget-content ui-corner-all" />
    		<label for="number">Number</label>
    		<input type="text" name="number" id="number" class="text ui-widget-content ui-corner-all" />
    	</fieldset>
    	</form>
  </div>
  <div class="modal-footer">
    <button id="btnCancelSaveBlock" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
    <button id="btnSaveBlock" class="btn btn-primary">Save Block</button>
  </div>
</div>

<div id="save_building_dialog_form" class="modal hide fade" tabindex="-2" role="dialog" aria-labelledby="buildingModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    <h3 id="buildingModalLabel">Save Building</h3>
  </div>
  <div class="modal-body">
    <form>
        <fieldset>
            <label for="buildingBlock">Block</label>
            <input type="text" name="buildingBlock" id="buildingBlock" class="text ui-widget-content ui-corner-all" />
            <label for="buildingNumber">Number</label>
            <input type="text" name="buildingNumber" id="buildingNumber" class="text ui-widget-content ui-corner-all" />
            <label for="buildingName">Building Name</label>
            <input type="text" name="buildingName" id="buildingName" class="text ui-widget-content ui-corner-all" />
            <label for="buildingAddress">Address</label>
            <input type="text" name="buildingAddress" id="buildingAddress" class="text ui-widget-content ui-corner-all" />
            <label for="buildingFloor">Floor Info</label>
            <input type="text" name="buildingFloor" id="buildingFloor" class="text ui-widget-content ui-corner-all" />
        </fieldset>
    </form>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
    <button id="btnSaveBuilding" class="btn btn-primary">Save changes</button>
  </div>
</div>

<div style="display:none" id="save_record_dialog_form" title="Write Record">
	<form>
	<fieldset>
		<label for="workDate">Work Date</label>
		<input type="text" name="workDate" id="workDate" class="text ui-widget-content ui-corner-all" />
		<label for="personInitial">Initial</label>
		<input type="text" name="initial" id="initial" class="text ui-widget-content ui-corner-all" />
	</fieldset>
	</form>
</div>

<div style="display:none" id="return_card_dialog_form" title="Write Record">
	<form>
	<fieldset>
		<label for="cardReturnDate">Card Return Date</label>
		<input type="text" name="returnDate" id="returnDate" class="text ui-widget-content ui-corner-all" />
	</fieldset>
	</form>
</div>

<div style="display:none" id="view_record_dialog" title="View Record">
	<table id="record">
	    <thead>
	    </thead>
	    <tbody>

	    </tbody>
	</table>
</div>

<div id="print_blocks_dialog_form" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="modalLabelForBlock" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    <h3 id="modalLabelForBlock">Print Blocks</h3>
  </div>
  <div class="modal-body">
    <form>
        <fieldset id="printBlocksFieldSet">

   	    </fieldset>
   	</form>
  </div>
  <div class="modal-footer">
    <button id="btnCancelPrintBlocks" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
    <button id="btnPrintBlocks" class="btn btn-primary">Print</button>
  </div>
</div>

<div id="print_buildings_dialog_form" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="modalLabelForBuilding" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    <h3 id="modalLabelForBuilding">Print Buildings</h3>
  </div>
  <div class="modal-body">
    <form>
        <fieldset id="printBuildingsFieldSet">

   	    </fieldset>
   	</form>
  </div>
  <div class="modal-footer">
    <button id="btnCancelPrintBuildings" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
    <button id="btnPrintBuildings" class="btn btn-primary">Print</button>
  </div>
</div>



<div style="display:none" id="printBlocksCheckTempl">
	<label class="printlabel">
	    <input type="checkbox" name="{block}" id="{blockName}^{blockNumber}" class="printBlocksCheck" />{block}
    </label>
</div>

<div style="display:none" id="printBlocksHeaderTempl">
	<br><h2 class="printBlockHeader">{blockName}</h2>
</div>

<div style="display:none" id="printBuildingsCheckTempl">
	<label class="printlabel">
	    <input type="checkbox" name="{block}" id="{blockName}^{blockNumber}" class="printBuildingsCheck" />{block}
    </label>
</div>

<div style="display:none" id="printBuildingsHeaderTempl">
	<br><h2 class="printBlockHeader">{blockName}</h2>
</div>

<div style="display:none" id="printBlocksOptionTempl">
	<div class="printBlockDiv">
        <span class="printlabel" >Select All</span>
        <input type="checkbox" name="printAllBlocks" id="printAllBlocks" class="printcheck" />
        <span class="printlabel" >For Overall</span>
        <input type="checkbox" name="printBlocksOptionForOverall" id="printBlocksOptionForOverall" class="printcheckForOptionRecord" />
        <span class="printlabel" >Bus Info</span>
        <input type="checkbox" name="printBlocksOptionForBusInfo" id="printBlocksOptionForBusInfo" class="printcheckForOptionRecord" />
        <span class="printlabel" >Business Type Info</span>
        <input type="checkbox" name="printBlocksOptionForBusinessTypeInfo" id="printBlocksOptionForBusinessTypeInfo" class="printcheckForOptionRecord" />
        <span class="printlabel" >Colour Division</span>
        <input type="checkbox" name="printBlocksOptionForColourDivision" id="printBlocksOptionForColourDivision" class="printcheckForOptionRecord" />
    </div>
</div>
<div style="display:none" id="printBuildingsOptionTempl">
	<div class="printBlockDiv">
        <span class="printlabel" >Select All</span>
        <input type="checkbox" name="printAllBuildings" id="printAllBuildings" class="printcheck" />
        <span class="printlabel" >For Overall</span>
        <input type="checkbox" name="printBuildingsOptionForOverall" id="printBuildingsOptionForOverall" class="printcheckForOptionRecord" />
        <span class="printlabel" >Bus Info</span>
        <input type="checkbox" name="printBuildingsOptionForBusInfo" id="printBuildingsOptionForBusInfo" class="printcheckForOptionRecord" />
        <span class="printlabel" >Business Type Info</span>
        <input type="checkbox" name="printBuildingsOptionForBusinessTypeInfo" id="printBuildingsOptionForBusinessTypeInfo" class="printcheckForOptionRecord" />
    </div>
</div>

