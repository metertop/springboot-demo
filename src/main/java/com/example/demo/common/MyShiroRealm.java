package com.example.demo.common;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * <P></P>
 *
 * @author zhaodong zhaodongxx@outlook.com
 * @version v1.0
 * @since 2018/3/30 22:55
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //从凭证中获得用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        //根据用户名查询用户对象
        User user = userService.selectByUserName(username);

        //查询用户拥有的角色
        List<Role> list = roleService.getRolesByUserId(user.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : list) {
            //赋予用户角色
            info.addStringPermission(role.getRoleName());
        }

        return info;
    }

    /**
     * 登录认证
     *
     * 四个参数
     * username：认证的实体信息。object,一般存放用户信息对象。可以通过SecurityUtils.getSubject().getPrincipal()获取。
     * password：数据库中保存的密码
     * realmName：当前realm对象的name，调用父类的getName()方法即可
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户账号
        String username = token.getPrincipal().toString();
        logger.warn("----username:" + username);
        User user = userService.selectByUserName(username);
        String password = user.getPassword();
        logger.warn("----获取到的密码是：{}", password);
        if (password != null) {

            String realmName = getName();
            return new SimpleAuthenticationInfo(user.getUsername(),    //认证通过后，存放在session,一般存放user对象
                    password,    //用户数据库中的密码
                    realmName);  //返回Realm名
        }
        return null;
    }
}
