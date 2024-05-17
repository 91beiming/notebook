//package com.beiming.blog.common.utils;
//
//import io.minio.BucketExistsArgs;
//import io.minio.GetObjectArgs;
//import io.minio.MakeBucketArgs;
//import io.minio.MinioClient;
//import io.minio.ObjectWriteResponse;
//import io.minio.PutObjectArgs;
//import io.minio.SetBucketPolicyArgs;
//import lombok.experimental.UtilityClass;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.http.MediaType;
//import org.springframework.http.MediaTypeFactory;
//
//import java.io.InputStream;
//import java.util.Optional;
//import java.util.UUID;
//
///**
// * @author lcl
// * @date 2024/1/8 10:55
// */
//@Slf4j
//@UtilityClass
//public class MinioUtils {
//
//
//    public static MinioClient getMinioClient(String endpoint, String accessKey, String secretKey) {
//        return MinioClient.builder()
//                .endpoint(endpoint)
//                .credentials(accessKey, secretKey)
//                .build();
//    }
//
//
//    /**
//     * 检查指定的存储桶是否存在
//     *
//     * @param minioClient Minio客户端对象
//     * @param bucketName  存储桶名称
//     * @return 如果存储桶存在则返回true，否则返回false
//     * @throws Exception 如果出现异常
//     */
//    public static boolean bucketExists(MinioClient minioClient, String bucketName) throws Exception {
//        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
//    }
//
//
//    public static void createBucket(MinioClient minioClient, String bucketName) throws Exception {
//        log.info("FileServiceImpl.upload: 开始创建桶: {}", bucketName);
//        minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
//        log.info("FileServiceImpl.upload: 创建桶成功: {}", bucketName);
//        log.info("FileServiceImpl.upload: 修改桶policy {}", bucketName);
//        String policy = """
//                {
//                    "Version": "2012-10-17",
//                    "Statement": [
//                        {
//                            "Effect": "Allow",
//                            "Principal": {
//                                "AWS": [
//                                    "*"
//                                ]
//                            },
//                            "Action": [
//                                "s3:GetObject"
//                            ],
//                            "Resource": [
//                                "arn:aws:s3:::%s/*"
//                            ]
//                        }
//                    ]
//                }
//                """;
//        minioClient.setBucketPolicy(SetBucketPolicyArgs.builder()
//                .bucket(bucketName)
//                .config(String.format(policy, bucketName))
//                .build());
//        log.info("FileServiceImpl.upload: 修改桶policy成功 {}", bucketName);
//    }
//
//
//    /**
//     * 将输入流中的对象上传到指定的存储桶和对象名称中
//     * put适合上传小文件,图片.
//     * upload支持分片上传和合并适合大文件,适合在客户端
//     *
//     * @param minioClient MinIO客户端对象
//     * @param inputStream 输入流对象
//     * @param bucketName  存储桶名称
//     * @param objectName  对象名称
//     * @throws Exception 如果上传失败
//     */
//    public static void putObject(MinioClient minioClient, InputStream inputStream, String bucketName, String objectName) throws Exception {
//        Optional<MediaType> mediaType = MediaTypeFactory.getMediaType(objectName);
//        ObjectWriteResponse response = minioClient.putObject(PutObjectArgs.builder()
//                .bucket(bucketName)
//                .object(objectName)
//                .contentType(mediaType.map(MediaType::toString).orElse(MediaType.APPLICATION_OCTET_STREAM_VALUE))
//                .stream(inputStream, inputStream.available(), -1)
//                .build());
//        log.info("MinioUtils.putObject: 上传结果 {}", response.etag());
//    }
//
//    /**
//     * 根据给定的Minio客户端、存储桶名和对象名获取FilterInputStream对象。
//     *
//     * @param minioClient Minio客户端对象
//     * @param bucketName  存储桶名
//     * @param objectName  对象名
//     * @return FilterInputStream对象
//     * @throws Exception 如果获取对象失败
//     */
//    public static InputStream getObject(MinioClient minioClient, String bucketName, String objectName) throws Exception {
//        return minioClient.getObject(GetObjectArgs.builder()
//                .bucket(bucketName)
//                .object(objectName)
//                .build());
//    }
//
//
//    /**
//     * 处理文件名
//     *
//     * @param file 原文件名
//     * @return 处理后的文件名
//     */
//    public static String processFileName(String file) {
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        if (StringUtils.isNotBlank(file) && file.contains(".")) {
//            int lastIndex = file.lastIndexOf(".");
//            String fileSuffix = file.substring(lastIndex);
//            return uuid + fileSuffix;
//        } else {
//            return uuid;
//        }
//    }
//
//}
