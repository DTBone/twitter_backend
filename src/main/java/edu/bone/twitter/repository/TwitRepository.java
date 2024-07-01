package edu.bone.twitter.repository;

import edu.bone.twitter.model.Twit;
import edu.bone.twitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TwitRepository extends JpaRepository<Twit, Long> {

    List<Twit> findAllByIsTwitTrueOrderByCreatedAtDesc();

    List<Twit> findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(User user, Long userId);

    List<Twit> findByLikesContainingOrderByCreatedAtDesc(User user);

    @Query("Select t from Twit t JOIN t.likes I where I.user.id=:userId")
    List<Twit> findByLikesUser_id(Long userId);


}
