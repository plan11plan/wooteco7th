package christmas.view.mapper;

import christmas.util.ValidationUtils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RequestParser {

    private RequestParser() {
    }

    /**
     * 입력 예시: "사탕 - 2, 바나나 -1, 구름-2" 아이템과 수량을 파싱하여 리스트로 반환합니다.
     */
    public static List<List<String>> parseOrderMenus(String input) {
        String[] items = input.trim().split(",");
        return Arrays.stream(items)
                .map(RequestParser::parseItemQuantity)
                .collect(Collectors.toList());
    }

    private static List<String> parseItemQuantity(String item) {
        String[] itemData = item.trim().split("-");
        return Arrays.stream(itemData)
                .map(String::trim)
                .collect(Collectors.toList());
    }


    public static int parseToInt(String input) {
        ValidationUtils.validateInteger(input);
        return Integer.parseInt(input);
    }
}
