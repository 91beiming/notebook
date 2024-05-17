# notebook

#### 介绍

私人笔记

#### 软件架构

* springboot
* mybatis-plus
* react

* mysql
* redis

#### 安装教程

需要下载源码在服务器进行本地构建镜像及部署

1. 安装有Docker的物理机(剩余内存 > 1G)
2. 修改compose.yml中的中文参数
3. 进入源码目录执行命令

```shell
docker pull maven:3.9.6-eclipse-temurin-21-alpine
docker pull openjdk:21-ea-jdk-slim
docker pull node:lts-alpine3.19
docker pull nginx:stable-alpine
docker pull mysql:8.0.36-debian
docker pull redis:alpine
docker-compose up -d
```

#### 更新教程

下载最新版源码在服务器,进入源码目录执行如下命令

```shell
docker-compose down
docker rmi notebook-frontend
docker rmi notebook-backend
docker-compose up -d
```

#### 使用说明

> 默认账号密码:`admin@qq.com/123456`

