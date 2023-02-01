package com.example.book.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.Entity.BookType;
import com.example.book.Service.BookTypeService;
import com.example.book.util.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookType")
public class BookTypeController {
    @Autowired
    private BookTypeService bookTypeService;

    /**
     * 新增分类
     *
     * @param BookType
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody BookType BookType) {
        return bookTypeService.save(BookType) ? R.success("新增分类成功") : R.error("新增分类失败");
    }

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        //分页构造器
        Page<BookType> pageInfo = new Page<>(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<BookType> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), BookType::getBookTypeName, name);
        //添加排序条件，根据sort进行排序
        queryWrapper.orderByAsc(BookType::getBookTypeId);
        //分页查询
        bookTypeService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(String id) {
        return bookTypeService.removeById(id) ? R.success("删除分类成功") : R.error("删除分类失败");
    }

    /**
     * 根据id修改分类信息
     *
     * @param BookType
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody BookType BookType) {
        return bookTypeService.updateById(BookType) ? R.success("修改分类成功") : R.error("修改分类失败");
    }

    @GetMapping()
    public R getOne(String id) {
        return R.success(bookTypeService.getById(id));
    }


}
