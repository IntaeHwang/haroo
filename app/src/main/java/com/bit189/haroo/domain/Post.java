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
  private List<String> attachedFile;
}