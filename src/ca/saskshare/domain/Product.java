package ca.saskshare.domain;

import java.util.Date;

public class Product {
	
	private long productId;
	private String title;
	private String description;
	private Date fromDate;
	private Date endDate;
	private long ownerId;
	private String summary;
	private String note;
	private String urlTitle;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	public String getNote() {
		return note;
	}
	
	public String getUrlTitle() {
		return urlTitle;
	}
	
	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}
}
