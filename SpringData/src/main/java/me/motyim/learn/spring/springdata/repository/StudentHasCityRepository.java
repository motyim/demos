package me.motyim.learn.spring.springdata.repository;

import me.motyim.learn.spring.springdata.entity.StudentHasCity;
import me.motyim.learn.spring.springdata.entity.StudentHasCityPK;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 25-Feb-18
 */
@Repository
public interface StudentHasCityRepository extends PagingAndSortingRepository<StudentHasCity,StudentHasCityPK> {
}
