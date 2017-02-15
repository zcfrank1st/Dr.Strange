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
0. [实现] 集群机器注册

1. ~~[修改]定时按准确时间计算(yyyy-MM-dd HH:mm:ss)~~
2. ~~[修改]集群actor调用，序列化方式优化~~
3. ~~[修改]修改异步执行Future处理方式,以及executorcontext~~
4. [修改]macros @app @application
5. [修改]支持同一机器多jvm，多端口支持

6. [实现]失败任务进kafka队列重试
7. [实现]persistent actor

8. [实现]落地任务是否成功执行，保证集群服务调用不丢失