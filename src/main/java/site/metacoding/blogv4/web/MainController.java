package site.metacoding.blogv4.web;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv4.config.auth.LoginUser;

@RequiredArgsConstructor
@Controller
public class MainController {
    
    @GetMapping("/")
    public String main() {
        //System.out.println(loginUser.getUsername());
        //System.out.println(loginUser.getUser().getUsername());
       
        return "main";
    }
}
