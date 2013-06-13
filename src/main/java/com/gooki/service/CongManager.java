package com.gooki.service;

import com.gooki.dao.CongDao;
import com.gooki.model.Cong;
import com.gooki.webapp.exception.CongExistsException;
import org.appfuse.service.GenericManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CongManager extends GenericManager<Cong, Long> {
    void setCongDao(CongDao congDao);

    Cong saveCong(Cong cong) throws CongExistsException;

    void removeCong(Cong block);

    void removeCong(String congId);

    Cong findByCongName(String name);

    List<Cong> search(String searchTerm);


}
