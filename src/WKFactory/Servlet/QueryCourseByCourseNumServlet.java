package WKFactory.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WKFactory.Entity.CourseEntity;
import WKFactory.Entity.SubjectEntity;
import WKFactory.Entity.UserEntity;
import WKFactory.Factory.BllFacadeFactory;
import WKFactory.Interface.BllInterface;
import WKFactory.Tools.SampleDateFormat;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class QueryCourseByCourseNumServlet extends HttpServlet {
	private BllFacadeFactory bllFacadeFactory = BllFacadeFactory.getbBllFactoryInstance() ;
	private BllInterface bllInterface = bllFacadeFactory.getInterface() ;
	/**
	 * Constructor of the object.
	 */
	public QueryCourseByCourseNumServlet() {
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
		response.setCharacterEncoding("utf-8") ;
		response.setContentType("text/html;charset=utf-8") ;
		PrintWriter out = response.getWriter() ;
		
		String courseNum = request.getParameter( "CourseNum" ) ;
		System.out.println( "本次查询获得的CourseNum:" + courseNum );
		CourseEntity course = bllInterface.QueryCourseByCourseNum( courseNum ) ;
		System.out.println( "获得的学科编号为:"+ course.getSubId() ) ;
		SubjectEntity sub = bllInterface.QuerySubjectById ( course.getSubId() ) ;
		UserEntity user = bllInterface.QueryUserByUserNum( course.getUserNum() ) ;
		JSONObject json = new JSONObject() ;
		if( user != null ) {
			json.put( "UserNum" , user.getUserNum() ) ;
			json.put( "NickName" , user.getNickName() ) ;			
		}
		json.put( "CourseNum" , course.getCourseNum() ) ;
		json.put( "CourseName" , course.getCourseName() ) ;
		json.put( "CoverPicture", course.getCoverPicture() ) ;
		json.put( "CourseContent" , course.getCourseContent() ) ;
		json.put( "CourseType", course.getCourseType() ) ;
		json.put( "AudienceNum" , course.getAudienceNum() ) ;
		json.put( "SubscriptionNum", course.getSubscriptionNum() ) ;
		if( sub != null ) {
			json.put( "SubId", sub.getId() ) ;
			json.put( "SubjectName" , sub.getSubjectName() ) ;			
		}
		int period = bllInterface.showPeriod( course.getCourseNum() ) ;
		json.put( "Period" , period ) ;
		String createtime = SampleDateFormat.toYearMonthDayString( course.getCreatetime() ) ;
		json.put( "Createtime" , createtime ) ;
		System.out.println( json ) ;
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
