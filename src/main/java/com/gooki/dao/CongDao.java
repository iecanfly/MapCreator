package com.gooki.dao;

import com.gooki.model.Cong;
import com.gooki.dao.GenericDao;


public interface CongDao extends GenericDao<Cong, Long>{
	Cong findByCongName(String cong);
    void removeCongByName(String congName);
}
