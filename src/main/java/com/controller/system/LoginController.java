package com.controller.system;

import com.constant.PageCodeEnum;
import com.constant.SessionKeyConst;
import com.dto.GroupDto;
import com.dto.UserDto;
import com.pojo.Group;
import com.service.GroupService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @Autowired
    private GroupService groupService;

    @RequestMapping
    public String login() {
        return "/system/login";
    }

    @RequestMapping("/validate")
    public String validate(UserDto userDto, RedirectAttributes redirectAttributes) {
        if (userService.validate(userDto)) {
            session.setAttribute(SessionKeyConst.USER_INFO, userDto);
            GroupDto groupDto = groupService.getByIdWithMenuAction(userDto.getGroupId());
            session.setAttribute(SessionKeyConst.ACTION_INFO, groupDto.getActionDtoList());
            session.setAttribute(SessionKeyConst.MENU_INFO, groupDto.getMenuDtoList());
            return "redirect:/index";
        }
        redirectAttributes.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.LOGIN_FAIL);
        return "redirect:/login";
    }

    /**
     * session超时
     */
    @RequestMapping("/sessionTimeout")
    public String sessionTimeout(Model model) {
        model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.SESSION_TIMEOUT);
        return "/system/error";
    }

    /**
     * 没有权限访问
     */
    @RequestMapping("/noAuth")
    public String noAuth(Model model) {
        model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.NO_AUTH);
        session.invalidate();
        return "/system/error";
    }

}
