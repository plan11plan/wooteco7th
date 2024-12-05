package christmas.constant;

import static christmas.constant.MenuType.APPATIZER;
import static christmas.constant.MenuType.DESSERT;
import static christmas.constant.MenuType.DRINK;
import static christmas.constant.MenuType.MAIN;

/*
<애피타이저>
양송이수프(6,000),타파스(5,500),시저샐러드(8,000)

<메인>
티본스테이크(55,000),바비큐립(54,000),해산물파스타(35,000),크리스마스파스타(25,000)

<디저트>
초코케이크(15,000),아이스크림(5,000)

<음료>
제로콜라(3,000),레드와인(60,000),샴페인(25,000)
 */
public enum Menu {
    양송이수프(APPATIZER, "양송이수프", 6_000),
    타파스(APPATIZER, "타파스", 5_500),
    시저샐러드(APPATIZER, "시저샐러드", 8_000),

    티본스테이크(MAIN, "티본스테이크", 55_000),
    바비큐립(MAIN, "바비큐립", 54_000),
    해산물파스타(MAIN, "해산물파스타", 35_000),
    크리스마스파스타(MAIN, "크리스마스파스타", 25_000),

    초코케이크(DESSERT, "초코케이크", 15_000),
    아이스크림(DESSERT, "아이스크림", 5_000),

    제로콜라(DRINK, "제로콜라", 3_000),
    레드와인(DRINK, "레드와인", 60_000),
    샴페인(DRINK, "샴페인", 25_000);


    private final MenuType menuType;
    private final String name;
    private final int price;

    Menu(final MenuType menuType, final String name, final int price) {
        this.menuType = menuType;
        this.name = name;
        this.price = price;
    }
}
