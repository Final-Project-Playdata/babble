package babble.service;

import java.util.List;

import babble.dto.LoginRequestDto;
import babble.dto.UserDto;

public interface UserService {

	List<UserDto> getUserList();

	UserDto getUser(Long id, String password) throws Exception;

	void signUp(LoginRequestDto loginDto) throws Exception;

	void updateUser(UserDto userDto, Long id, String password) throws Exception;

	void withdraw(Long id, String password, LoginRequestDto loginDto) throws Exception;

}
