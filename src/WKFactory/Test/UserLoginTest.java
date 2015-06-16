package WKFactory.Test;

import WKFactory.Dao.UserDao;
import WKFactory.Entity.UserEntity;
import WKFactory.Tools.MD5Tool;
import net.sf.json.JSONObject;

public class UserLoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity() ;
		user.setId(212);
		user.setUserNum("MXPFPRQT214NE5APIL0F");
		user.setUserName("a");
		user.setUserPassword("1");
		UserDao userDao = new UserDao() ;
		System.out.println( MD5Tool.GetMD5Code(user.getUserPassword()));
		JSONObject json = userDao.Login(user) ;
		System.out.println(json);
	}

}
