package com.teacher.serviceimpl;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("String-Hi")
public interface HiService {

}
