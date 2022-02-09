# Java双向队列Deque栈与队列

### 总体介绍

要讲[栈和队列](https://so.csdn.net/so/search?q=栈和队列&spm=1001.2101.3001.7020)，首先要讲Deque接口。Deque的含义是“double ended queue”，即双端队列，它既可以当作栈使用，也可以当作队列使用。下表列出了Deque与Queue相对应的接口：

![img](https://img-blog.csdnimg.cn/20181222160806384)

下表列出了[Deque](https://so.csdn.net/so/search?q=Deque&spm=1001.2101.3001.7020)与Stack对应的接口：

![img](https://img-blog.csdnimg.cn/20181222160806404)

上面两个表共定义了Deque的12个接口。添加，删除，取值都有两套接口，它们功能相同，区别是对失败情况的处理不同。**一套接口遇到失败就会抛出异常**，**另一套遇到失败会返回特殊值（false或null）**。除非某种实现对容量有限制，大多数情况下，添加操作是不会失败的。虽然Deque的接口有12个之多，但**无非就是对容器的两端进行操作**，或添加，或删除，或查看。明白了这一点讲解起来就会非常简单。