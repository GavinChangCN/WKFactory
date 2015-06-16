package WKFactory.Test;

import WKFactory.Dao.CourseDao;

public class CourseQueryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userNum = "MXPFPRQT214NE5APIL0F" ;
		CourseDao cd = new CourseDao() ;
		
		System.out.println(cd.queryByUserNum(userNum));

	}

}
