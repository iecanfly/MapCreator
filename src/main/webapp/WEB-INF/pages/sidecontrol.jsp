<div id="sideControl">
	<div id="blockDiv">

		<h5 class="sideControlHeader">Block Creation</h5>

		<div class="btn-group">
          <button class="btn">Create</button>
          <button class="btn dropdown-toggle" data-toggle="dropdown">
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
            <li><a href="#" onclick="territoryMap.startDrawingBlocks();">Block</a></li>
            <li><a href="#" onclick="territoryMap.startDrawingBuildings();">Building</a></li>
          </ul>
        </div>
	</div>

	<div id="printDiv">
		<h5 class="sideControlHeader">Print Territory</h5>
		<div class="btn-group">
          <button class="btn">Print</button>
          <button class="btn dropdown-toggle" data-toggle="dropdown">
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
            <li><a href="#" onclick="territoryMap.openPrintBlocksDialogue();">Block</a></li>
            <li><a href="#" onclick="territoryMap.openPrintBuildingsDialogue();">Building</a></li>
          </ul>
        </div>
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

<div id="viewFilterBlockOptionTmpl" style="display:none">
<option class="block" value="{val}">{Name}</option>
</div>

<div id="viewFilterBuildingOptionTmpl" style="display:none">
<option class="building" value="{val}">{Name}</option>
</div>

<div id="viewFilterSeperatorTmpl" style="display:none">
<option class="select-dash" disabled="disabled">----</option>
</div>