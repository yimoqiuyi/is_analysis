<!-- markdownlint-disable MD033-->
<!-- 禁止MD033类型的警告 https://www.npmjs.com/package/markdownlint -->

# “选择课程”用例 [返回](../../README.md)
## 1. 用例规约

|用例名称|选择课程|
|-------|:-------------|
|功能|根据每个学期选择属于自己的课程|
|参与者|学生|
|前置条件|学生需要先登录|
|后置条件| |
|主事件流| |
|备选事件流| |

## 2. 业务流程（顺序图） [源码](../main/CheckGrade.puml)
![sequence1](../../CheckGrade.png) 

## 3. 界面设计
- 界面参照: https://github.com/yimoqiuyi/is_analysis/blob/master/test6/src/ui/checkcourse.png
- API接口调用 
    - 接口1：[getOneStudentResult](../mapper/getOneStudentResult.md) 

## 4. 算法描述
    无
    
## 5. 参照表
- [STUDENTS](../../DataDesign.md/#STUDENTS)
- [Teacher_Student](../../DataDesign.md/#Teacher_Student)
- [Semester](../../DataDesign.md/#Semester)
- [GRADES](../../DataDesign.md/#GRADES)
- [TESTS](../../DataDesign.md/#TESTS)
- [TEACHERS](../../DataDesign.md/#TEACHERS)
- [COURSE](../../DataDesign.md/#COURSE)
