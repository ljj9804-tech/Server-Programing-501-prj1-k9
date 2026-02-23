package com.busanit501.jsp_server_project1.service;

import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.TodoDTO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2 // 로그를 기록 하는데, 어떤 기준으로 하나요? 로그레벨
// info, debug , warning
@ExtendWith(SpringExtension.class) // Junit5 단위 테스트 기능 통합 설정
// 빈을 등록한 파일의 위치를 지정, 단위 테스트 할 때, 해당파일를 참고해서, 테스트해줘.
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {
    // 외부 기능을 담당하는 클래스를 가져오기.

    // 서비스 기능을 담당하는 클래스 불러오기.
    // 전역으로 선언만 하구요, 실제 사용은 밑에서 초기화해서, 사용할수 있는 형태로 만들기.
    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister() {
        //준비물. , 화면에서 넘겨받은 데이터, 임시 더미데이터, 하드코딩.
        // 준비물, 화면에서 넘겨받은 TodoVO 있다고 가정, 또는 더미 데이터 준비.
        TodoDTO todoDTO = TodoDTO.builder()
                .title("오늘 점심 뭐 먹죠2-0223?")
                .dueDate(LocalDate.now())
                .writer("이상용2")
                .build();
        todoService.register(todoDTO);
    }

    @Test
    public void testGetAll() {
        List<TodoDTO> dtoList = todoService.getAll();
        dtoList.forEach(dto ->log.info(dto));
    }

    @Test
    public void testGetOne() {
        // 각자 데이터베이스에 있는 tno 번호 확인 후 , 테스트 진행하기.
        TodoDTO todoDTO = todoService.getOne(32L);
        log.info(todoDTO);
    }

}
