package designpattern.behavioral.command;

import designpattern.behavioral.command.basic.Command;
import java.util.List;

// 발신자
public class EditorInvoker {

    private Command command;
    private String clipboard;
    private List<Editor> editors;
    private Editor activeEditor;
    private CommandHistory history;

    // 커맨드 실행
    public void executeCommand(Command command) {
        if(command.execute()){
            history.push(command);
        }
    }
}
