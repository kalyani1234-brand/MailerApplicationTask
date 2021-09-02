package com.example.demo.MailerApplication.controller;

import java.io.FileWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.MailerApplication.service.MailService;

@Controller
public class MailController {
	static String sender;
	@Autowired
	private MailService mailservice;
	@RequestMapping("/log")
	public String Login() {
		/*
		 *  this is the method for login, this method returns login page for the users.
		 */
		
		return "login";
	}
	 String body1    ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris leo risus, malesuada pretium enim at, mollis fermentum est. Aliquam magna diam, fermentum eget consequat varius, accumsan non lacus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget nisi pellentesque, mollis lectus gravida, egestas leo. Suspendisse rutrum nunc eget purus eleifend, ut cursus turpis consequat. Mauris vulputate ultrices ante, non tempus mi efficitur ut. Aenean a ante scelerisque, fringilla sapien vitae, dictum leo. Nam vel ullamcorper purus. Curabitur vestibulum felis id urna euismod volutpat. Cras iaculis bibendum lorem, hendrerit gravida enim fermentum ornare. Nullam est tortor, ultrices non malesuada vel, cursus sed tortor. Praesent id purus elementum, rhoncus enim sed, luctus mauris. \r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "Curabitur quis semper dolor, vel mattis lorem. Aenean elit dolor, egestas at malesuada ac, pulvinar sit amet arcu. Nam finibus urna ac turpis convallis, vitae sodales nisi cursus. Donec eleifend ullamcorper est, eget efficitur sapien eleifend nec. Mauris auctor erat at tellus aliquam gravida tempor fermentum sapien. Etiam non congue lacus. Vestibulum hendrerit justo at libero ultricies, quis laoreet turpis accumsan. Praesent ut sem vel erat posuere ultricies. Vestibulum lacinia malesuada nisi, ut dapibus justo eleifend quis. Aliquam erat volutpat. \r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "Nunc vel volutpat magna, at venenatis ligula. In malesuada non arcu efficitur gravida. Etiam malesuada mauris id consectetur dapibus. Nam molestie leo eget libero sodales, non ullamcorper dolor condimentum. Donec sed turpis dui. Suspendisse a dapibus purus. Nunc metus nunc, convallis quis gravida et, pellentesque sit amet orci. Maecenas gravida hendrerit tincidunt. Ut scelerisque et orci ut commodo. Fusce vitae mollis nibh. Donec a mauris sagittis eros imperdiet euismod. Duis et lacus urna. Sed lacinia scelerisque ullamcorper. \r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "Vestibulum nec nunc urna. Integer egestas est ac aliquam fermentum. Morbi egestas nisi eu quam viverra, vitae fermentum mauris mattis. Integer et sapien urna. Proin et leo scelerisque, venenatis est non, hendrerit urna. Maecenas ut sodales ipsum. Suspendisse vehicula odio at ligula interdum, ut sodales lacus vulputate. Mauris egestas metus sed pellentesque eleifend. Morbi lacinia mauris sed aliquam efficitur. Nulla sed finibus ligula. Aliquam id massa nisl. Fusce a orci vehicula, imperdiet mauris nec, cursus metus. Proin rhoncus tincidunt dui et viverra. Nulla facilisi. \r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "Morbi magna diam, aliquam a luctus quis, interdum vitae ipsum. Ut eget tortor risus. Vivamus eu nibh sagittis, consectetur diam et, euismod mi. Suspendisse ultrices lorem et massa ornare, vitae laoreet odio condimentum. Duis et felis vel arcu lacinia sollicitudin. Aenean vel odio felis. Etiam blandit velit eros, et dapibus ante ultrices ac. Integer posuere eu urna cursus sagittis. Quisque mattis feugiat ligula ultricies facilisis. Ut nec quam nec dui commodo pretium rhoncus a magna. Pellentesque mauris augue, cursus ac augue id, efficitur vestibulum erat. Vestibulum nec lacus eu orci elementum ullamcorper. Donec et eros at lorem egestas laoreet et eget justo. Proin volutpat, tellus eu imperdiet luctus, ex nibh laoreet leo, at tincidunt lorem risus accumsan urna. ";
	@RequestMapping("/home")
	public String homePage(HttpServletRequest req,HttpServletResponse res){
		/*this method validates the username and password,
		if those are correct it will allow otherwise it will say wrong credentials to the user.
		And it will not enter the user to home page. 
		*/
		String name=req.getParameter("username");
		String password=req.getParameter("password");
		if(name.equals("testing20201011@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			System.setProperty("app.smail",sender);
			return "home";
		}
		
		else if(name.equals("testing20201012@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			return "home";
		}
		else if(name.equals("testing20201013@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			return "home";
		}
		else if(name.equals("testing20201014@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			return "home";
		}
		else if(name.equals("testing20201015@yahoo.com") && password.equals("testing@123")) {
			sender=name;
			return "home";
		}
		
		else {
			return "wrongcredentials";
		}
	}
	

	@RequestMapping("/sendmail")
	public String sendMail(HttpServletRequest req,HttpServletResponse res)throws Exception {
		/* this method is used to sending mails from login user to other 4 users.
		 * Here we are getting details from front to java program and the mails would be sent.
		 */
		String subject=req.getParameter("subject");
		String body= req.getParameter("body");
		  String attachment1 = req.getParameter("attachments");
		 
	
		 
		 for(int i =1;i<=5;i++) {
		
		 String str=sender.substring(0, 14);
		
		  if(sender.equals("testing20201015@yahoo.com")) {
		mailservice.sendMailMethod(str+i+"@yahoo.com", body1 , subject,sender,"D:\\attachment.txt");
		
	} else {
		System.out.println("mail has not sent");
	}
	}
	return "successfull";	
}
}
