package com.zhaojie.dianzan_demo.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import com.zhaojie.dianzan_demo.bean.Zan;
import com.zhaojie.dianzan_demo.util.CreateExcelFile;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@Aspect
public class DemoControllerAop {
    @Pointcut("execution(* com.zhaojie.dianzan_demo.controller.ZanController.insertObject(..))")
    private void privileged() {
    }
    @AfterReturning("privileged()")
    public void  access(JoinPoint sp) throws Exception {
        Object[] args = sp.getArgs();
        Zan zan = (Zan) args[0];
        log.info("参数是:"+zan);
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(JSON.parseObject(JSON.toJSONString(zan), new TypeReference<Map<String, Object>>() {}));
        boolean b = CreateExcelFile.fileExist("E:\\zan.xls");
        if(b){
            log.info("文件是否存在:"+b);
            boolean flag = CreateExcelFile.XlsSheetExist("E:\\zan.xls", "zan");
            if(flag){
                CreateExcelFile.writeToExcelXls("E:\\zan.xls","zan",list);
                log.info("写入成功");
            }
        }else{
            List<String> list1 = new ArrayList<>();
            list1.add("zan");
            CreateExcelFile.createExcelXls("E:\\zan.xls",list1,new String[]{"id","name","title","zan"});
            log.info("文件创建成功");
            CreateExcelFile.writeToExcelXls("E:\\zan.xls","zan",list);
            log.info("写入成功");
        }
    }
}
