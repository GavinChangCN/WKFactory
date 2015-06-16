package WKFactory.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import WKFactory.Entity.AccessoryEntity;
import WKFactory.Factory.BllFacadeFactory;
import WKFactory.Interface.BllInterface;

public class saveAccessoryServlet extends HttpServlet {
	private BllFacadeFactory bllFacadeFactory = BllFacadeFactory.getbBllFactoryInstance() ;
	private BllInterface bllInterface = bllFacadeFactory.getInterface() ;
	/**
	 * Constructor of the object.
	 */
	public saveAccessoryServlet() {
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
		System.out.println("执行保存附件操作！") ;
		String userNum = request.getParameter( "UserNum" ) ;
		String objectNum = request.getParameter( "ObjectNum" ) ;
		Integer objectType = Integer.parseInt( request.getParameter( "ObjectType" ) ) ;
		String accessoryName = new String(request.getParameter( "FileName" ) ) ;
		String accessoryAddress = new String(request.getParameter( "FileAddress" ) ) ;
		AccessoryEntity a = new AccessoryEntity() ;
		a.setAccessoryAddress(accessoryAddress);
		a.setAccessoryName(accessoryName);
		a.setObjectType(objectType);
		a.setObjectNum(objectNum);
		a.setUserNum(userNum);
		a.setDownloadNum(0);
		a.setCreateTime( new Timestamp( System.currentTimeMillis() ) ) ;
		
		boolean check = bllInterface.UploadAccessory(a) ;
		JSONObject json = new JSONObject() ;
		if( check ){
			json.put( "result" , 0 ) ;			
		}else {
			json.put( "result" , 1 ) ;
		}
		System.out.println( "Result的结果（0：保存成功，1：保存失败）："+json ) ;
		out.print( json );
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
