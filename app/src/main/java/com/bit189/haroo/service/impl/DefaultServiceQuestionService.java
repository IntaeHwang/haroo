package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import com.bit189.haroo.dao.ServiceQuestionDao;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;

public class DefaultServiceQuestionService implements ServiceQuestionService{

  ServiceQuestionDao serviceQuestionDao;


  public DefaultServiceQuestionService(ServiceQuestionDao serviceQuestionDao) {
    this.serviceQuestionDao = serviceQuestionDao;
  }

  @Override
  public int add(int postNo, Question question) throws Exception {
    HashMap<String,Object> param = new HashMap<>();
    param.put("no", postNo);
    param.put("question", question);
    return serviceQuestionDao.insert(param);
  }

  @Override
  public List<Question> list() throws Exception {
    return serviceQuestionDao.findAll(null);
  }


  @Override
  public List<Question> listByMember(int mno) throws Exception {
    return serviceQuestionDao.findByMember(mno);
  }

  @Override
  public Question get(int no) throws Exception {
    Question question = serviceQuestionDao.findByNo(no);
    if (question != null) {
    }
    return question;
  }

  @Override
  public int update(Question question) throws Exception {
    return serviceQuestionDao.update(question);
  }

  @Override
  public int delete(int no) throws Exception {
    return serviceQuestionDao.delete(no);
  }


  @Override
  public List<Question> Search(String keyword) throws Exception {
    return serviceQuestionDao.findByKeyword(keyword);
  }



}
