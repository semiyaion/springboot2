package com.xlc.springboot_03_ssmp.controller.until;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xlc.springboot_03_ssmp.pojo.Book;
import lombok.Data;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname R
 * @Description TODO
 * @Date 2024/12/6 15:18
 * @Created by cxx
 */
@Data
public class R {
    private boolean flag;
    private Object data;
    private String msg;

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
