package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.Mybatis.TransactionCallback;
import com.bit189.Mybatis.TransactionManager;
import com.bit189.Mybatis.TransactionTemplate;
import com.bit189.haroo.dao.MemberDao;
import com.bit189.haroo.dao.TutorCategoryDao;
import com.bit189.haroo.dao.TutorDao;
import com.bit189.haroo.dao.TutorDistrictDao;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.domain.TutorCategory;
import com.bit189.haroo.domain.TutorDistrict;
import com.bit189.haroo.service.TutorService;

public class DefaultTutorService implements TutorService {

  TransactionTemplate transactionTemplate;

  TutorDao tutorDao;
  MemberDao memberDao;
  TutorDistrictDao tutorDistrictDao;
  TutorCategoryDao tutorCategoryDao;

  public DefaultTutorService(TransactionManager txManager, TutorDao tutorDao, MemberDao memberDao, TutorDistrictDao tutorDistrictDao, TutorCategoryDao tutorCategoryDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.tutorDao = tutorDao;
    this.memberDao = memberDao;
    this.tutorDistrictDao = tutorDistrictDao;
    this.tutorCategoryDao = tutorCategoryDao;
  }

  //  @Override
  //  public int add(Tutor tutor, Member member, TutorDistrict tutorDistrict, TutorCategory tutorCategory) throws Exception {
  //    tutorDao.insert(tutor);
  //    memberDao.update1(member);
  //    tutorDistrictDao.insert(tutorDistrict);
  //    tutorCategoryDao.insert(tutorCategory);
  //    return 1;
  //  }

  @Override
  public int add(Tutor tutor, Member member, TutorDistrict tutorDistrict, TutorCategory tutorCategory) throws Exception {
    return (int) transactionTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction() throws Exception {
        tutorDao.insert(tutor);
        memberDao.update1(member);
        tutorDistrictDao.insert(tutorDistrict);
        tutorCategoryDao.insert(tutorCategory);
        return 1;
      }
    });
  }

  @Override
  public List<Tutor> list(String keyword) throws Exception {
    return tutorDao.findByKeyword(keyword);
  }

  @Override
  public Tutor get(int no) throws Exception {
    return tutorDao.findByNo(no);
  }

  @Override
  public int update(Tutor tutor , Member member , TutorDistrict tutorDistrict, TutorCategory tutorCategory) throws Exception {
    tutorDao.update(tutor);
    memberDao.update(member);
    tutorDistrictDao.update(tutorDistrict);
    tutorCategoryDao.update(tutorCategory);
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    return memberDao.delete(no);
  }

  @Override
  public Tutor Search(String name) throws Exception {
    //    return tutorDao.findByName(name);
    return null;
  }

  @Override
  public Tutor Search(int memberNo) throws Exception {
    //    return tutorDao.findFollowingByNo(memberNo);
    return null;
  }
}