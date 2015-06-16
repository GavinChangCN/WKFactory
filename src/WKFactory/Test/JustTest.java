package WKFactory.Test;

import WKFactory.Dao.SubjectDao;

public class JustTest {

	public static void main(String[] args) {
		SubjectDao subjectDao = new SubjectDao() ;
		System.out.println( subjectDao.QuerySubById(1) );
	}
}
