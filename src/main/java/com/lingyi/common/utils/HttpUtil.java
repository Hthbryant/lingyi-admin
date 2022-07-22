package com.lingyi.common.utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * @author 咕噜科
 * ClassName: HttpUtil
 * date: 2022-07-21 23:50
 * Description:
 * version 1.0
 */
@Component
public class HttpUtil {

    private RestTemplate restTemplate;

    private HttpHeaders headers;

    @Value("${http.readTimeout}")
    private int readTimeout;

    @Value("${http.connectTimeout}")
    private int connectTimeout;

    @PostConstruct
    public void init () {
        initHeaders();
        initRestTemplate();
    }

    public void initRestTemplate () {
        CloseableHttpClient httpClient = HttpClients.custom().setMaxConnPerRoute(200).setMaxConnTotal(200).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        requestFactory.setReadTimeout(readTimeout);
        requestFactory.setConnectTimeout(connectTimeout);
        restTemplate = new RestTemplate(requestFactory);
    }

    public void initHeaders () {
        headers = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=utf-8");
        headers.setContentType(mediaType);
    }

    public <T> T postForObject (String url,String requestJson,Class<T> responseType) {
        HttpEntity<String> httpEntity = new HttpEntity<>(requestJson,headers);
        return restTemplate.postForObject(url,httpEntity,responseType);
    }

    public String postForString (String url,String requestJson) {
        HttpEntity<String> httpEntity = new HttpEntity<>(requestJson,headers);
        return restTemplate.postForObject(url,httpEntity,String.class);
    }

    public <T> T getForObject (String url,String requestJson,Class<T> responseType) {
        HttpEntity<String> httpEntity = new HttpEntity<>(requestJson,headers);
        return restTemplate.getForObject(url,responseType,httpEntity);
    }

    public String getForString (String url,String requestJson) {
        HttpEntity<String> httpEntity = new HttpEntity<>(requestJson,headers);
        return restTemplate.getForObject(url,String.class,httpEntity);
    }
}
