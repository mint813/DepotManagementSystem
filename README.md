# 仓库包裹管理系统

## 项目概述

这是一个基于Java Swing开发的仓库包裹管理系统，用于管理包裹的接收、存储和客户取件流程。系统采用MVC架构模式设计，实现了包裹管理、客户队列、费用计算等核心功能。

### 业务流程
1. 站点接收客户包裹
2. 工作人员按排序记录包裹信息
3. 客户到达仓库使用排队系统
4. 客户领取包裹并支付费用
5. 系统更新包裹状态

## 系统要求

- JDK 17 或更高版本
- Maven 3.6 或更高版本
- 最小内存要求：512MB
- 推荐内存：1GB
- 磁盘空间：100MB

## 快速开始

1. 克隆项目

```bash
git clone https://github.com/your-repo/warehouse-parcel-management.git
cd warehouse-parcel-management
```

2. 编译项目

```bash
mvn clean compile
```

3. 运行项目

```bash
mvn exec:java -Dexec.mainClass="uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.Main"
```

## 功能特性

1. 包裹管理
   - 添加新包裹（ID、尺寸、重量、存放天数）
   - 查看包裹列表（按客户姓氏排序）
   - 标记包裹已收集
   - 计算存储费用
   - 支持至少20个包裹的管理

2. 客户队列管理
   - 客户排队系统（FIFO原则）
   - 按姓氏字母顺序排序
   - 处理下一位客户
   - 显示当前处理的客户信息

3. 费用计算
   - 基础费用：5.0
   - 重量费用：0.5/kg
   - 体积费用：0.001/cm³
   - 存储费用：1.0/天

## 系统架构

### MVC模式实现

1. Model（模型层）
   - Customer：客户信息（姓名、包裹ID）
   - Parcel：包裹信息（ID、尺寸、重量、天数）
   - QueueOfCustomers：客户队列管理
   - Log：日志记录（单例模式）

2. View（视图层）
   - ParcelListFrame：主窗口
     - 包裹列表显示
     - 客户队列显示
     - 当前处理包裹信息
   - AddParcelDialog：添加包裹对话框

3. Controller（控制层）
   - ParcelManager：包裹数据管理
   - CustomerManager：客户数据管理
   - Worker：业务逻辑处理（费用计算、包裹处理）

## 数据文件

### CSV文件格式

1. Parcels.csv
```csv
ParcelID,DaysInDepot,Weight,Length,Width,Height
TEST001,5,10.0,20.0,15.0,25.0
```

2. Custs.csv
```csv
CustomerName,ParcelID
John Smith,TEST001
```

## 测试

运行测试：

```bash
# 运行所有测试
mvn test

# 运行特定测试
mvn test -Dtest=SystemFunctionalTest
```

### 测试类型
1. 单元测试
   - ParcelTest：包裹基本功能测试
   - CustomerTest：客户操作测试
   - WorkerTest：业务逻辑测试

2. 集成测试
   - SystemIntegrationTest：系统集成测试
   - SystemFunctionalTest：功能流程测试
   - BoundaryTest：边界条件测试

## 故障排除

1. 程序无法启动
   - 检查Java版本（需要JDK 17+）
   - 确认数据文件存在（Parcels.csv, Custs.csv）
   - 验证文件权限（读写权限）

2. 数据无法保存
   - 检查磁盘空间
   - 验证文件写入权限
   - 确认文件未被锁定

## 开发指南

1. 代码规范
   - 遵循Java编码规范
   - 添加适当的注释
   - 保持代码简洁
   - 使用有意义的变量名

2. 提交规范
   - 清晰的提交信息
   - 单一功能提交
   - 提交前进行测试
   - 保持代码可追踪性

3. 设计模式使用
   - 单例模式：Log类
   - MVC模式：整体架构
   - 观察者模式：GUI更新

## 版本历史

- v1.0.0 (2024-01)
  - 初始版本发布
  - 实现基本功能：包裹管理、客户队列、费用计算
  - 完成GUI界面
  - 实现数据持久化

## 许可证

本项目采用 MIT 许可证。

## 作者

- 姓名：[您的姓名]
- 学号：[您的学号]
- 邮箱：[您的邮箱]
- 课程：6COM2013 Software Engineering Practice
- 学期：2023-2024
    