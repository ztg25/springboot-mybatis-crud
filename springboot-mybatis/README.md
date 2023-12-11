# springboot-mybatis
SpringBoot整合Thymeleaf实现增删改查分页(基于XML实现方式)
https://blog.csdn.net/qq_45745964/article/details/121404370

### xml 配置方式使用 MyBatis 主要步骤有以下三步：

- 配置 application.yml
- 编写 mapper xml 文件
- 写 mapper java 代码
  
# 实现页面：
![page](/images/page.jpg)

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

### XML映射文件规范
- XML映射文件名称与Mapper接口类名称一致，并且存放在相同路径包下，xml文件存入resources。
- XML映射文件的namespace属性为Mapper接口全路径名一致。
- XML映射文件Sql语句的id与Mapper接口中方法名一致，并保持返回类型一致。
