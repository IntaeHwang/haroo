package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Product;
import com.eomcs.pms.domain.Project;

public interface Sample_ProjectService {

  int add(Product project) throws Exception;

  List<Project> list() throws Exception;

  Project get(int no) throws Exception;

  int update(Project project) throws Exception;

  int delete(int no) throws Exception;

  List<Project> search(String title, String owner, String member) throws Exception;

  List<Project> search(String item, String keyword) throws Exception;

  int deleteMembers(int projectNo) throws Exception;

  int updateMembers(int projectNo, List<Member> members) throws Exception;
}







