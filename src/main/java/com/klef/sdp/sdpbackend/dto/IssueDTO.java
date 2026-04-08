package com.klef.sdp.sdpbackend.dto;

public class IssueDTO {

	
	  private Long id;
	    private String pollingStation;
	    private String issueType;
	    private String report;
	    private String citizenName;
//	    private String stat
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPollingStation() {
			return pollingStation;
		}
		public void setPollingStation(String pollingStation) {
			this.pollingStation = pollingStation;
		}
		public String getIssueType() {
			return issueType;
		}
		public void setIssueType(String issueType) {
			this.issueType = issueType;
		}
		public String getReport() {
			return report;
		}
		public void setReport(String report) {
			this.report = report;
		}
		public String getCitizenName() {
			return citizenName;
		}
		public void setCitizenName(String citizenName) {
			this.citizenName = citizenName;
		}
		@Override
		public String toString() {
			return "IssueDTO [id=" + id + ", pollingStation=" + pollingStation + ", issueType=" + issueType
					+ ", report=" + report + ", citizenName=" + citizenName + "]";
		}
		
}
