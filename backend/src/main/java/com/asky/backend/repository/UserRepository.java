package com.asky.backend.repository;

import com.asky.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Integer> {
   // public User findOneUser(int id);
    @Query("Select u from User u where u.userId=:id")
    public User findOneUserByUserId(@Param("id") int id);

    @Query("Select u from User  u where u.username=:username and u.password=:password")
    public User findUserByUserNameAndPassword(@Param("username") String username,@Param("password") String password);

    @Query("Select u from User u where u.username=:username")
    public User findUserByUserName(@Param("username") String username);

}
