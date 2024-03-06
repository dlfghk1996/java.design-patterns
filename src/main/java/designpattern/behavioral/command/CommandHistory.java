package designpattern.behavioral.command;

import designpattern.behavioral.command.basic.Command;
import java.util.List;
import lombok.Data;

@Data
public class CommandHistory {
    private List<Command> commandList;

    Editor editor;

    String backup;

    // 백업
    public void saveBackup(Editor editor){
        backup = editor.getText();
    }

    // 복원
    public void undo(){
        editor.setText(backup);
    }

    // 배열 끝으로 Command 푸시
    public void push(Command command){
        commandList.add(0,command);
    }

    // 가장 최근 Command
    public Command pop(){
        return commandList.get(commandList.size()-1);
    }
}
