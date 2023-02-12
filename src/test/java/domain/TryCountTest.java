package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.TryCount.TRY_COUNT_LIMIT;
import static org.assertj.core.api.Assertions.*;

class TryCountTest {

    @DisplayName(TRY_COUNT_LIMIT + "이하의 양의 정수를 입력 시 정상적으로 TryCount 인스턴스를 생성한다.")
    @Test
    void TryCount_성공() {
        assertThatNoException().isThrownBy(() -> new TryCount(5));
    }

    @DisplayName("0이하의 정수를 입력 시 예외를 반환한다.")
    @Test
    void TryCount_실패_너무작은수() {
        assertThatIllegalArgumentException().isThrownBy(() -> new TryCount(-1));
    }

    @DisplayName(TRY_COUNT_LIMIT + "보다 큰 정수를 입력 시 예외를 반환한다.")
    @Test
    void TryCount_실패_너무큰수() {
        assertThatIllegalArgumentException().isThrownBy(() -> new TryCount(101));
    }
}