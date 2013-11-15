package com.gooki.dao.hibernate;

import com.gooki.dao.BuildingDao;
import com.gooki.model.Building;
import com.gooki.webapp.constant.TerritoryConstants;
import com.gooki.webapp.exception.BuildingExistsException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BuildingDao")
public class BuildingDaoHibernate extends GenericDaoHibernate<Building, Long> implements BuildingDao {

    public BuildingDaoHibernate() {
		super(Building.class);
	}

	@SuppressWarnings("unchecked")
	public List<Building> findByCongName(String cong) {
		return getSession().createCriteria(Building.class).add(Restrictions.eq("cong", cong)).addOrder(Order.asc("block")).addOrder(Order.asc("number")).list();
	}

    public Building saveBuildingAfterDuplicateCheck(Building Building) throws BuildingExistsException {
        Building testBuilding = (Building) getSession().createCriteria(Building.class).
                            add(Restrictions.eq("cong", Building.getCong())).
                            add(Restrictions.eq("block", Building.getBlock())).
                            add(Restrictions.eq("number", Building.getNumber())).uniqueResult();

        if(testBuilding != null)  {
            throw new BuildingExistsException();
        }

        getSession().save(Building);

        return Building;
    }

    public void update(Building Building) {
        getSession().update(Building);
    }

    @Override
    public List<Building> findBuildings(String congName, String[] BuildingArray) {
        Criteria allCriteria = getSession().createCriteria(Building.class);
        allCriteria.add(Restrictions.conjunction().add(Restrictions.eq("cong", congName)));
        Disjunction BuildingOR = Restrictions.disjunction();

        for(String BuildingInfo : BuildingArray) {
            String BuildingName = BuildingInfo.split(TerritoryConstants.SEPERATOR.getValue())[0];
            Integer BuildingNumber = new Integer(BuildingInfo.split(TerritoryConstants.SEPERATOR.getValue())[1]);
            Criterion BuildingNameCriterion = Restrictions.eq("block", BuildingName);
            Criterion BuildingNumberCriterion = Restrictions.eq("number", BuildingNumber);
            BuildingOR.add(Restrictions.conjunction().add(BuildingNameCriterion).add(BuildingNumberCriterion));
        }

        allCriteria.add(BuildingOR);
        allCriteria.addOrder(Order.asc("block"));
        allCriteria.addOrder(Order.asc("number"));

        return (List<Building>) allCriteria.list();

    }

    @Override
    public Building findBuilding(String congName, String buildingBlock, String buildingNumber) {
        return (Building) getSession().createCriteria(Building.class).
                add(Restrictions.eq("cong", congName)).
                add(Restrictions.eq("block", buildingBlock)).
                add(Restrictions.eq("number", new Integer(buildingNumber))).uniqueResult();
    }

}
