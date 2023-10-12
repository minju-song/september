package co.project.prjdb.member.service;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberTel;
	private LocalDate memberEnterDate;
}
