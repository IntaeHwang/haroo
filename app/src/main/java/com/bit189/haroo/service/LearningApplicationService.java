package com.bit189.haroo.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.domain.LearningSchedule;

public interface LearningApplicationService {

  int add(LearningApplication learningApplication) throws Exception;

  List<LearningApplication> list() throws Exception;

  LearningApplication get(int no) throws Exception;

  int delete(int no) throws Exception;

  List<LearningSchedule> listSchedules() throws Exception;

  List<Learning> search(Date LearningDate, Time startTime, Time endTime) throws Exception;

  List<Learning> listLearning() throws Exception;


}


