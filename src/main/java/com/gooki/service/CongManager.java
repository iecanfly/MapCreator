package com.gooki.service;

import com.gooki.dao.CongDao;
import com.gooki.model.Cong;
import com.gooki.webapp.exception.CongExistsException;
import com.gooki.service.GenericManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CongManager extends GenericManager<Cong, Long> {
    void removeCongByName(String congName);
    Cong findByCongName(String name);
    List<Cong> search(String searchTerm);
}
