package christmas.config;

import christmas.controller.ChristmasController;
import christmas.service.ChristmasService;
import christmas.view.RequestView;
import christmas.view.ResponseView;
import christmas.view.io.ConsoleInputView;
import christmas.view.io.ConsoleOutputView;

public class AppConfig {
    private ConsoleInputView createInputView() {
        return new ConsoleInputView();
    }

    private ConsoleOutputView createOutputView() {
        return new ConsoleOutputView();
    }

    private RequestView createRequestView(ConsoleInputView inputView, ConsoleOutputView outputView) {
        return new RequestView(inputView, outputView);
    }

    private ResponseView createResponseView(ConsoleInputView inputView, ConsoleOutputView outputView) {
        return new ResponseView(inputView, outputView);
    }

    // service
    private ChristmasService createService() {
        return new ChristmasService();
    }

    public ChristmasController initialize() {
        ConsoleInputView inputView = createInputView();
        ConsoleOutputView outputView = createOutputView();
        RequestView requestView = createRequestView(inputView, outputView);
        ResponseView responseView = createResponseView(inputView, outputView);

        ChristmasService service = createService();
        return new ChristmasController(requestView, responseView, service);
    }
}

