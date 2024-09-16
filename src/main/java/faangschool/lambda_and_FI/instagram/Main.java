package faangschool.lambda_and_FI.instagram;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Image originalImage = new Image("original.jpg", "Оригинальное изображение");

        FilterProcessor filterProcessor = new FilterProcessor();

        Function<Image, Image> blackFilter = (image) -> new Image(image.getName() + "_blackFilter", "Фильтр чёрный");
        Function<Image, Image> vinietka = (image) -> new Image(image.getName() + "_vinietka", "Фильтр виниетака");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");

        Image image_black = filterProcessor.applyFilter(originalImage, blackFilter);

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(vinietka, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
        System.out.println(combinedImage);
    }
}
