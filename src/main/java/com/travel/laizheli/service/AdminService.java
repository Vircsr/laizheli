package com.travel.laizheli.service;

import com.travel.laizheli.entity.Admin;
/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/1/25 8:58
 * @Version：
 */
public interface AdminService {
    Admin getByName(String name,String password);
}