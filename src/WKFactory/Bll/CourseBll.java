package WKFactory.Bll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import WKFactory.Dao.ChapterDao;
import WKFactory.Dao.CourseDao;
import WKFactory.Dao.SubjectDao;
import WKFactory.Dao.UserDao;
import WKFactory.Entity.CourseEntity;
import WKFactory.Entity.SubjectEntity;
import WKFactory.Entity.UserEntity;
import WKFactory.Factory.DaoFactory;
import WKFactory.Tools.SampleDateFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CourseBll extends BllAbstract {

	private DaoFactory daoFactory = DaoFactory.getDaoFactory() ;
	private CourseDao courseDao = daoFactory.getInstance( CourseDao.class ) ;
	private SubjectDao subjectDao = daoFactory.getInstance( SubjectDao.class ) ;
	private ChapterDao chapterDao = daoFactory.getInstance( ChapterDao.class ) ;
	private UserDao userDao = daoFactory.getInstance( UserDao.class ) ;
	
	/** 
	* 方法： insert
	* 描述： 创建课程
	* 返回： JSONObject
	* 创建人：章华隽
	* 创建时间：2015年4月16日 下午6:38:30
	* 修改人：Administrator
	* 修改时间：2015年4月16日 下午6:38:30
	* 修改备注：
	* @throws 
	*/ 
	public JSONObject insert(CourseEntity course) {
		// TODO Auto-generated method stub
		return courseDao.insert( course ) ;
	}


	/** 
	* 方法： QueryQueryCourseByCourseNum
	* 描述：通过Num 查找课程信息
	* 返回： CourseEntity
	* 创建人：章华隽
	* 创建时间：2015年4月16日 下午6:46:13
	* 修改人：Administrator
	* 修改时间：2015年4月16日 下午6:46:13
	* 修改备注：
	* @throws 
	*/ 
	public CourseEntity QueryCourseByCourseNum(String courseNum) {
		// TODO Auto-generated method stub
		return courseDao.QueryByCourseNum( courseNum );
	}

	/** 
	* 方法： QueryByUserId
	* 描述： 通过创建者ID查找发布的课程
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午1:44:25
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午1:44:25
	* 修改备注：
	* @throws 
	*/ 
	public JSONArray QueryByUserNum( String userNum ) {
		List<CourseEntity> lists = courseDao.queryByUserNum( userNum ) ;
		return putIntoJsonArray( lists ) ;
	}


	/** 
	* 方法： AddAudienceNum
	* 描述： 增加观看记录
	* 返回： boolean
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午5:30:35
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午5:30:35
	* 修改备注：
	* @throws 
	*/ 
	public boolean AddAudienceNum(CourseEntity course) {
		// TODO Auto-generated method stub
		return courseDao.AddAudienceNum( course );
	}


	/** 
	* 方法： UpdateCourse
	* 描述： 修改课程
	* 返回： boolean
	* 创建人：章华隽
	* 创建时间：2015年4月20日 下午1:30:14
	* 修改人：Administrator
	* 修改时间：2015年4月20日 下午1:30:14
	* 修改备注：
	* @throws 
	*/ 
	public boolean UpdateCourse(CourseEntity course) {
		// TODO Auto-generated method stub
		return courseDao.update(course) ;
	}

	/**
	* @Title:       OpenComment
	* @Description: 开放聊天功能
	* @param:       @param courseNum
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	public boolean OpenComment( String courseNum ) {
		return courseDao.OpenComment( courseNum ) ;
	}

	/**
	* @Title:       QueryAllCourses
	* @Description: 遍历所有课程
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	public JSONArray QueryAllCourses() {
		// TODO Auto-generated method stub
		List<CourseEntity> lists = courseDao.QueryAllCourses() ;
		if( lists != null ) {
			return putIntoJsonArray( lists ) ;			
		} else {
			return null ;
		}
	}


	/**
	* @Title:       check
	* @Description: 审核课程
	* @param:       @param courseNum
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	public boolean check(String courseNum) {
		// TODO Auto-generated method stub
		return courseDao.check( courseNum ) ;
	}
	
	/**
	* @Title:       QueryUnChecked
	* @Description: 遍历未审核的课程
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	public JSONArray QueryUnChecked( Short check ) {
		List<CourseEntity> lists = courseDao.QueryUnChecked( check ) ;
		return putIntoJsonArray( lists ) ;
	}
	
	/**
	* @Title:       QuerySimilar
	* @Description: 模糊搜索
	* @param:       @param input
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	public JSONArray QuerySimilar( String inputName ) {
		List<CourseEntity> lists = courseDao.QuerySimilar( inputName ) ;
		return putIntoJsonArray( lists ) ;
	}
	
	/** 
	* 方法： putIntoJsonArray
	* 描述： 将获得的lists打包成JsonArray
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年5月10日 上午10:35:29
	* 修改人：GavinVictory
	* 修改时间：2015年5月10日 上午10:35:29
	* 修改备注：
	* @throws 
	*/ 
	@SuppressWarnings("null")
	public JSONArray putIntoJsonArray( List<CourseEntity> lists ) {
		if( lists == null || lists.size() == 0 ){
			return null ;
		} else {
			JSONArray jsonArray = new JSONArray() ;
			for ( CourseEntity course : lists ) {
				Map<String, Object> map = new HashMap<String, Object>() ;
				UserEntity user = userDao.QueryByUserNum( course.getUserNum() ) ;
				if( user != null ) {
					map.put( "UserNum" , user.getUserNum() ) ;
					map.put( "NickName", user.getNickName() ) ;				
				}
				map.put( "CourseName", course.getCourseName() ) ;
				map.put( "CoverPicture", course.getCoverPicture() ) ;
				map.put( "AudienceNum", course.getAudienceNum() ) ;
				map.put( "SubscriptionNum" , course.getSubscriptionNum() ) ;
				map.put( "CourseContent" , course.getCourseContent() ) ;
				map.put( "CourseNum", course.getCourseNum() ) ;
				String createtime = SampleDateFormat.toDIYDateString( course.getCreatetime() ) ;
				map.put( "Createtime", createtime ) ;
				map.put( "AudienceNum" , course.getAudienceNum() ) ;
				SubjectEntity sub = subjectDao.QuerySubById( course.getSubId() ) ;
				if( sub != null ){
					map.put( "SubId" , sub.getId() ) ;
					map.put( "SubjectName", sub.getSubjectName() ) ;				
				}
				int period = chapterDao.showPeriod( course.getCourseNum() ) ;
				map.put( "Period" , period ) ;
				jsonArray.add( map );	
			}
			return jsonArray ;		
		}
	}


	/**
	* @Title:       isMyCourse
	* @Description: 判断用户是否为课程的创建者
	* @param:       @param c
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	public boolean isMyCourse(CourseEntity c) {
		// TODO Auto-generated method stub
		return courseDao.isMyCourse( c );
	}
	
	/**
	* @Title:       QueryCourseBySubId
	* @Description: 根据学科查找课程
	* @param:       @param subId
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	public JSONArray QueryBySubId(Integer subId) {
		// TODO Auto-generated method stub
		List<CourseEntity> lists = courseDao.QueryBySubId( subId ) ;
		lists = addChildSubCourse( lists , subId ) ;
		return putIntoJsonArray( lists ) ;
	}
	
	/**
	* @Title:       addChildSubCourse
	* @Description: 将所有子学科分类的课程加入本队列
	* @param:       @param ancientList
	* @param:       @param subId
	* @param:       @return
	* @return:      List<CourseEntity>
	* @throws
	*/ 
	public List<CourseEntity> addChildSubCourse( List<CourseEntity> ancientList , int subId ) {
		List<SubjectEntity> childs = subjectDao.showChild( subId ) ;
		if ( childs != null ) {
			for ( int i = 0 ; i < childs.size() ; i ++ ) {
				int cid = childs.get(i).getId() ;
				List<CourseEntity> lists = courseDao.QueryBySubId( cid ) ;
				if ( lists != null ) {
					ancientList.addAll( lists ) ;
					ancientList = addChildSubCourse( ancientList , cid ) ;					
				}
			}
		}
		return ancientList ;
	}
}
