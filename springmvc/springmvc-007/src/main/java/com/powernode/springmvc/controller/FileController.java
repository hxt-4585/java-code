package com.powernode.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

@Controller
public class FileController {
    @PostMapping("/file/up")
    public String fileUp(@RequestParam("fileName")MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String name = multipartFile.getName();
        // 获取前端表单中上传文件字段的name值
        System.out.println(name);

        String originalFilename = multipartFile.getOriginalFilename();
        // 源文件名字
        System.out.println(originalFilename);

        InputStream inputStream = multipartFile.getInputStream();
        // 创建一个File对象，指向服务器上的upload文件夹。
        // getRealPath("/upload")返回的是项目根目录下的upload文件夹的绝对路径
        File file = new File(request.getServletContext().getRealPath("/upload"));

        // 如果该文件夹不存在，则创建该目录
        if(!file.exists()){
            file.mkdirs();
        }

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath() + "/" + UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."))));
        byte[] bytes = new byte[1024 * 100];
        int readCount = 0;

        while ((readCount = inputStream.read(bytes)) != -1){
            out.write(bytes, 0, readCount);
        }

        out.flush();

        inputStream.close();
        out.close();

        return "ok";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletResponse response, HttpServletRequest request) throws IOException {
        File file = new File(request.getServletContext().getRealPath("/upload") + "/1.jpeg");
        // 创建响应头对象
        HttpHeaders headers = new HttpHeaders();
        // 设置响应内容类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 设置下载文件的名称
        headers.setContentDispositionFormData("attachment", file.getName());

        // 下载文件
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(Files.readAllBytes(file.toPath()), headers, HttpStatus.OK);
        return entity;
    }
}
