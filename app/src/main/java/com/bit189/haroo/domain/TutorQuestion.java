package com.bit189.haroo.domain;

import java.util.Date;

public class TutorQuestion extends Post{
  private Member writer;
  private Member tutor;
  private String title;
  private int secret;
  private String reply;
  private Date replyDate;

  @Override
  public String toString() {
    return "TutorQuestion [writer=" + writer + ", tutor=" + tutor + ", title=" + title + ", secret="
        + secret + ", reply=" + reply + ", replyDate=" + replyDate + "]";
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public Member getTutor() {
    return tutor;
  }
  public void setTutor(Member tutor) {
    this.tutor = tutor;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public int getSecret() {
    return secret;
  }
  public void setSecret(int secret) {
    this.secret = secret;
  }
  public String getReply() {
    return reply;
  }
  public void setReply(String reply) {
    this.reply = reply;
  }
  public Date getReplyDate() {
    return replyDate;
  }
  public void setReplyDate(Date replyDate) {
    this.replyDate = replyDate;
  }





}
