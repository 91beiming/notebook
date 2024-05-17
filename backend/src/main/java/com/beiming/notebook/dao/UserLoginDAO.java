package com.beiming.notebook.dao;

import com.beiming.notebook.domain.UserLogin;

/**
 * UserLoginDAO
 */
public interface UserLoginDAO {
    UserLogin getByKeyAndSecretAndType(String key, String secret, String type);
}
