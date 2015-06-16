package WKFactory.Interface;

import WKFactory.Entity.AccessoryEntity;
import WKFactory.Entity.AttendCourseEntity;
import WKFactory.Entity.AudienceRecorderEntity;
import WKFactory.Entity.ChapterEntity;
import WKFactory.Entity.CommentEntity;
import WKFactory.Entity.CourseEntity;
import WKFactory.Entity.DownloadRecorderEntity;
import WKFactory.Entity.PollVoteEntity;
import WKFactory.Entity.SubjectEntity;
import WKFactory.Entity.UserEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public interface BllInterface {

	/** 
	* 方法： Login
	* 描述： 用户登录
	* 返回： JSONObject
	* 创建人：章华隽
	* 创建时间：2015年4月15日 下午5:15:22
	* 修改人：Administrator
	* 修改时间：2015年4月15日 下午5:15:22
	* 修改备注：
	* @throws 
	*/ 
	JSONObject Login( UserEntity user ) ;

	/** 
	* 方法： SignUp
	* 描述： 用户注册
	* 返回： JSONObject
	* 创建人：章华隽
	* 创建时间：2015年4月16日 上午11:14:11
	* 修改人：Administrator
	* 修改时间：2015年4月16日 上午11:14:11
	* 修改备注：
	* @throws 
	*/ 
	JSONObject SignUp( UserEntity user ) ;
	
	/** 
	* 方法： QueryUserByUserNum
	* 描述： 根据用户Num查找用户
	* 返回： UserEntity
	* 创建人：章华隽
	* 创建时间：2015年4月16日 下午5:15:55
	* 修改人：Administrator
	* 修改时间：2015年4月16日 下午5:15:55
	* 修改备注：
	* @throws 
	*/ 
	UserEntity QueryUserByUserNum ( String userNum ) ;

	/** 
	* 方法： CreateCourse
	* 描述： 创建课程
	* 返回： JSONObject
	* 创建人：章华隽
	* 创建时间：2015年4月16日 下午6:44:18
	* 修改人：Administrator
	* 修改时间：2015年4月16日 下午6:44:18
	* 修改备注：
	* @throws 
	*/ 
	JSONObject CreateCourse(CourseEntity course);
	
	/** 
	* 方法： QueryCourseByCourseNum
	* 描述： 通过课程Num查找课程实体
	* 返回： CourseEntity
	* 创建人：章华隽
	* 创建时间：2015年4月16日 下午6:44:58
	* 修改人：Administrator
	* 修改时间：2015年4月16日 下午6:44:58
	* 修改备注：
	* @throws 
	*/ 
	CourseEntity QueryCourseByCourseNum( String courseNum ) ;


	/** 
	* 方法： QueryChapterByNum
	* 描述： 根据章节Num查找章节实体
	* 返回： ChapterEntity
	* 创建人：章华隽
	* 创建时间：2015年4月16日 下午7:15:44
	* 修改人：Administrator
	* 修改时间：2015年4月16日 下午7:15:44
	* 修改备注：
	* @throws 
	*/ 
	ChapterEntity QueryChapterByNum(String chapterNum);

	/** 
	* 方法： PublishComment
	* 描述： 发表评论
	* 返回： boolean
	* 创建人：章华隽
	* 创建时间：2015年4月17日 上午11:18:49
	* 修改人：Administrator
	* 修改时间：2015年4月17日 上午11:18:49
	* 修改备注：
	* @throws 
	*/ 
	boolean PublishComment(CommentEntity comment);

	/** 
	* 方法： QueryCourseByUserID
	* 描述： 通过创建者Id查找课程
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午2:30:52
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午2:30:52
	* 修改备注：
	* @throws 
	*/ 
	JSONArray QueryCourseByUserNum( String userNum );

	/** 
	* 方法： QueryChapterByCourseNum
	* 描述： 通过课程Num查找下属所有章节
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午2:37:58
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午2:37:58
	* 修改备注：
	* @throws 
	*/ 
	JSONArray QueryChapterByCourseNum( String courseNum );

	/** 
	* 方法： DeleteAccessory
	* 描述： 根据Id删除附件
	* 返回： boolean
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午3:00:40
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午3:00:40
	* 修改备注：
	* @throws 
	*/ 
	boolean DeleteAccessory(int accessoryId);

	
	/** 
	* 方法： QueryCommentByObjectTypeAndId
	* 描述： 通过目标类型和目标ID遍历评论
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午3:28:38
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午3:28:38
	* 修改备注：
	* @throws 
	*/ 
	JSONArray QueryCommentByObjectTypeAndId(CommentEntity comment);

	/** 
	* 方法： QueryAccessoryByObjectTypeAndId
	* 描述： 通过目标类型和目标ID遍历附件
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午3:47:19
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午3:47:19
	* 修改备注：
	* @throws 
	*/ 
	JSONArray QueryAccessoryByObjectTypeAndNum(AccessoryEntity acc);

	/** 
	* 方法： CreateDownloadRecorder
	* 描述： 创建下载记录
	* 返回： boolean
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午4:52:51
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午4:52:51
	* 修改备注：
	* @throws 
	*/ 
	JSONObject CreateDownloadRecorder(DownloadRecorderEntity downloadRecorder);

	/** 
	* 方法： AddAccessoryDownloadNum
	* 描述： 使文件下载记录增加1
	* 返回： void
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午4:55:10
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午4:55:10
	* 修改备注：
	* @throws 
	*/ 
	boolean AddAccessoryDownloadNum(AccessoryEntity accessory);

	/** 
	* 方法： AddAudienceRecorder
	* 描述： 创建观看记录
	* 返回： JSONObject
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午5:28:16
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午5:28:16
	* 修改备注：
	* @throws 
	*/ 
	JSONObject CreateAudienceRecorder(AudienceRecorderEntity ar);

	/** 
	* 方法： AddCourseAudienceNum
	* 描述： 使观看数+1
	* 返回： boolean
	* 创建人：章华隽
	* 创建时间：2015年4月17日 下午5:29:57
	* 修改人：Administrator
	* 修改时间：2015年4月17日 下午5:29:57
	* 修改备注：
	* @throws 
	*/ 
	boolean AddCourseAudienceNum(CourseEntity course);

	/** 
	* 方法： QuerySubjectById
	* 描述： 通过学科Id查找学科
	* 返回： SubjectEntity
	* 创建人：章华隽
	* 创建时间：2015年4月20日 上午9:49:46
	* 修改人：Administrator
	* 修改时间：2015年4月20日 上午9:49:46
	* 修改备注：
	* @throws 
	*/ 
	SubjectEntity QuerySubjectById(Integer subId);

	/** 
	* 方法： UpdateCourse
	* 描述： 修改课程
	* 返回： boolean
	* 创建人：章华隽
	* 创建时间：2015年4月20日 下午1:29:34
	* 修改人：Administrator
	* 修改时间：2015年4月20日 下午1:29:34
	* 修改备注：
	* @throws 
	*/ 
	boolean UpdateCourse(CourseEntity course);

	/** 
	* 方法： UploadChapter
	* 描述： 上传章节视频
	* 返回： boolean
	* 创建人：章华隽
	* 创建时间：2015年4月20日 下午2:45:38
	* 修改人：Administrator
	* 修改时间：2015年4月20日 下午2:45:38
	* 修改备注：
	* @throws 
	*/ 
	boolean UploadChapter(ChapterEntity chapter);

	/** 
	* 方法： AddChapter
	* 描述： 新增章节
	* 返回： boolean
	* 创建人：章华隽
	* 创建时间：2015年4月20日 下午3:02:33
	* 修改人：Administrator
	* 修改时间：2015年4月20日 下午3:02:33
	* 修改备注：
	* @throws 
	*/ 
	JSONObject AddChapter(ChapterEntity chapter);



	/**
	* @Title:       QueryMatchByUserNum
	* @Description: 查找用户创建的比赛
	* @param:       @param userNum
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryMatchByUserNum( String userNum );

	/**
	* @Title:       StopMatch
	* @Description: 结束比赛
	* @param:       @param matchNum
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean StopMatch( String matchNum );

	/**
	* @Title:       AttendCourse
	* @Description: 订阅课程
	* @param:       @param a
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean AttendCourse(AttendCourseEntity attendCourse);

	/**
	* @Title:       DeleteAttendCourse
	* @Description: 删除学生订阅信息
	* @param:       @param a
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean DeleteAttendCourse(AttendCourseEntity attendCourse);

	/**
	* @Title:       IsRegister
	* @Description: 判断学生是否订阅
	* @param:       @param a
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean IsAttend(AttendCourseEntity attendCourse);

	/**
	* @Title:       AddPollVote
	* @Description: 投票
	* @param:       @param pv
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean AddPollVote(PollVoteEntity pollVote);

	/**
	* @Title:       IsPollVote
	* @Description: 判断是否已经投票
	* @param:       @param pv
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean IsPollVote(PollVoteEntity pollVote);

	/**
	* @Title:       QueryAllCourses
	* @Description: 遍历所有课程
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryAllCourses();

	/**
	* @Title:       QueryAllMatches
	* @Description: 遍历所有比赛
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryAllMatches();

	/**
	* @Title:       UploadAccessory
	* @Description: 上传附件
	* @param:       @param accessory
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean UploadAccessory(AccessoryEntity accessory);

	/** 
	* 方法： QueryMatchAward
	* 描述： 查看比赛奖项
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年4月26日 上午10:39:24
	* 修改人：华隽
	* 修改时间：2015年4月26日 上午10:39:24
	* 修改备注：
	* @throws 
	*/ 
	JSONArray QueryMatchAward(String matchNum);

	/**
	* @Title:       checkCourse
	* @Description: 审核课程
	* @param:       @param courseNum
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean checkCourse(String courseNum);

	/**
	* @Title:       checkChapter
	* @Description: 审核章节
	* @param:       @param chapterNum
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean checkChapter(String chapterNum);

	/**
	* @Title:       checkMatch
	* @Description: 审核比赛
	* @param:       @param matchNum
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean checkMatch(String matchNum);

	/**
	* @Title:       QueryUncheckedCourses
	* @Description: 遍历未过审的课程
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryUncheckedCourses( Short check );

	/**
	* @Title:       QueryUncheckedMatches
	* @Description: 遍历所有未过审的比赛活动
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryUncheckedMatches();
	
	/**
	* @Title:       QueryUncheckedChapters
	* @Description: 遍历未过审的活动章节
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryUncheckedChapters( Short check ) ;

	/**
	* @Title:       ChangeUserType
	* @Description: 修改用户类别
	* @param:       @param u
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean ChangeUserType(UserEntity u);

	/**
	* @Title:       QueryAllUser
	* @Description: 查找所有用户
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryAllUser( Short isLock );

	/**
	* @Title:       QueryUnsureUser
	* @Description: 模糊搜索用户
	* @param:       @param inputName
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryUnsureUser(String inputName);
	
	/**
	* @Title:       QueryUnsureCourse
	* @Description: 模糊搜索课程
	* @param:       @param inputName
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryUnsureCourse(String inputName);

	/** 
	* 方法： QueryUserInfo
	* 描述： 查看用户详情
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年5月10日 上午11:58:18
	* 修改人：Gavin
	* 修改时间：2015年5月10日 上午11:58:18
	* 修改备注：
	* @throws 
	*/ 
	JSONObject QueryUserInfo(String userNum);

	/** 
	* 方法： ShowMyAttends
	* 描述： 显示我的订阅的课程
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年5月10日 下午11:16:58
	* 修改人：Gavin
	* 修改时间：2015年5月10日 下午11:16:58
	* 修改备注：
	* @throws 
	*/ 
	JSONArray ShowMyAttends(String userNum);

	/**
	* @Title:       showPeriod
	* @Description: 显示课程学时
	* @param:       @param courseNum
	* @param:       @return
	* @return:      int
	* @throws
	*/ 
	int showPeriod(String courseNum);

	/**
	* @Title:       showChooseChapter
	* @Description: 返回选中的章节
	* @param:       @param cha
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONObject showChooseChapter(ChapterEntity cha);

	/**
	* @Title:       isMyCourse
	* @Description: 判断用户是否为课程的创建者
	* @param:       @param c
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean isMyCourse(CourseEntity c);

	/**
	* @Title:       QueryCourseBySubId
	* @Description: 通过学科ID查找课程
	* @param:       @param subId
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryCourseBySubId(Integer subId);

	/**
	* @Title:       showAllSubjects
	* @Description: 展示所有学科
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray showAllSubjects();

	/**
	* @Title:       QueryCourseBySubName
	* @Description: 通过SubName查找课程
	* @param:       @param subName
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray QueryCourseBySubName(String subName);

	/**
	* @Title:       showIndexSubject
	* @Description: 展示首页的学科分类
	* @param:       @param indexNum
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray showIndexSubject(int indexNum);

	/**
	* @Title:       showChildSubject
	* @Description: 显示子学科分类
	* @param:       @param subId
	* @param:       @return
	* @return:      JSONArray
	* @throws
	*/ 
	JSONArray showChildSubject(int subId);

	/**
	* @Title:       updateUserPic
	* @Description: 更新用户头像
	* @param:       @param u
	* @param:       @return
	* @return:      boolean
	* @throws
	*/ 
	boolean updateUserPic(UserEntity u);

	/** 
	* 方法： showReplay
	* 描述： 显示回复信息
	* 返回： JSONArray
	* 创建人：章华隽
	* 创建时间：2015年5月25日 下午10:04:45
	* 修改人：Gavin
	* 修改时间：2015年5月25日 下午10:04:45
	* 修改备注：
	* @throws 
	*/ 
	JSONArray showReply(Integer pid); 
}
