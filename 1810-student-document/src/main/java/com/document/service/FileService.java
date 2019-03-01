package com.document.service;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.util.UUIDUtil;
import com.jt.common.util.UploadUtil;
import com.document.mapper.DocumentMapper;
import com.document.pojo.Document;

@Service
public class FileService {
	@Autowired
	private DocumentMapper documentMapper;
	
	/**
	 * 文件保存的方法
	 * @param uploadFile
	 * @return	1 保存成功 0 保存失败
	 */
	public int UpLoad(MultipartFile uploadFile) {
		//获取文件名
		String oldName=uploadFile.getOriginalFilename();
		
		//获取文件后缀
		String extName=oldName.substring(oldName.lastIndexOf("."));
		String preName=oldName.split("\\.")[0];
		//判断后缀是否满足条件
		if(!extName.matches("^.(docx|txt|ppt|pdf)$")){
			return 0;
		}
		//生成路径
		String dir=UploadUtil.getUploadPath(oldName, "/upload/");
		String path="D:/webapp"+dir;
		String urlPath="http://document.student.com/"+dir;
		
		File _dir=new File(path);
		if(!_dir.exists()){
			_dir.mkdirs();
		}
		
		String fileName=preName+"#"+UUIDUtil.getUUID()+extName;
		try {
			uploadFile.transferTo(new File(path+fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} 
		
		//封装document对象
		Document doc=new Document();
		Date utilDate=new Date();
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		doc.setDocumentName(fileName);
		doc.setDocumentUrl(urlPath+fileName);
		doc.setDocumentData(sqlDate);
		
		int result=documentMapper.insert(doc);
		
		if(result==1){
			return 1;
		}else{
			return 0;
		}
	}

	public Map<String, String> findAll() {
		List<Document> docs=documentMapper.selectAll();
		Map<String,String> map=new HashMap<>();
		for(Document doc:docs){
			String name=doc.getDocumentName().split("#")[0];
			map.put(name, doc.getDocumentUrl());
		}
		return map;
	}

}
