package com.bit189.haroo.dao;

import java.util.Map;

public interface TutorDistrictDao {

  int insert(Map<String,Object> params) throws Exception;

  int delete(Map<String,Object> params) throws Exception;
}
