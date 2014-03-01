package com.gooki.webapp.controller;

import com.gooki.service.BlockManager;
import com.gooki.service.BuildingManager;
import com.gooki.webapp.constant.TerritoryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/print")
public class PrintController extends TerritoryBaseController {
	private BlockManager blockManager = null;
    private BuildingManager buildingManager = null;

    @Autowired
    public void setBuildingManager(BuildingManager buildingManager) {
        this.buildingManager = buildingManager;
    }

    @Autowired
    public void setBlockManager(BlockManager blockManager) {
        this.blockManager = blockManager;
    }

    @RequestMapping(value = "/blocks/{printType}Multiple/{congName}/{isDisplayBusInfo}/{isDisplayBusinessTypeInfo}/{block}", method = RequestMethod.GET)
    public ModelAndView handlePrintMultipleBlocksRequest(@PathVariable String congName, @PathVariable String block, @PathVariable String printType, @PathVariable Boolean isDisplayBusInfo, @PathVariable Boolean isDisplayBusinessTypeInfo) throws Exception {
        Model model = new ExtendedModelMap();
        String[] blockArray = block.split(",");
        model.addAttribute(TerritoryConstants.BLOCK_LIST.getValue(), blockManager.getBlocks(congName, blockArray));
        model.addAttribute(TerritoryConstants.IS_DISPLAY_BUS_INFO.getValue(), isDisplayBusInfo);
        return new ModelAndView("print/" + printType + "MultipleBlocks", model.asMap());
    }

    @RequestMapping(value = "/blocks/{printType}Single/{congName}/{isDisplayBusInfo}/{isDisplayBusinessTypeInfo}/{block}", method = RequestMethod.GET)
    public ModelAndView handlePrintBlockRequest(@PathVariable String congName, @PathVariable String block, @PathVariable String printType, @PathVariable Boolean isDisplayBusInfo, @PathVariable Boolean isDisplayBusinessTypeInfo) throws Exception {
        Model model = new ExtendedModelMap();
        String blockName = block.split(TerritoryConstants.SEPERATOR.getValue())[0];
        String blockNumber = block.split(TerritoryConstants.SEPERATOR.getValue())[1];
        model.addAttribute(TerritoryConstants.A_BLOCK.getValue(), blockManager.getBlock(congName, blockName, blockNumber));
        model.addAttribute(TerritoryConstants.IS_DISPLAY_BUS_INFO.getValue(), isDisplayBusInfo);
        return new ModelAndView("print/" + printType + "SingleBlock", model.asMap());
    }

    @RequestMapping(value = "/buildings/{printType}Multiple/{congName}/{isDisplayBusInfo}/{isDisplayBusinessTypeInfo}/{buildingBlock}", method = RequestMethod.GET)
    public ModelAndView handlePrintMultipleBuildingsRequest(@PathVariable String congName, @PathVariable String buildingBlock, @PathVariable String printType, @PathVariable Boolean isDisplayBusInfo, @PathVariable Boolean isDisplayBusinessTypeInfo) throws Exception {
        Model model = new ExtendedModelMap();
        String[] buildingArray = buildingBlock.split(",");
        model.addAttribute(TerritoryConstants.BUILDING_LIST.getValue(), buildingManager.getBuildings(congName, buildingArray));
        model.addAttribute(TerritoryConstants.IS_DISPLAY_BUS_INFO.getValue(), isDisplayBusInfo);
        return new ModelAndView("print/" + printType + "MultipleBuildings", model.asMap());
    }

    @RequestMapping(value = "/buildings/{printType}Single/{congName}/{isDisplayBusInfo}/{isDisplayBusinessTypeInfo}/{buildingBlock}", method = RequestMethod.GET)
    public ModelAndView handlePrintBuildingRequest(@PathVariable String congName, @PathVariable String buildingBlock, @PathVariable String printType, @PathVariable Boolean isDisplayBusInfo, @PathVariable Boolean isDisplayBusinessTypeInfo) throws Exception {
        Model model = new ExtendedModelMap();
        String buildingBlockName = buildingBlock.split(TerritoryConstants.SEPERATOR.getValue())[0];
        String buildingBlockNumber = buildingBlock.split(TerritoryConstants.SEPERATOR.getValue())[1];
        model.addAttribute(TerritoryConstants.A_BUILDING.getValue(), buildingManager.getBuilding(congName, buildingBlockName, buildingBlockNumber));
        model.addAttribute(TerritoryConstants.IS_DISPLAY_BUS_INFO.getValue(), isDisplayBusInfo);
        return new ModelAndView("print/" + printType + "SingleBuilding", model.asMap());
    }
}