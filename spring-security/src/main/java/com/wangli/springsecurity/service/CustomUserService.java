package com.wangli.springsecurity.service;

import com.wangli.springsecurity.dao.SysUserRepository;
import com.wangli.springsecurity.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author wangli
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.findByUsername(s);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        System.out.println("s: " + s);
        System.out.println("username: " + sysUser.getUsername() + ";" + "password: " + sysUser.getPassword());
        return sysUser;
    }
}
