public class AnnualGarden implements Garden {
    public Plant getShade() {
        return new Plant("コレウス");
    }
    public Plant getCenter() {
        return new Plant("キンセンカ");
    }
    public Plant getBorder() {
        return new Plant("アブラナ");
    }

}
