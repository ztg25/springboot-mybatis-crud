# springboot-mybatis
SpringBoot整合Thymeleaf实现增删改查分页(基于注解实现方式)

### 注解配置方式适用于简单SQL语句场景：


# 测试类：


# Mysql配置
```sql
CREATE DATABASE `mybatis` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
```
```sql
-- mybatis.`user` definition

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `pwd` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
```
