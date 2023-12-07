package racingcar.message;

public enum RacingCarErrorMessage {
    INVALID_CAR_NAME_LENGTH("자동차이름은 1자리이상 5자 이하만 가능합니다."),
    INVALID_TRY_COUNT_NATURAL_NUMBER("이동할 횟수는 자연수여야 한다."),
    INVALID_DUPLICATION_CAR_NAME("자동차 이름은 중복으로 사용될 수 없습니다."),
    INVALID_MINIMUM_CARS_COUNT("자동차는 최소 2대 이상 생성해야 합니다."),
    INVALID_CARS_EMPTY("차량 리스트가 비었습니다."),
    INVALID_DUPLICATED_DELIMITER("중복으로 구분자를 사용할 수 없습니다.");

    String message;

    RacingCarErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
