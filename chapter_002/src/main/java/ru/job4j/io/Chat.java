package ru.job4j.io;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Chat {

    private static final String STOP = "Стоп";
    private static final String CONTINUE = "Продолжить";
    private static final String FINISH = "Закончить";
    private static final String YOUASKQUESTION = "Вы задали вопрос : ";
    private List<String> answers = new LinkedList<>();
    private List<String> dialog = new LinkedList<>();
    private Path answerPath;
    private Path dialogPath;

    public Chat(Path answerPath, Path dialogPath) {
        this.answerPath = answerPath;
        this.dialogPath = dialogPath;
    }

    /**
     * Получает ответы из файла answerPath, если он существует и записывает в коллецию answers
     *
     * @throws IOException
     */
    public void getAnswers() throws IOException {
        if (!Files.exists(this.answerPath)) {
            throw new FileNotFoundException();
        }
        this.answers = Files.readAllLines(this.answerPath);
    }

    /**
     * Получает вопрос от пользователя
     *
     * @return вопрос от пользователя
     */
    public String getQuestions() {
        return new Scanner(System.in).nextLine();
    }

    /**
     * Выводит сообщение в консоль и добавляет его в коллекцию dialog
     *
     * @param message - сообщение
     */
    public void writeConsoleAndList(String message) {
        System.out.println(message);
        this.dialog.add(message);
    }

    /**
     * Записывает весь диалог из коллекции dialog в файл dialogPath
     *
     * @throws IOException
     */
    public void writeDialog() throws IOException {
        Files.write(this.dialogPath, this.dialog);
    }

    /**
     * Чат
     *
     * @throws IOException
     */
    public void chat() throws IOException {
        this.getAnswers();
        writeConsoleAndList("Задайте вопрос : ");
        String question = this.getQuestions();
        writeConsoleAndList(YOUASKQUESTION + question + ". ");
        if (question.equalsIgnoreCase(this.FINISH)) {
            this.writeDialog();
            return;
        } else if (question.equalsIgnoreCase(STOP)) {
            do {
                question = this.getQuestions();
                writeConsoleAndList(YOUASKQUESTION + question + ". ");
            } while (!question.equalsIgnoreCase(CONTINUE));
        } else {
            writeConsoleAndList("Мой ответ : " + this.answers.get((int) (Math.random() * (this.answers.size() - 1))));
        }
        this.chat();
    }

    public static void main(String[] args) throws IOException {
        Chat chat = new Chat(
                Paths.get(".\\chapter_002\\data\\answer.txt").toAbsolutePath().normalize(),
                Paths.get(".\\chapter_002\\data\\dialog.txt").toAbsolutePath().normalize());
        chat.chat();
    }
}
