
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;

public class PythonTypeInfoAddedEvent {}
/*
public class PythonTypeInfoAddedEvent {
    public static void eventClosure(@NotNull AnActionEvent event) {

        final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        final Project project = event.getRequiredData(CommonDataKeys.PROJECT);

        final VirtualFile file = ((FileEditorManagerEx) FileEditorManagerEx.getInstance(project)).getCurrentFile();
        if (file == null) {
            return;
        }
        PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
        final CaretModel cursor = editor.getCaretModel();
        if (psiFile == null) {
            return;
        }
        final PsiElement element = psiFile.findElementAt(cursor.getOffset());
        if (element == null) {
            return;
        }
        final PsiElement psiElement = element.getParent();
        if (psiElement == null) {
            return;
        }

        final Document document = editor.getDocument();
        final int line = cursor.getLogicalPosition().line;
        Runnable runnable = () -> {
            String type = Provider.getType(psiElement);
            if (type == null) {
                return;

            }

            document.insertString(document.getLineEndOffset(line), "  # type: " + Provider.normalizeFunctionType(type));
        };
  
        WriteCommandAction.runWriteCommandAction(project, runnable);
    }

}
*/