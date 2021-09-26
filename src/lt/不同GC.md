# 不同GC

jdk:1.8

操作系统 win10

### 串行GC

1.java -XX:+UseSerialGC -Xms128m -Xmx128m -XX:+PrintGCDetails lt.GCLogAnalysis

oom  7次youngGC 17次fullGC  每次youngGC时间约5-10ms   fullGC时间为1-13ms不等

2.java -XX:+UseSerialGC -Xms256m -Xmx256m -XX:+PrintGCDetails lt.GCLogAnalysis

oom  7次youngGC  时间约为10-20ms 37次fullGC 时间约为1-30ms不等

3.java -XX:+UseSerialGC -Xms1g -Xmx1g -XX:+PrintGCDetails lt.GCLogAnalysis

没有发生oom 生成14825个对象  14次youngGC 时间为10-50ms不等

4.java -XX:+UseSerialGC -Xms4g -Xmx4g -XX:+PrintGCDetails lt.GCLogAnalysis

没有发生oom  生成12652个对象   3次youngGC 时间为80-130ms不等

### 并行GC

1.java -XX:+UseParallelGC -Xms128m -Xmx128m -XX:+PrintGCDetails lt.GCLogAnalysis

8young  时间为2-3ms 19次fullGC 时间为2-22ms不等

2.java -XX:+UseParallelGC -Xms256m -Xmx256m -XX:+PrintGCDetails lt.GCLogAnalysis

oom  12 次youngGC     27次fullGC  时间为15-40ms不等

3.java -XX:+UseParallelGC -Xms1g -Xmx1g -XX:+PrintGCDetails lt.GCLogAnalysis

共生成对象次数:17253    3次gullGC  31次youngGC 大约10次youngGC后发生一次fullGC

4.java -XX:+UseParallelGC -Xms4g -Xmx4g -XX:+PrintGCDetails lt.GCLogAnalysis

共生成对象次数:18881  4次youngGC

## CMS

1.java -XX:+UseConcMarkSweepGC -Xms128m -Xmx128m -XX:+PrintGCDetails lt.GCLogAnalysis

oom  

2.java -XX:+UseConcMarkSweepGC -Xms256m -Xmx256m -XX:+PrintGCDetails lt.GCLogAnalysis

oom 

3.java -XX:+UseConcMarkSweepGC -Xms1g -Xmx1g -XX:+PrintGCDetails lt.GCLogAnalysis

生成对象次数:16703

4.java -XX:+UseConcMarkSweepGC -Xms4g -Xmx4g -XX:+PrintGCDetails lt.GCLogAnalysis

生成对象次数:16107

在相同的内存参数下 都略低于并行GC的吞吐量   回收时间与并行GC大致相同

## G1

1.java -XX:+UseG1GC -Xms128m -Xmx128m -XX:+PrintGC lt.GCLogAnalysis

oom  

2.java -XX:+UseG1GC -Xms512m -Xmx512m -XX:+PrintGC lt.GCLogAnalysis

生成对象次数:10947

3.java -XX:+UseG1GC -Xms1g -Xmx1g -XX:+PrintGC lt.GCLogAnalysis

生成对象次数:15713

4.java -XX:+UseG1GC -Xms4g -Xmx4g -XX:+PrintGC lt.GCLogAnalysis

生成对象次数:20414



内存128-256m 内存大小不足导致oom   频繁发生GC ;

G1在同等条件下 回收效率比较高 时间短  内存越大对比其他效果更好;

cms吞吐量对比其他GC有劣势,并且回收时间也不太稳定



