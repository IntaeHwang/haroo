package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.MetropolitanCity;

public interface SidoDao {
  int insert(int no) throws Exception;

  List<MetropolitanCity> findAll() throws Exception;

  MetropolitanCity findByNo(int no) throws Exception;

  MetropolitanCity findByname(String name) throws Exception;

  int update(int no) throws Exception;

  int delete(int no) throws Exception;
}
