package com.gooki.dao;

import com.gooki.model.Building;
import com.gooki.webapp.exception.BuildingExistsException;

import java.util.List;


public interface BuildingDao extends GenericDao<Building, Long>{
	List<Building> findByCongName(String cong);
    Building saveBuildingAfterDuplicateCheck(Building building) throws BuildingExistsException;
    void update(Building building);
    List<Building> findBuildings(String congName, String[] buildingBlockArray);
    Building findBuilding(String congName, String buildingBlock, String buildingNumber);
}
