package com.xlc.springboot_03_ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlc.springboot_03_ssmp.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname BookMapper
 * @Description TODO
 * @Date 2024/12/6 9:31
 * @Created by cxx
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
