package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import com.bit189.Mybatis.TransactionCallback;
import com.bit189.Mybatis.TransactionManager;
import com.bit189.Mybatis.TransactionTemplate;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.dao.ServiceQuestionDao;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;



public class DefaultServiceQuestionService implements ServiceQuestionService{

  TransactionTemplate transactionTemplate;

  ServiceQuestionDao serviceQuestionDao;
  PostDao postDao;


  public DefaultServiceQuestionService(TransactionManager txManager, ServiceQuestionDao serviceQuestionDao, PostDao postDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.serviceQuestionDao = serviceQuestionDao;
    this.postDao = postDao;

  }

  @Override
  public int add(Question question, Post post) throws Exception {
    return (int) transactionTemplate.execute(new TransactionCallback() {

      @Override
      public Object doInTransaction() throws Exception {

        postDao.insert(post);

        HashMap<String,Object> param = new HashMap<>();
        param.put("no", post.getNo());
        param.put("question", question);

        return  serviceQuestionDao.insert(param);
      }
    });
  }

  @Override
  public List<Question> list() throws Exception {
    List<Question> questions = serviceQuestionDao.findAll();

    return questions;
  }


  @Override
  public List<Question> listByMember(int mno) throws Exception {
    return serviceQuestionDao.findByMember(mno);
  }

  @Override
  public Question get(int no) throws Exception {
    Question question = serviceQuestionDao.findByNo(no);
    if (question != null) {
      postDao.updateViewCount(no);
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
