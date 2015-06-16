package WKFactory.Bll;

import java.util.HashMap;
import java.util.List;


import java.util.Map;

import net.sf.json.JSONArray;
import WKFactory.Dao.AttendCourseDao;
import WKFactory.Dao.ChapterDao;
import WKFactory.Dao.CourseDao;
import WKFactory.Dao.SubjectDao;
import WKFactory.Dao.UserDao;
import WKFactory.Entity.AttendCourseEntity;
import WKFactory.Entity.CourseEntity;
import WKFactory.Entity.SubjectEntity;
import WKFactory.Entity.UserEntity;
import WKFactory.Factory.DaoFactory;
import WKFactory.Tools.SampleDateFormat;

public class AttendCourseBll extends BllAbstract {
	private DaoFactory daoFactory = DaoFactory.getDaoFactory() ;
	private AttendCourseDao attendCourseDao = daoFactory.getInstance( AttendCourseDao.class ) ;
	private CourseDao courseDao = daoFactory.getInstance( CourseDao.class ) ;
	private UserDao userDao = daoFactory.getInstance( UserDao.class ) ;
	private SubjectDao subjectDao = daoFactory.getInstance( SubjectDao.class ) ;
	private ChapterDao chapterDao = daoFactory.getInstance( ChapterDao.class ) ;
	
	/**
	* @Title:       insert
	* @Description: 新建订阅
	* @param:       @param attendCourse
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	public boolean insert(AttendCourseEntity attendCourse) {
		// TODO Auto-generated method stub
		return attendCourseDao.insert( attendCourse ) ;
	}
	
	/**
	* @Title:       delete
	* @Description: 删除订阅
	* @param:       @param attendCourse
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	public boolean delete(AttendCourseEntity attendCourse) {
		return attendCourseDao.delete( attendCourse ) ;
	}

	/**
	* @Title:       IsRegister
	* @Description: 判断用户是否订阅
	* @param:       @param attendCourse
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	public boolean IsAttend(AttendCourseEntity attendCourse) {
		// TODO Auto-generated method stub
		return attendCourseDao.IsAttend( attendCourse ) ;
	}
	
	/** 
	* 方法： showMyAttends
	* 描述： 显示我的订阅
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年5月10日 下午11:01:18
	* 修改人：Gavin
	* 修改时间：2015年5月10日 下午11:01:18
	* 修改备注：
	* @throws 
	*/ 
	@SuppressWarnings("null")
	public JSONArray showMyAttends( String userNum ) {
		List<AttendCourseEntity> lists = attendCourseDao.showMyAttends( userNum ) ;
		if( lists == null ) {
			return null ;
		} else {
			JSONArray json = new JSONArray() ;
			for ( AttendCourseEntity ac : lists ) {
				Map<String, Object> map = new HashMap<String, Object>() ;
				CourseEntity c = courseDao.QueryByCourseNum( ac.getCourseNum() ) ;
				UserEntity user = userDao.QueryByUserNum( c.getUserNum() ) ;
				if( user != null ) {
					map.put( "UserNum" , user.getUserNum() ) ;
					map.put( "NickName", user.getNickName() ) ;				
				}
				map.put( "CourseName", c.getCourseName() ) ;
				map.put( "CoverPicture", c.getCoverPicture() ) ;
				map.put( "AudienceNum", c.getAudienceNum() ) ;
				map.put( "SubscriptionNum" , c.getSubscriptionNum() ) ;
				map.put( "CourseContent" , c.getCourseContent() ) ;
				map.put( "CourseNum", c.getCourseNum() ) ;
				String createtime = SampleDateFormat.toDIYDateString( c.getCreatetime() ) ;
				map.put( "Createtime", createtime ) ;
				map.put( "AudienceNum" , c.getAudienceNum() ) ;
				SubjectEntity sub = subjectDao.QuerySubById( c.getSubId() ) ;
				if( sub != null ){
					map.put( "SubId" , sub.getId() ) ;
					map.put( "SubjectName", sub.getSubjectName() ) ;				
				}
				int period = chapterDao.showPeriod( c.getCourseNum() ) ;
				map.put( "Period" , period ) ;
				json.add( map );	
			}
			return json ;
		}
	}
}
