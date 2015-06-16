package WKFactory.Bll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import WKFactory.Tools.SampleDateFormat;
import WKFactory.Dao.UserDao;
import WKFactory.Entity.UserEntity;
import WKFactory.Factory.DaoFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserBll extends BllAbstract {
	private DaoFactory daoFactory = DaoFactory.getDaoFactory() ;
	private UserDao userDao = daoFactory.getInstance( UserDao.class ) ;
	
	/** 
	* 方法： Login
	* 描述： 用户登录
	* 返回： JSONObject
	* 创建人：章华隽
	* 创建时间：2015年4月15日 下午2:49:51
	* 修改人：Administrator
	* 修改时间：2015年4月15日 下午2:49:51
	* 修改备注：
	* @throws 
	*/ 
	public JSONObject Login( UserEntity user ) {
		return userDao.Login(user) ;
	}

	/** 
	* 方法： insert
	* 描述： 用户注册
	* 返回： JSONObject
	* 创建人：章华隽
	* 创建时间：2015年4月16日 下午5:13:42
	* 修改人：Administrator
	* 修改时间：2015年4月16日 下午5:13:42
	* 修改备注：
	* @throws 
	*/ 
	public JSONObject insert ( UserEntity user ) {
		return userDao.insert(user) ;
	}
	
	/** 
	* 方法： queryByUserNum
	* 描述： 根据用户Num查找用户
	* 返回： UserEntity
	* 创建人：章华隽
	* 创建时间：2015年4月16日 下午5:15:07
	* 修改人：Administrator
	* 修改时间：2015年4月16日 下午5:15:07
	* 修改备注：
	* @throws 
	*/ 
	public UserEntity queryByUserNum ( String userNum ) {
		return userDao.QueryByUserNum(userNum) ;
	}

	/**
	* @Title:       ChangeUserType
	* @Description: 修改用户类别
	* @param:       @param user
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	public boolean ChangeUserType(UserEntity user) {
		// TODO Auto-generated method stub
		return userDao.ChangeUserType( user ) ;
	}

	/**
	* @Title:       QueryAll
	* @Description: 查找所有用户
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	@SuppressWarnings("null")
	public JSONArray QueryAll( Short isLock ) {
		// TODO Auto-generated method stub
		List<UserEntity> lists = userDao.QueryAll( isLock ) ;
		if( lists != null || lists.size() != 0 ) {
			JSONArray json = new JSONArray() ;
			for ( UserEntity u : lists ) {
				Map<String, Object> map = new HashMap<String, Object>() ;
				
				map.put( "UserNum" , u.getUserNum() ) ;
				map.put( "NickName" , u.getNickName() ) ;
				map.put( "UserType" , u.getUserType() ) ;
				map.put( "UserPicture", u.getUserPicture() ) ;
				map.put( "UserName" , u.getUserName() ) ;
				map.put( "isLock" , u.getIsLock() ) ;
				map.put( "UserPhone", u.getUserPhone() ) ;
				String regTime = SampleDateFormat.toYearMonthDayString( u.getRegTime() ) ;
				map.put( "RegTime", regTime ) ;
				
				json.add( map ) ;
			}
			return json ;
		} else {
			return null ;
		}
	}
	
	/**
	* @Title:       QueryUnsure
	* @Description: 模糊搜索
	* @param:       @param nickName
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	@SuppressWarnings("null")
	public JSONArray QueryUnsure( String inputName ) {
		List<UserEntity> lists = userDao.QueryBySimilarNick( inputName ) ;
		if( lists != null || lists.size() != 0 ) {
			JSONArray json = new JSONArray() ;
			for ( UserEntity u : lists ) {
				Map<String, Object> map = new HashMap<String, Object>() ;
				
				map.put( "UserNum" , u.getUserNum() ) ;
				map.put( "NickName" , u.getNickName() ) ;
				map.put( "UserType" , u.getUserType() ) ;
				map.put( "UserPicture", u.getUserPicture() ) ;
				map.put( "UserName" , u.getUserName() ) ;
				map.put( "RegTime", u.getRegTime() ) ;
				map.put( "UserPhone", u.getUserPhone() ) ;
				
				json.add( map ) ;
			}
			return json ;
		} else {
			return null ;
		}
	}

	/** 
	* 方法： UserInfo
	* 描述： 检索用户详情
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年5月10日 上午11:59:20
	* 修改人：Gavin
	* 修改时间：2015年5月10日 上午11:59:20
	* 修改备注：
	* @throws 
	*/ 
	public JSONObject UserInfo(String userNum) {
		// TODO Auto-generated method stub
		UserEntity u = userDao.QueryByUserNum(userNum) ;
		if ( u != null ) {
			JSONObject json = new JSONObject() ;
			json.put( "UserNum" , u.getUserNum() ) ;
			json.put( "NickName" , u.getNickName() ) ;
			json.put( "UserType" , u.getUserType() ) ;
			json.put( "UserPicture", u.getUserPicture() ) ;
			json.put( "UserName" , u.getUserName() ) ;
			json.put( "RegTime", u.getRegTime() ) ;
			return json ;
		} else {
			return null;			
		}
	}

	/**
	* @Title:       updateUserPic
	* @Description: 更新用户头像
	* @param:       @param u
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	public boolean updateUserPic(UserEntity u) {
		// TODO Auto-generated method stub
		return userDao.updatePic( u ) ;
	}
}
