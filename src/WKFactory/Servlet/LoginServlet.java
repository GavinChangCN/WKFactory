package WKFactory.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WKFactory.Entity.UserEntity;
import WKFactory.Factory.BllFacadeFactory;
import WKFactory.Interface.BllInterface;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	private BllFacadeFactory bllFacadeFactory = BllFacadeFactory.getbBllFactoryInstance() ;
	private BllInterface bllInterface = bllFacadeFactory.getInterface() ;
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("UserName") ;
		String userPassword = new String ( request.getParameter( "UserPassword" ) ) ;
		UserEntity user = new UserEntity() ;
		user.setUserName(userName) ;
		user.setUserPassword(userPassword) ;
		JSONObject json = bllInterface.Login( user ) ;
		if ( json.getString( "result").equals( "0" ) ) {
			String userNum = json.getString("UserNum") ;
			String nickName = json.getString( "NickName" ) ;
			int userTypeInt = json.getInt( "UserType" ) ;
			String userType = ""+userTypeInt ;
			// Cookie传值
			Cookie couserNickName = new Cookie( "NickName" , nickName ) ;
			Cookie couserUserNum = new Cookie( "UserNum" , userNum ) ;
			Cookie courseUserType = new Cookie( "UserType", userType ) ;
			
			int dieTime = 7*24*60*60 ;
			couserUserNum.setMaxAge( dieTime ) ;
			couserNickName.setMaxAge( dieTime ) ;
			courseUserType.setMaxAge( dieTime ) ;
			
			response.addCookie( couserNickName ) ;
			response.addCookie( couserUserNum ) ;
			response.addCookie( courseUserType ) ;
			try {
				HttpSession session = request.getSession() ;
				session.setAttribute( "NickName", nickName ) ;
				session.setAttribute( "UserNum", userNum ) ;
				session.setAttribute( "UserType" , userType ) ;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println( "result结果表是：\n 0：验证通过，1：密码错误，2：无此账号\n"+json ) ;
		out.print(json) ;
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
