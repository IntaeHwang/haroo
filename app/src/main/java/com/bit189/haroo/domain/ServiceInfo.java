package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.ArrayList;

public class ServiceInfo {
  private int no;
  private String narrowCategory;
  private String name;
  private String intro;
  private String coverImage;
  private double averageRate;
  private boolean state;
  private Date registeredDate;
  private ArrayList<Question> questions;
  private ArrayList<Review> reviews;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getNarrowCategory() {
    return narrowCategory;
  }
  public void setNarrowCategory(String narrowCategory) {
    this.narrowCategory = narrowCategory;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getIntro() {
    return intro;
  }
  public void setIntro(String intro) {
    this.intro = intro;
  }
  public String getCoverImage() {
    return coverImage;
  }
  public void setCoverImage(String coverImage) {
    this.coverImage = coverImage;
  }
  public double getAverageRate() {
    return averageRate;
  }
  public void setAverageRate(double averageRate) {
    this.averageRate = averageRate;
  }
  public boolean isState() {
    return state;
  }
  public void setState(boolean state) {
    this.state = state;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public ArrayList<Question> getQuestions() {
    return questions;
  }
  public void setQuestions(ArrayList<Question> questions) {
    this.questions = questions;
  }
  public ArrayList<Review> getReviews() {
    return reviews;
  }
  public void setReviews(ArrayList<Review> reviews) {
    this.reviews = reviews;
  }


}
