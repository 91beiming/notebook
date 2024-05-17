package com.beiming.notebook.common.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lcl
 * @date 2024/3/1 10:59
 */
@Getter
public enum AuditLabelEnum {
    AD("ad", "广告引流"),
    POLITICAL_CONTENT("political_content", "涉政内容"),
    PROFANITY("profanity", "辱骂内容"),
    CONTRABAND("contraband", "违禁内容"),
    SEXUAL_CONTENT("sexual_content", "色情内容"),
    VIOLENCE("violence", "暴恐内容"),
    NONSENSE("nonsense", "无意义内容"),
    NEGATIVE_CONTENT("negative_content", "不良内容"),
    RELIGION("religion", "宗教内容"),
    CYBERBULLYING("cyberbullying", "网络暴力"),
    AD_COMPLIANCE("ad_compliance", "广告法合规"),
    C_CUSTOMIZED("c_customized", "用户库命中");


    private static final Map<String, String> LABEL_TO_DESC_MAP = new HashMap<>();

    static {
        for (AuditLabelEnum auditLabelEnum : AuditLabelEnum.values()) {
            LABEL_TO_DESC_MAP.put(auditLabelEnum.getLabel(), auditLabelEnum.getDesc());
        }
    }

    private final String label;
    private final String desc;

    AuditLabelEnum(String label, String desc) {
        this.label = label;
        this.desc = desc;
    }


    public static String getDescByLabel(String label) {
        return LABEL_TO_DESC_MAP.get(label);
    }
}
