package com.asky.backend.repository;

import com.asky.backend.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contentRepository")
public interface ContentRepository extends JpaRepository<Content,Integer> {




}
