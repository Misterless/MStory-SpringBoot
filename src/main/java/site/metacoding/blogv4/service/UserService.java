package site.metacoding.blogv4.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv4.domain.user.User;
import site.metacoding.blogv4.domain.user.UserRepository;
import site.metacoding.blogv4.handler.ex.CustomException;
import site.metacoding.blogv4.util.email.EmailUtil;
import site.metacoding.blogv4.web.dto.user.PasswordResetReqDto;


@RequiredArgsConstructor
@Service  //IoC registration
public class UserService {
    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmailUtil emailUtil;

    @Transactional
    public void 회원가입(User user){
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        user.setPassword(encPassword);

        userRepository.save(user);
    }

    public boolean 유저네임중복체크(String username){
        Optional <User> userOp = userRepository.findByUsername(username);
        if(userOp.isPresent()){
            return false;
        }   else {
            return true;
        }
    }
        @Transactional
        public void 패스워드초기화(PasswordResetReqDto passwordResetReqDto){

            Optional <User> userOp = userRepository.findByUsernameAndEmail(
                passwordResetReqDto.getUsername(),
                passwordResetReqDto.getEmail());
            //1 username email 체크
            if (userOp.isPresent()){
                    User userEntity = userOp.get();
                String encPassword = bCryptPasswordEncoder.encode("9999");
                    userEntity.setPassword(encPassword);
                } else {
                    throw new CustomException("해당 이메일이 존재하지 않습니다.");

            }
            //초기화된 비밀번호 이메일로 전송 
            //더티체킹 후 update
            emailUtil.sendEmail("healwinds@gmail.;com"," 비밀번호 초기화","초기화된 비밀번호 : 9999");
        }


    }



