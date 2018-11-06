package com.controller.content;

import com.constant.PageCodeEnum;
import com.dto.AdDto;
import com.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private AdService adService;

    @RequestMapping
    public String init(Model model) {
        AdDto adDto = new AdDto();
        model.addAttribute("list", adService.searchByPage(adDto));
        model.addAttribute("searchParam", adDto);
        return "/content/adList";
    }

    @RequestMapping("/search")
    public String search(Model model, AdDto adDto) {
        model.addAttribute("list", adService.searchByPage(adDto));
        model.addAttribute("searchParam", adDto);
        return "/content/adList";
    }

    @RequestMapping("/modifyInit")
    public String modifyInit(Model model, @RequestParam("id") Long id) {
        model.addAttribute("modifyObj", adService.selectByid(id));
        return "/content/adModify";
    }

    @RequestMapping("/modify")
    public String modify(Model model, AdDto adDto) {
        if (adService.modify(adDto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
        }
        return "/content/adList";
    }

    @RequestMapping("/remove")
    public String remove(Model model, @RequestParam("id") Long id) {
        if (adService.remove(id)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
        }
        return "/content/adList";
    }

    @RequestMapping("/addInit")
    public String addInit() {
        return "/content/adAdd";
    }

    @RequestMapping("/add")
    public String add(Model model, AdDto adDto) {
        if (adService.add(adDto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
        }
        return "/content/adList";
    }

}
