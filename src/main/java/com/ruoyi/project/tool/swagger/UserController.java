package com.ruoyi.project.tool.swagger;

import java.util.*;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.framework.security.LoginBody;
import com.ruoyi.framework.security.service.SysLoginService;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.app.controller.utils.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * swagger 用户测试方法
 *
 * @author ruoyi
 */
@Api("用户管理")
@RestController

public class UserController extends BaseController {

    @Autowired
    private SysLoginService loginService;

    /**
     * 登录方法
     *
     * @return 结果
     */
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名称", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String", dataTypeClass = String.class),
    })
    @PostMapping("/userlogin")
    public AjaxResult userLogin(@RequestBody UserEntity user) {

        String token = loginService.userLogin(user.getUsername(), user.getPassword());
        Map<String, String> res = new HashMap<String, String>();
        res.put(Constants.TOKEN, token);

        return success(res);
    }

}

@ApiModel(value = "UserEntity", description = "用户实体")
class UserEntity {


    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("用户密码")
    private String password;

    public UserEntity() {

    }

    public UserEntity(Integer userId, String username, String password, String mobile) {

        this.username = username;
        this.password = password;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
