package com.gooki.dao.hibernate;

import com.gooki.dao.BlockDao;
import com.gooki.dao.CongDao;
import com.gooki.model.Block;
import com.gooki.model.Cong;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("congDao")
public class CongDaoHibernate extends GenericDaoHibernate<Cong, Long> implements CongDao {

	public CongDaoHibernate() {
		super(Cong.class);
	}

	public Cong findByCongName(String cong) {
		return (Cong) getSession().createCriteria(Cong.class).add(Restrictions.eq("name", cong)).uniqueResult();
	}

}
