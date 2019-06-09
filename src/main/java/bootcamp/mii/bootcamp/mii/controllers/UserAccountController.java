/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.controllers;

import bootcamp.mii.bootcamp.mii.entities.ConfirmationToken;
import bootcamp.mii.bootcamp.mii.entities.Users;
import bootcamp.mii.bootcamp.mii.repositories.ConfirmationTokenRepository;
import bootcamp.mii.bootcamp.mii.repositories.UsersRepository;
import bootcamp.mii.bootcamp.mii.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAccountController {
    
    @Autowired
    private UsersRepository userRepository;
    
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    
    @Autowired
    private EmailSenderService emailSenderService;
    
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, Users user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, Users user, String password) {
        
        Users existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            modelAndView.addObject("message", "This email already exists!");
            modelAndView.setViewName("error");
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setIsDelete('1');
            userRepository.save(user);
            
            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            
            confirmationTokenRepository.save(confirmationToken);
            
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("falapubi@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8089/confirm-account?token=" + confirmationToken.getConfirmationToken());
            
            emailSenderService.sendEmail(mailMessage);
            
            modelAndView.addObject("email", user.getEmail());
            
            modelAndView.setViewName("success");
        }
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        
        if (token != null) {
            Users user = userRepository.findByEmail(token.getUserId().getEmail());
            user.setIsDelete('0');
            userRepository.save(user);
            modelAndView.setViewName("verrified");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error");
        }
        
        return modelAndView;
    }
    
    public UsersRepository getUserRepository() {
        
        return userRepository;
        
    }
    
    public void setUserRepository(UsersRepository userRepository) {
        
        this.userRepository = userRepository;
        
    }
    
    public ConfirmationTokenRepository getConfirmationTokenRepository() {
        
        return confirmationTokenRepository;
        
    }
    
    public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {
        
        this.confirmationTokenRepository = confirmationTokenRepository;
        
    }
    
    public EmailSenderService getEmailSenderService() {
        
        return emailSenderService;
        
    }
    
    public void setEmailSenderService(EmailSenderService emailSenderService) {
        
        this.emailSenderService = emailSenderService;
        
    }
}
