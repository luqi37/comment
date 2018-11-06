package com.controller.content;

import com.constant.DicTypeConst;
import com.constant.PageCodeEnum;
import com.dto.BusinessDto;
import com.service.BusinessService;
import com.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;

@Controller
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private DicService dicService;

    @RequestMapping(method = RequestMethod.GET)
    public String search(Model model, BusinessDto businessDto) {
        model.addAttribute("list", businessService.searchByPage(businessDto));
        model.addAttribute("searchParam", businessDto);
        return "/content/businessList";
    }

    @RequestMapping("/addPage")
    public String addPage(Model model) {
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        return "/content/businessAdd";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(Model model, BusinessDto businessDto) {
        if (businessService.add(businessDto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
            return "/content/businessList";
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
            return "/content/businessAdd";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(Model model, @PathVariable("id") Long id) {
        /*if (businessService.remove(id)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_FAIL);
        }*/
        return "/content/businessList";
    }

    /**
     * 商户修改页初始化
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String modifyInit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        model.addAttribute("modifyObj", businessService.getById(id));
        return "/content/businessModify";
    }

    /**
     * 商户修改
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String modify(@PathVariable("id") Long id, BusinessDto dto) {
        System.out.println(id);
        return "/content/businessModify";
    }

}
