package org.insurgency.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.insuergency.dao.entity.User;
import org.insuergency.dao.mapper.UserMapper;
import org.insurgency.forms.UserForm;
import org.insurgency.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lynx123
 * @since 2020-07-16
 */
@SuppressWarnings("unused")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * logger
     */
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public ResponseEntity<String> userRegister(HttpServletRequest request, UserForm form) {
        log.info("*************accept user{} register request", form.getUserName());
        return new ResponseEntity<>("register response", HttpStatus.ACCEPTED);
    }
}
