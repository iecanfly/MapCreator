package com.gooki.webapp.controller;

import com.gooki.model.Building;
import com.gooki.service.BuildingManager;
import com.gooki.service.CongManager;
import com.gooki.webapp.constant.TerritoryConstants;
import com.gooki.webapp.exception.BuildingExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/buildings")
public class BuildingController extends TerritoryBaseController {
	private BuildingManager buildingManager;
    private CongManager congManager;

    @Autowired
    public void setBuildingManager(BuildingManager buildingManager) {
        this.buildingManager = buildingManager;
    }

    @Autowired
    public void setCongManager(CongManager congManager) {
        this.congManager = congManager;
    }

    @RequestMapping(value = "/edit/{cong}", method = RequestMethod.GET)
    public ModelAndView handleEditBuildingCongRequest(@PathVariable String cong) throws Exception {
        Model model = new ExtendedModelMap();
        model.addAttribute(TerritoryConstants.BUILDING_LIST.getValue(), buildingManager.getBuildingsByCongName(cong));

        return new ModelAndView("editBuildings", model.asMap());
    }

    @RequestMapping(value = "/editBuildings", method = RequestMethod.GET)
    public ModelAndView handleEditBuildingRequest() throws Exception {
        Model model = new ExtendedModelMap();
        model.addAttribute(TerritoryConstants.CONGREGATION_LIST.getValue(), congManager.getAllUniqueCongs());

        return new ModelAndView("editBuildingsDefault", model.asMap());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> handleUpdateBuildingRequest(@RequestBody Building building) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            buildingManager.updateBuilding(building);
            map.put("status", TerritoryConstants.JSON_OK_RESPONSE.getValue());
            map.put("message", "Successfully updated!");
        } catch (AccessDeniedException ade) {
            map.put("status", TerritoryConstants.JSON_NO_PERMISSION_RESPONSE.getValue());
            map.put("message", "Oops. It looks like you don't have permission for this operation.");
        } catch (Exception e) {
            map.put("status", TerritoryConstants.JSON_FAIL_RESPONSE.getValue());
            map.put("message", "Oops. Something went wrong and could not update the building info. Please try later.");
        }

        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> handleDeleteBuildingRequest(@RequestBody String id) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            buildingManager.removeBuilding(buildingManager.get(Long.parseLong(id)));
            map.put("status", TerritoryConstants.JSON_OK_RESPONSE.getValue());
            map.put("message", "Successfully deleted!");
        } catch (AccessDeniedException ade) {
            map.put("status", TerritoryConstants.JSON_NO_PERMISSION_RESPONSE.getValue());
            map.put("message", "Oops. It looks like you don't have permission for this operation.");
        } catch (Exception e) {
            map.put("status", TerritoryConstants.JSON_FAIL_RESPONSE.getValue());
            map.put("message", "Oops. Something went wrong and could not delete the building. Please try later.");
        }

        return map;
    }

    @RequestMapping(value = "/{cong}", method = RequestMethod.GET)
    public @ResponseBody List<Building> handleGetBuildingsRequest(@PathVariable String cong) throws Exception {
        try {
           return buildingManager.getBuildingsByCongName(cong);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> handleRequest(@RequestBody Building building) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            buildingManager.saveBuilding(building);
            map.put("status", TerritoryConstants.JSON_OK_RESPONSE.getValue());
        } catch (BuildingExistsException bee) {
            map.put("status", TerritoryConstants.JSON_FAIL_RESPONSE.getValue());
            map.put("message", "Oops. It looks like the same building already exists. Please try another building name / number.");
        } catch (AccessDeniedException ade) {
            map.put("status", TerritoryConstants.JSON_NO_PERMISSION_RESPONSE.getValue());
            map.put("message", "Oops. It looks like you don't have permission for this operation.");
        } catch (Exception e) {
            map.put("status", TerritoryConstants.JSON_FAIL_RESPONSE.getValue());
            map.put("message", "Oops. Something went wrong and could not save the building info. Please try later.");
        }

        return map;
    }

}
