package designpattern.behavioral.command;

import lombok.Data;

@Data
public class Editor {
    private String text;

    public String getSelection() {
        System.out.println("선택된 텍스트를 반환하세요.");
        return "선택된 텍스트 반환";
    }

    public void deleteSelection() {
        System.out.println("선택된 텍스트를 삭제하세요");
    }

    public void replaceSelection(String text) {
        System.out.println(" 현재 위치에 클립보드의 내용을 삽입하세요");
    }
}
