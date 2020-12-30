## AOP相关知识点

链接地址：https://blog.csdn.net/java_green_hand0909/article/details/90238242





## 相关的依赖包说明



### SpringBoot项目热部署（IDEA）

- 引入spring-boot-devtools依赖文件

```xml
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-devtools</artifactId>
     <scope>runtime</scope>
     <optional>true</optional>
</dependency>
```

- 修改IDEA中的相关设置

![修改IDEA设置](D:\document\相关文档\imgs\修改1.png)

- "ctl+alt+shift+/ "进行设置



## SpringBoot定时器相关



### 定时器使用（借鉴文章：https://segmentfault.com/a/1190000018805591）

- 在定时任务类上或者在主方法类上添加注解**@EnableScheduling** 开启启用定时任务功能
- 在需要的方法上添加上注解@Scheduled(cron = "执行周期表达式")，标注这个方法是个定时执行的方法。

```java
 private static SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
 @Scheduled(cron = "0/5 * * * * ?")
 public void test(){
 System.out.println(dateFmt.format(new Date()) + " : 执行定时任务");
 }

```

###  定时周期表达式管理

```xml
  #设置定时执行的周期 在线生成工具 https://www.bejson.com/othertools/cron/
  difference_cron: 0 0/5 * * * ?
  #表示不执行这个定时任务
  #difference_cron: "-"
```

```java
  @Scheduled(cron = "${shelljob.difference_cron}")
  public void comparisonFile(){
```

