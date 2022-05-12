package site.metacoding.blogv4.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv4.config.auth.LoginUser;
import site.metacoding.blogv4.domain.category.Category;
import site.metacoding.blogv4.domain.user.User;
import site.metacoding.blogv4.service.CategoryService;
import site.metacoding.blogv4.util.Script;
import site.metacoding.blogv4.util.UtilValid;
import site.metacoding.blogv4.web.dto.Category.CategoryWriteReqDto;

@RequiredArgsConstructor
@Controller
public class CategoryController {
    
    private final HttpSession httpSession;
    private final CategoryService categoryService;


    @GetMapping("/s/category/writeForm")
    public String writeForm() {
        return "/category/writeForm";
    }
    @PostMapping("/s/category")
    public @ResponseBody String write(@Valid CategoryWriteReqDto categoryWriteReqDto, BindingResult bindingResult,
                    @AuthenticationPrincipal LoginUser loginUser) {
                        
                        UtilValid.요청에러처리(bindingResult);

                        User principal = loginUser.getUser();

                        Category category = categoryWriteReqDto.toEntity(principal);

                        categoryService.카테고리등록(category);
                        
        return Script.href("/s/category/writeForm", "카테고리 등록 완료");
    }
}
