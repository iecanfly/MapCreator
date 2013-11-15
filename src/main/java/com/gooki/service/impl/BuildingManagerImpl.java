package com.gooki.service.impl;

import com.gooki.dao.BuildingDao;
import com.gooki.model.Building;
import com.gooki.service.BuildingManager;
import com.gooki.webapp.exception.BuildingExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("buildingManager")
public class BuildingManagerImpl extends GenericManagerImpl<Building, Long> implements BuildingManager{
    private BuildingDao buildingDao;

    @Autowired
    public BuildingManagerImpl(BuildingDao buildingDao) {
        super(buildingDao);
        this.buildingDao = buildingDao;
    }

	public List<Building> getBuildingsByCongName(String congName) {
		return buildingDao.findByCongName(congName);
	}

    @Override
    public List<Building> getBuildings(String congName, String[] buildingArray) {
        return buildingDao.findBuildings(congName, buildingArray);
    }

    @Override
    public Building getBuilding(String congName, String buildingName, String buildingNumber) {
        return buildingDao.findBuilding(congName, buildingName, buildingNumber);
    }

    @PreAuthorize("@mapSecurity.hasPermission(#building.getCong())")
    public Building saveBuilding(Building building) throws BuildingExistsException {
        buildingDao.saveBuildingAfterDuplicateCheck(building);
        return building;
	}

    @PreAuthorize("@mapSecurity.hasPermission(#building.getCong())")
    public void updateBuilding(Building building) {
        buildingDao.update(building);
	}

    @PreAuthorize("@mapSecurity.hasPermission(#building.getCong())")
	public void removeBuilding(Building building) {
		buildingDao.remove(building);
	}

	public List<Building> search(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
