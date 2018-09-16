package com.gglee.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 댓글 정보를 담는 모델 클래스
 * 
 * @author gglee
 */
@Alias("reply")
public class ReplyVO {
	
	private Integer rno;
	private Integer bno;
	private String replytext;
	private String replyer;
	private Date regDate;
	private Date updatedate;

	public ReplyVO() {
	}

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "[" + "rno=" + rno + ", bno=" + bno + ", replyer=" + replyer + ", replytext=" + replytext + "]";
	}

}
