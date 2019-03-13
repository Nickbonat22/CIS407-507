//package com.ftinc.plugin.generator.sectionblock;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;

public class DocStringGen extends AnAction {

    private static final String DOC_STRING =
                    "/--------\n" +
                    "     *\n" +
                    "     * Description:\n" +
                    "     *\n" +
                    "     */\n\t" +
                    "---------";

    @Override
    public void actionPerformed(AnActionEvent e) {

        // Get the offset in the current editor
        DataContext dataContext = e.getDataContext();
        final Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
        assert editor != null;
        final Document document = editor.getDocument();
        final int offset = editor.getCaretModel().getOffset();

        // Insert the block comment at the cursor position
        new WriteCommandAction(e.getProject()){
            @Override
            protected void run(Result result) throws Throwable {
                document.insertString(offset, DOC_STRING);
                editor.getCaretModel().moveToOffset(offset + DOC_STRING.length());
            }
        }.execute();

    }

}