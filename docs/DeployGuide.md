# 部署指南

## 系统要求
- JDK 17+
- Maven 3.6+
- 最小内存: 512MB
- 磁盘空间: 100MB

## 系统架构
### 运行环境
- JVM配置
  - 最小堆内存: 256MB
  - 最大堆内存: 1GB
  - GC策略: G1GC

### 存储要求
- 数据文件: 10MB
- 日志文件: 50MB
- 临时文件: 40MB

## 部署步骤

### 1. 环境准备
```bash
# 检查Java版本
java -version

# 检查Maven版本
mvn -version

# 检查系统内存
free -m
```

### 2. 构建项目
```bash
# 清理并编译
mvn clean compile

# 运行测试
mvn test

# 打包
mvn package
```

### 3. 运行应用
```bash
# 基本运行
java -jar target/mod_6com2013-asgnpart2-1.0-SNAPSHOT.jar

# 指定内存运行
java -Xms256m -Xmx1g -jar target/mod_6com2013-asgnpart2-1.0-SNAPSHOT.jar
```

## 配置文件
### 数据文件
- Parcels.csv: 包裹数据
  ```csv
  ParcelID,DaysInDepot,Weight,Width,Length,Height
  TEST001,5,10.0,15.0,20.0,25.0
  ```
- Custs.csv: 客户数据
  ```csv
  CustomerName,ParcelID
  John Smith,TEST001
  ```

### 日志文件
- depot_log.txt: 系统日志
  ```
  [2024-01-20 10:30:15] System started
  [2024-01-20 10:31:20] New parcel added: TEST001
  ```

## 性能优化
### JVM调优
- 使用G1GC垃圾收集器
- 调整堆内存大小
- 启用并行GC

### 数据处理优化
- 批量处理
- 缓存机制
- 索引优化

## 故障处理
### 常见问题
1. 启动失败
   - 检查Java版本
   - 验证配置文件
   - 检查端口占用

2. 数据丢失
   - 检查文件权限
   - 恢复备份数据
   - 验证磁盘空间

3. 性能问题
   - 检查内存使用
   - 分析GC日志
   - 优化JVM参数

### 日志分析
- 使用日志工具分析
- 检查错误堆栈
- 监控系统资源

## 维护计划
1. 日常维护
   - 日志清理
   - 数据备份
   - 性能监控

2. 定期维护
   - 系统更新
   - 安全补丁
   - 性能优化 