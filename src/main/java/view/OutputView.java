package view;

import model.dto.response.CarStatusDto;
import model.dto.response.WinnersNameDto;

import java.util.List;

public class OutputView {

    public static final String POSITION_MARK = "-";

    public void printEachRound(List<CarStatusDto> carStatusDtos) {
        carStatusDtos.forEach(carStatusDto -> printEachCarStatus(carStatusDto));
        System.out.println("");
    }

    public void printWinners(WinnersNameDto winnersNameDto) {
        System.out.println(getFormattedName(winnersNameDto.getWinnersNames()) + "가 최종 우승했습니다.");
    }

    private void printEachCarStatus(CarStatusDto carStatusDto) {
        System.out.println(carStatusDto.getName() + " : " + POSITION_MARK.repeat(carStatusDto.getPosition()));
    }

    private String getFormattedName(List<String> names) {
        return String.join(", ", names);
    }
}
