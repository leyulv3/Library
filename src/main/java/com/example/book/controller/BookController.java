package com.example.book.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.Entity.Book;
import com.example.book.Service.AuthorService;
import com.example.book.Service.BookService;
import com.example.book.Service.BookTypeService;
import com.example.book.dto.BookDto;
import com.example.book.util.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;

    @Autowired
    private AuthorService authorService;

    /**
     * 添加图书信息
     *
     * @param book
     * @return
     */
    @PostMapping("/add")
    public R addBook(@RequestBody Book book) {
        return bookService.save(book) ? R.success("添加成功") : R.error("添加失败");
    }

    /**
     * 修改图书信息
     *
     * @param book
     * @return
     */
    @PutMapping("/update")
    public R updateBook(@RequestBody Book book) {
        return bookService.updateById(book) ? R.success("修改成功") : R.error("修改失败");
    }

    /**
     * 删除图书信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public R deleteBook(String id) {
        return bookService.removeById(id) ? R.success("删除成功") : R.error("删除失败");
    }

    /**
     * 根据id查询图书信息
     *
     * @param id
     * @return
     */
    @GetMapping("/get")
    public R getBook(String id) {
        Book book = bookService.getById(id);
        if (book == null) {
            return R.error("查询失败");
        }
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto);
        bookDto.setBookTypeName(bookTypeService.getById(book.getBookTypeId()).getBookTypeName());
        bookDto.setAuthorName(authorService.getById(book.getAuthorId()).getAuthorName());
        return R.success(bookDto);
    }

    /**
     * 批量删除图书信息
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/deleteAll")
    public R deleteAll(@RequestBody List<String> ids) {
        return bookService.removeByIds(ids) ? R.success("删除成功") : R.error("删除失败");
    }

    /**
     * 查询所有图书信息
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/list")
    public R<List<BookDto>> list(int page, int pageSize, String name) {
        List<Book> list = bookService.list();
        List<BookDto> collect = list.stream().map(book -> {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book, bookDto);
            bookDto.setBookTypeName(bookTypeService.getById(book.getBookTypeId()).getBookTypeName());
            bookDto.setAuthorName(authorService.getById(book.getAuthorId()).getAuthorName());
            return bookDto;
        }).collect(Collectors.toList());
        return R.success(collect);
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        Page<Book> pageInfo = new Page<>(page, pageSize);
        Page<BookDto> bookDtoPage = new Page<>();
        //构造条件构造器
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), Book::getBookName, name);
        //添加排序条件
        queryWrapper.orderByDesc(Book::getBookId);
        //执行查询
        Page page1 = bookService.page(pageInfo, queryWrapper);
        //将page1的属性值赋值给bookDtoPage
        BeanUtils.copyProperties(page1, bookDtoPage);
        List<Book> records = page1.getRecords();
        List<BookDto> collect = records.stream().map(book -> {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book, bookDto);
            //根据图书类型id查询图书类型名称
            bookDto.setBookTypeName(bookTypeService.getById(book.getBookTypeId()).getBookTypeName());
            //根据作者id查询作者名称
            bookDto.setAuthorName(authorService.getById(book.getAuthorId()).getAuthorName());
            return bookDto;
        }).collect(Collectors.toList());
        bookDtoPage.setRecords(collect);
        return R.success(bookDtoPage);
    }
    //图书名称 图书id  图书作者 图书类型 借出数量 图书库存 图书状态
}
