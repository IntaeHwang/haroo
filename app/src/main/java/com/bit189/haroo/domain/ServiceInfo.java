package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ServiceInfo {
  private int no;
  private String name;
  private String intro;
  private String coverImage;
  private double averageRate;
  private boolean state;
  private Date registeredDate;
  private Time registeredTime;
  private ArrayList<Question> questions ;
  private ArrayList<Review> reviews;
}
