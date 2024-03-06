package designpattern.behavioral.command;

import designpattern.behavioral.command.basic.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class CutCommand implements Command {

    private final Editor editor;

    @Autowired
    CommandHistory commandHistory;

    @Override
    public boolean execute() {
        commandHistory.saveBackup(editor);
        editor.getSelection();
        editor.deleteSelection();
        return true; // cut 커맨드 기록 저장
    }
}
