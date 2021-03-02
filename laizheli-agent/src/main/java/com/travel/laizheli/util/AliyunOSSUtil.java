package com.travel.laizheli.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName: AliyunOSSUtil
 * @Description: 阿里云对象存储服务
 * @Author: Wangcb
 * @Date: 2021/3/2 14:24
 * @Version: 1.0
 **/
@Slf4j
@Configuration
public class AliyunOSSUtil {

    private static String  endpoint;
    private static String  keyid;
    private static String  keysecret;
    private static String  bucketname;

    @Value("${oos.file.endpoint}")
    public void setEndpoint(String endpoint){
        AliyunOSSUtil.endpoint = endpoint;
    }
    @Value("${oos.file.keyid}")
    public void setKeyid(String keyid){
        AliyunOSSUtil.keyid = keyid;
    }
    @Value("${oos.file.keysecret}")
    public void setKeysecret(String keysecret){
        AliyunOSSUtil.keysecret = keysecret;
    }
    @Value("${oos.file.bucketname}")
    public void setBucketname(String bucketname){
        AliyunOSSUtil.bucketname = bucketname;
    }

    /**
     * @Description: 上传文件
     * @Param: file
     * @Param: fileHost
    **/
    public static String upload(MultipartFile multipartFile, String fileHost) throws IOException {
        if (multipartFile==null){
            return null;
        }

        //将multipartFile转换成File类型
        InputStream ins = multipartFile.getInputStream();
        File file=new File(multipartFile.getOriginalFilename());
        FileUploadUtil.inputStreamToFile(ins, file);
        log.info("-----------------文件上传开始----------------");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());

        //创建OSS存储实例
        OSSClient ossClient = new OSSClient(endpoint,keyid,keysecret);
        try {
            //容器不存在，就创建
            if(! ossClient.doesBucketExist(bucketname)) {
                ossClient.createBucket(bucketname);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketname);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = fileHost+"/"+(dateStr + "/" + UUID.randomUUID().toString().replace("-","")+"-"+file.getName());
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketname, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketname,CannedAccessControlList.PublicRead);
            if(null != result){
                log.info("-------------------OSS文件上传成功,OSS地址："+fileUrl);
                return "https://laizheli.oss-cn-hangzhou.aliyuncs.com/"+fileUrl;
            }
        }catch (OSSException oe){
            log.error(oe.getMessage());
        }catch (ClientException ce){
            log.error(ce.getMessage());
        }finally {
            ossClient.shutdown();
        }
        return null;
    }

    /**
     * @Description: 删除图片
     * @Param: fileKey 
    **/        
    public  String delete(String fileKey){
        try {
            // 创建OSS实例
            OSSClient ossClient = new OSSClient(endpoint,keyid,keysecret);

            if(!ossClient.doesBucketExist(bucketname)){
                log.info("==============>您的Bucket不存在");
                return "您的Bucket不存在";
            }else {
                log.info("==============>开始删除Object");
                ossClient.deleteObject(bucketname,fileKey);
                log.info("==============>Object删除成功："+fileKey);
                return "==============>Object删除成功："+fileKey;
            }
        }catch (Exception ex){
            log.info("删除Object失败",ex);
            return "删除Object失败";
        }
    }

}
