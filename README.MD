[TOC]

# MyBatis学习笔记


[SSH与SSM学习之MyBatis01——MyBatis简介](blog/01.md)

[SSH与SSM学习之MyBatis02——使用jdbc编程问题总结](blog/02.md)

[SSH与SSM学习之MyBatis03——Mybatis架构](blog/03.md)

[SSH与SSM学习之MyBatis04——Mybatis基本使用](blog/04.md)

[](blog/05.md)

[](blog/06.md)

[](blog/07.md)

[](blog/08.md)

[](blog/09.md)

[](blog/10.md)

[](blog/11.md)

[](blog/12.md)

[](blog/13.md)

[](blog/14.md)

[](blog/15.md)

[](blog/16.md)

[](blog/17.md)

[](blog/18.md)

[](blog/19.md)







-----



# SSH与SSM学习之MyBatis01——MyBatis简介


## 一、简介

MyBatis 本是apache的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁移到了google code，并且改名为MyBatis 。2013年11月迁移到Github。

MyBatis是一个优秀的持久层框架，它对jdbc的操作数据库的过程进行封装，使开发者只需要关注 SQL 本身，而不需要花费精力去处理例如注册驱动、创建connection、创建statement、手动设置参数、结果集检索等jdbc繁杂的过程代码。

Mybatis通过xml或注解的方式将要执行的各种statement（statement、preparedStatemnt、CallableStatement）配置起来，并通过java对象和statement中的sql进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射成java对象并返回。


---

## 二、官网和下载

### 2.1 官网和文档

[http://www.mybatis.org/mybatis-3/zh/getting-started.html](http://www.mybatis.org/mybatis-3/zh/getting-started.html)

![](image/01/1.png)


### 2.2 下载地址
MyBatis已经托管到 github上，所以可以去上面下载。

[https://github.com/mybatis/mybatis-3](https://github.com/mybatis/mybatis-3)

![](image/01/2.png)


---

## 三、源码下载

[https://github.com/wimingxxx/mybatislearn](https://github.com/wimingxxx/mybatislearn)