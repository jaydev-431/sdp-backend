package com.klef.sdp.sdpbackend.dto;

import java.time.LocalDateTime;

public class DiscussionDTO {

	 private Long id;
	    private String comment;
	    private Long citizenId;
	    private String citizenName;
	    private LocalDateTime addedAt;
	    
	    
	    
	    
		public LocalDateTime getAddedAt() {
			return addedAt;
		}
		public void setAddedAt(LocalDateTime addedAt) {
			this.addedAt = addedAt;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public Long getCitizenId() {
			return citizenId;
		}
		public void setCitizenId(Long citizenId) {
			this.citizenId = citizenId;
		}
		public String getCitizenName() {
			return citizenName;
		}
		public void setCitizenName(String citizenName) {
			this.citizenName = citizenName;
		}
		@Override
		public String toString() {
			return "DiscussionDTO [id=" + id + ", comment=" + comment + ", citizenId=" + citizenId + ", citizenName="
					+ citizenName + ", addedAt=" + addedAt + "]";
		}
		
		
		
}
