package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import com.bit189.haroo.dao.CommentDao;
import com.bit189.haroo.dao.FeedDao;
import com.bit189.haroo.dao.LikeDao;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.service.FeedService;

public class DefaultFeedService implements FeedService{

  FeedDao feedDao;
  CommentDao commentDao;
  LikeDao likeDao;
  PostDao postDao;

  public DefaultFeedService(FeedDao feedDao, CommentDao commentDao, LikeDao likeDao, PostDao postDao) {
    this.feedDao = feedDao;
    this.commentDao = commentDao;
    this.likeDao = likeDao;
    this.postDao = postDao;
  }

  @Override
  public int add(int postNo, Feed feed) throws Exception {
    HashMap<String,Object> param = new HashMap<>();
    param.put("no", postNo);
    param.put("feed", feed);

    return feedDao.insert(param);
  }

  @Override
  public List<Feed> list() throws Exception {
    List<Feed> feeds = feedDao.findAll();

    //    for (Feed f : feeds) {
    //      f.setCommentCount(Integer.parseInt(commentDao.commentCount(f.getNo())));
    //      f.setLikeCount(Integer.parseInt(likeDao.likeCount(f.getNo())));
    //    }

    return feeds;
  }

  @Override
  public Feed get(int no) throws Exception {
    Feed feed = feedDao.findByNo(no);

    feed.setCommentCount(Integer.parseInt(commentDao.commentCount(no)));
    feed.setLikeCount(Integer.parseInt(likeDao.likeCount(no)));

    if (feed != null) {
      postDao.updateViewCount(no);
    }

    return feed;
  }



}