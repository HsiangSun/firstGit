package cn.hsiangsun.service.impl;

import cn.hsiangsun.domain.SysUser;
import cn.hsiangsun.mapper.UserMapper;
import cn.hsiangsun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<SysUser> getAllUser() {
        List<SysUser> allUser = mapper.findAllUser();
        return allUser;
    }
}
