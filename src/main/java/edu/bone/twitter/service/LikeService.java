package edu.bone.twitter.service;

import edu.bone.twitter.exception.TwitException;
import edu.bone.twitter.exception.UserException;
import edu.bone.twitter.model.Like;
import edu.bone.twitter.model.User;

import java.util.List;

public interface LikeService {

    public Like likeTwit(Long twitId, User user) throws UserException, TwitException;

    public List<Like> getAllLikes(Long twitId) throws TwitException;

}
