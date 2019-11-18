package com.zyc.controller;

import com.zyc.utils.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("page")
@PropertySource({"classpath:application.properties"})
public class PageController {

    @Value("${web.file.path}")
    private String realPath;


    @RequestMapping("index")
    public String index(){

        System.out.println(realPath);
        return "index";
    }

    @RequestMapping("exTest")
    @ResponseBody
    public Object exTest(){
        throw new MyException("500zyc","122");
    }

    @RequestMapping("upload")
    @ResponseBody
    public String upload(String name, @RequestParam("head_img")MultipartFile file, HttpServletRequest request){
        System.out.println(name);
        //获取文件名
        String filename = file.getOriginalFilename();
        System.out.println("文件名："+filename);
        String substring = filename.substring(filename.lastIndexOf('.'));
        System.out.println("文件名后缀："+substring);
        //获取文件夹的路径
        //request.getSession().getServletContext().getRealPath("/images");
        System.out.println("文件夹位置："+realPath);
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(path);
        //获取新的文件名
        filename = UUID.randomUUID()+substring;
        File file1 = new File(realPath+filename);
        try {
            file.transferTo(file1); //效率很高
            return filename;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
