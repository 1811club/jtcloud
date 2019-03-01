package com.student.service;

import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import feign.Response;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@FeignClient(value="service-document",configuration=DocumentService.MultipartSupportConfig.class)
public interface DocumentService {
	
	@RequestMapping(value="document/upload",method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	int UpLoad(@RequestPart(value="file") MultipartFile uploadFile);
	
	@Configuration
	class MultipartSupportConfig{
		@Autowired  
	    private ObjectFactory<HttpMessageConverters> messageConverters;  
	          
	    @Bean  
	    public Encoder feignFormEncoder() {  
	        return new SpringFormEncoder(new SpringEncoder(messageConverters));  
	    }  
	}
	
	@RequestMapping("findAll")
	Map<String,String> findAll();
	
	@RequestMapping(value="download",method=RequestMethod.GET,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	ResponseEntity<byte[]> download(@RequestParam(value="url") String url);
}

