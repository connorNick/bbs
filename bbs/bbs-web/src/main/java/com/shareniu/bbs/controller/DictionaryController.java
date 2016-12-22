package com.shareniu.bbs.controller;

import com.shareniu.bbs.common.JsonResult;
import com.shareniu.bbs.common.common.EnumDirectoryType;
import com.shareniu.bbs.domain.Dictionary;
import com.shareniu.bbs.service.IDictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
@Controller
@RequestMapping("/directory")
public class DictionaryController extends BaseController{
    private static final Logger LOGGER= LoggerFactory.getLogger(DictionaryController.class);

    @Autowired
    private IDictionaryService iDictionaryService;

    @RequestMapping("/tech_list.htm")
    public @ResponseBody JsonResult getCategoryList(){
        List<Dictionary> list=iDictionaryService.getDictionaryListByType(EnumDirectoryType.TECHNIQUE.getCode());
        return returnSuccess(list);
    }
}
