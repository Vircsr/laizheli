package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.travel.laizheli.entity.Supplier;
import com.travel.laizheli.mapper.SupplierMapper;
import com.travel.laizheli.service.ISupplierService;
import org.springframework.stereotype.Service;

/**
 * @author Nemo
 * @date 2021/2/1
 */
@Service
public class SupplierService extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {
}
