package eu.exposit.consoleApp.model.enumType;

import lombok.Getter;

public enum ProductCategory {

    AUTOMOTIVE_PARTS("автомобильные части"),
    CERAMIC("керамика"),
    CONSTRUCION_MATERIALS("строительные материалы"),
    COSMETICS("косметика"),
    ELECTRICAL("электрика"),
    FOOD("питание"),
    FUR("мех"),
    FURNITURE("мебель"),
    GALLERY("галерея"),
    GLASS("стекло"),
    HOUSEHOLD_CHEMICAL("бытовая химия"),
    JEWELRY("ювелирные изделия"),
    KNITTED("вязаный"),
    METAL("металл"),
    MUSICAL("музыка"),
    PLASTIC("пластик"),
    PRINTED_PUBLICATIONS("печатные издания"),
    SCHOOL_ACCESSORIES("школьные аксессуары"),
    SEWING("шитье"),
    SHOES("обувь"),
    SPORTING_GOODS("спортивные товары"),
    TEXTILE("текстиль"),
    TOYS("игрушки");

    @Getter
    private final String name;

    ProductCategory(String name) {
        this.name = name;
    }
}
