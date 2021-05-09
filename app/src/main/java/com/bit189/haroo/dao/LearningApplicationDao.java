package com.bit189.haroo.dao;

import java.util.Map;

public interface LearningApplicationDao {
  int insert(Map<String,Object> params) throws Exception;

  int delete(int no) throws Exception;
}
