<!-- markdownlint-disable MD033-->
<!-- 禁止MD033类型的警告 https://www.npmjs.com/package/markdownlint -->

# 接口：CheckCourse  [返回](../../README.md)
用例： [选择课程](../cases/CheckCourse.md)

- 功能：
      学生自主选择课程
    
- 权限：
     学生可以选择课程，
     老师查看课程。
    
- API请求地址： 
    接口基本地址/v1/api/CheckCourse.md

- 请求方式 ：
    POST
 
- 请求实例：  
        { 
              "semester": 1, 
             "student_id":20151044152
             "total": 6,
              "data": [
                {
                "course_id":1,
                 }, 
                {
                ... 
                }
            ] 
        }

- 请求参数说明:       
 
  |参数名称|说明|
  |:---------:|:--------------------------------------------------------|      
  |student_id|学号|
  |total|选课总数|
  |semester|学期|
  |course_id|课程ID|
 - 返回实例：

        {         
            "status": true,
            "info": null
        }

- 返回参数说明：    
 
  |参数名称|说明|
  |:---------:|:--------------------------------------------------------|      
  |status|bool类型，true表示选课成功，false表示选课错误|
  |info|返回结果说明信息|

