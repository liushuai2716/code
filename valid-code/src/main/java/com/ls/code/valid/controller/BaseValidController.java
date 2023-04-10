package com.ls.code.valid.controller;

import com.ls.code.valid.common.ResultVo;
import com.ls.code.valid.param.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LS
 * @Date: 2023/4/6
 * @Description:
 * @version:
 **/
@RestController
@Slf4j
@Validated
public class BaseValidController {

    /**
     * json提交校验
     *
     * @param user
     * @return
     */
    @PostMapping("/valid/bodyValid")
    public ResultVo bodyValid(@Validated @RequestBody User user) {
        return new ResultVo(User.builder().id("10086").name("ls").build());
    }


    @GetMapping("/valid/paramValid")
    public User paramValid() {

        return User.builder().id("10086").name("ls").build();
    }

    @GetMapping("/valid/paramValid2")
    public String paramValid2() {

        return "redis 存活";
    }

}
