package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;

public class member {
  private int no;
  private String email;
  private String password;
  private String name;
  private String nickname;
  private String profilePicture;
  private String phone;  
  private boolean sex;
  private Date birthDate;
  private String zipcode;
  private String address;
  private String detatilAddress;
  private Date registeredDate;
  private Time registeredTime;
  private String rank;
  private boolean state;

  @Override
  public String toString() {
    return "member [no=" + no + ", email=" + email + ", name=" + name + ", nickname=" + nickname
        + ", profilePicture=" + profilePicture + ", phone=" + phone + ", sex=" + sex
        + ", birthDate=" + birthDate + ", zipcode=" + zipcode + ", address=" + address
        + ", detatilAddress=" + detatilAddress + ", registeredDate=" + registeredDate
        + ", registeredTime=" + registeredTime + ", rank=" + rank + ", state=" + state + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getProfilePicture() {
    return profilePicture;
  }

  public void setProfilePicture(String profilePicture) {
    this.profilePicture = profilePicture;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public boolean isSex() {
    return sex;
  }

  public void setSex(boolean sex) {
    this.sex = sex;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
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

  public String getDetatilAddress() {
    return detatilAddress;
  }

  public void setDetatilAddress(String detatilAddress) {
    this.detatilAddress = detatilAddress;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public Time getRegisteredTime() {
    return registeredTime;
  }

  public void setRegisteredTime(Time registeredTime) {
    this.registeredTime = registeredTime;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }



}

