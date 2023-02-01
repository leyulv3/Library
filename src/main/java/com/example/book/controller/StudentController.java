package com.example.book.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.Entity.Student;
import com.example.book.Service.StudentService;
import com.example.book.util.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 分页查询学生信息
     *
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/all")
    public R<Page> getAllStudent(int page, int pageSize, String name, String id) {
        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);
        //构造条件构造器
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Student::getStudentName, name);
        queryWrapper.like(StringUtils.isNotEmpty(id), Student::getStudentId, id);
        //添加排序条件
        queryWrapper.orderByDesc(Student::getStudentId);
        //执行查询
        studentService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    //添加学生信息
    @PostMapping("/add")
    public R addStudent(@RequestBody Student student) {
        return studentService.save(student) ? R.success("添加成功") : R.error("添加失败");
    }

    //修改学生信息
    @PutMapping("/update")
    public R updateStudent(@RequestBody Student student) {
        return studentService.updateById(student) ? R.success("修改成功") : R.error("修改失败");
    }

    //删除学生信息
    @DeleteMapping("/delete")
    public R deleteStudent(String id) {
        return studentService.removeById(id) ? R.success("删除成功") : R.error("删除失败");
    }

    //查询单个学生信息
    @GetMapping("/one")
    public R<Student> getStudent(String id) {
        return R.success(studentService.getOne(new LambdaQueryWrapper<Student>().eq(Student::getStudentId, id)));
    }
}
