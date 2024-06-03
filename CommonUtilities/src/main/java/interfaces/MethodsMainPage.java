package interfaces;

import lombok.SneakyThrows;

public interface MethodsMainPage {
    @SneakyThrows
    void searchDestination(String from, String to);

    void setupPage(String link);
}
