public class PerennialGarden implements Garden {
    public Plant getShade() {
        return new Plant("チダケサシ");
    }
    public Plant getCenter() {
        return new Plant("ケマンソウ");
    }
    public Plant getBorder() {
        return new Plant("ベンケイソウ");
    }

}
