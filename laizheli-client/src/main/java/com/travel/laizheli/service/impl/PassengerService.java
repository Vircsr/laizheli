package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Passenger;
import com.travel.laizheli.mapper.PassengerMapper;
import com.travel.laizheli.service.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nemo
 * @date 2021/1/25
 */
@Service
public class PassengerService implements IPassengerService {

    @Autowired
    private PassengerMapper passengerMapper;
    /**
     * 根据现在登录的用户搜索属于他的所有旅客
     *
     * @param userId
     * @return
     */
    @Override
    public List<Passenger> getAllPassengersByUserId(String userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        List<Passenger> passengers = passengerMapper.selectList(queryWrapper);
        return passengers;
    }

    /**
     * 工具方法，仅在本类中使用
     * 修改当前旅客为默认旅客，即 将此用户的其他的默认旅客取消
     * @param passenger
     */
    private void updateDefaultPassenger(Passenger passenger) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Map map = new HashMap();
        map.put("user_id", passenger.getUserId());
        map.put("self", true);
        queryWrapper.allEq(map);
        Passenger defaultPassenger = passengerMapper.selectOne(queryWrapper);

        if (defaultPassenger != null) {
            defaultPassenger.setSelf(false);
            passengerMapper.updateById(defaultPassenger);
        }
    }
    /**
     * 为当前用户添加旅客，这里不需要userid，前端将userid写在隐藏域中即可
     *
     * @param passenger
     * @return
     */
    @Override
    public int addPassenger(Passenger passenger) {
        // 添加旅客时可能涉及到默认旅客的变更，所以要进行判断
        if (passenger.isSelf()) {
            updateDefaultPassenger(passenger);
        }
        int result = passengerMapper.insert(passenger);
        return result;
    }

    /**
     * 通过id删除旅客，这里id是唯一的，所以不需要知道是哪个用户的旅客
     *
     * @param id
     * @return
     */
    @Override
    public int delPassengerById(long id) {
        int result = passengerMapper.deleteById(id);
        return result;
    }

    /**
     * 通过id得到旅客，方便之后进行修改
     *
     * @param id
     * @return
     */
    @Override
    public Passenger getPassengerById(long id) {
        return passengerMapper.selectById(id);
    }

    /**
     * 修改旅客信息，虽然可能涉及到默认旅客的修改，但是passenger里面包含了userid
     *
     * @param passenger
     * @return
     */
    @Override
    public int updatePassenger(Passenger passenger) {
        // 修改旅客时可能涉及到默认旅客的变更，所以要进行判断
        if (passenger.isSelf()) {
            updateDefaultPassenger(passenger);
        }
        int result = passengerMapper.updateById(passenger);
        return result;
    }
}
