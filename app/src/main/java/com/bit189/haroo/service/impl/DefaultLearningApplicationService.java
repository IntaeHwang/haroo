package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.LearningApplicationDao;
import com.bit189.haroo.dao.LearningDao;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.service.LearningApplicationService;

public class DefaultLearningApplicationService implements LearningApplicationService{

  LearningApplicationDao learningApplicationDao;
  LearningScheduleDao learningScheduleDao;
  LearningDao learningDao;

  public DefaultLearningApplicationService(LearningApplicationDao learningApplicationDao,LearningScheduleDao learningScheduleDao) {
    this.learningApplicationDao = learningApplicationDao;
    this.learningScheduleDao = learningScheduleDao;
  }

  @Override
  public int add(LearningApplication learningApplication) throws Exception {
    return learningApplicationDao.insert(learningApplication);
  }


  @Override
  public List<LearningApplication> list(String keyword) throws Exception {
    return learningApplicationDao.findByKeyword(keyword);
  }

  @Override
  public List<LearningSchedule> listSchedules() throws Exception {
    //    return learningScheduleDao.findAllSchedules();
    return null;
  }

  @Override
  public LearningApplication get(int no) throws Exception {
    return learningApplicationDao.findByNo(no);
  }


  @Override
  public int delete(int no) throws Exception {
    return learningApplicationDao.delete(no);
  }

}