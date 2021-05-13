package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.ArrayList;

public class Post {
  private int no;
  private String content;
  private Date writingDate;
  private int viewCount;
  private boolean state;
  private ArrayList<String> attachedFile;

  @Override
  public String toString() {
    return "Post [no=" + no + ", content=" + content + ", writingDate=" + writingDate
        + ", viewCount=" + viewCount + ", state=" + state + ", attachedFile=" + attachedFile + "]";
  }

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

  public ArrayList<String> getAttachedFile() {
    return attachedFile;
  }

  public void setAttachedFile(ArrayList<String> attachedFile) {
    this.attachedFile = attachedFile;
  }

}