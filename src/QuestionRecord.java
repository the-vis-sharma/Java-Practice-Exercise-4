import java.time.LocalDate;

public class QuestionRecord {
	private int id;
	private LocalDate  answerDate;
	private String ministry;
	private boolean isStarred;
	private int questionNo;
	private String questionBy;
	private String questionTitle;
	private String questionDescription;
	
	
	
	public QuestionRecord(int id, LocalDate answerDate, String ministry, boolean isStarred, int questionNo,
			String questionBy, String questionTitle, String questionDescription) {
		super();
		this.id = id;
		this.answerDate = answerDate;
		this.ministry = ministry;
		this.isStarred = isStarred;
		this.questionNo = questionNo;
		this.questionBy = questionBy;
		this.questionTitle = questionTitle;
		this.questionDescription = questionDescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(LocalDate answerDate) {
		this.answerDate = answerDate;
	}
	public String getMinistry() {
		return ministry;
	}
	public void setMinistry(String ministry) {
		this.ministry = ministry;
	}
	public boolean isStarred() {
		return isStarred;
	}
	public void setStarred(boolean isStarred) {
		this.isStarred = isStarred;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestionBy() {
		return questionBy;
	}
	public void setQuestionBy(String questionBy) {
		this.questionBy = questionBy;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		QuestionRecord record = (QuestionRecord) obj;
		return record.id == this.id;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	
}
 