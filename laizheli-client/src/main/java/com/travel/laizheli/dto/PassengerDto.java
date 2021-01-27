package com.travel.laizheli.dto;

import com.travel.laizheli.entity.Credential;
import com.travel.laizheli.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Nemo
 * @date 2021/1/25
 * 此类将passenger类和credential类结合起来，作为数据的传输对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    // 旅客信息
    private long id;
    private String name;
    private String phone;
    private boolean type;
    private boolean self;
    private String userId;
    private Date createTime;

    // 证件信息
    private List<Credential> credentials;

    /**
     * 通过旅客个人信息和证件信息构造dto
     * @param passenger
     * @param credentials
     */
    public PassengerDto(Passenger passenger, List<Credential> credentials) {
        this.id = passenger.getId();
        this.name = passenger.getName();
        this.phone = passenger.getPhone();
        this.type = passenger.isType();
        this.self = passenger.isSelf();
        this.userId = passenger.getUserId();
        this.createTime = passenger.getCreateTime();

        this.credentials = credentials;
    }

    public List<Credential> getCredentials() {
        // 由于前端有可能传过来一些空的证件，所以需要排除一下
        this.credentials.removeIf(Objects::isNull);
        return credentials;
    }
}
