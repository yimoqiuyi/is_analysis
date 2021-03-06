<!-- markdownlint-disable MD033-->
<!-- 禁止MD033类型的警告 https://www.npmjs.com/package/markdownlint -->

# “更新数据”用例 [返回](../README.md)
## 1. 用例规约

|用例名称||
|-------|:-------------|
|功能|学生查看自己的每个学期中各个老师对每个实验的实验成绩及实验评价|
|参与者|学生|
|前置条件|学生需要先登录|
|后置条件| |
|主事件流| |
|备选事件流| |

## 2. 业务流程（顺序图） [源码](../main/CheckGrade.puml)
![sequence1](../CheckGrade.png) 

## 3. 界面设计
- 界面参照: https://zwdbox.github.io/is_analysis/test6/ui/查看成绩.html
- API接口调用
    - 接口1：[getOneStudentResults](../mapper/getOneStudentResults.md) 

## 4. 算法描述
    无
    
## 5. 参照表
- [STUDENTS](../DataDesign.md/#STUDENTS)
- [Teacher_Student](../DataDesign.md/#Teacher_Student)
- [Semester](../DataDesign.md/#Semester)
- [GRADES](../DataDesign.md/#GRADES)
- [TESTS](../DataDesign.md/#TESTS)
- [TEACHERS](../DataDesign.md/#TEACHERS)
