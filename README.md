# Java Demo with prometheus and jwt


### jwt

```bash
# get token
curl 127.0.0.1:8080/login

# get username by token
curl 127.0.0.1:8080/users -H 'Authorization Bearer xxxxx'
```

### prometheus metrics
接入 jvm 示例：
```bash
# application.properties
management.endpoints.web.exposure.include=health,info,prometheus  # * 也可以
management.endpoint.prometheus.enabled=true
```
```bash
# pom.xml 引入两个依赖
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<groupId>io.micrometer</groupId>
	<artifactId>micrometer-registry-prometheus</artifactId>
</dependency>

```

```bash
# 本地测试
curl  127.0.0.1:8080/actuator/prometheus
# HELP system_load_average_1m The sum of the number of runnable entities queued to available processors and the number of runnable entities running on the available processors averaged over a period of time
# TYPE system_load_average_1m gauge
system_load_average_1m 4.82470703125
# HELP tomcat_sessions_created_sessions_total  
# TYPE tomcat_sessions_created_sessions_total counter
tomcat_sessions_created_sessions_total 0.0
# HELP executor_pool_max_threads The maximum allowed number of threads in the pool
# TYPE executor_pool_max_threads gauge
executor_pool_max_threads{name="applicationTaskExecutor",} 2.147483647E9
# HELP process_cpu_usage The "recent cpu usage" for the Java Virtual Machine process
# TYPE process_cpu_usage gauge
process_cpu_usage 0.0


```
