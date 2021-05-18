package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.List;

public class ServiceInfo {
  private int no;
  private String broadCategory;
  private String narrowCategory;
  private String name;
  private String intro;
  private String coverImage;
  private double averageRate;
  private boolean state;
  private Tutor tutor;
  private Date registeredDate;
  private List<Question> questions;
  private List<Review> reviews;

  @Override
  public String toString() {
    return "ServiceInfo [no=" + no + ", broadCategory=" + broadCategory + ", narrowCategory="
        + narrowCategory + ", name=" + name + ", intro=" + intro + ", coverImage=" + coverImage
        + ", averageRate=" + averageRate + ", state=" + state + ", tutor=" + tutor
        + ", registeredDate=" + registeredDate + ", questions=" + questions + ", reviews=" + reviews
        + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getBroadCategory() {
    return broadCategory;
  }

  public void setBroadCategory(String broadCategory) {
    this.broadCategory = broadCategory;
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

  public Tutor getTutor() {
    return tutor;
  }

  public void setTutor(Tutor tutor) {
    this.tutor = tutor;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

}
