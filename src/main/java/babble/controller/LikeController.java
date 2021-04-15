package babble.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.dto.LikeDto;
import babble.dto.PostDto;
import babble.mapper.UserMapper;
import babble.service.LikeServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LikeController {

	private final LikeServiceImpl service;

	private final UserMapper mapper;

	@PostMapping("post/{id}/like")
	public void like(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.like(id, mapper.toDto(p.getUser()));
	}

	@DeleteMapping("post/{id}/like")
	public void unlike(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.unlike(id, p.getUser().getId());
	}

	@GetMapping("post/{id}/likes")
	public List<LikeDto> getLikeList(@PathVariable("id") Long id) {
		return service.getLikeList(id);
	}

	@DeleteMapping("post/{id}/likes")
	public void deleteLikeList(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.deleteLikeList(id, p.getUser().getId());
	}
	
	@GetMapping("user/{id}/likes")
	public List<PostDto> getLikeListInUser(@PathVariable("id") Long id) {
		return service.getLikePostList(id);
	}
	
}
