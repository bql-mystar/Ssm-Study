package com.xie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xie.domain.User;
import com.xie.domain.VO;
import com.xie.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="/quick", method= RequestMethod.GET, params={"username"})
    public String save(){
        System.out.println("saving......");
        return "success";
    }

    @RequestMapping(value="/quick2")
    public ModelAndView qucik2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("username", "xrz");
        return modelAndView;
    }

    @RequestMapping(value="/quick3")
    public ModelAndView qucik3(ModelAndView modelAndView){
        modelAndView.setViewName("success");
        modelAndView.addObject("username", "xie");
        return modelAndView;
    }

    @RequestMapping(value="/quick4")
    public String qucik4(Model model){
        model.addAttribute("username", "rong");
        return "success";
    }

    @RequestMapping(value="/quick5")
    public String qucik5(HttpServletRequest request){
        request.setAttribute("username", "bql");
        return "success";
    }

    @RequestMapping(value="/quick6")
    public void qucik6(HttpServletResponse response) throws IOException {
        response.getWriter().println("bai");
    }

    @RequestMapping(value="/quick7")
    @ResponseBody
    public String qucik7()  {
        return "bai";
    }

    @RequestMapping(value="/quick8")
    @ResponseBody
    public String qucik8() throws JsonProcessingException {
        User user = new User();
        user.setUsername("bai");
        user.setAge(30);
        // 使用Jackson转换工具将对象转换成json字符串
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value="/quick9")
    @ResponseBody
    public User qucik9()  {
        User user = new User();
        user.setUsername("bql");
        user.setAge(30);
        return user;
    }

    @RequestMapping(value="/quick10")
    @ResponseBody
    public List<User> qucik10()  {
        ArrayList<User> list = new ArrayList<User>();
        for (int i = 0; i < 4; i++) {
            list.add(new User("zhangsan", new Random().nextInt(10)));
        }
        return list;
    }

    @RequestMapping(value="/quick11")
    @ResponseBody
    public void qucik11(String username, int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value="/quick12")
    @ResponseBody
    public void qucik12(User user){
        System.out.println(user);
    }

    @RequestMapping(value="/quick13")
    @ResponseBody
    public void qucik13(String[] hobbies){
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
    }

    // 使用VO对象获取集合数据
    @RequestMapping(value="/quick14")
    @ResponseBody
    public void qucik14(VO vo){
        System.out.println(vo);
    }

    @RequestMapping(value="/quick15")
    @ResponseBody
    public void qucik15(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    @RequestMapping(value="/quick16")
    @ResponseBody
    public void qucik16(@RequestParam("name") String username){
        System.out.println(username);
    }

    // 使用Restful风格
    @RequestMapping(value="/quick17/{id}")
    @ResponseBody
    public void qucik17(@PathVariable("id") int id){
        System.out.println(id);
    }

    @RequestMapping(value="/quick18")
    @ResponseBody
    public void qucik18(Date date){
        System.out.println(date);
    }

    @RequestMapping(value="/quick19")
    @ResponseBody
    public void qucik19(@RequestHeader("User-Agent") String user_agent){
        System.out.println(user_agent);
    }

    @RequestMapping(value="/quick20")
    @ResponseBody
    public void qucik20(@CookieValue("JSESSIONID") String jsessionId){
        System.out.println(jsessionId);
    }

    @RequestMapping(value="/quick21")
    @ResponseBody
    public void qucik21(String name, MultipartFile file) throws IOException {
        System.out.println(name);
        System.out.println(file);
        // 获得上传文件名称
        String filename = file.getOriginalFilename();
        // 保存文件
//        file.transferTo(new File("./" + filename));
        File f = new File("D:\\" + filename);
        System.out.println(f.getAbsolutePath());
        file.transferTo(f);
    }

    @RequestMapping(value="/quick22")
    public ModelAndView qucik22(ModelAndView mv) {
        mv.addObject("name", "xrz");
        mv.setViewName("interceptor");
        return mv;
    }

    @RequestMapping(value="/quick23")
    @ResponseBody
    public void qucik23() {
        // 抛出类型转换异常
        throw new ClassCastException();
    }

    @RequestMapping(value="/quick24")
    @ResponseBody
    public void qucik24() {
        // 抛出分母为0异常
        int i = 1 / 0;
    }

    @RequestMapping(value="/quick25")
    @ResponseBody
    public void qucik25() throws MyException {
        // 抛出自定义异常
        throw new MyException();
    }

}
