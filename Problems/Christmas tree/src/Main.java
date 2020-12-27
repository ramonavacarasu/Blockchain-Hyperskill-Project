class ChristmasTree {

    private String color;

    public ChristmasTree(String color) {
        this.color = color;
    }

    // create method putTreeTopper()
    void putTreeTopper(String color) {
        new TreeTopper(color).sparkle();
    }

    class TreeTopper {

        private String color;        

        public TreeTopper(String color) {
            this.color = color;
        }

        void sparkle() {
            System.out.println("Sparkling " + this.color +
                    " tree topper looks stunning with " +
                    ChristmasTree.this.color + " Christmas tree!\n");
        }
    }
}

// this code should work
class CreateHoliday {

    public static void main(String[] args) {

        ChristmasTree christmasTree = new ChristmasTree("green");
        christmasTree.putTreeTopper("silver");
    }
}