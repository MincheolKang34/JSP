package dto;

public class RegisterDTO {

	private String regStdNo;
	private int regLecNo;
	private int regMidScore;
	private int regFinalScore;
	private int regTotalScore;
	private String regGrade;
	
	public String getRegStdNo() {
		return regStdNo;
	}
	public void setRegStdNo(String regStdNo) {
		this.regStdNo = regStdNo;
	}
	public int getRegLecNo() {
		return regLecNo;
	}
	public void setRegLecNo(int regLecNo) {
		this.regLecNo = regLecNo;
	}
	public void setRegLecNo(String regLecNo) {
		if(regLecNo != null)
			this.regLecNo = Integer.parseInt(regLecNo);
	}
	public int getRegMidScore() {
		return regMidScore;
	}
	public void setRegMidScore(int regMidScore) {
		this.regMidScore = regMidScore;
	}
	public void setRegMidScore(String regMidScore) {
		if(regMidScore != null)
			this.regMidScore = Integer.parseInt(regMidScore);
	}
	public int getRegFinalScore() {
		return regFinalScore;
	}
	public void setRegFinalScore(int regFinalScore) {
		this.regFinalScore = regFinalScore;
	}
	public void setRegFinalScore(String regFinalScore) {
		if(regFinalScore != null)
			this.regFinalScore = Integer.parseInt(regFinalScore);
	}
	public int getRegTotalScore() {
		return regTotalScore;
	}
	public void setRegTotalScore(int regTotalScore) {
		this.regTotalScore = regTotalScore;
	}
	public void setRegTotalScore(String regTotalScore) {
		if(regTotalScore != null)
			this.regTotalScore = Integer.parseInt(regTotalScore);
	}
	public String getRegGrade() {
		return regGrade;
	}
	public void setRegGrade(String regGrade) {
		this.regGrade = regGrade;
	}
	
	@Override
	public String toString() {
		return "RegisterDTO [regStdNo=" + regStdNo + ", regLecNo=" + regLecNo + ", regMidScore=" + regMidScore
				+ ", regFinalScore=" + regFinalScore + ", regTotalScore=" + regTotalScore + ", regGrade=" + regGrade
				+ "]";
	}
}
