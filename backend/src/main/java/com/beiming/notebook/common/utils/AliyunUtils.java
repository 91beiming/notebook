//package com.beiming.blog.common.utils;
//
//import com.aliyun.green20220302.Client;
//import com.aliyun.green20220302.models.TextModerationRequest;
//import com.aliyun.green20220302.models.TextModerationResponse;
//import com.aliyun.green20220302.models.TextModerationResponseBody;
//import com.aliyun.teautil.models.RuntimeOptions;
//import com.beiming.base.enums.AuditServiceEnum;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author lcl
// * @date 2024/3/1 13:08
// */
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class AliyunUtils {
//
//    private final Client client;
//
//    private final ObjectMapper objectMapper;
//
//    public Result textModerationForComment(String content) throws Exception {
//        if (null == content || content.isEmpty()) {
//            return Result.builder().status(0).build();
//        }
//        TextModerationRequest request = new TextModerationRequest();
//        request.setService(AuditServiceEnum.COMMENT_DETECTION.getCode());
//        Map<String, String> contentMap = new HashMap<>();
//        contentMap.put("content", content);
//        request.setServiceParameters(objectMapper.writeValueAsString(contentMap));
//        RuntimeOptions runtimeOptions = new RuntimeOptions();
//        runtimeOptions.setConnectTimeout(3000);
//        runtimeOptions.setReadTimeout(3000);
//        TextModerationResponse response = client.textModerationWithOptions(request, runtimeOptions);
//        TextModerationResponseBody body = response.getBody();
//        Result.ResultBuilder builder = Result.builder();
//        if (200 == body.getCode()) {
//            TextModerationResponseBody.TextModerationResponseBodyData data = body.getData();
//            String reasonJson = data.getReason();
//            if (null == reasonJson || reasonJson.isEmpty()) {
//                //审核通过
//                builder.status(1);
//            } else {
//                Reason reason = objectMapper.readValue(reasonJson, Reason.class);
//                builder.status(2)
//                        .reason(reason);
//            }
//        } else {
//            log.info("AliyunUtils.textModerationForComment: 内容审查请求错误,出错代码 {}", objectMapper.writeValueAsString(response));
//            builder.status(0);
//        }
//        Result result = builder.build();
//        log.info("AliyunUtils.textModerationForComment: 审核内容 {}, 审核结果 [{}]{}", content, result.getStatus(), result.getReason() == null ? "" : result.getReason());
//        return result;
//    }
//
//    @Data
//    public static class Reason {
//
//        /**
//         * 细分标签
//         */
//        private String riskTips;
//
//        /**
//         * 命中风险内容
//         */
//        private String riskWords;
//
//        /**
//         * 命中用户词
//         */
//        private String customizedWords;
//
//        /**
//         * 命中用户词库名
//         */
//        private String customizedLibs;
//    }
//
//    @Data
//    @Builder
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class Result {
//        /**
//         * 0审核异常 1审核通过 2审核不通过
//         */
//        private Integer status;
//
//        /**
//         * 不通过的原因
//         */
//        private Reason reason;
//    }
//}
