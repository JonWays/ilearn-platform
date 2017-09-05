package com.ilearn.platform.service.impl;

import com.ilearn.platform.bean.UserInfo;
import com.ilearn.platform.dao.UserInfoMapper;
import com.ilearn.platform.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Creator zhuweijun
 * Date 2017/9/5 0005.
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Resource
    private UserInfoMapper userDao;

    public UserInfo getUserById(int userId)
    {
        return this.userDao.selectByPrimaryKey(userId);
    }
}
