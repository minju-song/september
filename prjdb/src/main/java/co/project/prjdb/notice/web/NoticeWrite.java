package co.project.prjdb.notice.web;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.project.prjdb.common.ThumbNail;
import co.project.prjdb.common.ViewResolve;
import co.project.prjdb.notice.service.NoticeService;
import co.project.prjdb.notice.service.NoticeVO;
import co.project.prjdb.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticewrite.do")
public class NoticeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeWrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 업로드 처리(Notice)
		ThumbNail thumbNail = new ThumbNail();
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String saveDir = getServletContext().getRealPath("attech/notice");//servletContext: prjdb, realPath: webapp/attech/notice 실제경로, 파일이 바로바로 보임 현업에서는 안씀
		int maxSize = 1024*1024*100; //100M byte
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());//파일명이 동일할때 자동으로 1,2,3..
		String imgFileName = multi.getOriginalFileName("imgfile");//원본파일명/OriginalFileName을 imgfile에 담아두겠다
		String realImg = multi.getFilesystemName("imgfile"); //저장되는 파일명
		vo.setNoticeImage(realImg); //이미지 파일 명을 저장한다.

		
		
		String fileExt = imgFileName.substring(imgFileName.lastIndexOf(".")+1);
		String thumb = thumbNail.makeThumbnail(saveDir + File.separator+imgFileName, imgFileName, fileExt,
				saveDir+File.separator);
		thumb= thumb.substring(thumb.lastIndexOf("\\")+1);
		vo.setNoticeThumb(thumb);
		
		
		String attech = multi.getOriginalFileName("attechfile");
		if(attech != null) {
			String attechFile =  multi.getFilesystemName("attechfile");
			vo.setNoticeAttech(attechFile);
		}
		vo.setNoticeWriter(multi.getParameter("noticeWriter"));
		vo.setNoticeDate(LocalDate.parse(multi.getParameter("noticeDate")));
		vo.setNoticeTitle(multi.getParameter("noticeTitle"));
		vo.setNoticeSubject(multi.getParameter("noticeSubject"));
		vo.setNoticeWriterName(multi.getParameter("noticeWriterName"));
		
		int n = dao.noticeInsert(vo);
		if(n != 0) {
			response.sendRedirect("noticeselectlist.do");//위임, 리스트를 다시 보여주라는 것
		}else {
			request.setAttribute("message", "게시글 등록이 실패했습니다.");
			String page = "notice/noticemessage";
			ViewResolve.forward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}