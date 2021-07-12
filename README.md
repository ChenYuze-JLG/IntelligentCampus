# Intelligence-campus
重庆大学暑期实训项目

## 数据库更改todo（下划线为已做更改）
* activity表需要图片的url这个属性(imgUrl)
* news表需要标题这个属性(title)
* inoutrecord表：将inOutTime拆分为inTime与outTime
* dmtroom表：增加gasBalance、waterBalance、electricBalance属性
* ~~user表：添加初始化roomID~~
* ~~transrecord表：修改money类型为decimal,将支出修改为负值~~
* ~~borrowrecord表：修改renewCount为0-3范围~~
* ~~borrowrecord表：修改returnTime为timestamp~~
* ~~borrowrecord表：增加expirationTime超期时间属性~~
* ~~books表：添加是否在馆信息(state)~~
* ~~borrowrecord表：borrowTime更改为timestamp类型~~
* ~~borrowrecord表：将returnTime < borrowTime 的returnTime更改为NULL~~
* ~~books表：增加book数量~~
* ~~activityrecord表：修改regisTime为CURRENT_TIMESTAMP~~
* ~~activity表：修改属性名，更改publishTime为CURRENT_TIMESTAMP~~
* ~~transrecord表：修改payTime为CURRENT_TIMESTAMP~~
* ~~news表：publishTime修改为CURRENT_TIMESTAMP~~
* ~~lostandfound表：publishTime修改为CURRENT_TIMESTAMP~~
* ~~inoutrecord表：inOutTime修改为CURRENT_TIMESTAMP~~
 

## 环境配置：   

* MySQL: 8.0.x
* Idea: 2021.1.x
* JDK: 11.x.x
* Maven: 3.6.3 (idea 自带)

## 功能需求：

### 基本功能

1. 登录
2. 资讯（包括新闻、活动安排）

### 教务管理

1. 成绩查询（教师可以查看班级成绩的分布，学生只能查看自己的成绩）
2. 课表查询（教师可以查看自己上课的课表，学生可以查看自己的所有课程）
3. 考试安排（教师可以发布考试安排，学生只有查看权限）
4. 请假考勤（学生申请，辅导员批示，教师可以进行考勤（例：云班课））
5. 报到注册（待完善）
6. 教室申请

### 舍区管理

1. 水电缴费
2. 校园卡缴费
3. 归寝记录

### 校园服务

1. 校车时刻查询
2. 失物招领（发布和查看）
3. 图书借阅（借阅信息、续借、转借）
4. 校园地图（图片上传）

## 数据库说明

### 课程时间表

|  节次   | 时间  |
|  :---:  | :---:  |
| 第一节  | 08：30 - 09：15 |
| 第二节  | 09：25 - 10：10 |
| 第三节  | 10：30 - 11：15 |
| 第四节  | 11：25 - 12：10 |
| 第五节  | 13：30 - 14：15 |
| 第六节  | 14：25 - 15：10 |
| 第七节  | 15：20 - 16：05 |
| 第八节  | 16：25 - 17：10 |
| 第九节  | 17：20 - 18：05 |
| 第十节  | 19：00 - 19：45 |
| 第十一节 | 19：55 - 20：40 |
| 第十二节 | 20：50 - 21：35 |

### 数据库字段说明

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| acsnamelist  | |行政班中学生名单 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| adminclass | | 行政班级 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| classroomrecord | | 教室申用记录 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| counsellor  | | 辅导员 |

| 数据表 | 字段 | 解释  |
|  :---:  |  :---:  | :---:  |
| dmtadmin |  | 舍区管理员 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| eduadmin |  | 教务管理员 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| student | enrolyear | 入学年份 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| inoutrecord  | | 学生寝室出入记录 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| tcsnamelist  | | 教学班中学生名单 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| teachclass | | 教学班 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| transrecord  | | 交易记录 |

| 数据表 |  字段   | 解释  |
|  :---:  |  :---:  | :---:  |
| lostandfound | | 失物招领 |


## 分工

### 模块1 by 毛红灯、何翔 

1. 登陆
2. 资讯发布与显示
3. 活动发布、显示、审核、报名
4. 失物招领发布及查看

   

### 模块2 by 陈宇泽、闫雨勤

1. 成绩管理
2. 课表查询
3. 考试安排
4. 请假管理（包括审核）
5. 考勤功能（教师发布，学生收到后进行签到）
6. 教师查看班级信息



### 模块3 by 覃宇攀、凌瑞

1. 校车信息
2. 校园地图
3. 图书借阅管理
4. 缴费管理
5. 归寝管理

