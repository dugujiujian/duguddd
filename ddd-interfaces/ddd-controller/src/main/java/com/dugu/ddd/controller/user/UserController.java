package com.dugu.ddd.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author cihun
 * @date 2021-10-09 7:14 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {
//
//    @ResponseBody
//    public Result<Boolean> save() {
//        return Result.success();
//    }
//
//
//    @RequestMapping("/list")
//    @ResponseBody
//    public PageResult<UserDTO> list(@RequestBody UserQueryRequest request) {
//        List<UserDTO> data = new ArrayList<>();
//        UserDTO userDTO=new UserDTO();
//        userDTO.setName("刺魂");
//        userDTO.setSex("F");
//
//        ContactInfoDTO contactInfoDTO=new ContactInfoDTO();
//        contactInfoDTO.setEmail("zhaohaihua@163.com");
//        contactInfoDTO.setTelephone("0571-82783811");
//        userDTO.setContactInfo(contactInfoDTO);
//
//        data.add(userDTO);
//
//        return PageResult.success(data, 10L, request.getPageIndex(), request.getPageSize());
//    }
}
