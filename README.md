Dr.Strange
====

> 异步调用服务

#### 描述

主要承担服务间异步调用以及定时调用

#### 功能

集群模式

保证投递

失败记录

#### Licence

MIT


#### TODO

1. [修改]定时按准确时间计算(yyyy-MM-dd HH:mm:ss)
2. [修改]集群actor调用，序列化方式优化
3. [修改]修改异步执行Future处理方式
4. [实现]失败任务进kafka队列重试
5. [实现]persistent actor
6. [修改]macros @app @application