package com.gooki.dao;

import com.gooki.model.Cong;


public interface CongDao extends GenericDao<Cong, Long>{
	Cong findByCongName(String cong);
    void removeCongByName(String congName);
}
