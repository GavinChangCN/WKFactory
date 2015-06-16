package WKFactory.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WKFactory.Entity.ChapterEntity;
import WKFactory.Factory.BllFacadeFactory;
import WKFactory.Interface.BllInterface;
import WKFactory.Tools.SampleDateFormat;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class QueryChapterByChapterNumServlet extends HttpServlet {
	private BllFacadeFactory bllFacadeFactory = BllFacadeFactory.getbBllFactoryInstance() ;
	private BllInterface bllInterface = bllFacadeFactory.getInterface() ;
	/**
	 * Constructor of the object.
	 */
	public QueryChapterByChapterNumServlet() {
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
		
		String chapterNum = request.getParameter("ChapterNum") ;
		System.out.println("本次查询获得的ChapterNum:"+ chapterNum) ; 
		ChapterEntity cha = bllInterface.QueryChapterByNum(chapterNum) ;
		if ( cha != null ) {
			JSONObject json = new JSONObject() ;
			json.put( "ChapterName" , cha.getChapterName() ) ;
			json.put( "ChapterContent" , cha.getChapterContent() ) ;
			json.put( "isComment" , cha.getIsComment() ) ;
			json.put( "ChapterVideo" , cha.getChapterVideo() ) ;
			json.put( "Createtime", SampleDateFormat.toDIYDateString( cha.getCreateTime() ) ) ;
			json.put( "PID" , cha.getPid() ) ;
			
			out.print(json);			
		}
		out.flush();
		out.close();
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
