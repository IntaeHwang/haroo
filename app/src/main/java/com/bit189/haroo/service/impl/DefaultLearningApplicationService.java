package com.bit189.haroo.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import com.bit189.haroo.dao.LearningApplicationDao;
import com.bit189.haroo.dao.LearningDao;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.service.LearningApplicationService;

public class DefaultLearningApplicationService implements LearningApplicationService{

  LearningApplicationDao learningApplicationDao;
  LearningScheduleDao learningScheduleDao;
  LearningDao learningDao;

  public DefaultLearningApplicationService(LearningApplicationDao learningApplicationDao,  
      LearningScheduleDao learningScheduleDao, LearningDao learningDao) {
    this.learningApplicationDao = learningApplicationDao;
    this.learningScheduleDao = learningScheduleDao;
    this.learningDao = learningDao;
  }

  @Override
  public int add(LearningApplication learningApplication) throws Exception {
    return learningApplicationDao.insert(learningApplication);
  }

  @Override
  public List<LearningApplication> list() throws Exception {
    return learningApplicationDao.findAll();
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

  @Override
  public List<LearningSchedule> search(Date LearningDate, Time startTime, Time endTime)
      throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("LearningDate", LearningDate);
    params.put("startTime", startTime);
    params.put("endTime", endTime);
    return learningScheduleDao.findByKeywords(params);
  }

  @Override
  public List<Learning> listLearning() throws Exception {

    return learningDao.findAll();
  }




}
