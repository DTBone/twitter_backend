package edu.bone.twitter.repository;

import edu.bone.twitter.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query("SELECT I FROM Like I WHERE I.user.id =:userId AND I.twit.id = :twitId")
    public Like isLikeExist (@Param("userId") Long userId, @Param("twitId") Long twitId );

    @Query("SELECT I FROM Like I WHERE I.twit.id=:twitId")
    public List<Like> findByTwitId (@Param("twitId") Long twitId);

}
