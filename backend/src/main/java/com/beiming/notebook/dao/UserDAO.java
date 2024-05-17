package com.beiming.notebook.dao;

import com.beiming.notebook.domain.User;

/**
 * UserDAO
 */
public interface UserDAO {

    User getByUserId(Long userId);
}
