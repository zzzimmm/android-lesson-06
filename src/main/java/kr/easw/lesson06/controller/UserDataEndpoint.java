package kr.easw.lesson06.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.easw.lesson06.model.dto.RemoveUserDto;
import kr.easw.lesson06.model.dto.UserDataEntity;
import kr.easw.lesson06.service.UserDataService;

import java.util.List;
import java.util.stream.Collectors;

// @RestController 어노테이션을 사용하여 이 클래스가 REST 컨트롤러임을 선언합니다.
@RestController
// @RequestMapping 어노테이션을 사용하여 이 클래스의 기반 엔드포인트를 /api/v1/data로 설정합니다.
@RequestMapping("/api/v1/user")
// final로 지정된 모든 필드를 파라미터로 가지는 생성자를 생성합니다.
@RequiredArgsConstructor
public class UserDataEndpoint {
  private final UserDataService userDataService;

    // 원래대로라면 리스트를 통해 JSON에서 사용할 수 있는 형태로 변환해야 하지만, 이번 실습에서는 건너뜁니다.
    @GetMapping("/list")
    public List<String> listUsers() {
        return userDataService.getAllUsers().stream().map(UserDataEntity::getUserId).collect(Collectors.toList());
    }

    // 원래대로라면 리스트를 통해 JSON에서 사용할 수 있는 형태로 변환해야 하지만, 이번 실습에서는 건너뜁니다.
    @PostMapping("/remove")
    public ResponseEntity<String> removeUser(@RequestBody RemoveUserDto removeUserDto) {
        boolean isRemoved = userDataService.removeUser(removeUserDto.getUserId());
        if (isRemoved) {
            return ResponseEntity.ok("유저 삭제 성공");
        } else {
            return ResponseEntity.badRequest().body("유저 삭제 실패");
        }
    }
}
