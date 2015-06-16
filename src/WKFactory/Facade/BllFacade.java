package WKFactory.Facade;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import WKFactory.Bll.AccessoryBll;
import WKFactory.Bll.AttendCourseBll;
import WKFactory.Bll.AudienceRecorderBll;
import WKFactory.Bll.ChapterBll;
import WKFactory.Bll.CommentBll;
import WKFactory.Bll.CourseBll;
import WKFactory.Bll.DownloadRecorderBll;
import WKFactory.Bll.IndexSubjectBll;
import WKFactory.Bll.PollVoteBll;
import WKFactory.Bll.SubjectBll;
import WKFactory.Bll.UserBll;
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
import WKFactory.Factory.BllFactory;
import WKFactory.Interface.BllInterface;


public class BllFacade implements BllInterface{

	// 单例
	private static BllFacade bllFacade = new BllFacade();
	
	private BllFacade(){};
	
	public static BllFacade getBllFacadeInstance() {
		return bllFacade;
	}

	// 调用Bll层，单例模式
	private BllFactory bllFactory = BllFactory.getBllFactory();
	
	// 访问业务层
	private UserBll userBll = bllFactory.getInstance( UserBll.class ) ;
	private CourseBll courseBll = bllFactory.getInstance( CourseBll.class ) ;
	private ChapterBll chapterBll = bllFactory.getInstance( ChapterBll.class ) ;
	private CommentBll commentBll = bllFactory.getInstance( CommentBll.class ) ;
	private SubjectBll subjectBll = bllFactory.getInstance( SubjectBll.class ) ;
	private AccessoryBll accessoryBll = bllFactory.getInstance( AccessoryBll.class ) ;
	private AttendCourseBll attendCourseBll = bllFactory.getInstance( AttendCourseBll.class ) ;
	private DownloadRecorderBll downloadRecorderBll = bllFactory.getInstance( DownloadRecorderBll.class ) ;
	private AudienceRecorderBll AudienceRecorderBll = bllFactory.getInstance( AudienceRecorderBll.class ) ;
	private PollVoteBll pollVoteBll = bllFactory.getInstance( PollVoteBll.class ) ;
	private IndexSubjectBll indexSubjectBll = bllFactory.getInstance( IndexSubjectBll.class ) ;
	
	
	@Override
	public JSONObject Login( UserEntity user ) {
		// TODO Auto-generated method stub
		
		JSONObject json = userBll.Login( user ) ;
		return json ;
	}

	@Override
	public JSONObject SignUp ( UserEntity user ) {
	
		JSONObject json = userBll.insert( user ) ;
		return json ;
	}

	@Override
	public UserEntity QueryUserByUserNum( String userNum ) {
		// TODO Auto-generated method stub
		return userBll.queryByUserNum(userNum) ;
	}

	@Override
	public JSONObject CreateCourse(CourseEntity course) {
		// TODO Auto-generated method stub
		return courseBll.insert( course ) ;
	}

	@Override
	public CourseEntity QueryCourseByCourseNum(String courseNum) {
		// TODO Auto-generated method stub
		return courseBll.QueryCourseByCourseNum( courseNum ) ;
	}

	@Override
	public ChapterEntity QueryChapterByNum(String chapterNum) {
		// TODO Auto-generated method stub
		return chapterBll.QueryByNum( chapterNum ) ;
	}

	@Override
	public boolean PublishComment(CommentEntity comment) {
		// TODO Auto-generated method stub
		return commentBll.insert( comment ) ;
	}

	@Override
	public JSONArray QueryCourseByUserNum(String userNum) {
		// TODO Auto-generated method stub
		return courseBll.QueryByUserNum( userNum ) ;
	}

	@Override
	public JSONArray QueryChapterByCourseNum(String courseNum) {
		// TODO Auto-generated method stub
		return chapterBll.QueryByCourseNum( courseNum ) ;
	}

	@Override
	public boolean DeleteAccessory(int accessoryId) {
		// TODO Auto-generated method stub
		return accessoryBll.delete( accessoryId ) ;
	}

	@Override
	public JSONArray QueryCommentByObjectTypeAndId(CommentEntity comment) {
		// TODO Auto-generated method stub
		return commentBll.QueryByObjectTypeAndNum( comment ) ;
	}

	@Override
	public JSONArray QueryAccessoryByObjectTypeAndNum(AccessoryEntity acc) {
		// TODO Auto-generated method stub
		return accessoryBll.QueryByObjectTypeAndNum( acc ) ;
	}

	@Override
	public JSONObject CreateDownloadRecorder(
			DownloadRecorderEntity downloadRecorder) {
		// TODO Auto-generated method stub
		return downloadRecorderBll.insert( downloadRecorder ) ;
	}

	@Override
	public boolean AddAccessoryDownloadNum(AccessoryEntity accessory) {
		// TODO Auto-generated method stub
		return accessoryBll.AddAccessoryDownloadNum( accessory ) ;
	}

	@Override
	public JSONObject CreateAudienceRecorder(AudienceRecorderEntity ar) {
		// TODO Auto-generated method stub
		return AudienceRecorderBll.insert( ar ) ;
	}

	@Override
	public boolean AddCourseAudienceNum(CourseEntity course) {
		// TODO Auto-generated method stub
		return courseBll.AddAudienceNum( course ) ;
	}

	@Override
	public SubjectEntity QuerySubjectById(Integer subId) {
		// TODO Auto-generated method stub
		return subjectBll.QuerySubjectById( subId ) ;
	}

	@Override
	public boolean UpdateCourse(CourseEntity course) {
		// TODO Auto-generated method stub
		return courseBll.UpdateCourse( course ) ;
	}

	@Override
	public boolean UploadChapter(ChapterEntity chapter) {
		// TODO Auto-generated method stub
		return chapterBll.Upload( chapter ) ;
	}

	@Override
	public JSONObject AddChapter(ChapterEntity chapter) {
		// TODO Auto-generated method stub
		return chapterBll.AddChapter( chapter ) ;
	}

	@Override
	public boolean AttendCourse(AttendCourseEntity attendCourse) {
		// TODO Auto-generated method stub
		return attendCourseBll.insert( attendCourse ) ;
	}

	@Override
	public boolean DeleteAttendCourse(AttendCourseEntity attendCourse) {
		// TODO Auto-generated method stub
		return attendCourseBll.delete( attendCourse ) ;
	}

	@Override
	public boolean IsAttend(AttendCourseEntity attendCourse) {
		// TODO Auto-generated method stub
		return attendCourseBll.IsAttend(attendCourse);
	}

	@Override
	public boolean AddPollVote(PollVoteEntity pollVote) {
		// TODO Auto-generated method stub
		return pollVoteBll.insert( pollVote ) ;
	}

	@Override
	public boolean IsPollVote(PollVoteEntity pollVote) {
		// TODO Auto-generated method stub
		return pollVoteBll.IsPollVote( pollVote ) ;
	}

	@Override
	public JSONArray QueryAllCourses() {
		// TODO Auto-generated method stub
		return courseBll.QueryAllCourses() ;
	}


	@Override
	public boolean UploadAccessory(AccessoryEntity accessory) {
		// TODO Auto-generated method stub
		return accessoryBll.insert( accessory ) ;
	}

	@Override
	public boolean checkCourse(String courseNum) {
		// TODO Auto-generated method stub
		return courseBll.check( courseNum ) ;
	}

	@Override
	public boolean checkChapter(String chapterNum) {
		// TODO Auto-generated method stub
		return chapterBll.check( chapterNum ) ;
	}

	@Override
	public JSONArray QueryUncheckedCourses( Short check ) {
		// TODO Auto-generated method stub
		return courseBll.QueryUnChecked( check );
	}

	@Override
	public JSONArray QueryUncheckedChapters( Short check ) {
		// TODO Auto-generated method stub
		return chapterBll.QueryUnChecked( check ) ;
	}

	@Override
	public boolean ChangeUserType(UserEntity u) {
		// TODO Auto-generated method stub
		return userBll.ChangeUserType( u ) ;
	}

	@Override
	public JSONArray QueryAllUser( Short isLock ) {
		// TODO Auto-generated method stub
		return userBll.QueryAll( isLock ) ;
	}

	@Override
	public JSONArray QueryUnsureUser(String inputName) {
		// TODO Auto-generated method stub
		return userBll.QueryUnsure(inputName);
	}

	@Override
	public JSONArray QueryUnsureCourse(String inputName) {
		// TODO Auto-generated method stub
		return courseBll.QuerySimilar(inputName) ;
	}

	@Override
	public JSONArray QueryMatchByUserNum(String userNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean StopMatch(String matchNum) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean checkMatch(String matchNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JSONArray QueryUncheckedMatches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject QueryUserInfo(String userNum) {
		// TODO Auto-generated method stub
		return userBll.UserInfo( userNum ) ;
	}

	@Override
	public JSONArray ShowMyAttends(String userNum) {
		// TODO Auto-generated method stub
		return attendCourseBll.showMyAttends( userNum ) ;
	}

	@Override
	public int showPeriod(String courseNum) {
		// TODO Auto-generated method stub
		return chapterBll.showPeriod( courseNum ) ;
	}

	@Override
	public JSONObject showChooseChapter(ChapterEntity cha) {
		// TODO Auto-generated method stub
		return chapterBll.showChoose( cha ) ;
	}

	@Override
	public boolean isMyCourse(CourseEntity c) {
		// TODO Auto-generated method stub
		return courseBll.isMyCourse( c );
	}

	@Override
	public JSONArray QueryCourseBySubId(Integer subId) {
		// TODO Auto-generated method stub
		return courseBll.QueryBySubId( subId );
	}

	@Override
	public JSONArray showAllSubjects() {
		// TODO Auto-generated method stub
		return subjectBll.showAll() ;
	}

	@Override
	public JSONArray QueryCourseBySubName(String subName) {
		// TODO Auto-generated method stub
		SubjectEntity s = subjectBll.QueryByName( subName ) ;
		return courseBll.QueryBySubId( s.getId() ) ;
	}

	@Override
	public JSONArray showIndexSubject(int indexNum) {
		// TODO Auto-generated method stub
		return indexSubjectBll.showIndex(indexNum) ;
	}

	@Override
	public JSONArray showChildSubject(int subId) {
		// TODO Auto-generated method stub
		return subjectBll.showChild( subId ) ;
	}

	@Override
	public boolean updateUserPic(UserEntity u) {
		// TODO Auto-generated method stub
		return userBll.updateUserPic( u ) ;
	}

	@Override
	public JSONArray QueryAllMatches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray QueryMatchAward(String matchNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray showReply(Integer pid) {
		// TODO Auto-generated method stub
		return commentBll.showReply( pid ) ;
	}

	
}
