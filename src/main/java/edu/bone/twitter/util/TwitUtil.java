package edu.bone.twitter.util;

import edu.bone.twitter.model.Like;
import edu.bone.twitter.model.Twit;
import edu.bone.twitter.model.User;

public class TwitUtil {
    public static boolean isLikedByReqUser(User reqUser, Twit twit) {
        for (Like like : twit.getLikes()) {
            if(like.getUser().getId().equals(reqUser.getId())){

                return true;
            }
        }
        return false;
    }
    public final static boolean isRetwitedByReqUser(User reqUser, Twit twit)
    {
        for(User user : twit.getRetwitUser())
        {
            if(user.getId().equals(reqUser.getId())){
                return true;
            }
        }
        return false;
    }
}
