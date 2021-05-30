package com.bit189.haroo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.bit189.haroo.dao.BroadCategoryDao;
import com.bit189.haroo.dao.LearningDao;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.dao.NarrowCategoryDao;
import com.bit189.haroo.dao.ServiceInfoDao;
import com.bit189.haroo.dao.SidoDao;
import com.bit189.haroo.dao.SigunguDao;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.LearningService;

@Service
public class DefaultLearningService implements LearningService {

  TransactionTemplate transactionTemplate;
  ServiceInfoDao serviceInfoDao;
  LearningDao learningDao;
  LearningScheduleDao learningScheduleDao;
  BroadCategoryDao broadCategoryDao;
  NarrowCategoryDao narrowCategoryDao;
  SidoDao sidoDao;
  SigunguDao sigunguDao;

  public DefaultLearningService(PlatformTransactionManager txManager, ServiceInfoDao serviceInfoDao,
      LearningDao learningDao, LearningScheduleDao learningScheduleDao, BroadCategoryDao broadCategoryDao,
      NarrowCategoryDao narrowCategoryDao, SidoDao sidoDao, SigunguDao sigunguDao) {

    this.transactionTemplate = new TransactionTemplate(txManager);
    this.serviceInfoDao = serviceInfoDao;
    this.learningDao = learningDao;
    this.learningScheduleDao = learningScheduleDao;
    this.broadCategoryDao = broadCategoryDao;
    this.narrowCategoryDao = narrowCategoryDao;
    this.sidoDao = sidoDao;
    this.sigunguDao = sigunguDao;
  }

  @Override
  public int add(ServiceInfo serviceInfo, Learning learning, LearningSchedule learningSchedule) throws Exception {

    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        int count;
        try {
          count = serviceInfoDao.insert(serviceInfo);
          learningDao.insert(learning);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }

        return count;
      }
    });
  }

  @Override
  public List<Learning> list() throws Exception {
    return learningDao.findAll();
  }

  @Override
  public Learning get(int no) throws Exception {
    return learningDao.findByNo(no);
  }

  @Override
  public int update(Learning Learning) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(int no) throws Exception {
    return serviceInfoDao.delete(no);
  }

  @Override
  public Learning Search(int no) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

}