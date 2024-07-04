package edu.bone.twitter.service;

import edu.bone.twitter.exception.TwitException;
import edu.bone.twitter.exception.UserException;
import edu.bone.twitter.model.Like;
import edu.bone.twitter.model.Twit;
import edu.bone.twitter.model.User;
import edu.bone.twitter.repository.LikeRepository;
import edu.bone.twitter.repository.TwitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImplementation  implements LikeService{

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private TwitService twitService;

    @Autowired
    private TwitRepository twitRepository;

    @Override
    public Like likeTwit(Long twitId, User user) throws UserException, TwitException {
        Like isLikeExist = likeRepository.isLikeExist(user.getId(), twitId);

        if(isLikeExist != null){
            likeRepository.deleteById(isLikeExist.getId());
            return isLikeExist;
        }
        Twit twit = twitService.findById(twitId);
        if (twit == null) {
            throw new TwitException("Tweet with id " + twitId + " not found");
        }
        Like like = new Like();
        like.setTwit(twit);
        like.setUser(user);

        Like savedLike = likeRepository.save(like);

        twit.getLikes().add(savedLike);
        twitRepository.save(twit);
        return savedLike;
    }

    @Override
    public List<Like> getAllLikes(Long twitId) throws TwitException {
        Twit twit = twitService.findById(twitId);
        List<Like> likes = likeRepository.findByTwitId(twitId);
        return likes;

    }
}
