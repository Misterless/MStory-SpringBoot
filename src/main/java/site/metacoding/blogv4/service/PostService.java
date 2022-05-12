package site.metacoding.blogv4.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv4.domain.category.Category;
import site.metacoding.blogv4.domain.category.CategoryRepository;
import site.metacoding.blogv4.domain.post.Post;
import site.metacoding.blogv4.domain.post.PostRepository;
import site.metacoding.blogv4.domain.user.User;
import site.metacoding.blogv4.web.dto.post.PostRespDto;
import site.metacoding.blogv4.web.dto.post.PostWriteReqDto;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public List<Category> 게시글쓰기화면(User principal){
        return categoryRepository.findByUserId(principal.getId());
    }
    @Transactional
    public void 게시글쓰기(PostWriteReqDto postWriteReqDto){
        /** 일단 할거를 적어놓고 정리한다음에 구현하자.
         * 1 이미지파일 저장(UUID사용)
         * 2 이미지파일 이름은 Post오브젝트에 썸네일이름으로 옮기자.
         * 3.title contents 도 포스트로 옮기자
         * 4. userid categoryid 다 옮기자.
         * 예상되는 질문 왜 Post오브젝트에 전부 옮기셨나요? 카테고리는 왜 안쓰시나요?
         * 나중에 가져갈때 카테고리 포스트 전부가져가야 할 경우가 많을거라서,카테고리만 따로 담을 일이 없을거로 판단.
         * 
        **/
    }

    public PostRespDto 게시글목록보기(int userId) {
        List<Post> postsEntity = postRepository.findByUserId(userId);
        List<Category> categorysEntity = categoryRepository.findByUserId(userId);

        PostRespDto postRespDto = new PostRespDto(
                postsEntity,
                categorysEntity);
        return postRespDto;
    }
}