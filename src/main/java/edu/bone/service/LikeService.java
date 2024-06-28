package edu.bone.service;

import edu.bone.exception.TwitException;
import edu.bone.exception.UserException;
import edu.bone.model.Like;
import edu.bone.model.User;

import java.util.List;

public interface LikeService {

    public Like likeTwit(Long twitId, User user) throws UserException, TwitException;

    public List<Like> getAllLikes(Long twitId) throws TwitException;

}
