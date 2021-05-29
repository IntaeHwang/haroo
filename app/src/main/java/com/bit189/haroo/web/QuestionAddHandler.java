package com.bit189.haroo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.PostService;
import com.bit189.haroo.service.ServiceQuestionService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/question/add")
public class QuestionAddHandler extends HttpServlet{

  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/serviceQuestion/form.jsp").include(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServiceQuestionService serviceQuestionService =
        (ServiceQuestionService) request.getServletContext().getAttribute("serviceQuestionService");
    PostService postService = (PostService) request.getServletContext().getAttribute("postService");

    try {
      Post post = new Post();
      Question question = new Question();
      ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

      question.setTitle(request.getParameter("title"));
      question.setSecret(false);
      post.setContent(request.getParameter("content"));


      Member m = new Member();
      m.setNo(3);
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

            file.write(this.uploadDir + "/" + filename);
            System.out.println("uploadDir3 : " + uploadDir);
            System.out.println(this.uploadDir + "/");

            AttachedFile f = new AttachedFile();
            f.setName(filename);

            attachedFiles.add(f);
            //          f.setPostNo(post.getNo());
            //          postService.addFile(f);

            // 썸네일 이미지 생성
            Thumbnails.of(this.uploadDir + "/" + filename)
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

            Thumbnails.of(this.uploadDir + "/" + filename)
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

      response.sendRedirect("list");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }    
}

