package com.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class MovieServiceJSON
 */

@WebServlet({"/MovieServiceJSON","/movie"})
public class MovieServiceJSON extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServiceJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
          String clientId = "mZjebv2h_4D8Ye3KuBlU";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
           String clientSecret = "lHQxzAiyvQ";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
           
           String text = request.getParameter("query");
           
           
           try {
               text = URLEncoder.encode(text, "UTF-8"); // �ѱ�ȭ
               String apiURL = "https://openapi.naver.com/v1/search/movie.json?query="+ text; // json ���
               //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml ���
               
              
               URL url = new URL(apiURL);
               HttpURLConnection con = (HttpURLConnection)url.openConnection();
               con.setRequestMethod("GET");
               con.setRequestProperty("X-Naver-Client-Id", clientId);
               con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
               int responseCode = con.getResponseCode();
               BufferedReader br;
               if(responseCode==200) { // ���� ȣ��
                   br = new BufferedReader(new InputStreamReader(con.getInputStream()));
               } else {  // ���� �߻�
                   br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
               }
               
               String inputLine;
               StringBuffer sb = new StringBuffer();
               while ((inputLine = br.readLine()) != null) {//br.readLine()�� ���� �ƴҶ��� inputLine�� br.readLine()�� ����ְ� while�� ����
                   sb.append(inputLine);
               }
               br.close();
               //System.out.println(sb.toString());
               
               
               //json���� ���������.. ��.. ���ɺ�������
               response.setContentType("text/html;charset=UTF-8"); 
               response.getWriter().print(sb.toString());
             response.getWriter().close();
             
           } catch (Exception e) {
               System.out.println(e);
           }
      
   }

}

