<div id="save_block_dialog_form" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    <h3 id="myModalLabel">Save Block</h3>
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

<div id="print_dialog_form" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    <h3 id="myModalLabel">Print Blocks</h3>
  </div>
  <div class="modal-body">
    <form>
        <fieldset id="printFieldSet">

   	    </fieldset>
   	</form>
  </div>
  <div class="modal-footer">
    <button id="btnCancelPrintBlocks" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
    <button id="btnPrintBlocks" class="btn btn-primary">Print</button>
  </div>
</div>



<div style="display:none" id="printCheckTempl">
	<label class="printlabel">
	    <input type="checkbox" name="{block}" id="{blockName}^{blockNumber}" class="printcheck" />
        &nbsp;{block}
    </label>
</div>

<div style="display:none" id="printHeaderTempl">
	<br><h2 class="printBlockHeader">{blockName}</h2>
</div>

<div style="display:none" id="printOptionTempl">
	<div class="printBlockDiv">
        <span class="printlabel" >Select All</span>
        <input type="checkbox" name="printAll" id="printAll" class="printcheck" />
        <span class="printlabel" >For Record</span>
        <input type="checkbox" name="printOptionForRecord" id="printOptionForRecord" class="printcheckForOptionRecord" />
        <span class="printlabel" >For Overall</span>
        <input type="checkbox" name="printOptionForOverall" id="printOptionForOverall" class="printcheckForOptionRecord" />
        <span class="printlabel" >Bus Info</span>
        <input type="checkbox" name="printOptionForBusInfo" id="printOptionForBusInfo" class="printcheckForOptionRecord" />
    </div>
</div>

