package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Tutor extends Member{
  private String intro;
  private String application;
  private Date promotedDate;
  private Time promotedTime;
  private ArrayList<Learning> learnings;
  private ArrayList<Product> products;
  private ArrayList<District> tutorDistricts;
  private ArrayList<Category> tutorCategories;
  private ArrayList<Question> tutorQuestions;
  private ArrayList<Feed> feeds;
}
