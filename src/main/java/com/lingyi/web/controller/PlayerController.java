package com.lingyi.web.controller;

import com.lingyi.biz.entity.Player;
import com.lingyi.biz.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 咕噜科
 * ClassName: PlayerController
 * date: 2022-07-21 23:48
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/player")
@Slf4j
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/hello")
    public String hello () {
        return "hello world";
    }

    @RequestMapping("/list")
    public List<Player> list (@RequestBody Player player) {
        return playerService.list(player);
    }

}
