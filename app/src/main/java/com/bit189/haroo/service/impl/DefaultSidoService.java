package com.bit189.haroo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bit189.haroo.dao.SidoDao;
import com.bit189.haroo.domain.Sido;
import com.bit189.haroo.service.SidoService;

@Service
public class DefaultSidoService implements SidoService {

  SidoDao sidoDao;

  public DefaultSidoService(SidoDao sidoDao) {
    this.sidoDao = sidoDao;
  }

  @Override
  public List<Sido> list() throws Exception {
    return sidoDao.findAll();
  }
}
