package com.dugu.ddd.controller.user;

import com.dugu.base.open.result.PageResult;
import com.dugu.base.open.result.Result;
import com.dugu.ddd.common.user.ContactInfoDto;
import com.dugu.ddd.common.user.UserDto;
import com.dugu.ddd.common.user.request.UserQueryRequest;
import com.dugu.ddd.domain.service.user.UserService;
import com.dugu.ddd.infra.mw.message.NoticeEvent;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocEvent;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocState;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocStateContext;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.PfmDocEventFireService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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
    @Resource
    private PfmDocEventFireService pfmDocEventFireService;

    @ResponseBody
    public Result<Boolean> save() {
        return Result.success();
    }


    @RequestMapping("/list")
    @ResponseBody
    public PageResult<UserDto> list() {
        List<UserDto> data = new ArrayList<>();
        UserDto userDTO = new UserDto();
        userDTO.setName("刺魂");
        userDTO.setSex("F");
        UserQueryRequest request=new UserQueryRequest();
        request.setPageIndex(1);
        request.setPageSize(10);
        ContactInfoDto contactInfoDTO = new ContactInfoDto();
        contactInfoDTO.setEmail("zhaohaihua@163.com");
        contactInfoDTO.setTelephone("0571-82783811");
        userDTO.setContactInfo(contactInfoDTO);

        data.add(userDTO);

        return PageResult.success(data, 10L, request.getPageIndex(), request.getPageSize());
    }

    @RequestMapping("/trans")
    @ResponseBody
    public Boolean trans() {
        userService.saveUser();
        return Boolean.TRUE;
    }

    @RequestMapping("/state")
    @ResponseBody
    public Boolean state() {
        PfmDocStateContext ctx=PfmDocStateContext.builder()
                .event(new NoticeEvent())
                .operator(1L)
                .operateTime(new Date())
                .lockKey("kkk")
                .docId("1")
                .build();
        pfmDocEventFireService.fire(PfmDocState.PREPARE, PfmDocEvent.PLAN_START,ctx);
        return Boolean.TRUE;
    }
}
