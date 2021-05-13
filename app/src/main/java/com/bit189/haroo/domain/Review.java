package com.bit189.haroo.domain;

public class Review extends Post {
  private String title;
  private int writerNo;
  private int scheduleNo;
  private int recommandCount;
  private double rate;

  @Override
  public String toString() {
    return "Review [title=" + title + ", writerNo=" + writerNo + ", scheduleNo=" + scheduleNo
        + ", recommandCount=" + recommandCount + ", rate=" + rate + ", getNo()=" + getNo()
        + ", getContent()=" + getContent() + ", getWritingDate()=" + getWritingDate()
        + ", getViewCount()=" + getViewCount() + ", isState()=" + isState() + ", getAttachedFile()="
        + getAttachedFiles() + "]";
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getWriterNo() {
    return writerNo;
  }

  public void setWriterNo(int writerNo) {
    this.writerNo = writerNo;
  }

  public int getScheduleNo() {
    return scheduleNo;
  }

  public void setScheduleNo(int scheduleNo) {
    this.scheduleNo = scheduleNo;
  }

  public int getRecommandCount() {
    return recommandCount;
  }

  public void setRecommandCount(int recommandCount) {
    this.recommandCount = recommandCount;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

}