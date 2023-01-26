package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.entity.User;

/**
 * Userテーブル用リポジトリ
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//public long countByEmail(String email);
	//public long countByPassword(String password);
	//public long countByLoginAndcountByPass(String email, String password );
	public User findByEmailAndPassword(String email, String password);
}
