package com.travel.laizheli.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.UUID;

/**
 * @ClassName: FileUploadUtil
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 10:19
 * @Version: 1.0
 **/
@Slf4j
public class FileUploadUtil {

    /**
     * @Description: 生成文件名
     * @Param: uploadFile 
    **/        
    public static String getFilename(MultipartFile uploadFile){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UUID.randomUUID());// 使用UUID避免重名
        stringBuilder.append(uploadFile.getOriginalFilename());//获取原文件名
        log.info("新文件名为:"+stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * @Description: 生成存储路径 
    **/        
    public static String getPath() throws FileNotFoundException {
        String rootPath = ResourceUtils.getURL("classpath:").getPath();
        log.info("项目根路径为:"+rootPath);
        return rootPath+"static/image/upload/";
    }

    /**
     * @Description: 上传文件
    **/        
    public static void uploadFile(MultipartFile uploadFile) throws IOException {
        String filename = FileUploadUtil.getFilename(uploadFile);
        String rootPath = FileUploadUtil.getPath();
        File upload = new File(rootPath,filename);
        if (!upload.exists()){
            upload.mkdir();
        }
        log.info("图片存储路径为:"+upload.getAbsolutePath());
        uploadFile.transferTo(upload);
    }

    /**
     * @Description: base64字符串转图片文件
     * @Param: imgStr
     * @Param: imgFilePath
    **/
    public static boolean generateImage(String imgStr,String imgFilePath){
        // 裁剪base64的头
        int pos = imgStr.indexOf(";base64,");
        String data = imgStr.substring(pos+8);
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            FileOutputStream write = new FileOutputStream(new File(imgFilePath));
            byte[] decoderBytes = decoder.decodeBuffer(data.replace(" ", "+"));
            write.write(decoderBytes);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
