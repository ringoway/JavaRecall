package faangschool.lambda_and_FI.instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> combineFilters) {
        return combineFilters.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> function1, Function<Image, Image> function2) {
        return (image) -> {
            Image firstImage = function1.apply(image);
            Image secondImage = function2.apply(firstImage);
            return new Image(
                    secondImage.getName(), firstImage.getDescription() + " + " + secondImage.getDescription());
        };
    }
}
