package com.bit189.haroo.domain;

import java.util.List;

public class Learning extends ServiceInfo {
  private int sidoNo;
  private String sido;
  private int sigunguNo;
  private String sigungu;
  private Tutor owner;
  private int minPeople;
  private int maxPeople;
  private String progressOrder;
  private int price;
  private String zipcode;
  private String address;
  private String detailAddress;
  private String refundInformation;
  private List<LearningSchedule> schedules;

  @Override
  public String toString() {
    return "Learning [sidoNo=" + sidoNo + ", sido=" + sido + ", sigunguNo=" + sigunguNo
        + ", sigungu=" + sigungu + ", owner=" + owner + ", minPeople=" + minPeople + ", maxPeople="
        + maxPeople + ", progressOrder=" + progressOrder + ", price=" + price + ", zipcode="
        + zipcode + ", address=" + address + ", detailAddress=" + detailAddress
        + ", refundInformation=" + refundInformation + ", schedules=" + schedules + ", getNo()="
        + getNo() + ", getBroadCategoryNo()=" + getBroadCategoryNo() + ", getBroadCategory()="
        + getBroadCategory() + ", getNarrowCategoryNo()=" + getNarrowCategoryNo()
        + ", getNarrowCategory()=" + getNarrowCategory() + ", getName()=" + getName()
        + ", getIntro()=" + getIntro() + ", getCoverImage()=" + getCoverImage()
        + ", getAverageRate()=" + getAverageRate() + ", isState()=" + isState() + ", getTutor()="
        + getTutor() + ", getRegisteredDate()=" + getRegisteredDate() + "]";
  }

  public int getSidoNo() {
    return sidoNo;
  }
  public void setSidoNo(int sidoNo) {
    this.sidoNo = sidoNo;
  }
  public String getSido() {
    return sido;
  }
  public void setSido(String sido) {
    this.sido = sido;
  }
  public int getSigunguNo() {
    return sigunguNo;
  }
  public void setSigunguNo(int sigunguNo) {
    this.sigunguNo = sigunguNo;
  }
  public String getSigungu() {
    return sigungu;
  }
  public void setSigungu(String sigungu) {
    this.sigungu = sigungu;
  }
  public Tutor getOwner() {
    return owner;
  }
  public void setOwner(Tutor owner) {
    this.owner = owner;
  }
  public int getMinPeople() {
    return minPeople;
  }
  public void setMinPeople(int minPeople) {
    this.minPeople = minPeople;
  }
  public int getMaxPeople() {
    return maxPeople;
  }
  public void setMaxPeople(int maxPeople) {
    this.maxPeople = maxPeople;
  }
  public String getProgressOrder() {
    return progressOrder;
  }
  public void setProgressOrder(String progressOrder) {
    this.progressOrder = progressOrder;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public String getZipcode() {
    return zipcode;
  }
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getDetailAddress() {
    return detailAddress;
  }
  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }
  public String getRefundInformation() {
    return refundInformation;
  }
  public void setRefundInformation(String refundInformation) {
    this.refundInformation = refundInformation;
  }
  public List<LearningSchedule> getSchedules() {
    return schedules;
  }
  public void setSchedules(List<LearningSchedule> schedules) {
    this.schedules = schedules;
  }
}
