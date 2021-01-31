package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.travel.laizheli.entity.Help;
import com.travel.laizheli.mapper.HelpMapper;
import com.travel.laizheli.service.IHelpService;
import org.springframework.stereotype.Service;

/**
 * @author Nemo
 * @date 2021/1/28
 */
@Service
public class HelpService extends ServiceImpl<HelpMapper, Help> implements IHelpService {
}
