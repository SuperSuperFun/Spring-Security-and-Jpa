# Spring-Security-and-Jpa
spring security demo

##注意事项：

###1.
@Entity
public class SysUser implements UserDetails

###2.
@Entity
public class CustomUserService implements UserDetailsService

UserDetails / UserDetailsService均为spring security提供的接口

###3.
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
自定义一个安全配置类并继承WebSecurityConfigurerAdapter，这里进行各种安全规则配置
     * 更多的权限控制方式：
     * access(String) String EL表达式结果为true时可访问
     * anonymous() 匿名可访问
     * denyAll() 用户不可访问
     * fullyAuthenticated() 用户完全认证可访问（非remember me下自动登录）
     * hasAnyAuthority(String) 参数中任意权限的用户可访问
     * hasAnyRole(String) 参数中任意角色的用户可访问
     * hasAuthority(String) 某一权限的用户可访问
     * hasRole(String) 某一角色的用户可访问
     * permitAll() 所有用户可访问
     * rememberMe() 允许通过remember me登录的用户访问
     * authenticated() 用户登录后可访问
     * hasIpAddress(String) 用户来自参数中的ip可访问
     
###4.
SysUser里面有一个属性 
@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
private List<SysRole> roles;
SysUser和SysRole多对多，则需要一个中间表，此属性便是一个中间表的对象（初次接触，个人理解）
项目使用mysql，启动项目后会自动生成三张表，sys_user, sys_role, sys_user_roles

