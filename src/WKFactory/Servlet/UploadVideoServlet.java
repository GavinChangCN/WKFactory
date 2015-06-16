package WKFactory.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@SuppressWarnings("serial")
public class UploadVideoServlet extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public UploadVideoServlet() {
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

		 System.out.println("-------------------UpLoadify-doGet");
		 System.out.println("-------------------QueryString::::" + request.getQueryString());
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String originalName = "" ;
		String savePath = this.getServletConfig().getServletContext()  
                .getRealPath("");  
        savePath = savePath + "CuSunPlayer\\Chaptervideo\\";  
        File f1 = new File(savePath);  
        System.out.println(savePath);  
        if (!f1.exists()) {  
            f1.mkdirs();  
        }  
        DiskFileItemFactory fac = new DiskFileItemFactory();  
        ServletFileUpload upload = new ServletFileUpload(fac);  
        upload.setHeaderEncoding("utf-8");  
        List fileList = null;  
        try {  
            fileList = upload.parseRequest(request);  
        } catch (FileUploadException ex) {  
            return;  
        }  
  
        Iterator<FileItem> it = fileList.iterator();  
        String name = "";  
        String extName = "";  
        while (it.hasNext()) {  
            FileItem item = it.next();  
            if (!item.isFormField()) {  
                name = item.getName();  
                long size = item.getSize();  
                String type = item.getContentType();  
                System.out.println(size + " " + type);  
                if (name == null || name.trim().equals("")) {  
                    continue;  
                }  
  
                //扩展名格式：   
                if (name.lastIndexOf(".") >= 0) {  
                    extName = name.substring(name.lastIndexOf("."));  
                }  
                originalName = name ;
                File file = null;  
                do {  
                    //生成文件名：  
                    name = UUID.randomUUID().toString();  
                    file = new File(savePath + name + extName);  
                } while (file.exists());  
                File saveFile = new File(savePath + name + extName);  
                try {  
                    item.write(saveFile);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        JSONObject json = new JSONObject() ;
        json.put( "address" , "Accessory/"+ name + extName ) ;
        json.put( "filename", originalName ) ;
        System.out.println( "json.address:" + json.get( "address") ) ;
        System.out.println( "json.filename:" + json.get( "filename") ) ;
        out.print( name + extName ) ;
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
