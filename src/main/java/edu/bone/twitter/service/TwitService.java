package edu.bone.twitter.service;

import edu.bone.twitter.exception.TwitException;
import edu.bone.twitter.exception.UserException;
import edu.bone.twitter.model.Twit;
import edu.bone.twitter.model.User;
import edu.bone.twitter.request.TwitReplyRequest;

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
