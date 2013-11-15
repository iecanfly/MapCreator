package com.gooki.service;

import com.gooki.model.Building;
import com.gooki.webapp.exception.BuildingExistsException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BuildingManager extends GenericManager<Building, Long>{
    /**
     * Retrieves a list of buildings for given cong name.
     * @return List
     */
    List<Building> getBuildingsByCongName(String congName);

    /**
     * Retrieves a list of buildings for given params.
     * @return List
     */
    List<Building> getBuildings(String congName, String[] buildingArray);

    /**
     * Retrieves a building for given params.
     * @return List
     */
    Building getBuilding(String congName, String buildingName, String buildingNumber);

    /**
     * Saves a building's information.
     *
     * @param building the building's information
     * @throws com.gooki.webapp.exception.BuildingExistsException thrown when building already exists
     * @return building the updated building object
     */
    Building saveBuilding(Building building) throws BuildingExistsException;

    /**
     * Updates a building's information.
     * @param building the building's information
     */
    void updateBuilding(Building building) ;

    /**
     * Removes a building from the database
     *
     * @param building the building to remove
     */
    void removeBuilding(Building building);

    /**
     * Search a building for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Building> search(String searchTerm);
}
