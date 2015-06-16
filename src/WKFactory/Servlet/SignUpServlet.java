package WKFactory.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WKFactory.Entity.UserEntity;
import WKFactory.Factory.BllFacadeFactory;
import WKFactory.Interface.BllInterface;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class SignUpServlet extends HttpServlet {
	private BllFacadeFactory bllFacadeFactory = BllFacadeFactory.getbBllFactoryInstance() ;
	private BllInterface bllInterface = bllFacadeFactory.getInterface() ;
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String UserName = new String ( request.getParameter("UserName")  ) ;
		String UserPassword = request.getParameter("UserPassword") ;
		String NickName = new String ( request.getParameter( "NickName" )  ) ;
		int UserType = Integer.parseInt( request.getParameter("UserType") ) ;
		UserEntity user = new UserEntity() ;
		String defaultPicture = "img/user-default.png" ;
		user.setUserPicture( defaultPicture ) ;
		user.setLoginNum( 0 ) ;
		Short isLock = 0 ;
		user.setIsLock( isLock ) ;
		user.setUserName(UserName) ;
		user.setUserPassword(UserPassword) ;
		user.setNickName(NickName) ;
		user.setUserType( UserType ) ;
		Timestamp timestamp = new Timestamp( System.currentTimeMillis() ) ;
		user.setRegTime( timestamp );
		
		JSONObject json = bllInterface.SignUp( user ) ;
		System.out.println( "result结果表是：\n 0：注册成功，1：账号重复,-1:注册失败\n"+json ) ;
		out.print(json) ;
		out.close() ;
	}
//	/**
//	 * Constructor of the object.
//	 */
//	public SignUpServlet() {
//		super();
//	}
//
//	/**
//	 * Destruction of the servlet. <br>
//	 */
//	public void destroy() {
//		super.destroy(); // Just puts "destroy" string in log
//		// Put your code here
//	}
//
//	/**
//	 * The doGet method of the servlet. <br>
//	 *
//	 * This method is called when a form has its tag value method equals to get.
//	 * 
//	 * @param request the request send by the client to the server
//	 * @param response the response send by the server to the client
//	 * @throws ServletException if an error occurred
//	 * @throws IOException if an error occurred
//	 */
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//	}
//
//	/**
//	 * The doPost method of the servlet. <br>
//	 *
//	 * This method is called when a form has its tag value method equals to post.
//	 * 
//	 * @param request the request send by the client to the server
//	 * @param response the response send by the server to the client
//	 * @throws ServletException if an error occurred
//	 * @throws IOException if an error occurred
//	 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//	}
//
//	/**
//	 * Initialization of the servlet. <br>
//	 *
//	 * @throws ServletException if an error occurs
//	 */
//	public void init() throws ServletException {
//		// Put your code here
//	}

}
