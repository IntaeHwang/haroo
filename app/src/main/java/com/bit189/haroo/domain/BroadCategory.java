package com.bit189.haroo.domain;

public class BroadCategory {
  private int no;
  private String name;

  @Override
  public String toString() {
    return "BroadCategory [no=" + no + ", name=" + name + ", getNo()=" + getNo() + ", getName()="
        + getName() + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
