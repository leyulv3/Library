package com.example.book.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.Entity.Author;
import com.example.book.Service.AuthorService;
import com.example.book.util.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    /**
     * 新增分类
     *
     * @param author
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Author author) {
        return authorService.save(author) ? R.success("新增分类成功") : R.error("新增分类失败");
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
        Page<Author> pageInfo = new Page<>(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<Author> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Author::getAuthorName, name);
        //添加排序条件，根据sort进行排序
        queryWrapper.orderByAsc(Author::getAuthorId);
        //分页查询
        authorService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public R delete(String id) {
        return authorService.removeById(id) ? R.success("删除分类成功") : R.error("删除分类失败");
    }

    /**
     * 修改分类
     *
     * @param author
     * @return
     */
    @PutMapping
    public R update(@RequestBody Author author) {
        return authorService.updateById(author) ? R.success("修改分类成功") : R.error("修改分类失败");
    }
    /**
     * 根据id查询作者
     * @param id
     * @return
     */
    @GetMapping()
    public R getOne(String id) {
        return R.success(authorService.getById(id));
    }

}
