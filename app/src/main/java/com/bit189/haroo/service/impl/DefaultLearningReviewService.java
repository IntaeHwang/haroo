package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import com.bit189.Mybatis.TransactionManager;
import com.bit189.Mybatis.TransactionTemplate;
import com.bit189.haroo.dao.LearningReviewDao;
import com.bit189.haroo.dao.LearningReviewRecommendDao;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.service.LearningReviewService;

public class DefaultLearningReviewService implements LearningReviewService {

  TransactionTemplate transactionTemplate;
  LearningReviewDao learningReviewDao;
  LearningReviewRecommendDao learningReviewRecommendDao;

  public DefaultLearningReviewService(TransactionManager txManager,
      LearningReviewDao learningReviewDao,  
      LearningReviewRecommendDao learningReviewRecommendDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.learningReviewDao = learningReviewDao;
    this.learningReviewRecommendDao = learningReviewRecommendDao;
  }

  @Override
  public int add(LearningReview review) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<LearningReview> listByLearning(int learningNo, int sortingStd, boolean isAsc)
      throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("learningNo", learningNo);
    params.put("srtingStd", sortingStd);
    params.put("isAsc", params);

    return learningReviewDao.findListByLearningNo(params);
  }

  @Override
  public List<LearningReview> listByMember(int memberNo, int sortingStd, boolean isAsc)
      throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("memberNo", memberNo);
    params.put("srtingStd", sortingStd);
    params.put("isAsc", params);

    return learningReviewDao.findListByMemberNo(params);
  }

  @Override
  public LearningReview get(int postNo) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int update(LearningReview review) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<LearningReview> Search(String keyword) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

}