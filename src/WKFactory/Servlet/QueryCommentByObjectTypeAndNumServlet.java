package WKFactory.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WKFactory.Entity.CommentEntity;
import WKFactory.Factory.BllFacadeFactory;
import WKFactory.Interface.BllInterface;
import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class QueryCommentByObjectTypeAndNumServlet extends HttpServlet {
	private BllFacadeFactory bllFacadeFactory = BllFacadeFactory.getbBllFactoryInstance() ;
	private BllInterface bllInterface = bllFacadeFactory.getInterface() ;
	/**
	 * Constructor of the object.
	 */
	public QueryCommentByObjectTypeAndNumServlet() {
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

		JSONArray jsonArray = new JSONArray() ;
		// ObjectType = 1 ，章节的评论，ObjectType = 0 , 课程的评论
		int objectType = Integer.parseInt( new String( request.getParameter("ObjectType") ) ) ;
		String objectNum = request.getParameter( "ObjectNum" ) ;
		CommentEntity comment = new CommentEntity() ;
		comment.setObjectType( objectType ) ;
		comment.setObjectNum( objectNum ) ;
		comment.setPid( 0 ) ;
		jsonArray = bllInterface.QueryCommentByObjectTypeAndId( comment ) ;
		System.out.println( jsonArray ) ;
		out.print( jsonArray ) ;
		out.flush();
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