package com.document.pojo;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="document")
public class Document {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer documentId;
		private String documentName;
		private Date documentData;
		private String documentUrl;
		
		public Integer getDocumentId() {
			return documentId;
		}
		public void setDocumentId(Integer documentId) {
			this.documentId = documentId;
		}
		public String getDocumentName() {
			return documentName;
		}
		public void setDocumentName(String documentName) {
			this.documentName = documentName;
		}
		public Date getDocumentData() {
			return documentData;
		}
		public void setDocumentData(Date documentData) {
			this.documentData = documentData;
		}
		public String getDocumentUrl() {
			return documentUrl;
		}
		public void setDocumentUrl(String documentUrl) {
			this.documentUrl = documentUrl;
		}
		
		
}
