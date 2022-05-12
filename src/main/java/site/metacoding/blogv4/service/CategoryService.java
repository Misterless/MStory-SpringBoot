package site.metacoding.blogv4.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv4.domain.category.Category;
import site.metacoding.blogv4.domain.category.CategoryRepository;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //익셉션이나 에러가 생기면 롤백시키게 트랜잭션으로
    @Transactional
    public void 카테고리등록(Category category){
        categoryRepository.save(category);
    }
}
