package com.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.msg.Msg;

public class Client {
   int port;
   String address;
   String id;
   Socket socket;
   Sender sender;
   
   public Client() {
   }
   public Client(String address, int port, String id) {
      this.address = address;
      this.port = port;
      this.id = id;
   }
   
   public void connect() throws Exception {
      try {
         socket = new Socket(address, port);
      } catch (Exception e) {
         System.out.println("Retry ...");
         while (true) {
            try {
               Thread.sleep(2000);
               socket = new Socket(address, port);
               break;
            } catch (Exception e1) {
               System.out.println("Retry ...");
            }
         }
      }
      
      System.out.println("Connected Server: " + address);
      sender = new Sender(socket);
      //new Receiver(socket).start();
   }
   
   // 이 부분 추가
   public void sendTarget(String ip, String cmd) {
      ArrayList<String> ips = new ArrayList<String>();
      ips.add(ip);
      Msg msg = new Msg(ips, id, cmd);
      sender.setMsg(msg);
      new Thread(sender).start();
	   }
   
   public void sendMsg() {
      Scanner sc = new Scanner(System.in);
      while(true) {
         // 메세지 입력
         System.out.println("Input msg");
         String ms = sc.nextLine();
         Msg msg = null;
         ArrayList<String> ips = new ArrayList<>();
         if(ms.equals("w")) {
            // 귓속말
            while(true) {
               System.out.println("Input other Ip");
               String other = sc.nextLine();
               if(other.equals("end")) {
                  break;
               }
               ips.add(other);
            }
            System.out.println("Input msg");
            String newms = sc.nextLine();
            msg = new Msg(ips, id, newms);
         }else {
            msg = new Msg(id, ms);
         }
         
         // 메세지 전송
         sender.setMsg(msg);
         new Thread(sender).start();
         
         if(ms.equals("q")) {
            break;
         }
      }
      
      sc.close();
      if(socket != null) {
         try {
            socket.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      System.out.println("Exit ..");
   }
   
   class Sender implements Runnable{
      Socket socket;
      ObjectOutputStream oo;
      Msg msg;
      
      public Sender(Socket socket) throws Exception {
         this.socket = socket;
         oo = new ObjectOutputStream(socket.getOutputStream());
      }
      
      public void setMsg(Msg msg) {
         this.msg = msg;
      }

      @Override
      public void run() {
         if(oo != null) {
            try {
               oo.writeObject(msg);
            } catch (IOException e) {
               //e.printStackTrace();
               try {
                  if(socket != null) {
                     socket.close();
                  }
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
               
               try {
                  Thread.sleep(2000);
                  connect();
               } catch (Exception e1) {
                  e1.printStackTrace();
               }
            }
         }
      }
   }
   
   class Receiver extends Thread{
      ObjectInputStream oi;
      public Receiver(Socket socket) throws IOException {
         oi = new ObjectInputStream(socket.getInputStream());
      }
      
      @Override
      public void run() {
         while (oi != null) {
            Msg msg = null;
            try {
               msg = (Msg) oi.readObject();
               System.out.println(msg.getId() + msg.getMsg());
            } catch (Exception e) {
               e.printStackTrace();
            }
         } //end while
         
         try {
            if(oi != null) {
               oi.close();
            }
            if(socket != null) {
               socket.close();
            }
         } catch (Exception e) {
            // TODO: handle exception
         }
      }
      
   }

   public static void main(String[] args) {
      Client client = new Client("192.168.0.103", 5555, "[JaeHyun]");
      try {
         client.connect();
         client.sendMsg();
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}