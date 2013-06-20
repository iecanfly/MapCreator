package com.gooki.webapp.controller;

import com.gooki.model.Block;
import com.gooki.model.Cong;
import com.gooki.service.*;
import com.gooki.webapp.constant.TerritoryConstants;
import com.gooki.webapp.exception.BlockExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/acl")
public class AclController extends TerritoryBaseController {
    private CongManager congManager;
    private SecurityContextService securityContextService;

    @Autowired
    public void setSecurityContextService(SecurityContextService securityContextService) {
        this.securityContextService = securityContextService;
    }

    @Autowired
    public void setCongManager(CongManager congManager) {
        this.congManager = congManager;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView handleEditBlockCongRequest() throws Exception {
        Model model = new ExtendedModelMap();
        List<Cong> congList;
        //model.addAttribute(TerritoryConstants.CONGREGATION_LIST.getValue(), blockManager.getBlocksByCongName(cong));

        return new ModelAndView("editAclsDefault", model.asMap());
    }

}
