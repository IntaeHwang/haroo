package com.bit189.haroo.domain;

import java.util.ArrayList;

public class Learning extends ServiceInformation {
  private Tutor owner;
  private int sigungu;
  private int minPeople;
  private int maxPeople;
  private String progressOrder;
  private int price;
  private String zipCode;
  private String address;
  private String detailAddress;
  private String refundInformation;
  private ArrayList<LearningSchedule> schedules;
}
