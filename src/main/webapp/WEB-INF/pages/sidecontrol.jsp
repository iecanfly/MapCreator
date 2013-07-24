<div id="sideControl">
	<div id="blockDiv">
		<h5 class="sideControlHeader">Block Creation</h5>
		<input type="button" class="btn" value="Create" onclick="territoryMap.startDrawingBlocks();" />
		<input type="button" class="btn" value="Finish" onclick="territoryMap.finishDrawingBlocks();" />
	</div>

	<div id="printDiv">
		<h5 class="sideControlHeader">Print Territory</h5>
		<input type="button" class="btn" value="Print" onclick="territoryMap.openPrintDialogue();" />
	</div>

	<div id="filterDiv">
		<h5 class="sideControlHeader">View Filter</h5>
		<select style="font-size: 11px;" id="cboViewFilter" class="ui-combobox ui-widget ui-state-default ui-corner-all" >
		</select>
	</div>

    <!--
	<div id="coverageDiv">
		<h5 class="sideControlHeader">Coverage</h5>
        <div class="datepicker datepicker-inline"></div>
		<input type="button" class="btn" value="Block View" onclick="territoryMap.openBlockViewCoverage();" />
		<input type="button" class="btn" value="Chart View" onclick="territoryMap.openChartViewCoverage();" />
	</div>
    -->
</div>

<div id="viewFilterOptionTmpl" style="display:none">
<option value="{val}">{Name}</option>
</div>