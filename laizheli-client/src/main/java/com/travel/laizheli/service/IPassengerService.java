package com.travel.laizheli.service;

import com.travel.laizheli.entity.Contact;
import com.travel.laizheli.entity.Passenger;

import java.util.List;

/**
 * @author Nemo
 * @date 2021/1/25
 */
public interface IPassengerService {
    /**
     * 根据现在登录的用户搜索属于他的所有联系人
     * @param userId
     * @return
     */
    List<Passenger> getAllPassengersByUserId(String userId);

    /**
     * 为当前用户添加旅客，这里不需要userid，前端将userid写在隐藏域中即可
     * @param passenger
     * @return
     */
    int addPassenger(Passenger passenger);

    /**
     * 通过id删除旅客，这里id是唯一的，所以不需要知道是哪个用户的旅客
     * @param id
     * @return
     */
    int delPassengerById(long id);


    /**
     * 通过id得到旅客，方便之后进行修改
     * @param id
     * @return
     */
    Passenger getPassengerById(long id);

    /**
     * 修改旅客信息，虽然可能涉及到默认旅客的修改，但是passenger里面包含了userid
     * @param passenger
     * @return
     */
    int updatePassenger(Passenger passenger);
}
