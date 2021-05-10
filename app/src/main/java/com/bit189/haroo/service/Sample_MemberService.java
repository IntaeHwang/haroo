package com.bit189.haroo.service;

import java.util.List;
import com.eomcs.pms.domain.Member;

public interface Sample_MemberService {

  int add(Member member) throws Exception;

  List<Member> list() throws Exception;

  Member get(int no) throws Exception;

  Member get(String email, String password) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

  Member search(String name) throws Exception;
}
