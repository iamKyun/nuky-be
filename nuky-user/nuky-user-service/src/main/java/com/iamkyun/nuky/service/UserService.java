package com.iamkyun.nuky.service;

import com.iamkyun.nuky.data.entity.User;

/**
 * @author kyun
 *
 */
public interface UserService {
    /**
     * get user by user id
     * @param id
     * @return
     */
    User getUserById(Long id);
}
