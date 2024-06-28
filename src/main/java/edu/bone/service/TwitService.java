package edu.bone.service;

import edu.bone.exception.TwitException;
import edu.bone.exception.UserException;
import edu.bone.model.Like;
import edu.bone.model.Twit;
import edu.bone.model.User;
import edu.bone.request.TwitReplyRequest;

import java.util.List;

public interface TwitService {

    public Twit createTwit(Twit req, User user) throws UserException;
    public List<Twit> findAllTwit();
    public Twit retwit(Long twitId, User user) throws UserException, TwitException;
    public Twit findById(Long twitId) throws TwitException;

    public void deleteTwitById(long twitId, Long userId) throws  TwitException, UserException;
    public Twit removeFromRetwit(Long twitId, User user) throws TwitException, UserException;
    public Twit createdreply(TwitReplyRequest req, User user) throws TwitException;

    public List<Twit> getUserTwit(User user);
    public List<Twit> findByLikesContainsUser(User user);


}
