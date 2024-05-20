package com.beiming.notebook.dao;

import com.beiming.notebook.dao.model.User;

/**
 * UserDAO
 */
public interface UserDAO {

    User getByUserId(Long userId);
}
