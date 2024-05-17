package com.beiming.notebook.controller;

import com.beiming.notebook.common.utils.RequestUtils;
import com.beiming.notebook.domain.UserDTO;
import com.beiming.notebook.service.LogoutService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 */
@RestController
public class LogoutController {

    @Resource
    private LogoutService logoutService;

    @GetMapping("logout")
    public Boolean logout() {
        UserDTO currentUser = RequestUtils.getCurrentUser();
        logoutService.logout(currentUser.getId(), currentUser.getUuid());
        return true;
    }
}
