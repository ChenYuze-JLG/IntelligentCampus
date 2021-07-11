# Intelligence-campus
重庆大学暑期实训项目

## 环境配置：   

* MySQL: 8.0.x
* Idea: 2021.1.x
* JDK: 1.8.x
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

|  字段   | 解释  |
|  :---:  | :---:  |
| acsnamelist  | 行政班中学生名单 |
| adminclass  | 行政班级 |
| classroomrecord  | 教室申用记录 |
| counsellor  | 辅导员 |
| dmtadmin | 舍区管理员 |
| eduadmin | 教务管理员 |
| enrolyear | 入学年份 |
| inoutrecord  | 学生寝室出入记录 |
| tcsnamelist  | 教学班中学生名单 |
| teachclass | 教学班 |
| transrecord  | 交易记录 |
| lostandfound | 失物招领 |



## 模块1 by 毛红灯、何翔 

1. 登陆
2. 资讯发布与显示
3. 活动发布、显示、审核、报名
4. 失物招领发布及查看

   

## 模块2 by 陈宇泽、闫雨勤

1. 成绩管理
2. 课表查询
3. 考试安排
4. 请假管理（包括审核）
5. 考勤功能（教师发布，学生收到后进行签到）
6. 教师查看班级信息



## 模块3 by 覃宇攀、凌瑞

1. 校车信息
2. 校园地图
3. 图书借阅管理
4. 缴费管理
5. 归寝管理

### 模块说明
1. index3.html
   <dd><a href="javascript: $('#feed').load(localhost+'/car.html')" style="padding: 0 0px"><i class="fa fa-list fa-lg"></i> <span >校车信息</span></a></dd>

在标签中插入javascript语句使其动态加载正文网页

#### 功能需求
1.获取所有图书
```javascript
type: "GET",//方法类型
dataType: "json",//预期服务器返回的数据类型
url: "mod3/bookList",//url
```
2.根据名字检索图书,返回列表
```javascript
type: "GET",//方法类型
dataType: "json",//预期服务器返回的数据类型
url: "mod3/selectBookByName",//url
data:  {name:name},
```

3.借阅图书
```javascript
type: "post",//方法类型
dataType: "json",//预期服务器返回的数据类型
url: "mod3/bookBorrowByID",//url
data: {bookID : bookID},
```

4.获取自己已借的图书列表
```javascript
type: "GET",//方法类型
dataType: "json",//预期服务器返回的数据类型
url: "mod3/selfBookList",//url
```

5.归还图书
```javascript
type: "post",//方法类型
dataType: "json",//预期服务器返回的数据类型
url: "mod3/bookReturnByID",//url
data: {bookID : bookID},
```

6.出入记录
```javascript
type: "GET",//方法类型
dataType: "json",//预期服务器返回的数据类型
url: "mod3/inOutRecord",//url
```
