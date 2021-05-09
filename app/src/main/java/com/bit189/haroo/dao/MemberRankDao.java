package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.Member;

public interface MemberRankDao {
  int insert(Map<String,Object> params) throws Exception;

  List<Member> findAll() throws Exception;

  Member findByNo(int no) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

  Member findByName(String name) throws Exception;
}
