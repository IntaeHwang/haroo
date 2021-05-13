package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Post {
  private int no;
  private String content;
  private Date writingDate;
  private Time writingTime;
  private int viewCount;
  private boolean state;
  private List<AttachedFile> attachedFiles;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getWritingDate() {
    return writingDate;
  }
  public void setWritingDate(Date writingDate) {
    this.writingDate = writingDate;
  }
  public Time getWritingTime() {
    return writingTime;
  }
  public void setWritingTime(Time writingTime) {
    this.writingTime = writingTime;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public boolean isState() {
    return state;
  }
  public void setState(boolean state) {
    this.state = state;
  }
  public List<AttachedFile> getAttachedFiles() {
    return attachedFiles;
  }
  public void setAttachedFiles(List<AttachedFile> attachedFiles) {
    this.attachedFiles = attachedFiles;
  }





}