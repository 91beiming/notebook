package com.beiming.notebook.common.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lcl
 * @date 2024/3/1 10:59
 */
@Getter
public enum AuditServiceEnum {
    NICKNAME_DETECTION("nickname_detection", "用户昵称检测"),
    CHAT_DETECTION("chat_detection", "私聊互动内容检测"),
    COMMENT_DETECTION("comment_detection", "公聊评论内容检测"),
    AI_ART_DETECTION("ai_art_detection", "AIGC文字检测"),
    AD_COMPLIANCE_DETECTION("ad_compliance_detection", "广告法合规检测"),
    PGC_DETECTION("pgc_detection", "PGC教学物料检测");


    private static final Map<String, String> CODE_TO_DESC_MAP = new HashMap<>();

    static {
        for (AuditServiceEnum auditLabelEnum : AuditServiceEnum.values()) {
            CODE_TO_DESC_MAP.put(auditLabelEnum.getCode(), auditLabelEnum.getDesc());
        }
    }

    private final String code;
    private final String desc;

    AuditServiceEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(String code) {
        return CODE_TO_DESC_MAP.get(code);
    }
}
