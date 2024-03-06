package designpattern.behavioral.command;

import designpattern.behavioral.command.basic.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

// 붙여넣기
@RequiredArgsConstructor
public class PasteCommand implements Command {

    private final Editor editor;
    @Autowired
    CommandHistory commandHistory;

    @Override
    public boolean execute() {
        commandHistory.saveBackup(editor);
        editor.replaceSelection(editor.getSelection());
        return true; // Paste 커맨드 기록 저장
    }
}
