package designpattern.behavioral.command;

import designpattern.behavioral.command.basic.Command;
import lombok.RequiredArgsConstructor;

// 복사 작업
@RequiredArgsConstructor
public class CopyCommand implements Command {

    private final Editor editor;

    @Override
    public boolean execute() {
        editor.getSelection();
        return false; // 복사 커맨드는 기록에 저장하지 않는다.
    }

}
