package com.ransibi.validation;

import lombok.Data;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class RequestParams {
    @NotBlank
    private String name;

    /**
     *    1.@NotNull：不能为null，但可以为empty(""," ","   ")
     *    2.@NotEmpty：不能为null，而且长度必须大于0 (" ","  ")
     *    3.@NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0("test")    即：必须有实际字符
     */
    @NotBlank(message="用户名不能为空")
    private String userName;

    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄不正确")
    private String age;

    @AssertFalse(message = "必须为false")
    private Boolean isFalse;
    /**
     * 如果是空，则不校验，如果不为空，则校验
     */
    @Pattern(regexp="^\\d{4}(-)(1[0-2]|0?\\d)\\1([0-2]\\d|\\d|30|31)$",message="出生日期格式不正确")
    private String birthday;

    @Pattern(regexp = "^[M|F|U|m|f|u]{1}$")
    private String gender;

    @Pattern(regexp = "^(MS)?(MR)?(PRO)?(MRS)?(DOC)?$")
    private String civility;

    @Size(min = 1, message = "field names can't be empty")
    private List<String> names = new ArrayList();
}
