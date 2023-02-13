package view;

import model.domain.TryCount;
import model.dto.request.CarNameDto;

import java.util.InputMismatchException;
import java.util.List;

public class InputViewForRetry {

    private final InputView inputView;

    public InputViewForRetry(InputView inputView) {
        this.inputView = inputView;
    }

    public List<CarNameDto> inputCarsName() {
        try {
            return inputView.sendCarsName();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return inputCarsName();
        }
    }

    public TryCount inputTryCount() {
        try {
            return inputView.sendTryCount();
        } catch (InputMismatchException exception) {
            printExceptionMessage("시도 횟수는 양의 정수여야 합니다.");
            return inputTryCount();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return inputTryCount();
        }
    }

    private void printExceptionMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}