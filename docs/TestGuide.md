# 测试指南

## 测试环境配置
### 开发环境
- JDK 17
- JUnit 5.8.2
- Maven 3.6+

### 测试数据
- 测试用CSV文件
- 模拟客户数据
- 边界测试数据

## 测试类型
### 1. 单元测试
- ParcelTest
  - 包裹属性测试
  - 包裹操作测试
- CustomerTest
  - 客户信息测试
  - 排序功能测试
- WorkerTest
  - 费用计算测试
  - 客户处理测试

### 2. 集成测试
- SystemIntegrationTest
  - 组件交互测试
  - 数据流测试
- SystemFunctionalTest
  - 功能流程测试
  - 业务逻辑测试

### 3. 边界测试
- BoundaryTest
  - 数值边界测试
  - 异常情况测试

## 测试用例编写规范
### 命名规则
- test[功能名称]
- test[条件]_[预期结果]
- shouldXXX_whenYYY

### 断言使用
```java
assertEquals(expected, actual, "消息");
assertTrue(condition, "消息");
assertNotNull(object, "消息");
```

### 测试数据管理
- 使用@BeforeEach准备数据
- 使用@AfterEach清理数据
- 使用常量管理测试数据

## 运行测试
```bash
# 运行所有测试
mvn test

# 运行特定测试
mvn test -Dtest=ParcelTest

# 运行特定方法
mvn test -Dtest=ParcelTest#testAddParcel
```

## 测试覆盖率
### 生成报告
```bash
mvn jacoco:report
```

### 覆盖率要求
- 模型层: >90%
- 控制层: >85%
- 视图层: >75%

### 报告分析
- 查看未覆盖代码
- 分析测试质量
- 制定改进计划

## 测试结果分析
### 成功率统计
- 通过率要求
- 失败原因分析
- 性能指标评估

### 问题跟踪
- 记录测试问题
- 创建问题票据
- 跟踪解决进度

### 改进建议
- 测试用例优化
- 测试流程改进
- 自动化建议 