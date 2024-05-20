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
docker pull eclipse-temurin:21-jdk-alpine
docker pull node:20.13.0-slim
docker pull nginx:alpine3.19
docker pull mysql:8.4.0-oracle
docker pull redis:alpine3.19
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

