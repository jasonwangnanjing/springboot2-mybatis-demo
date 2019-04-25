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


Next steps:
dao mapper for order
dao mapper for order detail

service for order
service for order detail

authorization with spring security

**vue as frontend?** 
 
 
 Common Errors:
 during sql operation, sometimes it report error 'does not have get method for property xxx',need check sql's object has a property or not.
 
 posted object with wrong format like below, will not be handled by spring, no exception will be raised
 
 {
 	"orderId": "201904120001",
 	"itemId": "1",
 	"material": "3"
 }
 
 with right format, it will be handled
{
	"orderId": "201904120001",
	"itemId": "1",
	"material": {"id":"3"}
}

