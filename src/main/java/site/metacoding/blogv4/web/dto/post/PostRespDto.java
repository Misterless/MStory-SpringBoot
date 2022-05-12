package site.metacoding.blogv4.web.dto.post;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv4.domain.category.Category;
import site.metacoding.blogv4.domain.post.Post;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostRespDto {
    private List<Post> posts;
    private List<Category> categorys;
}
