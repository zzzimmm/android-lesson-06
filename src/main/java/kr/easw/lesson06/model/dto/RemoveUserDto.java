package kr.easw.lesson06.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class RemoveUserDto {
    private String userId;

    public RemoveUserDto(String userId) {
        this.userId = userId;
    }
}
