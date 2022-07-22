package com.lingyi.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lingyi.biz.entity.Player;
import com.lingyi.biz.mapper.PlayerMapper;
import com.lingyi.biz.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    @Cacheable(value = {"playerList"},key = "#player.age")
    public List<Player> list(Player player) {
        log.info("query playerList start...");
        QueryWrapper<Player> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",player.getAge());
        List<Player> players = playerMapper.selectList(queryWrapper);
        log.info("players : {}",players);
        return players;
    }
}
