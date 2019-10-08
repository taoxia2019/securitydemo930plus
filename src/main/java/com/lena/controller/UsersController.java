package com.lena.controller;



import com.lena.base.result.PageTableRequest;
import com.lena.base.result.ResponseCode;
import com.lena.base.result.Results;
import com.lena.dto.UsersDTO;
import com.lena.entity.Users;
import com.lena.service.UsersService;
import com.lena.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.time.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/findByFuzzyUsername")
    @ResponseBody
    public Results<Users> findByFuzzyUsername(PageTableRequest page,String username){
        page.countOffset();

        return usersService.getByFuzzyUsername(username,page.getOffset(),page.getLimit());
    }

    @GetMapping("/list")
    @ResponseBody
    public Results<Users> getUsers(PageTableRequest page){
        page.countOffset();

        return usersService.getAllUsersByPage(page.getOffset(),page.getLimit());
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute(new Users());
        return "user/user-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Results<Users> saveUser(UsersDTO usersDTO,Integer roleid){
        Users user=null;
        user=usersService.getUserByPhone(usersDTO.getPhone());
        if(user!=null &&!(user.getId().equals(usersDTO.getId()))){
            return Results.failure(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT.getMessage());
        }

        usersDTO.setStatus(1);
        usersDTO.setPassword(MD5.getMD5(usersDTO.getPassword()));

        return usersService.saveUsers(usersDTO,roleid);
    }

    //跳转编辑页面
    @GetMapping("/edit")
    public String editUser(Model model,Users users){
        Users user = usersService.getById(users.getId());
        model.addAttribute(user);
        return "user/user-edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public Results<Users> updateUser(UsersDTO usersDTO,Integer roleid){
        Users user=null;

       /* user=usersService.getByPhone(usersDTO.getPhone());
        if(user!=null ||(user.getId().equals(usersDTO.getId()))){
            return Results.failure(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT.getMessage());
        }*/
        return usersService.updateUsers(usersDTO,roleid);
    }

    //删除
    @GetMapping("/delete")
    @ResponseBody
    public Results deleteUser(UsersDTO usersDTO){
        int count = usersService.deleteUserByid(usersDTO.getId());
        if(count>0){
            return Results.success();
        }else {
            return Results.failure();
        }
    }


    String pattern="yyyy-MM-dd";

    @InitBinder
    public void initBinder(WebDataBinder binder,WebRequest request){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        binder.registerCustomEditor(Date.class,new CustomDateEditor(formatter,true));
    }

}

