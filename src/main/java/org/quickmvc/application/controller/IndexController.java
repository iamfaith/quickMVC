package org.quickmvc.application.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by faith on 16/5/18.
 */
@Controller
@RequestMapping("/welcome")
public class IndexController {

    private Log log = LogFactory.getLog("FILE");

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        modelMap.put("some", "spring freemarker模板终能使用");
        log.info("访客访问");
        return "index";
    }
}
