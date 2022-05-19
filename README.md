# CommandAnalysis
文本指令解析，对于带参数前缀的文本指令使用IOC的思想进行解析。



在写文本指令的时候长期会出现大量的`if-else if-else`的结构，不仅代码冗长并且执行效率为$ O(n) $。所以本项目旨在通过IOC的思想，引入哈希的方式使得指令解析的速率大幅提升。

例如：

```java
public void function(String message) {
    if (message.equals("你好")) {
        // 业务
    } else if (message.equals("购买")) {
        String temp = message.substring(2);
        String[] param = temp.split(" ");
        // 解析参数
    }
}
```

可见其麻烦所在。

所以本项目想利用注解的方式直接进行指令的注册并调用。
