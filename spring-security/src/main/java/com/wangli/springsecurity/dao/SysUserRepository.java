package com.wangli.springsecurity.dao;

import com.wangli.springsecurity.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangli
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
