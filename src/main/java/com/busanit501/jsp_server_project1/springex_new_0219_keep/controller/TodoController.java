package com.busanit501.jsp_server_project1.springex_new_0219_keep.controller;

import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.TodoDTO;
import com.busanit501.jsp_server_project1.springex_new_0219_keep.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
// http://localhost:8080/todo2/ 관련된 업무는 내가 처리할게.
@RequestMapping("/todo2")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // http://localhost:8080/todo2/list
    // 뷰 리졸버가 연결되어서,
    // todo2/list -> WEN-INF/views/todo2/list.jsp 연결 설정됨.
    @RequestMapping("/list")
    public void list(Model model) {

        log.info("todo list...");
        List<TodoDTO> dtoList = todoService.getAll();
        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : dtoList, 내용물: DB에서 받아온 목록들
        model.addAttribute("dtoList",dtoList);
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    // 뷰 리졸버가 연결되어서,
    // todo2/list -> WEN-INF/views/todo2/register.jsp 연결 설정됨.
    public void getRegister() {
        log.info("todo register..get");
    }

    @PostMapping("/register")
    // 유효성 체크시, 주의사항, !) @Valid TodoDTO todoDTO, BindingResult bindingResult, 순서 주의!!!
    public String postRegister(@Valid TodoDTO todoDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("todo register..post");


        // 유효성 체크
        if(bindingResult.hasErrors()) {
            log.info("유효성 오류가 있습니다. ");
            // 서버에서 화면으로 임시 데이터를 전달. 박스이름: errors, 박스 내용물: 오류가 난 이유.
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            return "redirect:/todo2/register";
        }

        // 서비스의 도움을 받아서, 화면으로 부터 전달 받은 데이터를 전달하기.
        todoService.register(todoDTO);

        log.info(" 유효성 통과한 데이터 todoDTO : " + todoDTO);
        return "redirect:/todo2/list";
    }
}
