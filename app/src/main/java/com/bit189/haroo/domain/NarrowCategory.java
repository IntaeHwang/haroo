package com.bit189.haroo.domain;

public class NarrowCategory {
  private int no;
  private String nmae;

  @Override
  public String toString() {
    return "NarrowCategory [no=" + no + ", nmae=" + nmae + ", getNo()=" + getNo() + ", getNmae()="
        + getNmae() + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getNmae() {
    return nmae;
  }
  public void setNmae(String nmae) {
    this.nmae = nmae;
  }
}
