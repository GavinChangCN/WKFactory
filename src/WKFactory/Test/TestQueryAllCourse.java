package WKFactory.Test;

import net.sf.json.JSONArray;
import WKFactory.Bll.CourseBll;

public class TestQueryAllCourse {

	public static void main(String[] args) {
		CourseBll courseBll = new CourseBll() ;
		JSONArray json = courseBll.QueryAllCourses() ;
		System.out.println( json ) ;
	}
}
