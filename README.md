# jackie-validator
this validator expand from hibernate-validator
### 自定义已有扩展校验器
```
<dependency>
    <groupId>com.github.jackieonway</groupId>
    <artifactId>jackie-validator</artifactId>
  <version>1.0</version> 
</dependency>   
```
已经实现的注解有: 
Constraint | 详细信息 
-|-
@AllEqual(value[] )|  该注解使用在类上，value：是需要校验全等的参数名称集合，常见于校验修改密码的新密码和确认密码使用
@DateTimeSize(start, end, pattern )|  该注解使用在参数或者字段上，start：开始时间，end：结束时间 ， pattern : 时间格式化方式, 默认 *yyyy-MM-dd HH:mm:ss*
@Email | 该注解使用在参数或者字段上,验证常见的邮箱信息
@DateCompare(startTime, endTime, lessOrEqualThanNow, must )|  该注解使用在类上，startTime：开始时间字段,如: *#order.startTime*，endTime：结束时间字段,如: *#order.endTime*,lessOrEqualThanNow:是否必须小于等于当前时间，默认: *false*,  must: 是否必须传开始和结束时间字段，默认: *false*
@HasNotNull(value[] )|  该注解使用在类上，value：是需要校验有一个不能为空的参数名称集合，常见于登录时有账号、手机号、邮箱等登录方式的情景
@URL |  该注解使用在参数或者字段上，校验*IPV4*、*IPV6*、*http*、*https*、*ftp*等方式的链接地址支持链接带参数
@Ranges(params[] ) |  该注解使用在参数或者字段上，params: 校验值,如： *['1','3','5','6']*，校验字段的值在一定的范围内，常见于校验不连续的数量不大的数据值情景
