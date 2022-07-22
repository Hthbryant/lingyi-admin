package com.lingyi.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lingyi.biz.entity.Player;
import com.lingyi.biz.mapper.PlayerMapper;
import com.lingyi.biz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: PlayerServiceImpl
 * date: 2022-07-23 0:22
 * Description:
 * version 1.0
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public List<Player> list(Player player) {
        return playerMapper.selectList(new QueryWrapper<>());
    }
}
