package com.mozzi.board.toyproj.web.hello.dto;
import com.mozzi.board.toyproj.web.hello.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
public class HelloResponseDtoTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void 롬복_기능_테스트() throws Exception{
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertEquals(dto.getName(), name);
        assertEquals(dto.getAmount(), amount);
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;
    }
}