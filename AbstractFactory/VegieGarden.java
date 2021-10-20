public class VegieGarden implements Garden {
    public Plant getShade() {
        return new Plant("ブロッコリ");
    }
    public Plant getCenter() {
        return new Plant("トウモロコシ");
    }
    public Plant getBorder() {
        return new Plant("エンドウ");
    }

}
