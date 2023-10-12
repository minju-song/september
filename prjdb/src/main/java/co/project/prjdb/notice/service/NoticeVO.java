package co.project.prjdb.notice.service;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private String noticeTitle;
	private String noticeSubject;
	private LocalDate noticeDate;
	private int noticeHit;
	private String noticeAttech;
	private String noticeImage;
	private String noticeWriterName; 
	private String noticeThumb;
}
