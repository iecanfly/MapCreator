package com.gooki.webapp.controller;

import com.gooki.model.Cong;
import com.gooki.service.CongManager;
import com.gooki.webapp.constant.TerritoryConstants;
import com.gooki.webapp.exception.CongNotExistsException;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public abstract class TerritoryBaseController {
    protected final transient org.apache.commons.logging.Log log = LogFactory.getLog(getClass());

    @ExceptionHandler(CongNotExistsException.class)
    public ModelAndView handleIOException(CongNotExistsException ex) {
        Model model = new ExtendedModelMap();
        model.addAttribute("cong", ex.getCong());

        return new ModelAndView("noCongFound", model.asMap());
    }

}
