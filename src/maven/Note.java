package maven;

/*
*
*一、 Maven概述
*
* Maven是专门用于管理和构件Java项目的工具，它得主要功能有:
* 1.提供了一套标准化的项目结构
* 原因：不同的IDE之间，项目结构不一样，maven则统一了项目结构，提供一套标准化的结构
* 所有IDE创建的maven项目可以通用
* 结构：
* maven-project  ： 项目名称
*
* src : 源代码和测试代码目录，main包下放源代码，test包下放测试代码
* main： main包下有java包(源代码Java文件目录)，resources(源代码配置文件目录)、webapp(Web项目核心目录)
* test：Java包(Java测试代码)、resources(测试代码配置文件目录)
*
* pom.xml : 项目核心配置文件
*
* 2.提供了一套标准化的构建流程（编译、测试、打包、发布...）
*
* 解决繁琐的构建流程(每个模块都要进行编译、测试等操作)，maven提供了一套简单的命令来完成项目构建
*
*
* 3.提供了一套依赖管理机制
*
*  依赖管理：其实就是管理项目所依赖的第三方资源(jar包、插件)
*
*  1.maven使用标准的坐标配置来管理各种依赖
*  2.只需要简单的配置就可以完成依赖管理
*
* 常见的项目构建工具
* 1.maven
* 2.gradle
* 3.ant
* 4.SBT
*-------------------------------------------------------------------------------------------------
*
* 二、Maven简介
* 1.Apache Maven是一个项目管理和构建工具，它基于项目对象模型(POM)的概念，通过一小段描述信息来管理项目的构建、报告、和文档
*   Apache(基金组织)
*
* 2.Maven模型
* 1.项目对象模型(Project Object Model)
* 2.依赖管理模型(dependency)
* 3.插件(plugin)
*
* Maven仓库：
* 1.本地仓库
* 2.中央仓库
* 由Maven团队维护的全球唯一的仓库
* 地址：https://repo1.maven.org/maven2/
* 3.远程仓库(私服)
* 一般是由公司团队搭建的私有仓库
*
* 注：
* 1.当项目使用坐标引用对应依赖的jar包后，首先会查找本地仓库中是否有对应的jar包
* 如果有，则在项目直接引用
* 若没有，则从中央仓库下载对应的jar包到本地仓库
*
* ------------------------------------------------------------------------------------------------------
*
* Maven安装配置
* 1.解压Apache-maven-3.8.6.rar
* 2.配置环境变量
* 3.配置本地仓库：修改conf/settings.xml中的<localRepository>为一个指定目录
* 4.配置阿里云私服:修改conf/settings.xml中的<mirrors>标签,为其添加如下子标签
*
* <mirrors>
*
*  <id>alimaven</id>
*  <name>aliyun maven</name>
*  <url>https://maven.aliyun.com/repository/public/</url>
*  <mirrorOf>central</mirrorOf>
*
* </mirrors>
*
*-----------------------------------------------------------------------------------------------------
*
* 三、Maven的常用命令
* 1.compile 编译 (cmd: mvn compile)-->生成target目录
* 2.clean 清理(cmd: mvn compile) --> 删除target目录
* 3.test 测试 (cmd : mvn test) --> 执行测试文件
* 4.package 打包 (cmd : mvn package)--> 生成jar包（存放字节码文件）
* 5.install 安装 (cmd : mvn install) --> 安装jar包到本地仓库
*
* Maven生命周期
* 1.Maven构建项目生命周期描述的是一次构建过程经历了多少个事件
* 2.Maven对项目构建的生命周期划分为3套
*   （1）clean：清理工作
*   （2）default：核心工作，如编译，测试，打包等
*   （3）site 产生报告，发布站点等（不常用）
*
*  注意：同一生命周期内，执行后边的命令，前面的命令会自动执行
*
* -----------------------------------------------------------------------------------------------------
*
* 四、Maven坐标详解
* 1.Maven中的坐标是资源的唯一标识
* 2.使用坐标来定义项目或引入项目中需要的依赖
*
* Maven坐标主要组成
* 1.groupId：定义当前Maven项目隶属组织的名称(通常是域名反写)
* 2.artifactId：定义当前Maven项目名称(通常是模块名称，例如order-service，goods-service)
* 3.version：定义当前项目版本号
* -----------------------------------------------------------------------------------------------------
* 导入maven项目
* 1.选择右侧Maven面板，点击+号
* 2.选择对应项目的pom.xml文件，双击打开
* -----------------------------------------------------------------------------------------------------
* 五、依赖管理
* 1.在pom.xml中编写<dependencies>标签
* 2.在<dependencies>标签中使用<dependency>引入坐标
* 3.定义坐标的groupId，artifactId，version
* 4.点击刷新按钮，使坐标生效
*
*   <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.31</version>
        </dependency>


    </dependencies>

* 也可以alt+insert 选添加依赖项，自动添加坐标
* -----------------------------------------------------------------------------------------------------
*
* 六、依赖范围
* 通过设置坐标的依赖范围（scope），可以设置对应jar包的作用范围：编译环境、测试环境、运行环境、
* 默认值是compile，也是最大的范围
*
* */

public class Note {
}
