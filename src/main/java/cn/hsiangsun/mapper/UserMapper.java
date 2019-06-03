package cn.hsiangsun.mapper;


import cn.hsiangsun.domain.SysRole;
import cn.hsiangsun.domain.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    //find role by id
    @Select("SELECT * FROM sys_role r,sys_user_role ur\n" +
            "WHERE ur.roleId =r.id AND userId = #{id};")
    @Results({
            @Result(id = true,column = "userId",property = "id"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "roleName",property = "roleName"),
    })
    List<SysRole> findRoleByUid(int id);


    //find all user with role
    @Select("SELECT * FROM sys_user;")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username" ,property = "username"),
            @Result(column = "email" ,property = "email"),
            @Result(column = "password" ,property = "password"),
            @Result(column = "phoneNum" ,property = "phoneNum"),
            @Result(
                    property = "roleList",
                    javaType = List.class,
                    column = "id",
                    many = @Many (select ="cn.hsiangsun.mapper.UserMapper.findRoleByUid")
            )
    })
    List<SysUser> findAllUser();
}
