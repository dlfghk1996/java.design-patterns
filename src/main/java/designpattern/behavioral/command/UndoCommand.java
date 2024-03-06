package designpattern.behavioral.command;

import designpattern.behavioral.command.basic.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

// 실행취소 작업
@RequiredArgsConstructor
public class UndoCommand implements Command {
    @Autowired
    CommandHistory commandHistory;

    // 기록에서 가장 최근의 커맨드를 가져와서 실행 취소 메서드 실행
// 명령을 스택에 쌓고, undo를 실행할 때마다 pop하여 순서대로 실행 취소를 한다.
    @Override
    public boolean execute() {
        if (commandHistory.pop() != null) {
            commandHistory.undo();
        }
        return false;
    }
}
