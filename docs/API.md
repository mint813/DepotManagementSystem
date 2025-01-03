# API 文档

## 模型层 (Model)

### Customer 类
```java
public class Customer implements Serializable, Comparable<Customer>
```

#### 主要方法
- `Customer(String name, Parcel parcel)`: 构造函数，创建客户对象
- `getFirstName()`: 获取客户名
- `getLastName()`: 获取客户姓
- `getParcel()`: 获取关联包裹
- `setParcel(Parcel)`: 设置关联包裹
- `compareTo(Customer)`: 按姓氏字母顺序比较客户
- `toString()`: 返回客户全名

### Parcel 类
```java
public class Parcel implements Serializable
```

#### 主要方法
- `getParcelID()`: 获取包裹ID
- `setParcelID(String)`: 设置包裹ID
- `getDaysInDepot()`: 获取存放天数
- `setDaysInDepot(int)`: 设置存放天数
- `getWeight()`: 获取重量
- `setWeight(double)`: 设置重量
- `getLength()`: 获取长度
- `setLength(double)`: 设置长度
- `getWidth()`: 获取宽度
- `setWidth(double)`: 设置宽度
- `getHeight()`: 获取高度
- `setHeight(double)`: 设置高度

### QueueOfCustomers 类
```java
public class QueueOfCustomers
```

#### 主要方法
- `addCustomer(Customer)`: 添加客户到队列
- `removeCustomer()`: 移除并返回下一个客户
- `getQueue()`: 获取当前队列状态

### Log 类
```java
public class Log
```

#### 主要方法
- `getInstance()`: 获取Log单例实例
- `addEvent(String)`: 添加日志事件
- `saveToFile(String)`: 保存日志到指定文件

## 控制层 (Controller)

### ParcelManager 类
```java
public class ParcelManager
```

#### 主要方法
- `getInstance()`: 获取ParcelManager单例实例
- `addParcel(Parcel)`: 添加新包裹
- `deleteParcel(Parcel)`: 删除包裹
- `getParcel(String)`: 根据ID获取包裹
- `getParcels()`: 获取所有包裹列表
- `saveParcels()`: 保存包裹数据到文件
- `isModified()`: 检查数据是否被修改

### CustomerManager 类
```java
public class CustomerManager
```

#### 主要方法
- `getInstance()`: 获取CustomerManager单例实例
- `printCustomers()`: 打印所有客户信息

### Worker 类
```java
public class Worker
```

#### 主要方法
- `calculateFee(Parcel)`: 计算包裹费用
  - 基础费用：5.0
  - 重量费用：0.5/kg
  - 体积费用：0.001/cm³
  - 存储费用：1.0/天
- `processCustomer(Customer)`: 处理客户
- `getCurrentCustomer()`: 获取当前处理的客户
- `getCurrentParcel()`: 获取当前处理的包裹

## 视图层 (View)

### ParcelListFrame 类
```java
public class ParcelListFrame extends JFrame
```

#### 主要方法
- `display()`: 更新显示内容
- `processNextCustomer()`: 处理下一个客户
- `updateQueueDisplay()`: 更新队列显示
- `updateCurrentCustomerDisplay()`: 更新当前客户显示

### AddParcelDialog 类
```java
public class AddParcelDialog extends JDialog
```

#### 主要方法
- `add()`: 添加新包裹
- `reset()`: 重置输入字段 