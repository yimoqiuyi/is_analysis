<!-- markdownlint-disable MD033-->
<!-- 禁止MD033类型的警告 https://www.npmjs.com/package/markdownlint -->

# 接口：login  [返回](../README.md)
用例： [注册](../cases/updateGrade.md)

- 功能：
    注册学生。
    
- 权限：
    访客。    
    
- API请求地址： 
    接口基本地址/v1/api/regist

- 请求方式 ：
    POST

- 请求实例：

        {
            "id":"201510414224",
            "password":"ABCDE",
            "type":"学生"
        }
        
- 请求参数说明:        

  |参数名称|说明|
  |:---------:|:--------------------------------------------------------|      
  |id|注册账号|
  |password|加密后的字符串| 
  |type|注册类型，学生或者老师|
  
- 返回实例：

        { 
            "status": true,
            "info": null,    
        }
 
- 返回参数说明：    
 
  |参数名称|说明|
  |:---------:|:--------------------------------------------------------|      
  |status|bool类型，true表示注册成功，false表示注册失败|
  |info|返回结果说明信息|

