package com.dugu.ddd.controller.user;

import com.dugu.ddd.common.base.result.PageResult;
import com.dugu.ddd.common.base.result.Result;
import com.dugu.ddd.common.user.ContactInfoDTO;
import com.dugu.ddd.common.user.UserDTO;
import com.dugu.ddd.common.user.request.UserQueryRequest;
import com.dugu.ddd.domain.service.user.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author cihun
 * @date 2021-10-09 7:14 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    public Result<Boolean> save() {
        return Result.success();
    }


    @RequestMapping("/list")
    @ResponseBody
    public PageResult<UserDTO> list(@RequestBody UserQueryRequest request) {
        List<UserDTO> data = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        userDTO.setName("刺魂");
        userDTO.setSex("F");

        ContactInfoDTO contactInfoDTO = new ContactInfoDTO();
        contactInfoDTO.setEmail("zhaohaihua@163.com");
        contactInfoDTO.setTelephone("0571-82783811");
        userDTO.setContactInfo(contactInfoDTO);

        data.add(userDTO);

        return PageResult.success(data, 10L, request.getPageIndex(), request.getPageSize());
    }

    @RequestMapping("/trans")
    @ResponseBody
    public Boolean trans() {
        userService.transactionTest();
        return Boolean.TRUE;
    }
}
