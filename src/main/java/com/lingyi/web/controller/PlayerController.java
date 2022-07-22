package com.lingyi.web.controller;

import com.lingyi.common.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private HttpUtil httpUtil;

    @RequestMapping("/hello")
    public String hello () {
        return "hello world";
    }

    @RequestMapping("/list")
    public String list () {
        String url = "http://localhost:1580/capricorn/player/list";
        String result = httpUtil.postForString(url, null);
        log.info("player list :{}",result);
        return result;
    }

}
