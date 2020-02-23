package com.zhaojie.dianzan_demo.controller;

import com.github.pagehelper.PageInfo;
import com.zhaojie.dianzan_demo.bean.Zan;
import com.zhaojie.dianzan_demo.service.ZanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Api(tags = "接口所在处")
@Controller
public class ZanController {
        @Autowired
        ZanService zanService;


        @ApiOperation(value = "查询",httpMethod = "POST")
        @RequestMapping("/home")
        public String home(HttpServletRequest request,
                           @RequestParam(defaultValue = "1")Integer page,
                           @RequestParam(defaultValue = "3")Integer rows,
                           Zan zan){
            PageInfo<Zan> pageInfo = zanService.selectList(page,rows,zan);

            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("zan",zan);
            return "list";
        }
        @ApiOperation(value = "添加",httpMethod = "POST")
        @RequestMapping("insertObject")
        public String insertObject(Zan example)throws IOException{
            try {
             zanService.insertObject(example);
             return "redirect:/home";
            } catch (Exception e) {
             e.printStackTrace();
             return "redirect:/add";
           }
      }
    @ApiOperation(value = "根据id删除",httpMethod = "POST")
    @RequestMapping("delAll")
    @ResponseBody
    public boolean delAll(String id) {
        try {
            zanService.delAll(id);
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }@ApiOperation(value = "根据id查询",httpMethod = "POST")
    @RequestMapping("upd")
    public String upd(HttpServletRequest request ,Integer id){
        List<Zan> user = zanService.upd(id);
        request.setAttribute("user" ,user);
        return "userupd";
    }
    @ApiOperation(value = "修改",httpMethod = "POST")
    @RequestMapping("/updObject")
    public String updObject(Zan example) {
        System.out.println("修改"+example);
        try {
            zanService.updObject(example);
            return "redirect:/home";
        } catch (Exception e) {
            e.printStackTrace();
            return "userupd";
        }
    }
    @ApiOperation("根据id查看用户")
    @RequestMapping("/sel")
    public String selObject(HttpServletRequest request,Integer id){
        List<Zan> user = zanService.selObject(id);
        request.setAttribute("user", user);
        return "usersel";
    }
    @RequestMapping("/add")
    public String add() {
        return "useradd";
    }



}
