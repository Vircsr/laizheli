package com.travel.laizheli.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.dto.PassengerDto;
import com.travel.laizheli.entity.Credential;
import com.travel.laizheli.entity.Passenger;
import com.travel.laizheli.mapper.CredentialMapper;
import com.travel.laizheli.service.ICredentialService;
import com.travel.laizheli.service.IPassengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nemo
 * @date 2021/1/25
 */
@RestController
@RequestMapping("passenger")
@Slf4j
public class PassengerController {

    @Autowired
    private IPassengerService passengerService;

    @Autowired
    private ICredentialService credentialService;


    /**
     * 查询属于该用户的所有旅客信息，旅客信息包括旅客个人信息与旅客证件信息
     * @param userId
     * @return
     */
    @GetMapping("/all/{userId}")
    public Result getAllPassengers(@PathVariable String userId) {
        List<PassengerDto> passengerDtos = new ArrayList<>();
        // 根据用户id查出所有属于他的旅客
        List<Passenger> allPassengers = passengerService.getAllPassengersByUserId(userId);
        allPassengers.forEach(passenger -> {
            // 1. 根据旅客id查出所有对应的证件列表
            List<Credential> credentialsByPId = credentialService.getCredentialsByPassengerId(passenger.getId());

            // 2. 直接将此旅客与证件列表构造成passengerDto
            PassengerDto passengerDto = new PassengerDto(passenger, credentialsByPId);

            // 3. 将此dto加入列表中
            passengerDtos.add(passengerDto);
        });

        log.info(passengerDtos.toString());
        if (!allPassengers.isEmpty()) {
            return Result.success(passengerDtos);
        } else {
            return Result.failed();
        }
    }

    /**
     * 添加旅客，这里不需要userid，前端将userid写在隐藏域中即可
     * @param passengerDto 旅客所有信息
     * @return
     */
    @Transactional
    @PostMapping("/passenger")
    public Result addPassenger(@RequestBody PassengerDto passengerDto) {
        // 设置旅客的创建日期
        DateTime now = DateTime.now();
        passengerDto.setCreateTime(now);

        Passenger passenger = new Passenger(passengerDto);

        // 这里由于我们的主键id是自增的，我在passenger类中标明了，所以这里插入可以直接获取到主键值（mbp功能可自行查阅官网）
        int addPassengerResult = passengerService.addPassenger(passenger);

        // 设置证件的创建日期与旅客id
        passengerDto.getCredentials().forEach(credential -> {
            credential.setPassengerId(passenger.getId());
            credential.setCreateTime(now);
        });

        boolean saveCredentialsResult = credentialService.saveBatch(passengerDto.getCredentials());

        if (addPassengerResult > 0  && saveCredentialsResult) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }

    /**
     * 通过id删除旅客
     * @param id 旅客id
     * @return
     */
    @Transactional
    @DeleteMapping("/passenger/{id}")
    public Result delPassengerById(@PathVariable long id) {
        // 删除旅客个人信息
        int result = passengerService.delPassengerById(id);

        // 删除旅客证件信息
        QueryWrapper<Credential> credentialQueryWrapper = new QueryWrapper<>();
        credentialQueryWrapper.eq("passenger_id", id);
        boolean removeResult = credentialService.remove(credentialQueryWrapper);

        if (result > 0 && removeResult) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }


    /**
     * 通过旅客id找到旅客信息，包括旅客个人信息与证件信息
     * @param id 旅客id
     * @return
     */
    @GetMapping("/passenger/{id}")
    public Result getPassengerById(@PathVariable long id) {
        // 旅客个人信息
        Passenger passengerById = passengerService.getPassengerById(id);

        // 证件信息
        QueryWrapper<Credential> credentialQueryWrapper = new QueryWrapper<>();
        credentialQueryWrapper.eq("passenger_id", id);
        List<Credential> credentials = credentialService.list(credentialQueryWrapper);

        if (passengerById != null) {
            return Result.success(new PassengerDto(passengerById, credentials));
        } else {
            return Result.failed();
        }
    }

    /**
     * 修改旅客，因为参数旅客中已经包含了id信息了，所以无需id
     * @param passengerDto
     * @return
     */
    @PutMapping("/passenger")
    public Result updatePassenger(@RequestBody PassengerDto passengerDto) {
        // 修改旅客个人信息
        int result = passengerService.updatePassenger(new Passenger(passengerDto));

        // 修改证件信息
        boolean updateBatchById = credentialService.updateBatchById(passengerDto.getCredentials());

        if (result > 0 && updateBatchById) {
            log.info("修改旅客：" + passengerDto.toString());
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }
}
