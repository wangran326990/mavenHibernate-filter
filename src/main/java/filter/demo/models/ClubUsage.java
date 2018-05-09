package filter.demo.models;

import java.util.Date;


import javax.persistence.*;

@Entity
@Table(name="clubusage")
public class ClubUsage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="UserID")
	private String userId;
	@Column(name="PageID")
	private String pageId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="VisitDate")
	private Date visitDate;
	@Temporal(TemporalType.TIME)
	@Column(name="VisitTime")
	private Date visitTime;
	@Column(name="Allowed")
	private char allowed;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TimeStamp")
	private Date timeStamp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public char getAllowed() {
		return allowed;
	}
	public void setAllowed(char allowed) {
		this.allowed = allowed;
	}
	@Override
	public String toString() {
		return "ClubUsage [id=" + id + ", userId=" + userId + ", pageId=" + pageId + ", visitDate=" + visitDate
				+ ", visitTime=" + visitTime + ", allowed=" + allowed + ", timeStamp=" + timeStamp + "]";
	}

}
