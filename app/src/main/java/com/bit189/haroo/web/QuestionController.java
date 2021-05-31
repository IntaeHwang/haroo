package com.bit189.haroo.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.ServiceQuestionService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;


@Controller
public class QuestionController{

  ServiceQuestionService serviceQuestionService;

  public QuestionController(ServiceQuestionService serviceQuestionService) {
    this.serviceQuestionService = serviceQuestionService;
  }

  @RequestMapping("/question/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    if (request.getMethod().equals("GET")) {
      return "/jsp/serviceQuestion/form.jsp";
    }


    Post post = new Post();
    Question question = new Question();
    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

    question.setTitle(request.getParameter("title"));
    question.setSecret(Integer.parseInt(request.getParameter("secret")));
    post.setContent(request.getParameter("content"));


    Member m = new Member();
    m.setNo(2);
    question.setWriter(m);

    ServiceInfo s = new ServiceInfo();
    s.setNo(2);
    question.setServiceInfo(s);

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("file") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        System.out.println("uploadDir1 : " + uploadDir);

        //          Part photoPart = request.getPart("file");
        if (file.getSize() > 0) {
          // 파일을 선택해서 업로드 했다면,
          String filename = UUID.randomUUID().toString();

          System.out.println("uploadDir2 : " + uploadDir);

          file.write(uploadDir + "/" + filename);
          System.out.println("uploadDir3 : " + uploadDir);
          System.out.println(uploadDir + "/");

          AttachedFile f = new AttachedFile();
          f.setName(filename);

          attachedFiles.add(f);
          //          f.setPostNo(post.getNo());
          //          postService.addFile(f);

          // 썸네일 이미지 생성
          Thumbnails.of(uploadDir + "/" + filename)
          .size(330, 220)
          .outputFormat("jpg")
          .crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_330x220";
            }
          });

          System.out.println("uploadDir4 : " + uploadDir);

          Thumbnails.of(uploadDir + "/" + filename)
          .size(500, 500)
          .outputFormat("jpg")
          .crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_300x300";
            }
          });
        }
      }


      System.out.println("uploadDir5 : " + uploadDir);
    }

    serviceQuestionService.add(question, post, attachedFiles);

    return "redirect:list";

  }    

  @RequestMapping("/question/delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Question oldQuestion = serviceQuestionService.get(no);
    if (oldQuestion == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    serviceQuestionService.delete(no);

    return "redirect:list";

  }

  @RequestMapping("/question/detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    int no = Integer.parseInt(request.getParameter("no"));

    Question question = serviceQuestionService.get(no);
    request.setAttribute("question", question);

    return "/jsp/serviceQuestion/detail.jsp";

  }

  @RequestMapping("/question/list")
  public String list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Question> questions = serviceQuestionService.list();

    request.setAttribute("questions", questions);

    return "/jsp/serviceQuestion/list.jsp";

  }    

  @RequestMapping("/question/update")
  public String update(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Question oldQuestion = serviceQuestionService.get(no);
    if (oldQuestion == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    Question q = new Question();
    q.setNo(oldQuestion.getNo());
    q.setContent(request.getParameter("content"));
    serviceQuestionService.update(q);

    return "redirect:list";

  }

  @RequestMapping("/question/reply/add")
  public String replyAdd(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");


    if (request.getMethod().equals("GET")) {
      return "/jsp/serviceQuestion/form2.jsp";
    }

    int no = Integer.parseInt(request.getParameter("no"));

    Question oldQuestion = serviceQuestionService.get(no);

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("작업 권한이 없습니다!");
    }

    Question question = new Question();
    question.setNo(oldQuestion.getNo());
    question.setReplyContent(request.getParameter("content"));


    AttachedFile attachedFile = new AttachedFile();

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("file") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        System.out.println("uploadDir1 : " + uploadDir);

        if (file.getSize() > 0) {
          String filename = UUID.randomUUID().toString();

          System.out.println("uploadDir2 : " + uploadDir);

          file.write(uploadDir + "/" + filename);
          System.out.println("uploadDir3 : " + uploadDir);
          System.out.println(uploadDir + "/");


          attachedFile.setName(filename);

          //attachedFile.add(attachedFile);

          System.out.println("uploadDir4 : " + uploadDir);

          Thumbnails.of(uploadDir + "/" + filename)
          .size(500, 500)
          .outputFormat("jpg")
          .crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_300x300";
            }
          });
        }
      }

      System.out.println("uploadDir5 : " + uploadDir);
    }

    serviceQuestionService.replyUpdate(question, attachedFile);

    return "redirect:list";


  }    
}

