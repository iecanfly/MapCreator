package com.gooki.dao.hibernate;

import com.gooki.dao.CongDao;
import com.gooki.model.Cong;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("congDao")
public class CongDaoHibernate extends GenericDaoHibernate<Cong, Long> implements CongDao {

	public CongDaoHibernate() {
		super(Cong.class);
	}

	public Cong findByCongName(String cong) {
		return (Cong) getSession().createCriteria(Cong.class).add(Restrictions.eq("name", cong)).uniqueResult();
	}

    public void removeCongByName(String congName) {
        Cong toBeDeleted = (Cong) getSession().createCriteria(Cong.class).add(Restrictions.eq("name", congName)).uniqueResult();
        getSession().delete(toBeDeleted);
    }

}
