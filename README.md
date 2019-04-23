## springboot 2.0 集成 mybatis

### 环境：

* 开发工具：Intellij IDEA 2017.1.3
* springboot: **2.0.1.RELEASE**
* jdk：1.8.0_40
* maven:3.3.9
* local mariadb

### 额外功能：

* PageHelper 分页插件


Different action should use different method. Method with resource stand for meaning.
@GetMapping = @RequestMapping(method = RequestMethod.GET)
@PostMapping = @RequestMapping(method = RequestMethod.POST)
@PutMapping = @RequestMapping(method = RequestMethod.PUT)
@DeleteMapping = @RequestMapping(method = RequestMethod.DELETE
--------------------- 
作者：前方太黑暗 
来源：CSDN 
原文：https://blog.csdn.net/xcc_2269861428/article/details/80432765 
版权声明：本文为博主原创文章，转载请附上博文链接！