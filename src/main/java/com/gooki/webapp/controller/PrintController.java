package com.gooki.webapp.controller;

import com.gooki.model.Block;
import com.gooki.model.Cong;
import com.gooki.service.BlockManager;
import com.gooki.webapp.constant.TerritoryConstants;
import com.gooki.webapp.exception.BlockExistsException;
import com.gooki.webapp.exception.CongNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/print")
public class PrintController extends TerritoryBaseController {
	private BlockManager blockManager = null;

    @Autowired
    public void setBlockManager(BlockManager blockManager) {
        this.blockManager = blockManager;
    }

    @RequestMapping(value = "/{printType}Multiple/{congName}/{block}", method = RequestMethod.GET)
    public ModelAndView handlePrintMultipleRequest(@PathVariable String congName, @PathVariable String block, @PathVariable String printType) throws Exception {
        Model model = new ExtendedModelMap();
        String[] blockArray = block.split(",");
        model.addAttribute(TerritoryConstants.BLOCK_LIST.getValue(), blockManager.getBlocks(congName, blockArray));
        return new ModelAndView("print/" + printType + "Multiple", model.asMap());
    }

    @RequestMapping(value = "/{printType}Single/{congName}/{block}", method = RequestMethod.GET)
    public ModelAndView handlePrintRequest(@PathVariable String congName, @PathVariable String block, @PathVariable String printType) throws Exception {
        Model model = new ExtendedModelMap();
        String blockName = block.split(TerritoryConstants.SEPERATOR.getValue())[0];
        String blockNumber = block.split(TerritoryConstants.SEPERATOR.getValue())[1];
        model.addAttribute(TerritoryConstants.A_BLOCK.getValue(), blockManager.getBlock(congName, blockName, blockNumber));

        return new ModelAndView("print/" + printType + "Single", model.asMap());
    }
}