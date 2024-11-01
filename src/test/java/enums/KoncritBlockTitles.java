package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum KoncritBlockTitles {
    PLATFORM_ADVANTAGES("ПРЕИМУЩЕСТВА ПЛАТФОРМЫ"),
    APPLICATION_AREAS("СФЕРЫ ПРИМЕНЕНИЯ"),
    BUSINESS_FIT("ОТЛИЧНО ПОДОЙДЁТ ДЛЯ БИЗНЕСА, В КОТОРОМ"),
    FEATURES("KILLER FEATURES"),
    OPTIMIZATION_TOOL("МОЩНЫЙ ИНСТРУМЕНТ ДЛЯ ОПТИМИЗАЦИИ ЛОГИСТИКИ БОЛЬШОГО МАСШТАБА"),
    DEVELOPMENT_STAGES("ЭТАПЫ РАЗРАБОТКИ ПЛАТФОРМЫ"),
    FAQ("FAQ"),
    EXPERTISE("ЭКСПЕРТИЗА"),
    GUIDANCE("НЕ ЗНАЕТЕ, С ЧЕГО НАЧАТЬ? МЫ ПОДСКАЖЕМ");

    @Getter
    private final String titleText;
}
