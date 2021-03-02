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
        return stringBuilder.toString();
    }

    /**
     * @Description: 生成存储路径 
    **/        
    public static String getPath() throws FileNotFoundException {
        String rootPath = ResourceUtils.getURL("classpath:").getPath();
        return rootPath+"static/image/upload/";
    }

    /**
     * @Description: 上传文件
    **/        
    public static String uploadFile(MultipartFile uploadFile) throws IOException {
        String filename = FileUploadUtil.getFilename(uploadFile);
        String rootPath = FileUploadUtil.getPath();
        File upload = new File(rootPath,filename);
        if (!upload.exists()){
            upload.mkdir();
        }
        log.info("图片存储路径为:"+upload.getAbsolutePath());
        uploadFile.transferTo(upload);
        return filename;
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

    /**
     * @Description: 将输入流转成File
     * @Param: ins
     * @Param: file 
    **/        
    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
