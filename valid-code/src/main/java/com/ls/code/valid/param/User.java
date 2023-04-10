package com.ls.code.valid.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author: LS
 * @Date: 2023/4/6
 * @Description:
 * @version:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {


    private String id;

    @Length(min = 6, max = 12, message = "accountId长度必须位于6到12之间")
    private String accountId;

    @NotBlank(message = "名字为必填项")
    private String name;


}
