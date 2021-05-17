package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.List;

public class Tutor extends Member {
  private String intro;
  private String application;
  private Date promotedDate;
  private List<Learning> learnings;
  private List<Product> products;
  private List<Sigungu> tutorDistricts;
  private List<NarrowCategory> tutorCategories;
  private List<Question> tutorQuestions;
  private List<Feed> feeds;

}
