package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.List;

public class Tutor extends Member{
  private String intro;
  private String application;
  private Date promotedDate;
  private List<Sigungu> tutorDistricts;
  private List<TutorCategory> tutorCategories;

  public String getIntro() {
    return intro;
  }
  public void setIntro(String intro) {
    this.intro = intro;
  }
  public String getApplication() {
    return application;
  }
  public void setApplication(String application) {
    this.application = application;
  }
  public Date getPromotedDate() {
    return promotedDate;
  }
  public void setPromotedDate(Date promotedDate) {
    this.promotedDate = promotedDate;
  }
  public List<Learning> getLearnings() {
    return learnings;
  }
  public void setLearnings(List<Learning> learnings) {
    this.learnings = learnings;
  }
  public List<Product> getProducts() {
    return products;
  }
  public void setProducts(List<Product> products) {
    this.products = products;
  }
  public List<Sigungu> getTutorDistricts() {
    return tutorDistricts;
  }
  public void setTutorDistricts(List<Sigungu> tutorDistricts) {
    this.tutorDistricts = tutorDistricts;
  }
  public List<NarrowCategory> getTutorCategories() {
    return tutorCategories;
  }
  public void setTutorCategories(List<NarrowCategory> tutorCategories) {
    this.tutorCategories = tutorCategories;
  }
  public List<Question> getTutorQuestions() {
    return tutorQuestions;
  }
  public void setTutorQuestions(List<Question> tutorQuestions) {
    this.tutorQuestions = tutorQuestions;
  }
  public List<Feed> getFeeds() {
    return feeds;
  }
  public void setFeeds(List<Feed> feeds) {
    this.feeds = feeds;
  }

}

