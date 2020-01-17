package me.motyim.docker.pageviewservice.repository;

import me.motyim.docker.pageviewservice.domain.PageView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageViewRepo extends JpaRepository<PageView,Integer> {
}
