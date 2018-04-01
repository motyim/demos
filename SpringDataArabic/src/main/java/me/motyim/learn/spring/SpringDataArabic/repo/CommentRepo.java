package me.motyim.learn.spring.SpringDataArabic.repo;

import me.motyim.learn.spring.SpringDataArabic.entity.Comments;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 19, 2018
 */
public interface CommentRepo extends PagingAndSortingRepository<Comments, Integer> {

}
