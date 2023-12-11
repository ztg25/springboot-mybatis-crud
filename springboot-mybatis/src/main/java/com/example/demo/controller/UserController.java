package com.example.demo.controller;


import com.example.demo.pojo.User;
import com.example.demo.pojo.query.UserQuery;
import com.example.demo.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {

    @Autowired
    @Qualifier("rootUserService")  // 指定使用同一个UserService接口下的哪个实现类
    private IUserService userService;

    @GetMapping("/")
    public String listUsers(Model model, UserQuery userQuery) {
        PageInfo<User> userPageInfo = userService.listUsersByName(userQuery);
        model.addAttribute("page", userPageInfo);
        return "index";
    }

    @PostMapping("/search")
    public String listUsersByName(Model model, UserQuery userQuery) {
        PageInfo<User> userPageInfo = userService.listUsersByName(userQuery);
        model.addAttribute("page", userPageInfo);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        boolean result = userService.deleteUserById(id);
        if (result) {
            attributes.addFlashAttribute("message", "删除用户成功");
        } else {
            attributes.addFlashAttribute("message", "删除用户失败");
        }
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.queryUserById(id));
        return "edit";
    }


    @PostMapping("/save")
    public String saveUser(User user, RedirectAttributes attributes) {

        /* 根据id的是否为null判断新增还是修改操作，null为新增，不为null为修改 */
        Integer id = user.getId();
        boolean status = false;

        /* 修改用户 */
        if (id != null && id != -1) {
            status = userService.updateUser(user);
            if (status) {
                attributes.addFlashAttribute("message", " 更新用户成功");
                return "redirect:/";
            } else {
                attributes.addFlashAttribute("message", "更新用户失败");
                return "redirect:/";
            }
        } else {
            // 新增用户
            int count = userService.countUserByName(user.getName());
            if (count == 0) {
                status = userService.addUser(user);
                if (status) {
                    attributes.addFlashAttribute("message", " 新增用户成功");
                    return "redirect:/";
                } else {
                    attributes.addFlashAttribute("message", "新增用户失败");
                    return "redirect:/";
                }
            } else {
                attributes.addFlashAttribute("message", "该用户名已存在");
                return "redirect:/";
            }
        }
    }

    /* 新增操作 */
    @GetMapping("/add")
    public String addUser(Model model) {
        User user = new User();
        user.setId(-1);
        model.addAttribute("user", user);
        return "edit";
    }
}