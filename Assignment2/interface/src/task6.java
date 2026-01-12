public class task6 {
    public static void main(String[] args) throws Exception {
    }
    interface Selectable {
        void onSelect();
    }
    interface Updatable {
        void refresh();
    }
    public static class Screen implements Selectable, Updatable {
        public void onSelect() {
        }
        public void refresh() {
        }
    }
}
