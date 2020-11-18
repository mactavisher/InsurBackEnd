package org.insurgency.service;

import javax.servlet.http.HttpServletRequest;

import org.insurgency.dao.entity.User;
import org.insurgency.forms.UserForm;
import org.springframework.http.ResponseEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lynx123
 * @since 2020-07-16
 */
public interface IUserService extends IService<User> {

    /**
     * Register a new user
     * 
     * @param request
     *            request context
     * @param form
     *            register params
     * @return register response
     */
    ResponseEntity<String> userRegister(HttpServletRequest request, UserForm form);
}
