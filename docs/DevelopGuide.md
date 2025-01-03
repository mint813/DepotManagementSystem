# 开发指南

## 项目结构

```
src/
├── main/
│   └── java/
│       └── uk/ac/herts/sp23ahy/mod_6com2013/asgnpart2/
│           ├── controller/
│           ├── model/
│           └── view/
└── test/
    └── java/
        └── uk/ac/herts/sp23ahy/mod_6com2013/asgnpart2/
            ├── controller/
            ├── model/
            └── integration/
```

## 开发环境配置
### IDE设置
- JDK 17配置
- Maven配置
- 编码设置(UTF-8)

### 依赖管理
- JUnit 5.8.2
- Swing GUI库
- Maven插件

## 开发规范
### 1. 代码风格
- 使用4空格缩进
- 类名使用PascalCase
- 方法名使用camelCase
- 常量使用UPPER_CASE

### 2. 测试规范
- 单元测试覆盖所有公共方法
- 集成测试验证组件交互
- 使用有意义的测试名称

### 3. Git提交规范
- feat: 新功能
- fix: 修复bug
- docs: 文档更新
- test: 添加测试

## 设计模式
### 1. 单例模式
- Log类
- ParcelManager类
- CustomerManager类

### 2. MVC模式
- Model: 数据模型类
- View: GUI界面类
- Controller: 业务逻辑类

## 调试指南
- 日志查看
- 断点设置
- 数据验证

## 发布流程
1. 版本号更新
2. 测试执行
3. 文档更新
4. 打包发布 