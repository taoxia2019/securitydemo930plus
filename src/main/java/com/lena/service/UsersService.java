package com.lena.service;

import com.lena.base.result.Myresult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lena.base.result.Results;
import com.lena.dto.UsersDTO;
import com.lena.entity.Users;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
public interface UsersService extends IService<Users> {


    Results<Users> getAllUsersByPage(Integer offset, Integer limit);

    Results<Users> saveUsers(UsersDTO usersDTO, Integer roleid);



    Results<Users> updateUsers(UsersDTO usersDTO, Integer roleid);

    Users getUserByPhone(String phone);

    int deleteUserByid(Integer id);

    Results<Users> getByFuzzyUsername(String username, Integer offset, Integer limit);
}
