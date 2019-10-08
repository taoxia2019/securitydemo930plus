package com.lena.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lena.base.DataGridView;
import com.lena.base.TreeNode;

import com.lena.base.result.Results;
import com.lena.entity.Permission;

import com.lena.service.PermissionService;
import com.lena.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taoxia
 * @since 2019-10-04
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addPermission(Model model){
        model.addAttribute("permission",new Permission());
        return "permission/permission-add";
    }

    @RequestMapping(value = "/add",method=RequestMethod.POST)
    @ResponseBody
    public Results<Permission> savePermission(@RequestBody Permission permission){
        return permissionService.savePermission(permission);
    }



    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editPermission(Model model,Permission permission){
        model.addAttribute("permission",permissionService.getById(permission.getId()));
        return "permission/permission-add";
    }

    @RequestMapping(value = "/edit",method=RequestMethod.POST)
    @ResponseBody
    public Results<Permission> editPermission(@RequestBody Permission permission){
        System.out.println("----");
        System.out.println(permission.toString());
        System.out.println("----");
        return permissionService.editPermission(permission);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Results<Permission> deletePermission(Permission permission){
        return permissionService.delectPermission(permission.getId());
    }

    @GetMapping("/menuAll")
    @ResponseBody
    public DataGridView getMenuAll(){
        return permissionService.getMenuAll();
    }

    @RequestMapping("/listAllPermission")
    @ResponseBody
    public DataGridView listAllPermission(){

        List<Permission> list = permissionService.list();
        //构造 List<TreeNode>
        List<TreeNode> nodes=new ArrayList<>();
        for (Permission p1 : list) {
            String checkArr="0";
            Boolean spread= true;
            nodes.add(new TreeNode(p1.getId(), p1.getParentid(), p1.getName(), spread, checkArr));
        }
        return new DataGridView(nodes);
    }


    @RequestMapping("/initPermissionByRoleId")
    @ResponseBody
    public DataGridView initPermissionByRoleId(Integer roleid) {

        System.out.println("角色ID"+roleid);

        //查询所有可用的菜单和权限
        List<Permission> allPermissions = permissionService.list();
        /**
         * 1,根据角色ID查询当前角色拥有的所有的权限或菜单ID
         * 2,根据查询出来的菜单ID查询权限和菜单数据
         */
        List<Integer> currentRolePermissions=this.rolePermissionService.queryRolePermissionIdsByRid(roleid);
        List<Permission> carrentPermissions=null;
        if(currentRolePermissions.size()>0) { //如果有ID就去查询
            QueryWrapper<Permission> queryWrapper=new QueryWrapper<>();
            queryWrapper.in("id", currentRolePermissions);
            carrentPermissions = permissionService.list(queryWrapper);
        }else {
            carrentPermissions=new ArrayList<>();
        }
        //构造 List<TreeNode>
        List<TreeNode> nodes=new ArrayList<>();
        for (Permission p1 : allPermissions) {
            String checkArr="0";
            for (Permission p2 : carrentPermissions) {
                if(p1.getId()==p2.getId()) {
                    checkArr="1";
                    break;
                }
            }
            Boolean spread=true;
            nodes.add(new TreeNode(p1.getId(), p1.getParentid(), p1.getName(), spread, checkArr));
        }
        return new DataGridView(nodes);
    }

}

