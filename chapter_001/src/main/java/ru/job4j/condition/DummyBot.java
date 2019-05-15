package ru.job4j.condition;

/**
 * DummyBot.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class DummyBot {

    /**
     * Answering questions.
     * @param question question from client
     * @return answer
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
