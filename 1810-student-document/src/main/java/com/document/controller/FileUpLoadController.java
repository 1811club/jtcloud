package com.document.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.document.service.FileService;

import feign.Response;


@Controller
public class FileUpLoadController {
		 @Autowired
		 private FileService fileService;
		 
		 @RequestMapping(value="document/upload",method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
		@ResponseBody
		 public int UpLoad(@RequestPart(value="file") MultipartFile uploadFile){
			 int result=fileService.UpLoad(uploadFile);
			 return result;
		 }
		 /**
		  * 查询所有文件
		  * @return
		  */
		 @RequestMapping("findAll")
		 @ResponseBody
		 public Map<String, String> findAll(){
			 Map<String,String> map=fileService.findAll();
			 return map;
		 }
		 
		 /**
		  * 下载文件
		  */
		 @RequestMapping("download")
		 public  ResponseEntity<byte[]> download(@RequestParam(value="url") String url){
			 
	         ResponseEntity<byte[]> entity = null;
	         InputStream in=null;
	          try {
	        	String name=url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("#"));
	        	String extname=url.substring(url.lastIndexOf("."));
	        	String realUrl=url.replaceAll("http://document.student.com/", "D:/webapp");
	           in=new FileInputStream(new File(realUrl));
	             
	           byte[] bytes = new byte[in.available()];
	             
	           in.read(bytes);
	           HttpHeaders heads = new HttpHeaders();
	           heads.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+name+extname);
	           heads.add(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE);

	          entity = new ResponseEntity <byte[]>(bytes,heads, HttpStatus.OK);
	            
	       } catch (Exception e) {
	           e.printStackTrace();
	       }finally {
	           if(in!=null) {
	               try {
	                   in.close();
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	       }
	         
	          return entity;

		 }
}
