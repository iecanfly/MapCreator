package com.gooki.webapp.controller;

import com.gooki.model.Block;
import com.gooki.webapp.exception.BlockExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.gooki.webapp.constant.TerritoryConstants;
import com.gooki.service.BlockManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blocks")
public class BlockController extends TerritoryBaseController {
	private BlockManager blockManager = null;

    @Autowired
    public void setBlockManager(BlockManager blockManager) {
        this.blockManager = blockManager;
    }

    @RequestMapping(value = "/{cong}", method = RequestMethod.GET)
    public @ResponseBody List<Block> handleRequest(@PathVariable String cong) throws Exception {
        try {
           return blockManager.getBlocksByCongName(cong);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> handleRequest(@RequestBody Block block) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            blockManager.saveBlock(block);
            map.put("status", TerritoryConstants.JSON_OK_RESPONSE.getValue());
        } catch (BlockExistsException bee) {
            map.put("status", TerritoryConstants.JSON_FAIL_RESPONSE.getValue());
            map.put("message", "Oops. It looks like the same block already exists. Please try another block name / number.");
        } catch (Exception e) {
            map.put("status", TerritoryConstants.JSON_FAIL_RESPONSE.getValue());
            map.put("message", "Oops. Something went wrong and could not save the block info. Please try later.");
        }

        return map;
    }

}
