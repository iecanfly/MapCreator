package com.gooki.dao;

import com.gooki.model.Cong;
import org.appfuse.dao.GenericDao;


public interface CongDao extends GenericDao<Cong, Long>{
	Cong findByCongName(String cong);
}
