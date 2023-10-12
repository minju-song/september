package co.project.prjdb.notice.service;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int replyId;
	private int noticeId;
	private String replyer;
	private String reply;
	private Date replyDate;
	private Date updateDate;
}
