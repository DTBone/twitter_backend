package edu.bone.twitter.controller;

import edu.bone.twitter.dto.LikeDto;
import edu.bone.twitter.dto.mapper.LikeDtoMapper;
import edu.bone.twitter.exception.TwitException;
import edu.bone.twitter.exception.UserException;
import edu.bone.twitter.model.Like;
import edu.bone.twitter.model.User;
import edu.bone.twitter.service.LikeService;
import edu.bone.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeController {
    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    @PostMapping("/{twitId}/likes")
    public ResponseEntity<LikeDto> likeTwit(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException
    {
        User user = userService.findUserProfileByJwt(jwt);
        Like like = likeService.likeTwit(twitId, user);

        LikeDto likeDto = LikeDtoMapper.toLikeDto(like, user);
        return new ResponseEntity<LikeDto>(likeDto, HttpStatus.CREATED);
    }

    @PostMapping("/twit/{twitId}")
    public ResponseEntity<List<LikeDto>> getAllLikes(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException
    {
        User user = userService.findUserProfileByJwt(jwt);
        List<Like> likes = likeService.getAllLikes(twitId);

        List<LikeDto> likeDtos = LikeDtoMapper.toLikeDtos(likes, user);
        return new ResponseEntity<List<LikeDto>>(likeDtos, HttpStatus.CREATED);
    }

}
