package com.beiming.notebook.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * WxUserInfo
 */
@Getter
@Setter
@ToString
public class WxUserInfo {
    private String tempUserId;
    private UserInfo wxMaUserInfo;

    @Getter
    @Setter
    @ToString
    public static class UserInfo {
        private String openId;
        private String nickName;
        private String gender;
        private String language;
        private String province;
        private String city;
        private String country;
        private String avatarUrl;
        private String unionId;
    }
}
