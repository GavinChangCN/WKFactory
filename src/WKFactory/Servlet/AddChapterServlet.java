package WKFactory.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WKFactory.Entity.ChapterEntity;
import WKFactory.Entity.CourseEntity;
import WKFactory.Factory.BllFacadeFactory;
import WKFactory.Interface.BllInterface;
import net.sf.json.JSONObject;

public class AddChapterServlet extends HttpServlet {
	private BllFacadeFactory bllFacadeFactory = BllFacadeFactory.getbBllFactoryInstance() ;
	private BllInterface bllInterface = bllFacadeFactory.getInterface() ;
	/**
	 * Constructor of the object.
	 */
	public AddChapterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userNum = request.getParameter( "UserNum" ) ;
		System.out.println( "获取的用户Num：" + userNum ) ;
		String courseNum = request.getParameter("CourseNum") ;
		CourseEntity c = new CourseEntity() ; 
		c.setUserNum( userNum ) ;
		c.setCourseNum( courseNum ) ;
		// isMyCourse = true ，证明新建章节的用户是课程的创建者，否则不是课程的创建者
		JSONObject json = new JSONObject() ;
		if ( !bllInterface.isMyCourse( c ) ) {
			// json result = 2 ,非课程创建者上传的章节，不予保存
			json.put( "result" , 2 ) ;
		} else {
			ChapterEntity chapter = new ChapterEntity() ;
			chapter.setChapterName( request.getParameter("ChapterName") ) ;
			chapter.setCourseNum( courseNum ) ;
			System.out.println( "得到的CourseNum：" + chapter.getCourseNum() ) ;
			chapter.setChapterContent( new String( request.getParameter("ChapterContent")) ) ;
			chapter.setListId( Integer.parseInt( request.getParameter("ListID").toString() ) ) ;
			chapter.setChapterVideo( new String( request.getParameter( "VideoAddress" ) ) ) ;
			chapter.setChapterVideoName( new String(request.getParameter( "VideoName" ) ) ) ;
			chapter.setCreateTime( new Timestamp( System.currentTimeMillis() ) ) ;
			chapter.setPid( 0 ) ;
			chapter.setCourseNum( courseNum ) ;
			Short isComment = 1 ;
			chapter.setIsComment( isComment ) ;
			short check = 0 ;
			chapter.setIsChecked( check ) ;
			// json result = 0 ,新建章节成功，result = 1 ，新建章节失败
			json = bllInterface.AddChapter( chapter ) ;			
		}
		System.out.println( "result：0-创建章节成功，1-创建章节失败，2-非本人创建的课程，不允许上传视频");
		System.out.println(json);
		out.print( json ) ;
		out.close() ;
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
