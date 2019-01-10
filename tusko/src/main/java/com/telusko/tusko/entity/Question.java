package com.telusko.tusko.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
@Id
private int qid;

private String que;

private String opt1;

private String opt2;

private String opt3;

private String opt4;

private String answer;

public int getQid() {
	return qid;
}

public void setQid(int qid) {
	this.qid = qid;
}

public String getQue() {
	return que;
}

public void setQue(String que) {
	this.que = que;
}

public String getOpt1() {
	return opt1;
}

public void setOpt1(String opt1) {
	this.opt1 = opt1;
}

public String getOpt2() {
	return opt2;
}

public void setOpt2(String opt2) {
	this.opt2 = opt2;
}

public String getOpt3() {
	return opt3;
}

public void setOpt3(String opt3) {
	this.opt3 = opt3;
}

public String getOpt4() {
	return opt4;
}

public void setOpt4(String opt4) {
	this.opt4 = opt4;
}

public String getAnswer() {
	return answer;
}

public void setAnswer(String answer) {
	this.answer = answer;
}

@Override
public String toString() {
	return "Question [qid=" + qid + ", que=" + que + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3 + ", opt4="
			+ opt4 + ", answer=" + answer + "]";
}
}
