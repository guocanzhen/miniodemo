package com.guocz.controller;

import com.guocz.result.Result;
import com.guocz.util.MinIoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author guocz
 * @date 2022/8/30 14:34
 */
@RestController
@RequestMapping("minio")
public class MinIoController {

    @Autowired
    private MinIoUtils minIoUtils;

    /**
     * 存储桶名称
     */
    private static final String MINIO_BUCKET = "img";

    @PostMapping(value = "/upload")
    public Result upload(@RequestParam(value = "files") MultipartFile files){
        try {
            return Result.ok(minIoUtils.upload(files,MINIO_BUCKET,null));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/download")
    public void download(@RequestParam("minFileName")String minFileName, HttpServletResponse response){
        minIoUtils.download(response,"img",minFileName);
    }
}
