package designpattern.behavioral.command;



public class EditorController {

    public void all(){
        Editor editor = new Editor(); // 실제 작업 수행
        EditorInvoker editorInvoker = new EditorInvoker(); // 작업 호출자

        // copy
        editorInvoker.executeCommand(new CopyCommand(editor));

        // cut
        editorInvoker.executeCommand(new CutCommand(editor));

        // paste
        editorInvoker.executeCommand(new PasteCommand(editor));

        // undo
        editorInvoker.executeCommand(new UndoCommand());
    }
}
