package com.student.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.student.service.DocumentService;

import feign.Response;

@Controller
public class DocumentController {
	@Autowired
	private DocumentService documentService;
		/**
		 * 文件上传
		 * @param uploadFile
		 * @return
		 */
	 @RequestMapping(value="ServletUploadFile")
	 @ResponseBody
	 public String UpLoad(@RequestPart("file")  MultipartFile uploadFile){
		 int result=documentService.UpLoad(uploadFile);
		 if(result==1){
			 return "上传成功";
		 }else{
			 return "上传失败";
		 }
	 }
	 
	 /**
	  * 查询全部文件
	  * @param model
	  * @return
	  */
	 @RequestMapping("ServletListFile")
	 public String DocumentList(Model model){
		 Map<String,String> map=documentService.findAll();
		 model.addAttribute("map",map);
		 return "admin/fileList";
	 }
	 
	 /**
	  * 文件下载
	  */
	 @RequestMapping("ServletDownloadFile")
 public  ResponseEntity<byte[]> download(@RequestParam(value="url") String url){
	 			return documentService.download(url);
 }
	 
	
	  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
