package com.xia.controller;

import com.xia.domain.Account;
import com.xia.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService service;

    @RequestMapping("/addStudent.do")
    public ModelAndView addAccount(Account account){
        ModelAndView mv = new ModelAndView();
        // 调用service处理account
        int nums = service.addAccount(account);
        String tips = "注册失败";
        if (nums > 0){
            tips = "学生【 + " + account.getName() + " + 】" + "注册成功";
        }
        mv.addObject("tips", tips);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/queryAccount.do")
    @ResponseBody
    public List<Account> queryAccount(){
        // 参数检查，简单的数据处理
        List<Account> accounts = new ArrayList<>();
        accounts = service.findAccount();
        System.out.println(accounts);
        return accounts;
    }
}
