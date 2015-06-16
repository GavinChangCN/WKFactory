package WKFactory.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WKFactory.Entity.AudienceRecorderEntity;
import WKFactory.Entity.CourseEntity;
import WKFactory.Factory.BllFacadeFactory;
import WKFactory.Interface.BllInterface;
import net.sf.json.JSONObject;

public class AudienceCourseServlet extends HttpServlet {
	private BllFacadeFactory bllFacadeFactory = BllFacadeFactory.getbBllFactoryInstance() ;
	private BllInterface bllInterface = bllFacadeFactory.getInterface() ;
	/**
	 * Constructor of the object.
	 */
	public AudienceCourseServlet() {
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

		this.doPost(request, response) ;
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
		
		String userNum = request.getParameter("UserNum" )  ;
		String courseNum = request.getParameter( "CourseNum" ) ;
		CourseEntity c = bllInterface.QueryCourseByCourseNum(courseNum) ;
		AudienceRecorderEntity ar = new AudienceRecorderEntity() ;
		ar.setCourseNum( courseNum ) ;
		ar.setUserNum( userNum ) ;
		ar.setRecorderTime( new Timestamp( System.currentTimeMillis() ) ) ;
		CourseEntity course = new CourseEntity() ;
		course.setId( c.getId() ) ;
		JSONObject json = bllInterface.CreateAudienceRecorder( ar ) ;
		// result：0：创建观看记录成功，1：已经存在观看记录，所以不增加观看数
		if( json.getInt( "result" ) == 0 ) {
			bllInterface.AddCourseAudienceNum( course ) ;
		}
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
