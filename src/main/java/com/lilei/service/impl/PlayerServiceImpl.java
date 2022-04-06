package com.lilei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lilei.pojo.Player;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lilei.mapper.PlayerMapper;
import com.lilei.service.PlayerService;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Resource
    private PlayerMapper playerMapper;

    @Override
    public Player findByUIdList(Integer id) {
        QueryWrapper<Player> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",id);
        return playerMapper.selectOne(queryWrapper);
    }
}
